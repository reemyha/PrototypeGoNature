package server;

import javafx.stage.Stage;

import server.EchoServer;
import gui.ServerFrameController;
import javafx.application.Application;

public class ServerUI extends Application {
	
	
	//final public static int DEFAULT_PORT = 5555;
	//initalizing it 
	public static void main( String args[] ) throws Exception 
	{   
		launch(args);
	  } // end main
	
	
	
	//starts the server primary stage.
	
	@Override
	public void start(Stage primaryStage) throws Exception {
						  		
		//ServerFrameController aFrame = new ServerFrameController(); // create StudentFrame
		 
		//aFrame.start(primaryStage);
		
	}
	
	public static void runServer(String p)
	{
		 int port = 0; //Port to listen on

	        try
	        {
	        	port = Integer.parseInt(p); //Set port to 5555
	          
	        }
	        catch(Throwable t)
	        {
	        	System.out.println("ERROR - Could not connect!");
	        }
	    	
	        EchoServer sv = new EchoServer(port);
	        
	        try 
	        {
	          sv.listen(); //Start listening for connections
	        } 
	        catch (Exception ex) 
	        {
	          System.out.println("ERROR - Could not listen for clients!");
	        }
	}
	

}
