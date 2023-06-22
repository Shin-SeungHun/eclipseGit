package bookStoreManager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.stage.Stage;

public class BookListDetailController implements Initializable {
	@FXML
	private Label lbIdx;
	@FXML
	private Label lbAuthor;
	@FXML
	private Label lbPublisher;
	@FXML
	private Label lbName;
	@FXML
	private Label lbDate;
	@FXML
	private Button btnOk;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String getData = BookListController.obj.toString();
		btnOk.setOnAction(event -> cancel(event));
		String data[] = getData.split("/");

		// System.out.println("data[0]" + data[0]);
		// System.out.println("data[1]" + data[1]);
		// System.out.println("data[2]" + data[2]);
		// System.out.println("data[3]" + data[3]);
		//
		lbIdx.setText(data[0].trim());
		lbAuthor.setText(data[1].trim());
		lbName.setText(data[2].trim());
		lbPublisher.setText(data[3].trim());
		lbDate.setText(data[4].trim());
	}

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnOk.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

}
