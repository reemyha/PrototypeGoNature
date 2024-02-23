package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DbController {
	
	private static Connection conn = null;
	
	public Connection connectToDB() 
	{
		System.out.println("Connecting to DataBase");
		if (conn == null) {
			try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver definition succeed");
        } catch (Exception ex) {
        	/* handle the error*/
        	 System.out.println("Driver definition failed");
        	 }
        
        try 
        {
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/new_method_test?serverTimezone=IST","root","Aa123456");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed");
            return conn;
        
	 	} catch (SQLException ex) 
		    {/* handle any errors*/
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	    }
        
		}
		return null;
	}
	
	public void Update(String orderNum,String telephone,String parkName) {
		
		try {
			String sql = "UPDATE orders" + "SET telephone = ? , parkname = ? WHERE ordernumber = ?;" ;
			//creating a prepare statement to execute SQL queries
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// Set the values for the update query parameters
			pstmt.setString(1, telephone);
			pstmt.setString(2, parkName);
			pstmt.setString(3, orderNum);
			// Execute the update query
			pstmt.executeUpdate();
	
			System.out.println("Update Complate");
			pstmt.close();
		} catch (SQLException e)
		{
			e.printStackTrace();}
	}
	

}
