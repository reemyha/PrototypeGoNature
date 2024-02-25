// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package server;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import common.DbController;


import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */

public class EchoServer extends AbstractServer 
{
	
	//private String db_url, db_name, db_password;
	public static DbController Dbcontroller = null;
	
	private static Connection conn = null;
    private static final String DB_URL = "jdbc:mysql://localhost/sys?serverTimezone=IST";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Aa123456";
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  //final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   * 
   */


  public EchoServer(int port) 
  {
    super(port);
  }

  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   * @param 
   */
  
  
  
  public void handleMessageFromClient  (Object msg, ConnectionToClient client)
  {
	  
	  //get ordernumber and send to user the sql data
	  
	  System.out.println("Message received: " + msg + " from " + client);   
	   
  }
   
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
 * @return 
 * @return 
 * @return 
   */
  
  
  protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
		
		
		
		
	}

  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()  {
    System.out.println ("Server has stopped listening for connections.");
  }  
}
//End of EchoServer class
