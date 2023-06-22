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

		primaryStage.setTitle("�α���ȭ��");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false); // â ũ������
	}

	public static void main(String[] args) {
		launch(args); // start ����
	}
}

