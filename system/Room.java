package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    
    JTable t;
    JButton b1,b2;
    private Container cnt;
    
    Room()
    {
        t = new JTable();
        t.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,13));
        t.setForeground(Color.BLUE);
        t.setBounds(0,40,900,435);
        add(t);
        
        JLabel l1 = new JLabel("Room_no");
        l1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l1.setBounds(0,10,120,30);
        add(l1);
                
        JLabel l2 = new JLabel("Availability");
        l2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l2.setBounds(180,10,120,30);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l3.setBounds(360,10,120,30);
        add(l3);

        JLabel l4 = new JLabel("Type");
        l4.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l4.setBounds(540,10,120,30);
        add(l4);

        JLabel l5 = new JLabel("Price");
        l5.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l5.setBounds(720,10,120,30);
        add(l5);

        b1 = new JButton("Load Data");
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.BLACK);
        b1.setBounds(320,500,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.BLACK);
        b2.setBounds(480,500,120,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setLayout(null);
        setTitle("Information of Rooms");
        setBounds(500,200,918,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try{
                conn c = new conn();
                String str = "select * from room";
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
        new Room().setVisible(true);
    }
}

