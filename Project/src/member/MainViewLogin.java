package member;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewLogin extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("members_login.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("로그인화면");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false); // 창 크기조정
	}

	public static void main(String[] args) {
		launch(args); // start 동작
	}
}

