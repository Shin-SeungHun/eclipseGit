package bookStoreManager;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class BoardListDetailController implements Initializable {
	@FXML
	private TextField tfTitle;
	@FXML
	private TextArea content;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnDel;

	private Stage primaryStage;
	int idx;

	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_library?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String inputIdx, inputTitle, inputContent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnOk.setOnAction(event -> cancel(event));
		btnDel.setOnAction(event -> del(event));

		String getData = BoardListController.obj.toString();

		String data[] = getData.split("/");

		// System.out.println("data[0]" + data[0]);
		// System.out.println("data[1]" + data[1]);
		// System.out.println("data[2]" + data[2]);
		// System.out.println("data[3]" + data[3]);
		//
		tfTitle.setText(data[1].trim());
		content.setText(data[2].trim());

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

	public void del(ActionEvent event) {

		inputTitle = tfTitle.getText().toString();
		inputContent = content.getText().toString();
		// 공백체크
		if (inputTitle.equals("")) {
			dlgMsg("삭제할 내용이 없습니다.");
			return;
		} else if (inputContent.equals("")) {
			dlgMsg("삭제할 내용이 없습니다.");
			return;
		}

		detail(idx);
	}

	void detail(int idx) {
		System.out.println("idx: " + idx);
		String query = "select * from board where idx='" + idx + "'";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				tfTitle.setText(rs.getString("title"));
				content.setText(rs.getString("content"));
			}

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
		deleteBoard(idx);
	}

	public void deleteBoard(int idx) {
		String query = "delete from board where idx = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("문의글이 삭제되었습니다.");

			tfTitle.setText("");
			content.setText("");

			// viewClose();
			BoardListController.list.clear();
			// BoardListController.list.removeAll();// 리시트항목 모두제거
			BoardListController.loadData();// 삭제후 디비 새로읽기
		} catch (SQLException ee) {
			System.err.println("게시글 삭제 실패");
		}
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnDel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnOk.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
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
