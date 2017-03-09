package test;

import java.sql.Connection;    
import java.sql.DriverManager;    
import java.sql.ResultSet;    
import java.sql.SQLException;
import java.sql.Statement;    
    
public class DBMannager {   
	 static String DRIVER="oracle.jdbc.driver.OracleDriver";
	 static String url = "jdbc:oracle:" + "thin:@223.3.75.198:8088:orcl";
	 static Connection con = null;   
	 static String UserName = "system";

	  static String Password = "manager";// √‹¬Î
     static Statement stmt = null;    
     static ResultSet rs = null;    
     protected static Connection getConn(){  
    	 try {
				
				Class.forName(DRIVER);
				con = DriverManager.getConnection(url, UserName, Password);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
     }
     public static void closeAll(){
 		try {
 			if(rs!=null) rs.close();
 			if(stmt!=null) stmt.close();
 			if(con!=null) con.close();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		
 	}

} 