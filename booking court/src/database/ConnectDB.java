package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public void connect() {
        // SQLite connection string
        String url = "jdbc:mysql://localhost:3306/court_booking";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "";
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
