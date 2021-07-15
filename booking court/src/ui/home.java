package ui;

import javax.swing.*;

import database.SelectApp;

import java.awt.*;
import java.awt.event.*;

public class home extends JFrame{
    protected static final JFrame f = null;
	//private JMenuBar menubar;
    private JMenu menu;
   // private JMenu submenu;
    
    /** Creates a new instance of Example5 */
    public home() {
        setTitle("Menu Demo");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JFrame f=new JFrame("Button Example");
        
        JMenuBar menubar = new JMenuBar();
        
        
        menu = new JMenu("HomePage");

        menu.setMnemonic(KeyEvent.VK_A);
        
        menubar.add(menu);
      
        JButton b1=new JButton("booking");
        JButton b2=new JButton("History");
        JButton b3=new JButton("Personal");
        
       // JMenu b = (new JMenu("Booking"));
        menubar.add(b1);   
        menubar.add(b2);
        menubar.add(b3);
        //menubar.add(new JMenu("View History"));
        //menubar.add(new JMenu("Personal"));
        f.add(menubar);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menubar,BorderLayout.NORTH);
        setVisible(true);
        
        b1.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent arg0) {
				
					SelectApp app = new SelectApp();
					
					app.checkId(f , "1", "1");
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
					
					//app.checkId(f , "1", "1");
			}          
		  });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new home();
    }
}
    