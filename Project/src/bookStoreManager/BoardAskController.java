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
	private Button btnCancel;

	private Stage primaryStage;
	boolean idCheck = true;
	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_library?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	String inputTitle, inputContent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnRegist.setOnAction(event -> regist(event));
		btnCancel.setOnAction(event -> cancel(event));

		dbCon();
	}

	void dbCon() {
		////////////////////////////////////////
		/// 데이타베이스접속..
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
		// Close 작업
		try {

			pstmt.close();
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("닫기 실패~!!");
		}
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnRegist.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnCancel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	void regist(ActionEvent event) {
		String pquery = "insert into board values (null, ?, ?, now())";
		inputTitle = tfTitle.getText().toString();
		inputContent = content.getText().toString();
		if(inputTitle.equals("")) {
			dlgMsg("제목을 입력해주세요.");
			return;
		}else if(inputContent.equals("")) {
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
		dbClose();// 디비작업끝나서 닫기

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
