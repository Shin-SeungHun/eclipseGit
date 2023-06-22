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
	// ������ Ŭ����������...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	String inputId, inputPw, inputName, inputHp, inputSex = "����";

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnJoin.setOnAction(event -> join(event));
		btnCancel.setOnAction(event -> cancel(event));
		btnIdCheck.setOnAction(event -> idCheck(event));

		chSex.getItems().add("����");
		chSex.getItems().add("����");
		chSex.setValue("����");
		dbCon();
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

		// ����üũ
		if (inputId.equals("")) {
			dlgMsg("���̵� �Է����ּ���.");
			return;
		} else if (inputPw.equals("")) {
			dlgMsg("�н����带 �Է����ּ���.");
			return;
		} else if (inputName.equals("")) {
			dlgMsg("�̸��� �Է����ּ���.");
			return;
		} else if (inputHp.equals("")) {
			dlgMsg("����ó�� �Է����ּ���.");
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
		// ���̵��ߺ�üũ...
		String query = "select * from tb_member2";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				if (tfId.getText().toString().equals(rs.getString("id"))) {
					dlgMsg("�ߺ��� ���̵�");
					tfId.setText("");
					idCheck = false;

					break;
				}
			}
			if (idCheck == true) {
				dlgMsg("��밡���� ���̵�");
				tfId.setDisable(true);
				btnIdCheck.setDisable(true);
			}

		} catch (SQLException ee) {
			System.err.println("������ ȹ�����!!");
		}

		idCheck = true;
	}

	void insert(String inputId, String inputPw, String inputName, String inputHp, String inputSex) {

		if (idCheck != true) {
			dlgMsg("���̵� �ߺ�üũ�����ϼ���!");
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
			System.out.println("���༺��");
		} catch (SQLException ee) {
			System.err.println("Query ���� Ŭ���� ���� ����~!! : " + ee.toString());
		}

		// ȸ������ó���� ��������ó��...
		// tfId.setDisable(true);
		// btnIdCheck.setDisable(true);
		tfId.setText("");
		tfPw.setText("");
		tfName.setText("");
		tfHp.setText("");

		dlgMsg("ȸ������ �Ϸ�");
		viewClose();

	}

	void dlgMsg(String msg) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("ȸ������ ���� �˸�");

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
