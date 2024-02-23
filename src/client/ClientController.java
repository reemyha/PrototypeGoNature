package client;

import java.io.IOException;

import common.ChatIF;

public class ClientController implements ChatIF 
{
		//the port 
	   public static int DEFAULT_PORT ;
	  
	  //Instance variables **********************************************
	   
	  //The instance of the client that created this ConsoleChat.
	  Client client;

	  //Constructors ****************************************************

	  /**
	   * Constructs an instance of the ClientConsole UI.
	   *
	   * @param host The host to connect to.
	   * @param port The port to connect on.
	   */
	  
	  public ClientController(String host, int port) 
	  {
	    try 
	    {
	      client= new Client(host, port, this);
	    } 
	    catch(IOException exception) 
	    {
	      System.out.println("Error: Can't setup connection!"+ " Terminating client.");
	      System.exit(1); 
	    }
	  }

	  
	  //Instance methods ************************************************
	  
	  /**
	   * This method waits for input from the console.  Once it is 
	   * received, it sends it to the client's message handler.
	   */
	  public void accept(String str) 
	  {
		  client.handleMessageFromClientUI(str);
	  }
	  
	  /**
	   * This method overrides the method in the ChatIF interface.  It
	   * displays a message onto the screen.
	   *
	   * @param message The string to be displayed.
	   */
	  public void display(String message) 
	  {
	    System.out.println("> " + message);
	  }

}
