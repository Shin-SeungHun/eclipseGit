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

public class BoardListController implements Initializable {
	@FXML
	private ListView<String> mList;
	@FXML
	private Button btnOk;
	ObservableList list = FXCollections.observableArrayList(); // ���� ������ �����Ѵٸ�

	public static Object obj = null; // �ٸ� Ŭ�������� ����ϱ����ؼ� ����

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loadData();
		btnOk.setOnAction(event -> cancel(event));

		mList.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// ������ ó��
				obj = mList.getSelectionModel().getSelectedItem();
				System.out.println("����Ʈ��:" + obj.toString());
				try {
					Stage primaryStage = new Stage();
					Parent root;
					root = FXMLLoader.load(getClass().getResource("board_list_detail.fxml"));
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
		/// ����Ÿ���̽�����..
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;
		// ���� �ּ� : 3306/����
		String url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8";
		// String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from board";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String item = "�۹�ȣ: " + rs.getString("idx") + " / " + rs.getString("title") + " / "
						+ rs.getString("content");
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

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnOk.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

}