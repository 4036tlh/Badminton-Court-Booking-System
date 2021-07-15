package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class SamplePopup2 {
  public static void main(String args[]) {

    JFrame frame = new JFrame("Sample Popup");
    JButton button = new JButton ("Ask");
    
    
    
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        Component source = (Component)actionEvent.getSource();
        Object response = JOptionPane.showInputDialog(
          source, 
          "Where would you like to go to lunch?",
          "Select a Destination", 
          JOptionPane.QUESTION_MESSAGE,
          null,
          new String[] {"Burger King", "McDonalds", "Pizza Hut", "Taco Bell", "Wendy's",
          "McDonalds", "Burger King", "McDonalds", "Pizza Hut", "Taco Bell", "Wendy's",
          "McDonalds", "Burger King", "McDonalds", "Pizza Hut", "Taco Bell", "Wendy's",
          "Pizza Hut", "Taco Bell", "Wendy's"},
          "McDonalds");
        System.out.println ("Response: " + response);
      }
    };
    button.addActionListener(actionListener);
    Container contentPane = frame.getContentPane();
    contentPane.add(button, BorderLayout.SOUTH);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}