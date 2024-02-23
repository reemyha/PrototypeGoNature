package server;

import ocsf.server.ConnectionToClient;
import ocsf.server.*;

public class EchoServer extends AbstractServer {
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  //Constructs an instance of the echo server.
  
	
  public EchoServer(int port) 
  {
    super(port);
  }

  public void handleMessageFromClient (Object msg, ConnectionToClient client)
  {		
	  //to do- provide to db controller the action to do.
	  //to do - chose the data structure 
	  	
	    System.out.println("Message received: " + msg + " from " + client);
	    //this.sendToAllClients(msg);

	    
  }
  
  
  protected void serverStarted()
  {
	  
	   System.out.println
      ("Server listening for connections on port " + getPort());
	   
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods *****************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
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
//End of EchoServer class
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
     

 