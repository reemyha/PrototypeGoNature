package client;

import java.io.IOException;

import common.ChatIF;
import logic.Order;

public class ClientController implements ChatIF 
{
		//the port 
	   public static int DEFAULT_PORT ;
	  
	  //Instance variables **********************************************
	   
	  //The instance of the client that created this ConsoleChat.
	  Client client;
	  
	  public Order o;
	  public void setO(Order o) {
		  this.o = o;
	  }
	  //Constructors ****************************************************



	public Order getO() {
		return o;
	}



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
	 * @param oNum 
	   */
	  public void show(String flag, String oNum) 
	  {
		  String[] msg = new String[] {flag,oNum};
		  client.handleMessageFromClientUI(msg);
	  }
	  


	public void update(String flag, String oNum, String newParkName, String newTelephone) {
		// TODO Auto-generated method stub
		  String[] msg = new String[] {flag,oNum,newParkName,newTelephone};
		  client.handleMessageFromClientUI(msg);
	}


	@Override
	public void display(String message) 
	  {
	    System.out.println("> " + message);
	  }

}
