package member;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController implements Initializable {
	@FXML // fxml과 같아야 함
	private Button btnLogin;
	@FXML
	private Button btnJoin;
	@FXML
	private TextField tfId;
	@FXML
	private TextField tfPw;

	private Stage primaryStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnLogin.setOnAction(event -> login(event));
		btnJoin.setOnAction(event -> join(event));
	}

	public void login(ActionEvent event) {
		String fxId = tfId.getText().toString();
		String fxPw = tfPw.getText().toString();
		// System.out.println("id:"+id);
		// System.out.println("pw:"+pw);

		if (tfId.getText().toString().equals("")) {
			dlgMsg("아이디를 입력하시오.");
			return;
		}
		if (tfPw.getText().toString().equals("")) {
			dlgMsg("패스워드를 입력하시오.");
			return;
		}

		String inputId = tfId.getText();
		String inputPw = tfPw.getText();
		////////////////////////////////////////
		/// 데이타베이스접속..

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;
		// 접속 주소 : 3306/디비명
		String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
		// String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from tb_member2";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			boolean idOk = false;
			while (rs.next()) {
				if (inputId.equals(rs.getString(2))) {
					idOk = true;
					if (inputPw.equals(rs.getString(3))) {

						dlgMsg("로그인 성공!!");
						viewClose();
						main();
					} else {
						dlgMsg("비번이 틀립니다!!");
					}
				}

			}
			if (idOk == false) {
				dlgMsg("아이디를 확인하세요.");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	public void viewClose() {
		Stage stage11 = (Stage) btnLogin.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void main() {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("members_main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void join(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("members_join.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void dlgMsg(String msg) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("로그인 화면");

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
