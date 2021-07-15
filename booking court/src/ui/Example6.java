package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Example6 extends JFrame{
    private JMenuBar menubar;
    private JMenu menu;
    private JMenu submenu;
    
    /** Creates a new instance of Example5 */
    public Example6() {
        setTitle("Menu Demo");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JMenuBar menubar = new JMenuBar();
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menubar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("A text-only menu item",KeyEvent.VK_T);
        menu.add(menuItem);
        
        JMenuItem save = new JMenuItem("Both text and icon", new ImageIcon("c:/save_icon.gif"));
        save.setMnemonic(KeyEvent.VK_B);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menu.add(save);
        
        // A group of radio buttons
        menu.addSeparator();
        ButtonGroup bg = new ButtonGroup();
        JRadioButtonMenuItem rb1 = new JRadioButtonMenuItem("A radio button menu item");
        rb1.setSelected(true);
        rb1.setMnemonic(KeyEvent.VK_R);
        bg.add(rb1);
        menu.add(rb1);
        
        JRadioButtonMenuItem rb2 = new JRadioButtonMenuItem("Another radio button");
        rb1.setMnemonic(KeyEvent.VK_D);
        bg.add(rb2);
        menu.add(rb2);
        
        // A group of checkboxes
        menu.addSeparator();
        JCheckBoxMenuItem cb1 = new JCheckBoxMenuItem("CheckBoxMenuItem 1");
        menu.add(cb1);
        JCheckBoxMenuItem cb2 = new JCheckBoxMenuItem("CheckBoxMenuItem 2");
        menu.add(cb2);
        
        //A submenu
        submenu = new JMenu("A Submenu");
        submenu.setMnemonic(KeyEvent.VK_U);
        JMenuItem sm1 = new JMenuItem("Submenu Item 1");
        submenu.add(sm1);
        JMenuItem sm2 = new JMenuItem("Submenu Item 2");
        submenu.add(sm2);
        menu.add(submenu);
        
        menubar.add(new JMenu("Another menu"));
        menubar.add(new JMenu("Another menu"));
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menubar,BorderLayout.NORTH);
        setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void meain(String[] args) {
        new Example6();
    }
}
    