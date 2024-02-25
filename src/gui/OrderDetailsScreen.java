package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import client.ClientUI;
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
import logic.Order;
import server.EchoServer;
import server.ServerUI;

public class OrderDetailsScreen  {
	
	public String defaultPort="5555";
	
	@FXML
	private Button showOrder = null;
	@FXML
	private Button updateOrder = null;
	
	@FXML
	private Label orderNumberT;
	@FXML
	private Label parkNameT;
	@FXML
	private Label telephoneT;
	@FXML
	private Label emailT;
	@FXML
	private Label dateT;
	@FXML
	private Label attendeesT;
	
	@FXML
	private Button back = null;
	
	private Order o;
	
	public void backBtn(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		EnterOrderFrameController aFrame = new EnterOrderFrameController(); // create StudentFrame
		aFrame.start(primaryStage);
	}

	public void loadOrder() {
		this.o = ClientUI.chat.getO();
		this.orderNumberT.setText(o.getOrderNumber());
		this.parkNameT.setText(o.getParkName());
		this.telephoneT.setText(o.getTelephone());
		this.emailT.setText(o.getEmail());
		this.dateT.setText(o.getDate());
		this.attendeesT.setText(o.getAttendees());
	
	
	}
	
	public void start(Stage primaryStage) throws Exception {	
		 System.out.println("enterstart");
	     FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/orderDetailsScreen.fxml"));
	     loader.setController(this); // Set the controller
	     Parent root = loader.load();
	     Scene scene = new Scene(root);
	     primaryStage.setTitle("GoNature - Order Details");
	     primaryStage.setScene(scene);
	     primaryStage.show();  	
	}
	

	

}