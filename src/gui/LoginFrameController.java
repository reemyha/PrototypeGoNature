package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import client.ClientController;
import client.ClientUI;
import gui.EnterOrderFrameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import server.EchoServer;
import server.ServerUI;

public class LoginFrameController  {
	
	public String defaultPort="5555";
	
	@FXML
	private Button login = null;
	@FXML
	private TextField ipAddressT;
	@FXML
	private TextField portT;
	
	private String getIpAddress() {
		return ipAddressT.getText();
	}
	private Integer getPort() {
		return Integer.valueOf(portT.getText());
	}
	public static ClientController chat;
	
	
	public void loginBtn(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		EnterOrderFrameController aFrame = new EnterOrderFrameController(); // create StudentFrame
		aFrame.start(primaryStage);
		getIpAddress();
		getPort();
		chat= new ClientController(getIpAddress(), getPort());
		}
	

	public void start(Stage primaryStage) throws Exception {	
		System.out.println("enterstart");
	     FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/loginScreen.fxml"));
	     loader.setController(this); // Set the controller
	     Parent root = loader.load();
	     Scene scene = new Scene(root);
	     primaryStage.setTitle("GoNature");
	     primaryStage.setScene(scene);
	     primaryStage.show();
	     
	}
	
	public void closeServerBtn(ActionEvent event) throws Exception {
	
	}

}