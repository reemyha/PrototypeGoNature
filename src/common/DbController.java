package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DbController {
	
	private static Connection conn = null;
	
	//private static String passwrd ;
	//private static String Username ;
	
	  /*public static void setDatabaseCredentials(String username, String password) {
		  Username = username;
	      passwrd = password;
	    }*/
	
    private static final String DB_URL = "jdbc:mysql://localhost/sys?serverTimezone=IST";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Aa123456";
	
	public Connection connectToDB() 
	{
		System.out.println("Connecting to DataBase");
		if (conn == null) {
			
			try {
					Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
					System.out.println("Driver definition succeed");
				} catch (Exception ex) {
					/* handle the error */
					System.out.println("Driver definition failed");
				}
				try {
					Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					 if (conn.isValid(5)) { // Check if the connection is valid within 5 seconds
					        System.out.println("Connection is valid. Connected to the database.");
					    } else {
					        System.out.println("Connection is not valid. Not connected to the database.");
					    }
					System.out.println("SQL connection succeed");
				} catch (SQLException ex) {// handle any errors
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
	public void getOrderDetails(String orderNum) {
        try {
            String sql = "SELECT * FROM order WHERE ordernumber = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, orderNum);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
//                String telephone = rs.getString("telephone");
//                String parkName = rs.getString("parkname");
            	
//				ToDo: add values to data structure
//              
//				  System.out.println("Telephone: " + telephone);
//                System.out.println("Park Name: " + parkName);
            } else {
                System.out.println("Order with order number " + orderNum + " not found.");
            }

            rs.close();
            pstmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}


}
