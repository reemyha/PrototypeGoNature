package client;
import common.ChatIF;
import gui.LoginFrameController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientUI extends Application { 
	
	public static ClientController chat; //only one instance

	public static void main( String args[] ) throws Exception
	   { 
		    launch(args);  
	   } // end main
	 
	@Override
	public void start(Stage primaryStage) throws Exception {
		 chat= new ClientController("localhost", 5555);

		LoginFrameController aFrame = new LoginFrameController(); // create StudentFrame		 
		aFrame.start(primaryStage); 
						 
		 
	}
	
	
	
	
		
}
