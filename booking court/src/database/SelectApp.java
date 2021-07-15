package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import model.user;
import ui.Login;
import ui.TimeDialog;
//import ui.alertBox;
import ui.home;

import java.io.*; 
import java.lang.*; 
import java.util.*; 
public class SelectApp {
	


	/**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:mysql://localhost:3306/court_booking";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "";//url,userName,password
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT userId, userName FROM user";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("userId") +  "\t" + 
                                   rs.getString("userName") );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void checkId(JFrame f, String userId, String pwd){
    	//JFrame f = null;
    	  
    	if(userId.isEmpty() || pwd.isEmpty()) {
    		JOptionPane.showMessageDialog(f,
    			    "Please dont left Id or password empty",
    			    "Inane warning",
    			    JOptionPane.WARNING_MESSAGE);
    	}
    	else
    	{
        String sql = "SELECT userId, userName FROM user where userId='" + userId + "' and password='" + pwd +"';";
       
        System.out.println(sql);
        
	             
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            if (rs.next()) {
            	f.dispose();
                System.out.println(rs.getString("userId") +  "\t" + 
                                   rs.getString("userName") );
                
              user user = new user();
              user.setId(userId);
              
                
                TimeDialog d = new TimeDialog();
				int result = d.showDialog(f, rs.getString("userName")+"  You are successfully login", 5);
	               
            }
            else {
            	JOptionPane.showMessageDialog(f,
        			    "No this user",
        			    "Inane warning",
        			    JOptionPane.PLAIN_MESSAGE);
            	
            	}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        	}
      }
    
    }
    
	public String[] getCourts(JFrame f, JFrame father, Date date, String start, String end)
	{
		String[] haveCourt = {};
		
		Time st = Time.valueOf(start + ":00");
		Time et =Time.valueOf(end + ":00");
		
		String sql = "SELECT * FROM court;";
		        
		        try (Connection conn = this.connect();
		             Statement stmt  = conn.createStatement();
		             ResultSet rs    = stmt.executeQuery(sql)){
		            
		        	
		            while (rs.next()) {
		            	String n = rs.getString("courtId");
		            	
		            	String sql2 = "SELECT * FROM booking;";
		            	try (Connection conn2 = this.connect();
		   		             Statement stmt2  = conn2.createStatement();
		   		             ResultSet rs2    = stmt2.executeQuery(sql2)){
		   		            
		   		        int add=0;
		   		        
		   		        //check court//
		   		            while (rs2.next()) {
		   		            	String n2 = rs2.getString("courtId");
		   		            	
		   		            	//check date//
		   		            	if( date.compareTo( rs2.getDate("date")) == 0) {
		   		            		
			   		            	if( !stringCompare( n, n2) ) {
			   		            		add=1;
			   		            		/////////System.out.println(rs2.getDate("date")+" "+date);
			   		            		//System.out.println(n+"  "+n2);
			   		            		//haveCourt = addX(haveCourt.length+1, haveCourt, n); 
				   		               // System.out.println("\nArray with  added:\n"
				   						//		+ Arrays.toString(haveCourt)); 
			   		            		//break;
			   		            	}
			   		            	else {
			   		            		Time s = rs2.getTime("startTime");
			   		            		Time e = rs2.getTime("endTime");
			   		            		
			   		            		//Check time//
			   		            		
			   		            		if((e.before(et) && e.after(st)) || (s.before(et) && s.after(st)) || (s.before(st) && e.after(et)) || (e.before(et) && s.after(st)) || (s.compareTo(st)==0) ) {
			   		            			
			   		            			add=0;break;//JOptionPane.showMessageDialog(f, "Tme not valid", "Inane warning", JOptionPane.PLAIN_MESSAGE);				
			   		 					}
			   		            		else {
			   		            			add=1;
			   		            		//haveCourt = addX(haveCourt.length+1, haveCourt, n); 
					   		               // System.out.println("\nArray with  added:\n"
					   						//		+ Arrays.toString(haveCourt)); 
					   		                //break;
			   		            		}
			   		            	}
		   		            	}
		   		            	else add=1;

		   		            	
		   		               
		   		                
		   		            }if(add==1)haveCourt = addX(haveCourt.length+1, haveCourt, n); 
		   		        } catch (SQLException e) {
		   		            System.out.println(e.getMessage());
		   		        }
		            }
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		        return haveCourt;
	}
	
    public void addBooking(JFrame f, JFrame father,Object courtId, Date date, String start, String end){
    	
    	user user = new user();
        String s = user.getId();
        
    	String sql = "INSERT INTO booking (userId, courtId, date, startTime, endTime) VALUES("
    				+ s + ", " + courtId + ", '" + date + "', '" + start + "', '" + end + "');";
        
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
            
    		f.dispose();
    		father.setLayout(null);    
    		father.setVisible(true);    
    		father.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      }


    public static String[] addX(int n, String arr[], String x) 
    { 
        int i; 
  
        List<String> arrlist 
            = new ArrayList<String>( 
                Arrays.asList(arr)); 
  
        arrlist.add(x); 
  
        arr = arrlist.toArray(arr); 
  
        return arr; 
    } 
    
    public static boolean stringCompare(String str1, String str2) 
    { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return false; 
            } 
        } 
  
        // Edge case for strings like 
        // String 1="Geeks" and String 2="Geeksforgeeks" 
        if (l1 != l2) { 
            return false; 
        } 
  
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return true; 
        } 
    } 
    
    /**
     * @param args the command line arguments
     */

 
}