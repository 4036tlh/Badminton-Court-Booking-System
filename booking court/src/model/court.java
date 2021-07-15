package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import ui.TimeDialog;

public class court {
	
	//court(int court){
		
	//}
	
	
	private void readDbCourt(){
		String sql = "SELECT * FROM court";
	       
        
	             
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
        	
        	//int[] court = {};
        	String[] position = {};
        	double[] price = {};
        	
        	List<Integer> court = new ArrayList<Integer>();

            while (rs.next()) {
            	System.out.println(sql);
            	int id = rs.getInt("courtId");
            	System.out.println(id);
            	//int n = court.length+1;
            	court.add(id);
            	//court = new int[n+1];
            	
            	
            	//court[n+1]=id;
            }
          for (int i : court) {
     		   System.out.println(i+":"+i);
    		}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        	}
      }
	
	
	private int courtId;
	private String position;
	private double price;

	
	public int getCourtId() {
		return courtId;
	}
	public void setCourtId(int courtId) {
		this.courtId = courtId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
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

	 public static void main(String[] args) 
	    {
		 court c = new court();
		 c.readDbCourt();
	    }
}
