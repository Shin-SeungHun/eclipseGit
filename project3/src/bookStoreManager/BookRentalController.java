package bookStoreManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookRentalController implements Initializable {
	@FXML
	private Button btnRental;
	@FXML
	private Button btnFindBook;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField tfTitle;
	@FXML
	private TextField tfUser;
	@FXML
	private TextField tfHp;

	// ������ Ŭ����������...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_library?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	private Stage primaryStage;
	boolean findBook = true;
	String inputTitle, inputUser, inputHp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnRental.setOnAction(event -> home2(event));
		btnFindBook.setOnAction(event -> find(event));
		btnCancel.setOnAction(event -> home(event));
		dbCon();
	}

	public void cancel() {
		Stage stage11 = (Stage) btnCancel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnRental.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void home(ActionEvent event) {
		// main();
		cancel();
	}

	public void home2(ActionEvent event) {
		// main();
		rental();
	}

	public void main() {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("library.fxml"));
			primaryStage.setTitle("Library");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("button.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void dbCon() {
		////////////////////////////////////////
		/// ����Ÿ���̽�����..
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		////////////////////////////////////////////
	}

	void dbClose() {
		// Close �۾�
		try {
			rs.close();
			stmt.close();
			pstmt.close();
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("�ݱ� ����~!!");
		}
	}

	void find(ActionEvent event) {
		inputTitle = tfTitle.getText().toString();
		if (inputTitle.equals("")) {
			dlgMsg("�뿩�Ͻ� å�� ������ �Է����ּ���");
		}
		findBook(inputTitle);
	}

	void findBook(String inputTitle) {
		// �뿩�� å ã��
		String query = "select * from book where book_name='" + inputTitle + "'and available_for_rental='yes'";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				if (inputTitle.equals(rs.getString("book_name"))) {

					dlgMsg("�뿩������ å�� �˻��߽��ϴ�.");
					// tfTitle.setText(rs.getString("bookName"));
					findBook = false;
					break;
				}

			}
			if (findBook == true) {
				dlgMsg("������ �뿩�Ͻ� �� ���� å�Դϴ�.");
			}

		} catch (SQLException ee) {
			System.err.println("������ ȹ�����!!");
		}
		findBook = true;
	}

	void rental() {
		inputTitle = tfTitle.getText().toString();
		inputUser = tfUser.getText().toString();
		inputHp = tfHp.getText().toString();

		// ����üũ
		if (inputTitle.equals("")) {
			dlgMsg("������ �Է����ּ���");
			return;
		} else if (inputUser.equals("")) {
			dlgMsg("�̸��� �Է����ּ���");
			return;
		} else if (inputHp.equals("")) {
			dlgMsg("����ó�� �Է����ּ���");
			return;
		}

		updateBook(inputTitle);
		bookRent(inputTitle, inputUser, inputHp);
		dbClose();
		viewClose();
	}

	void bookRent(String inputTitle, String inputUser, String inputHp) {
		String pquery = "insert into library values (null, ?, ?, ?, now(), null)";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, inputTitle);
			pstmt.setString(2, inputUser);
			pstmt.setString(3, inputHp);

			pstmt.executeUpdate();
			System.out.println("�뿩 ����");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}

		tfTitle.setText("");
		tfUser.setText("");
		tfHp.setText("");

		dlgMsg("å�� �뿩�ϼ̽��ϴ�.");

	}

	// å ��Ż ���� ����
	void updateBook(String InputTitle) {
		System.out.println(InputTitle);
		String query = "update book set available_for_rental = ? where book_name = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "no");
			pstmt.setString(2, InputTitle);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("å �뿩���·� ����");
		} catch (SQLException ee) {
			System.err.println("å �뿩���·� ����!!");

		}

	}

	void dlgMsg(String msg) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("alert");

		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("dialog.fxml"));
			Label txtTitle = (Label) parent.lookup("#txtTitle");
			txtTitle.setText(msg);
			Button btnOk = (Button) parent.lookup("#btnOk");
			btnOk.setOnAction(event -> dialog.close());
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (IOException e) {
		}

	}

}
