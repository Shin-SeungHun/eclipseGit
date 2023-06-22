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

public class BoardAskController implements Initializable {
	@FXML
	private TextField tfTitle;
	@FXML
	private TextArea content;
	@FXML
	private Button btnRegist;
	@FXML
	private Button btnBack;

	private Stage primaryStage;
	boolean idCheck = true;

	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_library?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String inputTitle, inputContent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnRegist.setOnAction(event -> regist(event));
		btnBack.setOnAction(event -> home(event));

		dbCon();
	}

	void dbCon() {
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
	}

	void dbClose() {
		try {

			pstmt.close();
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("clsoe fail");
		}
	}

	public void home(ActionEvent event) {
//		main();
		cancel();
	}

//	public void home2(ActionEvent event) {
//		main();
//		regist();
//	}

	public void viewClose() {
		Stage stage11 = (Stage) btnRegist.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void cancel() {
		Stage stage11 = (Stage) btnBack.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});

	}

	public void main() {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("library_manager.fxml"));
			primaryStage.setTitle("Main");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("button.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void regist(ActionEvent event) {
		String pquery = "insert into board values (null, ?, ?, now())";
		inputTitle = tfTitle.getText().toString();
		inputContent = content.getText().toString();
		if (inputTitle.equals("")) {
			dlgMsg("제목을 입력해주세요.");
			return;
		} else if (inputContent.equals("")) {
			dlgMsg("내용을 입력해주세요.");
			return;
		}

		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfTitle.getText().toString());
			pstmt.setString(2, content.getText().toString());
			pstmt.executeUpdate();
			System.out.println("실행성공");
			tfTitle.setText("");
			content.setText("");
			dlgMsg("문의가 등록되었습니다.");
			viewClose();
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}

		dbClose();

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
