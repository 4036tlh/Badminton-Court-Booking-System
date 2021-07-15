package ui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeDialog {
    private String message = null;  
    private int secends = 0;  
    private JLabel label = new JLabel();  
    private JButton confirm,click;   
    private JDialog dialog = null;  
    int result = -5;  
    
    public int  showDialog(JFrame father, String message, int sec) 
    {  
        this.message = message;  
        secends = sec;  
        label.setText(message);  
        label.setBounds(80,6,200,20);  
        ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();  
       /* confirm = new JButton("����");  
        confirm.setBounds(100,40,60,20);  
        confirm.addActionListener(new ActionListener() {              
            @Override  
            public void actionPerformed(ActionEvent e) {  
                result = 0;  
                TimeDialog.this.dialog.dispose();  
            }  
        });  */
        click = new JButton("Redirect now");  
        click.setBounds(90,40,140,20);  
        click.addActionListener(new ActionListener() {  
              
            @Override  
            public void actionPerformed(ActionEvent e) {  
                result = 1;  
                
                TimeDialog.this.dialog.dispose();  
                userMenu m= new userMenu();//////////////////////////////
            }  
        });  
        
        dialog = new JDialog(father, true);  
        dialog.setTitle("��ʾ: �����ڽ���"+secends+"����Զ��ر�");  
        dialog.setLayout(null);  
        dialog.add(label);  
       // dialog.add(confirm);  
        dialog.add(click);  
        s.scheduleAtFixedRate(new Runnable() {  
              
            @Override  
            public void run() {  
                // TODO Auto-generated method stub  
                  
                TimeDialog.this.secends--;  
                if(TimeDialog.this.secends == 0) {  
                    TimeDialog.this.dialog.dispose();  
                    if(result != 1) {
                    	userMenu m= new userMenu();//////////////////////////////
                    }
                }else {  
                    dialog.setTitle("��ʾ: �����ڽ���"+secends+"����Զ��ر�");  
                }  
            }  
        }, 1, 1, TimeUnit.SECONDS);  
        dialog.pack();  
        dialog.setSize(new Dimension(350,100));  
        
        //MenuExample m= new MenuExample();
        
        //dialog.setLocationRelativeTo(father);  
        dialog.setVisible(true);  
        return result;  
        
    }

}