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
	private Button btnOk;
	@FXML
	private Label lbTitle;
	@FXML
	private Label lbContent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnOk.setOnAction(event -> cancel(event));

		String getData = BoardListController.obj.toString();

		String data[] = getData.split("/");

		// System.out.println("data[0]" + data[0]);
		// System.out.println("data[1]" + data[1]);
		// System.out.println("data[2]" + data[2]);
		// System.out.println("data[3]" + data[3]);
		//
		lbTitle.setText(data[1].trim());
		lbContent.setText(data[2].trim());

	}

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnOk.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

}
