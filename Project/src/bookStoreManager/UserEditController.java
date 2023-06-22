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

public class UserEditController implements Initializable {
	@FXML
	private Button btnEdit;
	@FXML
	private Button btnIdCheck;
	@FXML
	private TextField tfId;
	@FXML
	private TextField tfPw;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfNickname;
	@FXML
	private TextField tfAge;
	@FXML
	private TextField tfHp;
	@FXML
	private ChoiceBox chGender;

	// ������ Ŭ����������...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_library?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	String inputId, inputPw, inputName, inputNickname, inputAge, inputHp, inputGender = "����";
	private Stage primaryStage;
	boolean idCheck = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnEdit.setOnAction(event -> edit(event));
		btnIdCheck.setOnAction(event -> idCheck(event));

		chGender.getItems().add("����");
		chGender.getItems().add("����");
		chGender.getItems().add("���� ����");

		chGender.setValue("����");
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
		/// ����Ÿ���̽�����..
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
			e.printStackTrace(); // printStackTrace�� ���ϰ��� ���� ȣ���ϸ� �޼ҵ尡 ���������� ���� ����� ȭ�鿡 ���, ���� �ڼ��� ���� ������ ����, ������
									// �߻��ٿ����� ã�Ƽ� �ܰ躰�� ������ ���
		}
		////////////////////////////////////////////
	}

	void dbClose() {
		// Close �۾�
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
			System.err.println("�ݱ� ����~!!");
		}
	}

	void idCheck(ActionEvent event) {
		// �������̵� ã��
		String query = "select * from user";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				if (tfId.getText().toString().equals(rs.getString("id"))) {
					// ������ ��� ������

					dlgMsg("�Է��� ���̵� ã�ҽ��ϴ�.");
					tfPw.setText(rs.getString("pw"));
					tfName.setText(rs.getString("name"));
					tfNickname.setText(rs.getString("nickname"));
					tfAge.setText(rs.getString("age"));
					tfHp.setText(rs.getString("hp"));
					chGender.setValue(rs.getString("gender"));
					// String sex = rs.getString("sex");

					tfId.setDisable(true);
					btnIdCheck.setDisable(true);
					idCheck = false;
					break;
				}
			}

			if (idCheck == true) {
				dlgMsg("��������� �����ϴ�.");
			}

		} catch (SQLException ee) {
			System.err.println("������ ȹ�����!!");
		}
		idCheck = true;
	}

	void edit(ActionEvent event) {
		inputId = tfId.getText().toString();
		inputPw = tfPw.getText().toString();
		inputName = tfName.getText().toString();
		inputNickname = tfNickname.getText().toString();
		inputAge = tfAge.getText().toString();
		inputHp = tfHp.getText().toString();
		inputGender = (String) chGender.getValue();

		// ����üũ
		if (inputId.equals("")) {
			dlgMsg("���̵� �Է����ּ���.");
			return;
		} else if (inputPw.equals("")) {
			dlgMsg("��й�ȣ�� �Է����ּ���");
			return;
		} else if (inputName.equals("")) {
			dlgMsg("�̸��� �Է����ּ���.");
			return;
		} else if (inputNickname.equals("")) {
			dlgMsg("�г����� �Է����ּ���");
			return;
		} else if (inputAge.equals("")) {
			dlgMsg("���̸� �Է����ּ���");
			return;
		} else if (inputHp.equals("")) {
			dlgMsg("����ó�� �Է����ּ���.");
			return;
		}
		updateUser(inputId, inputPw, inputName, inputNickname, inputAge, inputHp, inputGender);
	}

	// ȸ�� ���������� ���ؼ�...
	void updateUser(String inputId, String inputPw, String inputName, String inputNickname, String inputAge,
			String inputHp, String inputGender) {
		String query = "update user set id = ?, pw = ?, name = ?, nickname = ?, age = ?,  hp = ?, gender = ? where id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			pstmt.setString(3, inputName);
			pstmt.setString(4, inputNickname);
			pstmt.setString(5, inputAge);
			pstmt.setString(6, inputHp);
			pstmt.setString(7, inputGender);
			pstmt.setString(8, inputId);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("ȸ������ ������ �Ϸ�Ǿ����ϴ�.");
			viewClose();
		} catch (SQLException ee) {
			System.err.println("ȸ�� ���������� �����߽��ϴ�.");

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
