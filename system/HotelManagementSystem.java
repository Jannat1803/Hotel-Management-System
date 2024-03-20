
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem()
    {
        setBounds(600,230,613,460);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/HI595135094.jpg"));
        
        JLabel lb1 = new JLabel(image);
        lb1.setBounds(0,0,613,460);
        add(lb1);
        
        JLabel lb2 = new JLabel("HOTEL MANAGEMENT SYSTEM");
        lb2.setBounds(15,350,600,70);
        lb2.setForeground(Color.ORANGE);
        lb2.setFont(new Font("serif",Font.ITALIC+Font.BOLD,30));
        lb1.add(lb2);
        
        JButton jb = new JButton("Enter");
        jb.setBackground(Color.LIGHT_GRAY);
        jb.setForeground(Color.BLUE);
        jb.setBounds(510,370,70,30);
        jb.addActionListener(this);
        lb1.add(jb);
        
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true)
        {
            lb2.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
            lb2.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        new Login().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }  
}
