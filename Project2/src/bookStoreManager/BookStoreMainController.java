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
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BookStoreMainController implements Initializable {
	@FXML
	private Button btnBookManager; // ��������
	@FXML
	private Button btnUser; // ȸ������
	@FXML
	private Button btnAsk; // ���ǰԽ���
	@FXML
	private Button btnAdmin; // ������ ���
	@FXML
	private Button btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnBookManager.setOnAction(event -> bookStoreManager(event));
		btnUser.setOnAction(event -> user(event));
		btnAsk.setOnAction(event -> ask(event));
		btnAdmin.setOnAction(event -> admin(event));
		btnCancel.setOnAction(event -> cancel(event));
	}

	public void bookStoreManager(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("bookStore.fxml"));
			primaryStage.setTitle("bookStore");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void user(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("user_main.fxml"));
			primaryStage.setTitle("user");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ask(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("board_ask.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("q&a");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void admin(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("board_list.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("admin");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnCancel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}
}
