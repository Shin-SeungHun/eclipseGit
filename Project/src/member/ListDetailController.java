package member;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListDetailController implements Initializable {
	@FXML
	private Label lbId;
	@FXML
	private Label lbPw;
	@FXML
	private Label lbHp;
	@FXML
	private Label lbName;
	@FXML
	private Label lbSex;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String getData = ListController.obj.toString();
		
		String data[]  = getData.split("/");
		
		System.out.println("data[0]"+data[0]);
		System.out.println("data[1]"+data[1]);
		System.out.println("data[2]"+data[2]);
		System.out.println("data[3]"+data[3]);
		
		lbId.setText(data[0].trim());
		lbName.setText(data[1].trim());
		lbHp.setText(data[2].trim());
		lbSex.setText(data[3].trim());
		
		
	}

}
