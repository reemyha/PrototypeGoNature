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

public class UpdateDetailsScreen implements Initializable  {
	
	public String defaultPort="5555";
	
	@FXML
	private Label orderNumberT;
	@FXML
	private ComboBox parkNameT;
	@FXML
	private TextField telephoneT;
	@FXML
	private Label emailT;
	@FXML
	private Label dateT;
	@FXML
	private Label attendeesT;
	
	@FXML
	private Button saveBtn = null;
	@FXML
	private Button backBtn = null;
	
	ObservableList<String> list;
	
	public void backBtn(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		EnterOrderFrameController aFrame = new EnterOrderFrameController(); // create StudentFrame
		aFrame.start(primaryStage);
	}
	
//	public void loadOrder(Order o) {
//		this.s=s1;
//		this.txtID.setText(s.getId());
//		this.txtName.setText(s.getPName());
//		this.txtSurname.setText(s.getLName());		
//		this.cmbFaculty.setValue(s.getFc().getFName());
//	}
	

	public void start(Stage primaryStage) throws Exception {	
		 System.out.println("enterstart");
	     FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/updateDetailsScreen.fxml"));
	     loader.setController(this); // Set the controller
	     Parent root = loader.load();
	     Scene scene = new Scene(root);
	     primaryStage.setTitle("GoNature - Update");
	     primaryStage.setScene(scene);
	     primaryStage.show();  	
	}
	
	private String getParkName() {
		return (String)parkNameT.getValue();
	}
	private String getTelephone() {
		return telephoneT.getText();
	}
	
	public void saveBtn(ActionEvent event) throws Exception {
		String newParkName = this.getParkName();
		String newTelephone = this.getTelephone();
	}
	
	 //creating list of Faculties
	private void setComboBox() {
		ArrayList<String> al = new ArrayList<String>();	
		al.add("YellowStone");
		al.add("Hyde Park");
		al.add("Black Forest");

		list = FXCollections.observableArrayList(al);
		parkNameT.setItems(list);
		parkNameT.getSelectionModel().select("Hyde Park");//getparkname
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		setComboBox();		
	}

}