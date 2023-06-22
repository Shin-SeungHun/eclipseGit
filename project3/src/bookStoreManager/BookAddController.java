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

public class BookAddController implements Initializable {
	@FXML
	private TextField tfTitle;
	@FXML
	private TextField tfPrice;
	@FXML
	private TextField tfAuthor;
	@FXML
	private TextField tfPublisher;
	@FXML
	private Button btnRegist;
	@FXML
	private Button btnCancel;
	private Stage primaryStage;
	boolean idCheck = true;
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

		btnRegist.setOnAction(event -> regist(event));
		btnCancel.setOnAction(event -> home(event));
		dbCon();
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

	public void viewClose() {
		Stage stage11 = (Stage) btnRegist.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void home(ActionEvent event) {
		// main();
		cancel();
	}

	// public void home2(ActionEvent event) {
	// main();
	// regist();
	// }

	public void main() {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("bookManage.fxml"));
			primaryStage.setTitle("bookManager");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("button.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cancel() {
		Stage stage11 = (Stage) btnCancel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void regist(ActionEvent event) {
		inputTitle = tfTitle.getText().toString();
		inputPrice = tfPrice.getText().toString();
		inputAuthor = tfAuthor.getText().toString();
		inputPublisher = tfPublisher.getText().toString();

		// ����üũ
		if (inputTitle.equals("")) {
			dlgMsg("������ �Է����ּ���");
			return;
		} else if (inputPrice.equals("")) {
			dlgMsg("������ �Է����ּ���");
			return;
		} else if (inputAuthor.equals("")) {
			dlgMsg("���ڸ� �Է����ּ���");
			return;
		} else if (inputPublisher.equals("")) {
			dlgMsg("���ǻ縦 �Է����ּ���");
			return;
		}

		String pquery = "insert into book values (null, ?, ?, ?, ?,now(),?)";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfTitle.getText().toString());
			pstmt.setInt(2, Integer.parseInt(tfPrice.getText().toString()));
			pstmt.setString(3, tfAuthor.getText().toString());
			pstmt.setString(4, tfPublisher.getText().toString());
			pstmt.setString(5, "yes"); // �뿩�������� ����
			pstmt.executeUpdate();
			System.out.println("å�� ��ϵǾ����ϴ�.");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}

		// ���Ǳ� ��ǰ���ó���� ��������ó��...

		tfTitle.setText("");
		tfPrice.setText("");
		tfAuthor.setText("");
		tfPublisher.setText("");

		dlgMsg("å�� ��ϵǾ����ϴ�.");

		dbClose();
		viewClose();
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
