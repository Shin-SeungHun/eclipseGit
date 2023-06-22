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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EditController implements Initializable {
	@FXML
	private Button btnEdit;
	@FXML
	private Button btnIdCheck;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField tfId;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfHp;
	@FXML
	private ChoiceBox chSex;

	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	String inputId, inputPw, inputName, inputHp, inputSex = "남자";
	private Stage primaryStage;
	boolean idCheck = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnEdit.setOnAction(event -> edit(event));
		btnCancel.setOnAction(event -> cancel(event));
		btnIdCheck.setOnAction(event -> idCheck(event));

		chSex.getItems().add("남자");
		chSex.getItems().add("여자");
		chSex.setValue("남자");
		dbCon();
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnEdit.getScene().getWindow();
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
			e.printStackTrace(); // printStackTrace는 리턴값이 없다 호출하면 메소드가 내부적으로 예외 결과를 화면에 출력, 가장 자세한 예외 정보를 제공, 에러의
									// 발생근원지를 찾아서 단계별로 에러를 출력
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

	void idCheck(ActionEvent event) {
		// 수정아이디 찾기
		String query = "select * from tb_member2";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				if (tfId.getText().toString().equals(rs.getString("id"))) {
					// 수정할 목록 가져옴

					dlgMsg("대상을 찾았습니다.");
					// tfPw.setText(rs.getString("pw"));
					tfName.setText(rs.getString("name"));
					tfHp.setText(rs.getString("hp"));
					chSex.setValue(rs.getString("sex"));
					// String sex = rs.getString("sex");

					tfId.setDisable(true);
					btnIdCheck.setDisable(true);
					idCheck = false;
					break;
				}
			}

			if (idCheck == true) {
				dlgMsg("수정대상이 없습니다.");
			}

		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}
		idCheck = true;
	}

	void edit(ActionEvent event) {
		inputId = tfId.getText().toString();
		inputName = tfName.getText().toString();
		inputHp = tfHp.getText().toString();
		inputSex = (String) chSex.getValue();

		// 공백체크
		if (inputId.equals("")) {
			dlgMsg("아이디를 입력해주세요.");
			return;
		} else if (inputName.equals("")) {
			dlgMsg("이름을 입력해주세요.");
			return;
		} else if (inputHp.equals("")) {
			dlgMsg("연락처를 입력해주세요.");
		}
		updateMember(inputId, inputPw, inputName, inputHp, inputSex);
	}

	// 회원 정보수정을 위해서...
	void updateMember(String inputId, String inputPw, String inputName, String inputHp, String inputSex) {
		String query = "update tb_member2 set id = ?, pw = ?, name = ?, hp = ?, sex = ? where id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			pstmt.setString(3, inputName);
			pstmt.setString(4, inputHp);
			pstmt.setString(5, inputSex);
			pstmt.setString(6, inputId);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("수정완료");
			viewClose();
		} catch (SQLException ee) {
			System.err.println("회원 정보수정 실패!!");

		}

	}

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnCancel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	void dlgMsg(String msg) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("회원수정 정보 알림");

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
