package bookStoreManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

public class BookReturnController implements Initializable {
	@FXML
	private Button btnFindBook;
	@FXML
	private TextField tfTitle;

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
	String inputTitle, inputHp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnFindBook.setOnAction(event -> findBook(event));

		dbCon();
	}

	// public void viewClose() {
	// Stage stage11 = (Stage) btn.getScene().getWindow();
	// Platform.runLater(() -> {
	// stage11.close();
	// });
	// }

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
//			pstmt.close();
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
		inputTitle = tfTitle.getText().toString();
		String query = "select * from bookstore";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				if (inputTitle.equals(rs.getString("bookName"))) {

					findBook = false;
					dlgMsg("반납 가능한 책입니다.");
					
					dlgReturn(rs.getString("bookName"), rs.getString("userHp"), rs.getString("return_date"));
					break;
				}
			
			}
			if (findBook == true) {
				dlgMsg("반납 가능한 책이 아닙니다.");
			}

		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}

	}

	// 책 렌탈 상태 변경
	public void updateBook(String inputTitle) {
		System.out.println(inputTitle);
		String query = "update book set Available_for_rental = ? where bookName = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "yes");
			pstmt.setString(2, inputTitle);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("책 대여상태로 변경!");
		} catch (SQLException ee) {
			System.err.println("책 대여상태로 실패!!");

		}

	}

	// 책대여리스트 반납일 업데이트..
	public void updateRentalList(String inputTitle) {
		String query = "update bookstore set return_date = now() where bookName = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputTitle);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("반납완료!");
		} catch (SQLException ee) {
			System.err.println("책 반납 실패!!");

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

	void dlgReturn(String bookTitle, String hp, String date) {
		Stage dlgReturn = new Stage(StageStyle.UTILITY);
		dlgReturn.initModality(Modality.WINDOW_MODAL);
		dlgReturn.initOwner(primaryStage);
		dlgReturn.setTitle("alert");

		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("dialog_return.fxml"));
			// Label txtTitle = (Label) parent.lookup("#txtTitle");

			Label lbTitle = (Label) parent.lookup("#lbTitle");
			lbTitle.setText(bookTitle);
			Label lbHp = (Label) parent.lookup("#lbHp");
			lbHp.setText(hp);
			Label lbDate = (Label) parent.lookup("#lbDate");
			lbDate.setText(date);

			Button btnReturn = (Button) parent.lookup("#btnReturn");
			btnReturn.setOnAction(event -> updateBook(bookTitle));// 책제목으로 호출해서 대여상태변환
			btnReturn.setOnAction(event -> updateRentalList(bookTitle));
			Scene scene = new Scene(parent);
			dlgReturn.setScene(scene);
			dlgReturn.setResizable(false);
			dlgReturn.show();
		} catch (IOException e) {
		}

	}

}
