package bookStoreManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookListController implements Initializable {
	@FXML
	private ListView<String> mList;
	@FXML
	private Button btnOk;
	ObservableList list = FXCollections.observableArrayList(); // 전역 변수로 선언한다면

	public static Object obj = null; // 다른 클래스에서 사용하기위해서 선언

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loadData();
		btnOk.setOnAction(event -> home(event));

		mList.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// 수행할 처리
				obj = mList.getSelectionModel().getSelectedItem();
				System.out.println("리스트값:" + obj.toString());
				try {
					Stage primaryStage = new Stage();
					Parent root;
					root = FXMLLoader.load(getClass().getResource("book_list_detail.fxml"));
					Scene scene = new Scene(root);
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
	}

	public void loadData() {
		/// 데이타베이스접속..
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;
		// 접속 주소 : 3306/디비명
		String url = "jdbc:mysql://localhost:3306/db_library?useUnicode=true&characterEncoding=utf8";
		// String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from book";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String item = "책 번호: " + rs.getString("idx") + " / 책 이름: " + rs.getString("book_name") + " / 작가: "
						+ rs.getString("author") + " / 출판사: " + rs.getString("publisher") + " / 날짜: "
						+ rs.getString("date_reg");
				list.add(item);
			}
			mList.setItems(list);

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	public void home(ActionEvent event) {
		main();
		cancel();
	}

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
		Stage stage11 = (Stage) btnOk.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

}
