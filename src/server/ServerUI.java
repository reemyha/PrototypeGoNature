package server;

import javafx.application.Application;
import javafx.stage.Stage;
import gui.ServerFrameController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import server.EchoServer;
import common.DbController;

public class ServerUI extends Application {
	
	//private static Connection conn = null;
	private static final int DEFAULT_PORT = 5555;
    private static final String DB_URL = "jdbc:mysql://localhost/gonature?serverTimezone=IST";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Aa123456";
    
	

	public static void main( String args[] ) throws Exception
	   {   
		 launch(args);
	  } // end main
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub				  		
		ServerFrameController aFrame = new ServerFrameController(); 
		//conn = connectToDB();
		 
		aFrame.start(primaryStage);
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
