package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import database.SelectApp;
import model.user;  
class userMenu  
{  
          JMenu menu, submenu;  
          JMenuItem i1, i2, i3, i4, i5;  
          userMenu(){  
          JFrame f= new JFrame("Menu and MenuItem Example");  
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("Menu");  
          
          submenu=new JMenu("Sub Menu");  
          i1=new JMenuItem("Item 1");  
          i2=new JMenuItem("Item 2");  
          i3=new JMenuItem("Item 3");  
          i4=new JMenuItem("Item 4");  
          i5=new JMenuItem("Item 5");  
          menu.add(i1); menu.add(i2); menu.add(i3);  
          submenu.add(i4); submenu.add(i5);  
          menu.add(submenu);  
          mb.add(menu);  
          f.setJMenuBar(mb);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
          
          JButton b1=new JButton("booking");
          JButton b2=new JButton("History");
          JButton b3=new JButton("Personal");
          
         // JMenu b = (new JMenu("Booking"));
          mb.add(b1);   
          mb.add(b2);
          mb.add(b3);
          
          b1.addActionListener(new ActionListener() {
  	        
  			public void actionPerformed(ActionEvent arg0) {
  				
  					bookTime booking = new bookTime(f);
  			}          
  	      });
          b2.addActionListener(new ActionListener() {
  	        
  			public void actionPerformed(ActionEvent arg0) {
  				
  					SelectApp app = new SelectApp();
  					
  					app.checkId(f , "1", "1");
  			}          
  	      });
          b3.addActionListener(new ActionListener() {
      
  			public void actionPerformed(ActionEvent arg0) {
  				
  				userMenu m= new userMenu();
  				//new MenuExample(); 
  				
  					SelectApp app = new SelectApp();
  					
  					app.checkId(f , "1", "1");
  			}          
  		  });
}  
}  