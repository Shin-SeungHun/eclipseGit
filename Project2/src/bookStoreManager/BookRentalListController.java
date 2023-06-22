package bookStoreManager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookRentalListController implements Initializable {
	@FXML
	private CheckBox cbRentAll;
	@FXML
	private CheckBox cbRentNo;
	@FXML
	private CheckBox cbRentYes;
	@FXML
	private ListView<String> mList;
	@FXML
	private Button btnOk;
	ObservableList list = FXCollections.observableArrayList(); // 전역 변수로 선언한다면
	static int bookIdx[] = new int[20];

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbRentAll.setOnAction(event -> checkBox(event));
		cbRentNo.setOnAction(event -> checkBox(event));
		cbRentYes.setOnAction(event -> checkBox(event));
		// loadData();
		bookList("all");
		btnOk.setOnAction(event -> cancel(event));
	}


	public void checkBox(ActionEvent event) {
		if (cbRentAll.isSelected()) {
			cbRentYes.setSelected(false);
			cbRentNo.setSelected(false);
			if (cbRentAll.isSelected() == true && cbRentYes.isSelected() == false && cbRentNo.isSelected() == false) {
				mList.getItems().clear();
				System.out.println("전체");
				bookList("all");
			}

		} else if (cbRentYes.isSelected()) {
			cbRentAll.setSelected(false);
			cbRentNo.setSelected(false);
			if (cbRentAll.isSelected() == false && cbRentYes.isSelected() == true && cbRentNo.isSelected() == false) {
				mList.getItems().clear();
				System.out.println("대여가능");
				bookList("yes");
			}
		} else if (cbRentNo.isSelected()) {
			mList.getItems().clear();
			cbRentYes.setSelected(false);
			cbRentAll.setSelected(false);
			if (cbRentAll.isSelected() == false && cbRentYes.isSelected() == false && cbRentNo.isSelected() == true) {
				System.out.println("대여불가");
				bookList("no");
			}
		}
	}

	public void bookList(String gubun) {

		String query = "";
		if (gubun.equals("all")) {
			query = "select * from book";
		} else if (gubun.equals("yes")) {
			query = "select * from book where Available_for_rental='" + gubun + "'";
		} else if (gubun.equals("no")) {
			query = "select * from book where Available_for_rental='" + gubun + "'";
		}

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8";

		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			// String result = "";
			int cnt = 0;
			while (rs.next()) {
				if (cnt == 20) {
					break;
				}
				String item = rs.getString(1) + " / " + rs.getString(2) + " / " + rs.getString(3) + " / "
						+ rs.getString(4) + " / " + rs.getString(5);
				System.out.println("item: " + item);
				list.add(item);

				// 상세보기 처리를 위해서 싱크를 맞춰서 idx값을 저장
				// 리스트에서 아이템 선택시 인덱스값하고 맞춰서 제어를 위해
				bookIdx[cnt] = Integer.parseInt(rs.getString("idx"));
				cnt++;

			}
			mList.setItems(list);
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnOk.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

}
