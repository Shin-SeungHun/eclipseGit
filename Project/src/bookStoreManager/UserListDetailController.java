package bookStoreManager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.stage.Stage;

public class UserListDetailController implements Initializable {
	@FXML
	private Label lbId;
	@FXML
	private Label lbPw;
	@FXML
	private Label lbName;
	@FXML
	private Label lbNickName;
	@FXML
	private Label lbAge;
	@FXML
	private Label lbHp;
	@FXML
	private Label lbGender;
	@FXML
	private Button btnOk;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String getData = UserListController.obj.toString();
		btnOk.setOnAction(event -> cancel(event));
		String data[] = getData.split("/");

		// System.out.println("data[0]" + data[0]);
		// System.out.println("data[1]" + data[1]);
		// System.out.println("data[2]" + data[2]);

		// System.out.println("data[3]" + data[3]);
		//
		lbId.setText(data[0].trim());
		lbPw.setText(data[1].trim());
		lbName.setText(data[2].trim());
		lbNickName.setText(data[3].trim());
		lbAge.setText(data[4].trim());
		lbHp.setText(data[5].trim());
		lbGender.setText(data[6].trim());
	}

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnOk.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

}
