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

public class EnterOrderFrameController  {
	
	public String defaultPort="5555";
	
	@FXML
	private Button showOrder = null;
	@FXML
	private Button updateOrder = null;
	@FXML
	private TextField orderNumber;
	
	private String getOrderNumber() {
		return orderNumber.getText();
	}
	
	public void updateOrderBtn(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		UpdateDetailsScreen aFrame = new UpdateDetailsScreen(); // create StudentFrame
		//send order number to sql and he will return object order
		//aFrame.loadOrder(order);
		aFrame.start(primaryStage);
	}
	public void showOrderBtn(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		OrderDetailsScreen aFrame = new OrderDetailsScreen(); // create StudentFrame
		//send order number to sql and he will return object order
		//aFrame.loadOrder(order);
		aFrame.start(primaryStage);

	}
	

	public void start(Stage primaryStage) throws Exception {	
		 System.out.println("enterstart");
	     FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/enterOrderScreen.fxml"));
	     loader.setController(this); // Set the controller
	     Parent root = loader.load();
	     Scene scene = new Scene(root);
	     primaryStage.setTitle("GoNature - Enter Order");
	     primaryStage.setScene(scene);
	     primaryStage.show();  	
	}
	

}