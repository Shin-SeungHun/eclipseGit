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

public class BookManagerController implements Initializable {
	@FXML
	private Button btnBookAdd; // 책 등록
	@FXML
	private Button btnBookList; // 책 목록
	@FXML
	private Button btnBookEdit; // 책 정보 수정
	@FXML
	private Button btnBookDel; // 책 삭제
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnLibrary;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnBookAdd.setOnAction(event -> bookAdd(event));
		btnBookList.setOnAction(event -> bookList(event));
		btnBookEdit.setOnAction(event -> bookBookEdit(event));
		btnBookDel.setOnAction(event -> bookDel(event));
		btnHome.setOnAction(event -> home(event));
		btnLibrary.setOnAction(event -> home2(event));
		btnCancel.setOnAction(event -> cancel(event));
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnHome.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void viewClose2() {
		Stage stage11 = (Stage) btnLibrary.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void home(ActionEvent event) {
		main();
		viewClose();
	}

	public void home2(ActionEvent event) {
		library();
		viewClose2();
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

	public void library() {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("library.fxml"));
			primaryStage.setTitle("Library");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("button.css").toString());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bookAdd(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_add.fxml"));
			primaryStage.setTitle("book add");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// bookAddViewClose();
	}

	public void bookList(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_list.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("book list");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bookListViewClose();
	}

	public void bookBookEdit(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_edit.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("book edit");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// bookEditViewClose();
	}

	public void bookDel(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("book_del.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("book del");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// bookDelViewClose();
	}

	public void bookManager(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("bookManage.fxml"));
			primaryStage.setTitle("bookStore");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bookAddViewClose() {
		Stage stage11 = (Stage) btnBookAdd.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void bookListViewClose() {
		Stage stage11 = (Stage) btnBookList.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void bookEditViewClose() {
		Stage stage11 = (Stage) btnBookEdit.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	public void bookDelViewClose() {
		Stage stage11 = (Stage) btnBookDel.getScene().getWindow();
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
