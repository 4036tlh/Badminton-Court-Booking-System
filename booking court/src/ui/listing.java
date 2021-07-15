package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class listing {
  listing(String[] a) {
    

    //final listing model = new listing(labels);

    JFrame frame = new JFrame("Shared Data");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    JComboBox comboBox1 = new JComboBox(a);
    comboBox1.setEditable(true);

    panel.add(comboBox1);
    frame.add(panel, BorderLayout.NORTH);

    JList jlist = new JList(a);
    JScrollPane scrollPane = new JScrollPane(jlist);
    frame.add(scrollPane, BorderLayout.CENTER);


    JButton button = new JButton("Add");
    frame.add(button, BorderLayout.SOUTH);
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
    	  Object datepre = comboBox1.getSelectedItem();
    	  System.out.println(datepre);
      }
    };
    button.addActionListener(actionListener);

    frame.setSize(300, 200);
    frame.setVisible(true);
  }
  
  public static void main(String[] args) {    
	  String[] a = { "A", "B", "C", "D", "E", "F", "G" };
	  //listing l = new listing();
	  //l.listing(labels);
	  new listing(a);
	}  
}