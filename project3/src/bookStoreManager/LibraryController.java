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

public class LibraryController implements Initializable {
	@FXML
	private Button btnRental; // 대여
	@FXML
	private Button btnReturn; // 반납
	@FXML
	private Button btnRentalList; // 대여가능 책 목록
	@FXML
	private Button btnRentalUserList; // 대여자 목록
	@FXML
	private Button btnBookManager; // 도서 관리
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnHome;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnRental.setOnAction(event -> bookRental(event));
		btnReturn.setOnAction(event -> bookReturn(event));
		btnRentalList.setOnAction(event -> bookRentalList(event));
		btnRentalUserList.setOnAction(event -> rentalUserList(event));
		btnBookManager.setOnAction(event -> bookManager(event));
		btnCancel.setOnAction(event -> cancel(event));
		btnHome.setOnAction(event -> home(event));
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

	public void bookRental(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_rental.fxml"));
			primaryStage.setTitle("rental");
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// bookRentalViewClose();
	}

	public void bookReturn(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_return.fxml"));
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setTitle("return");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// bookReturnViewClose();
	}

	public void bookRentalList(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_rental_list.fxml"));
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setTitle("rentalList");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bookRentalListViewClose();
	}

	public void rentalUserList(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_rental_user.fxml"));
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setTitle("rentalUserList");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		rentalUserListViewClose();
	}

	public void bookManager(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("bookManage.fxml"));
			primaryStage.setTitle("bookManager");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Button.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bookManagerViewClose();
	}

	public void bookManagerViewClose() {
		Stage stage11 = (Stage) btnBookManager.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void bookRentalViewClose() {
		Stage stage11 = (Stage) btnRental.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void bookReturnViewClose() {
		Stage stage11 = (Stage) btnReturn.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void bookRentalListViewClose() {
		Stage stage11 = (Stage) btnRentalList.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void rentalUserListViewClose() {
		Stage stage11 = (Stage) btnRentalUserList.getScene().getWindow();
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
