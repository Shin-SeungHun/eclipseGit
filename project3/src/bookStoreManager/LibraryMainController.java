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

public class LibraryMainController implements Initializable {
	@FXML
	private Button btnBookManager; // 도서관리
	@FXML
	private Button btnUser; // 회원관리
	@FXML
	private Button btnAsk; // 문의게시판
	@FXML
	private Button btnAdmin; // 관리자 모드
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnHome;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnBookManager.setOnAction(event -> libraryManager(event));
		btnUser.setOnAction(event -> user(event));

		btnAsk.setOnAction(event -> ask(event));
		btnAdmin.setOnAction(event -> admin(event));

		btnAdmin.setVisible(false);
		btnAdmin.setVisible(true);

		btnCancel.setOnAction(event -> cancel(event));
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnHome.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void home(ActionEvent event) {
		main();
		viewClose();
	}

	public void main() {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("library_manager.fxml"));
			primaryStage.setTitle("Main");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("button.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void libraryManager(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("library.fxml"));
			primaryStage.setTitle("Library");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("button.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		libraryViewClose();
	}

	public void user(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("user_main.fxml"));
			primaryStage.setTitle("user");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("button.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);

		} catch (IOException e) {
			e.printStackTrace();
		}
		userViewClose();
	}

	public void ask(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("board_ask.fxml"));
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("button.css").toString());
			primaryStage.setTitle("Q&A");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// askViewClose();
	}

	public void admin(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("board_list.fxml"));
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("button.css").toString());
			primaryStage.setTitle("admin");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);

		} catch (IOException e) {
			e.printStackTrace();
		}
		adminViewClose();
	}

	public void libraryViewClose() {
		Stage stage11 = (Stage) btnBookManager.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void userViewClose() {
		Stage stage11 = (Stage) btnUser.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void askViewClose() {
		Stage stage11 = (Stage) btnAsk.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void adminViewClose() {
		Stage stage11 = (Stage) btnAdmin.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void cancel(ActionEvent event) {
		Stage stage11 = (Stage) btnCancel.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}
}
