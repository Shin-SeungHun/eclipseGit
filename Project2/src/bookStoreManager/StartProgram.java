package bookStoreManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartProgram extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("user_login.fxml"));
//		Parent root = FXMLLoader.load(getClass().getResource("bookStoreManager.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("Login");
//		primaryStage.setTitle("bookStore");
		primaryStage.setScene(scene);
		
		primaryStage.show();
		primaryStage.setResizable(false); // 창 크기조정
	}

	public static void main(String[] args) {
		launch(args); // start 동작
	}
}
