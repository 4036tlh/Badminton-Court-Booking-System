package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import database.SelectApp;
import model.user;


public class bookTime extends JFrame {

	bookTime(JFrame father){    
		JFrame f=new JFrame("Button Example"); 

		JButton b=new JButton("Next step");    
		b.setBounds(10,170,400, 40);    
		
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		
		label1.setText("Enter Date :");
		label1.setBounds(10, 10, 190, 100);
		
		label2.setText("Enter Starting Time :");
		label2.setBounds(10, 50, 190, 100);

		label3.setText("Enter Ending Time :");
		label3.setBounds(10, 90, 190, 100);
		
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int date = cal.get(Calendar.DATE);
		
	    String da1 = year + "-" + month + "-" + date;
	    String da2 = year + "-" + month + "-" + (date+1);
	    String da3 = year + "-" + month + "-" + (date+2);
	    
	    String[] s1= { 
	    		da1, da2, da3
	    };
	    
	    String[] stime= {
	    		null, "08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"
	    };
	    String[] etime= {
	    		null, "09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00"
	    };
	    
	    JComboBox c1 = new JComboBox(s1);
	    c1.setBounds(200, 50, 210, 30);
	    
	    JComboBox c2 = new JComboBox(stime);
	    c2.setBounds(200, 90, 210, 30);
	    
	    JComboBox c3 = new JComboBox(etime);
	    c3.setBounds(200, 130, 210, 30);
	    
		f.add(label1);
		f.add(c1);
		
		f.add(label2);
		f.add(c2);
		
		f.add(label3);
		f.add(c3);
		
		   
		f.add(b);    
		f.setSize(800,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
		//action listener
		b.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Object datepre = c1.getSelectedItem();
				Object stpre = c2.getSelectedItem();
				Object etpre = c3.getSelectedItem();
				
				
				if( datepre == null || stpre == null || etpre == null) {
		    		JOptionPane.showMessageDialog(f,
		    			    "Please dont left any input empty",
		    			    "Inane warning",
		    			    JOptionPane.WARNING_MESSAGE);
		    	}
				else
				{
					String date = datepre.toString();
					String st = stpre.toString();
					String et = etpre.toString();
				
					//Prove it work	
					System.out.println(date);
					System.out.println(st);
					System.out.println(et);
					
					
					//convert to time or date type
					Date date1=Date.valueOf(date);
					//Time d = Time.valueOf(st + ":00");
					//Time d2 =Time.valueOf(et + ":00");
					
					LocalTime stime = LocalTime.parse(st);
					LocalTime etime = LocalTime.parse(et);
					
					
					if(etime.isBefore(stime) && stime.isAfter(etime)) {
						
						JOptionPane.showMessageDialog(f, "Tme not valid", "Inane warning", JOptionPane.PLAIN_MESSAGE);				
					}
					else
					{
					
					SelectApp app = new SelectApp();
					Object[] haveCourts = app.getCourts(f, father, date1, st, et);					
					
					Object selectedCourt = JOptionPane.showInputDialog(f, "Please select a court:", "Court ordering", JOptionPane.QUESTION_MESSAGE, null, haveCourts, haveCourts[0]);
					
					if(selectedCourt != null)
			        {
						SelectApp a = new SelectApp();

						a.addBooking(f, father, selectedCourt, date1, st, et);
						
						user user = new user();
			             String s = user.getId();
			             System.out.println(s);
			             
			            father.setVisible(true);    
			         	father.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			         	f.dispose();
			        }
					
					//father.setVisible(true);    
			    	//father.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			    	//f.dispose();
					else
					{
				    	f.setVisible(true);    
				    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
					}
					}
				}	    
			}          
	      });
		
		}         
	
	
		 
}
