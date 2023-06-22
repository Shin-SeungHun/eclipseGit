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

public class BookDelController implements Initializable {
	@FXML
	private Button btnFindBook;
	@FXML
	private Button btnDel;
	@FXML
	private TextField tfTitle;
	@FXML
	private Label lbTitle;
	@FXML
	private Label lbPrice;
	@FXML
	private Label lbAuthor;
	@FXML
	private Label lbPublisher;

	private Stage primaryStage;
	boolean findBook = true;
	// ������ Ŭ����������...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_library?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	String inputTitle, inputPrice, inputAuthor, inputPublisher;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnDel.setOnAction(event -> del(event));
		btnFindBook.setOnAction(event -> findBook(event));

		dbCon();
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnDel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
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
			e.printStackTrace(); // printStackTrace�� ���ϰ��� ���� ȣ���ϸ� �޼ҵ尡 ���������� ���� ����� ȭ�鿡 ���, ���� �ڼ��� ���� ������ ����, ������
									// �߻��ٿ����� ã�Ƽ� �ܰ躰�� ������ ���
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

	void findBook(ActionEvent event) {
		// �������̵� ã��
		String query = "select * from book";
		try {
			rs = stmt.executeQuery(query);
			 
			while (rs.next()) {

				if (tfTitle.getText().toString().equals(rs.getString("book_name"))) {
					dlgMsg("������ å�� ã�ҽ��ϴ�.");
					findBook = true;
					// ���ã������ ǥ��
					lbTitle.setText(rs.getString("book_name"));
					lbPrice.setText(rs.getString("book_price"));
					lbAuthor.setText(rs.getString("author"));
					lbPublisher.setText(rs.getString("publisher"));
					findBook = false;
					break;
				}
			}
			if (findBook == true) {
				dlgMsg("å ������ �Է����ּ���.");
			}

		} catch (SQLException ee) {
			System.err.println("������ ȹ�����!!");
		}

	}

	void del(ActionEvent event) {
		inputTitle = tfTitle.getText().toString();
		// ����üũ
		if (inputTitle.equals("")) {
			dlgMsg("������ �Է����ּ���.");
			return;
		}

		deleteBook(inputTitle);
	}

	public void deleteBook(String inputTitle) {
		String query = "delete from book where book_name = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputTitle);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("å�� �����ϼ̽��ϴ�.");
			tfTitle.setText("");
			lbTitle.setText("");
			lbPrice.setText("");
			lbAuthor.setText("");
			lbPublisher.setText("");
			viewClose();
		} catch (SQLException ee) {
			System.err.println("å ������ �����߽��ϴ�.");
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
