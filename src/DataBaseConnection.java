import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;



public class DataBaseConnection {
	 Connection mysqlConnection=null;
public static Connection dbConnector() {
	try {
	
        
		Class.forName("com.mysql.jdbc.Driver");
		Connection mysqlConnection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/event_planning","root","root");
	
		return mysqlConnection;
	
		
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null, e);
		return null;
		
		
	}
	//return mysqlConnection;
	
	
}
}
