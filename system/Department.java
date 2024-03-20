package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    
    JButton b1,b2;
    
    Department()
    {
        b1 = new JButton("Submit");
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.BLACK);
        b1.setBounds(250,450,110,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.BLACK);
        b2.setBounds(410,450,110,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setLayout(null);
        setTitle("DEPARTMENT");
        setBounds(550,200,800,550);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            
        }
        else if(ae.getSource()==b2)
        {
            new AddReception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Department().setVisible(true);
    }
}
