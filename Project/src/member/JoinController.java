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

public class JoinController implements Initializable {
	@FXML
	private Button btnJoin;
	@FXML
	private Button btnIdCheck;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField tfId;
	@FXML
	private TextField tfPw;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfHp;
	@FXML
	private ChoiceBox chSex;

	private Stage primaryStage;
	boolean idCheck = true;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnJoin.setOnAction(event -> join(event));
		btnCancel.setOnAction(event -> cancel(event));
		btnIdCheck.setOnAction(event -> idCheck(event));

		chSex.getItems().add("남자");
		chSex.getItems().add("여자");
		chSex.setValue("남자");
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
			e.printStackTrace(); // printStackTrace는 리턴값이 없다 호출하면 메소드가 내부적으로 예외 결과를 화면에 출력, 가장 자세한 예외 정보를 제공, 에러의
									// 발생근원지를 찾아서 단계별로 에러를 출력
		}
		////////////////////////////////////////////
	}

	public void cancel(ActionEvent event) {
		viewClose();
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnJoin.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void join(ActionEvent event) {
		inputId = tfId.getText().toString();
		inputPw = tfPw.getText().toString();
		inputName = tfName.getText().toString();
		inputHp = tfHp.getText().toString();
		inputSex = (String) chSex.getValue();

		// 공백체크
		if (inputId.equals("")) {
			dlgMsg("아이디를 입력해주세요.");
			return;
		} else if (inputPw.equals("")) {
			dlgMsg("패스워드를 입력해주세요.");
			return;
		} else if (inputName.equals("")) {
			dlgMsg("이름을 입력해주세요.");
			return;
		} else if (inputHp.equals("")) {
			dlgMsg("연락처를 입력해주세요.");
			return;
		}

		insert(inputId, inputPw, inputName, inputHp, inputSex);

		// System.out.println("id: " + id);
		// System.out.println("pw: " + pw);
		// System.out.println("name: " + name);
		// System.out.println("hp: " + hp);
		// System.out.println("sex: " + sex);

	}

	void idCheck(ActionEvent event) {
		// 아이디중복체크...
		String query = "select * from tb_member2";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				if (tfId.getText().toString().equals(rs.getString("id"))) {
					dlgMsg("중복된 아이디");
					tfId.setText("");
					idCheck = false;

					break;
				}
			}
			if (idCheck == true) {
				dlgMsg("사용가능한 아이디");
				tfId.setDisable(true);
				btnIdCheck.setDisable(true);
			}

		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}

		idCheck = true;
	}

	void insert(String inputId, String inputPw, String inputName, String inputHp, String inputSex) {

		if (idCheck != true) {
			dlgMsg("아이디 중복체크부터하세요!");
			return;
		}

		String pquery = "insert into tb_member2 values (null, ?, ?, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			pstmt.setString(3, inputName);
			pstmt.setString(4, inputHp);
			pstmt.setString(5, inputSex);
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}

		// 회원가입처리후 사후제어처리...
		// tfId.setDisable(true);
		// btnIdCheck.setDisable(true);
		tfId.setText("");
		tfPw.setText("");
		tfName.setText("");
		tfHp.setText("");

		dlgMsg("회원가입 완료");
		viewClose();

	}

	void dlgMsg(String msg) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("회원가입 정보 알림");

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
