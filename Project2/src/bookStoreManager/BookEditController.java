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
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookEditController implements Initializable {
	@FXML
	private Button btnEdit;
	@FXML
	private Button btnFindBook;
	@FXML
	private TextField tfTitle;
	@FXML
	private TextField tfPrice;
	@FXML
	private TextField tfAuthor;
	@FXML
	private TextField tfPublisher;
	

	// ������ Ŭ����������...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	
	private Stage primaryStage;
	boolean findBook = true;
	 String inputTitle, inputPrice, inputAuthor, inputPublisher;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnEdit.setOnAction(event -> edit(event));
		btnFindBook.setOnAction(event -> findBook(event));

		
		dbCon();
	}

	public void viewClose() {
		Stage stage11 = (Stage) btnEdit.getScene().getWindow();
		Platform.runLater(() -> {
			stage11.close();
		});
	}

	void dbCon() {
		////////////////////////////////////////
		/// ����Ÿ���̽�����..
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		////////////////////////////////////////////
	}

	void dbClose() {
		// Close �۾�
		try {
			rs.close();
			stmt.close();
			pstmt.close();
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("�ݱ� ����~!!");
		}
	}

	void findBook(ActionEvent event) {
		// ����å ã��
		String query = "select * from book";
		try {
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				if(tfTitle.getText().toString().equals(rs.getString("bookName"))) {
					
					dlgMsg("��������� ã�ҽ��ϴ�.");
//					tfTitle.setText(rs.getString("bookName"));
					tfPrice.setText(rs.getString("bookPrice"));
					tfAuthor.setText(rs.getString("author"));
					tfPublisher.setText(rs.getString("publisher"));
					
					findBook = false;
					break;
				}

			}
			if (findBook == true) {
				dlgMsg("å ������ �Է����ּ���.");
			}

		} catch (SQLException ee) {
			System.err.println("������ ȹ�����!!");
		}
		findBook = true;
	}

	void edit(ActionEvent event) {
		inputTitle = tfTitle.getText().toString();
		inputPrice = tfPrice.getText().toString();
		inputAuthor = tfAuthor.getText().toString();
		inputPublisher = tfPublisher.getText().toString();
		
		

		// ����üũ
		if (inputTitle.equals("")) {
			dlgMsg("������ �Է����ּ���");
			return;
		} else if (inputPrice.equals("")) {
			dlgMsg("������ �Է����ּ���");
			return;
		} else if (inputAuthor.equals("")) {
			dlgMsg("���ڸ� �Է����ּ���");
			return;
		} else if (inputPublisher.equals("")) {
			dlgMsg("���ǻ縦 �Է����ּ���");
			return;
		}
		updateBook(inputTitle, inputPrice, inputAuthor, inputPublisher);
	}

	
	void updateBook(String inputTitle, String inputPrice, String inputAuthor, String inputPublisher) {
		String query = "update book set bookName = ?, bookPrice = ?, author=?, publisher = ? where bookName = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputTitle);
			pstmt.setString(2, inputPrice);
			pstmt.setString(3, inputAuthor);
			pstmt.setString(4, inputPublisher);
			pstmt.setString(5, inputTitle);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("�����Ϸ�!");
		} catch (SQLException ee) {
			System.err.println("å �������� ����!!");

		}
	}
	void dlgMsg(String msg) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("alert");

		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("dialog.fxml"));
			Label txtTitle = (Label) parent.lookup("#txtTitle");
			txtTitle.setText(msg);
			Button btnOk = (Button) parent.lookup("#btnOk");
			btnOk.setOnAction(event -> dialog.close());
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (IOException e) {
		}

	}

}
