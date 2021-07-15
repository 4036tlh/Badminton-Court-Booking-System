package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.SelectApp;

public class booking2 extends JFrame {

	booking2(){    
		JFrame f=new JFrame("Button Example"); 
					//submit button
		JButton b=new JButton("Submit");    
		b.setBounds(100,130,140, 40);    
					//enter name label
		JLabel label = new JLabel();	
		
		label.setText("Enter Name :");
		label.setBounds(10, 10, 100, 100);
		
		JLabel label2 = new JLabel();	
		
		label2.setText("Enter Id :");
		label2.setBounds(10, 50, 100, 100);
					//empty label which will show event after button clicked
		JLabel label1 = new JLabel();
		label1.setBounds(10, 170, 200, 100);
					//textfield to enter name
		JTextField textfield= new JTextField();
		textfield.setBounds(110, 50, 130, 30);
		
		JTextField textfield2= new JTextField();
		textfield2.setBounds(110, 90, 130, 30);
					//add to frame
		f.add(label1);
		f.add(textfield);
		
		f.add(label2);
		f.add(textfield2);
		f.add(label);
		f.add(b);    
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
							//action listener
		b.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String text = textfield.getText();
				String text2 = textfield2.getText();
					
						//aaa a= new aaa();

						//int result = a.showDialog(f);
					
					SelectApp app = new SelectApp();
					app.checkId(f, text, text2);
					//f.dispose();
					//label1.setText(text3);
					    
			}          
	      });
		}         
	
	public static String[] addX(int n, String arr[], String x) 
	{ 
		int i; 

		// create a new ArrayList 
		List<String> arrlist 
			= new ArrayList<String>( 
				Arrays.asList(arr)); 

		// Add the new element 
		arrlist.add(x); 

		// Convert the Arraylist to array 
		arr = arrlist.toArray(arr); 

		// return the array 
		return arr; 
	} 
		public static void main(String[] args) {    
			int n = 3; 
			int i; 

			// initial array of size 10 
			String arr[] 
				= {}; 

			// print the original array 
			System.out.println("Initial Array:\n"
							+ Arrays.toString(arr)); 

			// element to be added 
			String x = "50"; 

			// call the method to add x in arr 
			arr = addX(arr.length+1, arr, x); 

			// print the updated array 
			System.out.println("\nArray with " + x 
							+ " added:\n"
							+ Arrays.toString(arr)); 
			String[] etime= {
		    		null, "09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00"
		    };
			System.out.println("\nArray with " + x 
					+ " added:\n"
					+ Arrays.toString(etime)); 
		   // new Login();    
		}    
}
