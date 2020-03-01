import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	static Connection conn = null;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/C:\\Users\\fmi\\Desktop\\cars","sa", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}//end method

}//end class
