package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable t;
    JButton b1,b2;
    
    CustomerInfo()
    {
        t = new JTable();
        t.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,13));
        t.setForeground(Color.BLUE);
        t.setBounds(0,40,1000,490);
        add(t);
        
        JLabel l1 = new JLabel("ID");
        l1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l1.setBounds(0,10,70,30);
        add(l1);
                
        JLabel l2 = new JLabel("Number");
        l2.setBounds(125,10,70,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l3.setBounds(250,10,70,30);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l4.setBounds(375,10,70,30);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l5.setBounds(500,10,70,30);
        add(l5);

        JLabel l6 = new JLabel("Allocated Room_no");
        l6.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l6.setBounds(625,10,120,30);
        add(l6);

        JLabel l7 = new JLabel("Checked in");
        l7.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l7.setBounds(750,10,120,30);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l8.setBounds(876,10,70,30);
        add(l8);    
        
        b1 = new JButton("Load Data");
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.BLACK);
        b1.setBounds(350,550,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.BLACK);
        b2.setBounds(520,550,120,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setLayout(null);
        setTitle("GUEST INFORMATION");
        setBounds(450,200,1018,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try{
                conn c = new conn();
                String str = "select * from customer";
                ResultSet rs = c.s.executeQuery(str);
                
                t.setModel(DbUtils.resultSetToTableModel(rs));
                
               
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else if(ae.getSource()==b2)
        {
            new AddReception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new CustomerInfo().setVisible(true);
    }
}

