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
	
	private static Connection conn = null;
	private static final int DEFAULT_PORT = 5555;
    private static final String DB_URL = "jdbc:mysql://localhost/";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Aa123456";
    
	

	public static void main( String args[] ) throws Exception
	   {   
		 launch(args);
	  } // end main
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub				  		
		ServerFrameController aFrame = new ServerFrameController(); // create StudentFrame
		//conn = connectToDB();
		 
		aFrame.start(primaryStage);
	}
	
	/*private Connection connectToDB() 
	{
		System.out.println("Connecting to DataBase");
		if (conn == null) {
			try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver definition succeed");
        } catch (Exception ex) {
        	/* handle the error*/
        	/* System.out.println("Driver definition failed");
        	 }
        
        try 
        {
        	Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed");
            return conn;
        
	 	} catch (SQLException ex) 
		    {/* handle any errors*/
	 		// handleException("Failed to connect to the database", ex);
	    /*System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	    }
        
		}
		return null;
	}*/
	
	
	

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
