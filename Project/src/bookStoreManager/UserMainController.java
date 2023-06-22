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

public class UserMainController implements Initializable {
	@FXML
	private Button btnList; // 회원 목록
	@FXML
	private Button btnEdit; // 회원정보 수정
	@FXML
	private Button btnDel; // 회원탈퇴
	@FXML
	private Button btnJoin; // 회원등록
	@FXML
	private Button btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnList.setOnAction(event -> list(event));
		btnEdit.setOnAction(event -> edit(event));
		btnDel.setOnAction(event -> del(event));
		btnJoin.setOnAction(event -> join(event));
		btnCancel.setOnAction(event -> cancel(event));
	}

	public void list(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("user_list.fxml"));
			primaryStage.setTitle("List");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Button.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void edit(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("user_edit.fxml"));
			primaryStage.setTitle("Personal information change");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void del(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("user_del.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setTitle("Delete account");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void join(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("user_join.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setTitle("Join");
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
