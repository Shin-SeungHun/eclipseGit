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
	private Button btnRental; //대여
	@FXML
	private Button btnReturn; // 반납
	@FXML
	private Button btnRentalList; // 대여가능 책 목록
	@FXML
	private Button btnRentalUserList; // 대여자 목록
	@FXML
	private Button btnBookManager; // 책 관리
	@FXML
	private Button btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnRental.setOnAction(event -> bookRental(event));
		btnReturn.setOnAction(event -> bookReturn(event));
		btnRentalList.setOnAction(event -> bookRentalList(event));
		btnRentalUserList.setOnAction(event -> rentalUserList(event));
		btnBookManager.setOnAction(event -> bookManager(event));
		btnCancel.setOnAction(event -> cancel(event));
	}

	public void bookRental(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_rental.fxml"));
			primaryStage.setTitle("rental");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bookReturn(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_return.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setTitle("q&a");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bookRentalList(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_rental_list.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setTitle("admin");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void rentalUserList(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_rental_user.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("login.css").toString());
			primaryStage.setTitle("admin");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void bookManager(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("bookManage.fxml"));
			primaryStage.setTitle("bookStore");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("login.css").toString());
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
