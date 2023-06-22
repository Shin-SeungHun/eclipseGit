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
	private TextField tfTitle;
	@FXML
	private TextField tfUser;
	@FXML
	private TextField tfHp;

	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8";
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

		btnRental.setOnAction(event -> rental(event));
		btnFindBook.setOnAction(event -> findBook(event));

		dbCon();
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnRental.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
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
			System.err.println("닫기 실패~!!");
		}
	}

	void findBook(ActionEvent event) {
		// 수정책 찾기
		String query = "select * from book";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				if (tfTitle.getText().toString().equals(rs.getString("bookName"))) {

					dlgMsg("대여가능한 책을 검색했습니다.");
					// tfTitle.setText(rs.getString("bookName"));
					findBook = false;
					break;
				}

			}
			if (findBook == true) {
				dlgMsg("책 제목을 입력해주세요.");
			}

		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}
		findBook = true;
	}

	void rental(ActionEvent event) {
		inputTitle = tfTitle.getText().toString();
		inputUser = tfUser.getText().toString();
		inputHp = tfHp.getText().toString();

		// 공백체크
		if (inputTitle.equals("")) {
			dlgMsg("제목을 입력해주세요");
			return;
		} else if (inputUser.equals("")) {
			dlgMsg("이름을 입력해주세요");
			return;
		} else if (inputHp.equals("")) {
			dlgMsg("연락처를 입력해주세요");
			return;
		}

		updateBook(inputTitle);
		bookRent(inputTitle, inputUser, inputHp);
		dbClose();

	}

	void bookRent(String inputTitle, String inputUser, String inputHp) {
		String pquery = "insert into bookstore values (null, ?, ?, ?, now(),null)";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, inputTitle);
			pstmt.setString(2, inputUser);
			pstmt.setString(3, inputHp);

			pstmt.executeUpdate();
			System.out.println("대여 성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}

		tfTitle.setText("");
		tfUser.setText("");
		tfHp.setText("");

		dlgMsg("책을 대여하셨습니다.");

	}

	// 책 렌탈 상태 변경
	void updateBook(String InputTitle) {
		System.out.println(InputTitle);
		String query = "update book set Available_for_rental = ? where bookName = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "no");
			pstmt.setString(2, InputTitle);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("책 대여상태로 변경");
		} catch (SQLException ee) {
			System.err.println("책 대여상태로 실패!!");

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
