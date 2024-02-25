package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

public class ServerFrameController  {
	
	public String defaultPort="5555";//TODO: PUT THIS AS AN ENUM IN A COMMON FOLDER
	
	@FXML
	private Button startServer = null;
	@FXML
	private Button closeServer = null;
	
	@FXML
	private Label serverStatus;
	@FXML 
	private TextFlow serverStatusPane;
	
	
	public void startServerBtn(ActionEvent event) throws Exception {
			System.out.println("servermayberunning");
			//((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			ServerUI.runServer(defaultPort);
			this.serverStatus.setText("Server Online");
			this.serverStatusPane.setStyle("-fx-background-color: Green;");
		}
	

	public void start(Stage primaryStage) throws Exception {	
		System.out.println("enterstart");
	     FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/serverScreen.fxml"));
	     loader.setController(this); // Set the controller
	     Parent root = loader.load();
	     Scene scene = new Scene(root);
	     primaryStage.setTitle("Server");
	     primaryStage.setScene(scene);
	     primaryStage.show();  	
	}
	
	public void closeServerBtn(ActionEvent event) throws Exception {
		System.out.println("exit Academic Tool");
		System.exit(0);			
	}

}