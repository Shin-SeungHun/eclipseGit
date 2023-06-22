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
	// 디비관련 클래스변수들...
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

		// 공백체크
		if (inputTitle.equals("")) {
			dlgMsg("제목을 입력해주세요");
			return;
		} else if (inputPrice.equals("")) {
			dlgMsg("가격을 입력해주세요");
			return;
		} else if (inputAuthor.equals("")) {
			dlgMsg("저자를 입력해주세요");
			return;
		} else if (inputPublisher.equals("")) {
			dlgMsg("출판사를 입력해주세요");
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
			pstmt.setString(5, "yes"); // 대여가능한지 여부
			pstmt.executeUpdate();
			System.out.println("책이 등록되었습니다.");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}

		// 자판기 상품등록처리후 사후제어처리...

		tfTitle.setText("");
		tfPrice.setText("");
		tfAuthor.setText("");
		tfPublisher.setText("");

		dlgMsg("책이 등록되었습니다.");

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
