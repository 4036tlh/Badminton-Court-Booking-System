package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.SelectApp;

public class Login extends JFrame {

	Login(){    
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
		
		JPasswordField textfield2= new JPasswordField();
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
	
	
		public static void main(String[] args) {    
		    new Login();    
		}    
}
