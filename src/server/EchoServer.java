// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package server;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

import client.ClientUI;
import common.DbController;
import logic.Order;
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
	
    private static final String DB_URL = "jdbc:mysql://localhost/gonature?serverTimezone=IST";
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
  
  
  
  public void handleMessageFromClient (Object msg, ConnectionToClient client)
  {
	  //get order number and send to user the sql data
	  System.out.println("Message received: " + msg + " from " + client);  
	  DbController dbController = new DbController();

	    if (msg instanceof String[]) {
	        String[] order = (String[]) msg;
	        if (order[0].equals("SHOW")) {
	            // Retrieve order details

				Order orderDetails = dbController.getOrderDetails(order[1]);
				// Send the order details back to the client
				try {
					//sendToAllClients(orderDetails);
					client.sendToClient(orderDetails);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } else if (order[0].equals("UPDATE")) {
	            try {
	                // Placeholder for the UPDATE case
	                // Extract values from 'order' array and call the update method
	                String orderNum = order[1];
	                String telephone = order[2];
	                String parkName = order[3];
	                dbController.Update(orderNum, telephone, parkName);
	                
	                // Optionally, you can send a confirmation message back to the client
	                //client.sendToClient("UPDATE_SUCCESS");
	            } catch (Exception e) {
	                e.printStackTrace();
	                // Handle the error accordingly for UPDATE
	            }
	        } else {
	        	try {
	        		sendToAllClients(msg);
					client.sendToClient(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    }
	}
	  
	  
		  
	   
 
   
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
 * @return 
 * @return 
 * @return 
   */
 // private static Connection conn = null;
  
  protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
		
		DbController dbController = new DbController();
		// Establish a connection to the database when the server starts

		conn = dbController.connectToDB();
			
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
