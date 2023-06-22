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

public class DelController implements Initializable {
	@FXML
	private Button btnIdCheck;
	@FXML
	private Button btnDel;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField tfId;
	@FXML
	private Label lbName;
	@FXML
	private Label lbHp;
	@FXML
	private Label lbSex;

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

		btnDel.setOnAction(event -> del(event));
		btnCancel.setOnAction(event -> cancel(event));
		btnIdCheck.setOnAction(event -> idCheck(event));

		dbCon();
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnDel.getScene().getWindow();
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

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnCancel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	void idCheck(ActionEvent event) {
		// �������̵� ã��
		String query = "select * from tb_member2";
		try {
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				if (tfId.getText().toString().equals(rs.getString("id"))) {
					dlgMsg("������ ���̵� ã�ҽ��ϴ�");
					// idCheck = true;
					// ���ã������ ǥ��
					lbName.setText(rs.getString("name"));
					lbHp.setText(rs.getString("hp"));
					lbSex.setText(rs.getString("sex"));

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

	void del(ActionEvent event) {
		inputId = tfId.getText().toString();
		// ����üũ
		if (inputId.equals("")) {
			dlgMsg("���̵� �Է����ּ���.");
			return;
		}

		deleteMember(inputId);
	}

	public void deleteMember(String id) {
		String query = "delete from tb_member2 where id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("ȸ�������Ϸ�");
			tfId.setText("");
			lbName.setText("");
			lbHp.setText("");
			lbSex.setText("");
			viewClose();
		} catch (SQLException ee) {
			System.err.println("ȸ�� ���� ����!!");
		}

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
