package ui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class TTTTTInsertDataDemo {
    public static void main(String[] args) {
    	String sql = "INSERT INTO `booking`(`userId`, `courtId`, `date`, `startTime`, `endTime`) VALUES (1,2,'"+date+"','"+start+"','"+end+"')";
	       
        System.out.println(sql);
        
        Connection connection = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/court_booking", "root", null);
             
            stmt = connection.createStatement();
            stmt.execute(sql);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}