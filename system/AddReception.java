package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddReception extends JFrame implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    
    AddReception()
    {
        b1 = new JButton("New Guest Form");
        b1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.ORANGE);
        b1.setBounds(40,30,300,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Room");
        b2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.ORANGE);
        b2.setBounds(40,75,300,30);
        b2.addActionListener(this);
        add(b2);
        /*
        b3 = new JButton("Department");
        b3.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.ORANGE);
        b3.setBounds(40,110,300,30);
        b3.addActionListener(this);
        add(b3);
        */
        b4 = new JButton("Guest Info");
        b4.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b4.setBackground(Color.GRAY);
        b4.setForeground(Color.ORANGE);
        b4.setBounds(40,120,300,30);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Manager Info");
        b5.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b5.setBackground(Color.GRAY);
        b5.setForeground(Color.ORANGE);
        b5.setBounds(40,165,300,30);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("All Employee Info");
        b6.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b6.setBackground(Color.GRAY);
        b6.setForeground(Color.ORANGE);
        b6.setBounds(40,210,300,30);
        b6.addActionListener(this);
        add(b6);
        
        b7 = new JButton("Update Check Status");
        b7.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b7.setBackground(Color.GRAY);
        b7.setForeground(Color.ORANGE);
        b7.setBounds(40,255,300,30);
        b7.addActionListener(this);
        add(b7);
        
        b8 = new JButton("Update Room Status");
        b8.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b8.setBackground(Color.GRAY);
        b8.setForeground(Color.ORANGE);
        b8.setBounds(40,300,300,30);
        b8.addActionListener(this);
        add(b8);
        
        b9 = new JButton("Pick-up Service");
        b9.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b9.setBackground(Color.GRAY);
        b9.setForeground(Color.ORANGE);
        b9.setBounds(40,345,300,30);
        b9.addActionListener(this);
        add(b9);
        
        b10 = new JButton("Search Room");
        b10.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b10.setBackground(Color.GRAY);
        b10.setForeground(Color.ORANGE);
        b10.setBounds(40,390,300,30);
        b10.addActionListener(this);
        add(b10);
        
        b11 = new JButton("Check Out");
        b11.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b11.setBackground(Color.GRAY);
        b11.setForeground(Color.ORANGE);
        b11.setBounds(40,435,300,30);
        b11.addActionListener(this);
        add(b11);
        
        b12 = new JButton("Logout");
        b12.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        b12.setBackground(Color.GRAY);
        b12.setForeground(Color.ORANGE);
        b12.setBounds(40,480,300,30);
        b12.addActionListener(this);
        add(b12);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/reception.jpg"));
        Image i2 = i1.getImage().getScaledInstance(570,470,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lb = new JLabel(i3);
        lb.setBounds(375,30,570,470);
        add(lb);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setLayout(null);
        setTitle("RECEPTION");
        setBounds(470,200,1000,580);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            new Customer().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b2)
        {
            new Room().setVisible(true);
            this.setVisible(false);
        }
        /*else if(ae.getSource()==b3)
        {
            new Department().setVisible(true);
            this.setVisible(false);
        }*/
        else if(ae.getSource()==b4)
        {
            new CustomerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b5)
        {
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b6)
        {
            new Employee().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b7)
        {
            new UpdateCheck().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b8)
        {
            new UpdateRoom().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b9)
        {
            new Pickup().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b10)
        {
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b11)
        {
            new Checkout().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b12)
        {
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddReception().setVisible(true);
    }
}