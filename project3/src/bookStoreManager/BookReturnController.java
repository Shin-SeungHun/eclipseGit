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

public class BookReturnController implements Initializable {
	@FXML
	private Button btnFindBook;
	@FXML
	private TextField tfTitle;
	@FXML
	private Button btnCancel;
	@FXML
	private Label lbBookName;
	@FXML
	private Label lbRentUser;
	@FXML
	private Label lbRentUserHp;
	@FXML
	private Label lbRentalDate;
	@FXML
	private Button btnReturn;

	// 디비관련 클래스변수들...
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
	String inputTitle, inputHp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnFindBook.setOnAction(event -> detail(event));
		btnReturn.setOnAction(event -> home2(event));
		btnCancel.setOnAction(event -> home(event));
		dbCon();
	}

	public void home(ActionEvent event) {
		// main();
		cancel();
	}

	public void home2(ActionEvent event) {
		bookReturn();
		// main();
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

	public void cancel() {
		Stage stage11 = (Stage) btnCancel.getScene().getWindow();
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
			// pstmt.close();
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("닫기 실패");
		}
	}

	void detail(ActionEvent event) {
		inputTitle = tfTitle.getText().toString();
		if (inputTitle.equals("")) {
			dlgMsg("반납할 책의 제목을 입력해주세요");
			return;
		}
		findBook(inputTitle);
	}

	void findBook(String inputTitle) {
		// inputTitle = tfTitle.getText().toString();
		String query = "select * from library where rental_book_name='" + inputTitle + "'and isnull(return_date)";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				if (inputTitle.equals(rs.getString("rental_book_name"))) {

					lbBookName.setText(rs.getString("rental_book_name"));
					lbRentUser.setText(rs.getString("rental_user_name"));
					lbRentUserHp.setText(rs.getString("rental_user_hp"));
					lbRentalDate.setText(rs.getString("rental_date"));

					findBook = false;
					dlgMsg("반납 가능한 책입니다.");

					// dlgReturn(inputTitle, rs.getString("userHp"), rs.getString("rental_date"));
					break;
				}

			}
			if (findBook == true) {
				dlgMsg("반납 가능한 책이 아닙니다.");
			}

		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패");
		}
		findBook = true;
	}

	void bookReturn() {
		inputTitle = tfTitle.getText().toString();
		if (inputTitle.equals("")) {
			dlgMsg("반납하실 책의 제목을 입력해주세요.");
			return;
		}
		updateBook(inputTitle);
		updateRentalList(inputTitle);
		viewClose();
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnReturn.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	// 책 렌탈 상태 변경
	public void updateBook(String inputTitle) {
		System.out.println(inputTitle);
		String query = "update book set available_for_rental = ? where book_name = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "yes");
			pstmt.setString(2, inputTitle);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("반납하신 책이 대여상태로 변경되었습니다.");
		} catch (SQLException ee) {
			System.err.println("책 대여상태 변경을 실패했습니다.");

		}

	}

	// 책대여리스트 반납일 업데이트..
	public void updateRentalList(String inputTitle) {
		String query = "update library set return_date = now() where rental_book_name = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputTitle);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("반납이 완료되었습니다.");
			lbBookName.setText("");
			lbRentUser.setText("");
			lbRentUserHp.setText("");
			lbRentalDate.setText("");
		} catch (SQLException ee) {
			System.err.println("책 반납에 실패");

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
