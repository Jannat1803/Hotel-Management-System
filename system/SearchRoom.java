package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    
    JComboBox cb1;
    JCheckBox ch;
    JButton b1,b2;
    JTable t;
    
    SearchRoom()
    {
        JLabel l1 = new JLabel("Room_no");
        l1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l1.setBounds(0,110,100,30);
        add(l1);
                
        JLabel l2 = new JLabel("Availability");
        l2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l2.setBounds(160,110,100,30);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l3.setBounds(320,110,100,30);
        add(l3);

        JLabel l4 = new JLabel("Type");
        l4.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l4.setBounds(480,110,100,30);
        add(l4);

        JLabel l5 = new JLabel("Price");
        l5.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l5.setBounds(640,110,100,30);
        add(l5);
        
        JLabel lb = new JLabel("Room Bed Type");
        lb.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        lb.setBounds(40,30,160,30);
        add(lb);
        cb1 = new JComboBox(new String[]{"Single","Double"});
        cb1.setBounds(190,30,160,30);
        cb1.setFont(new Font("Tahoma",Font.PLAIN,14));
        cb1.setBackground(Color.DARK_GRAY);
        cb1.setForeground(Color.CYAN);
        add(cb1);
        
        ch = new JCheckBox("Display only availables");
        ch.setBounds(550,30,200,30);
        ch.setFont(new Font("Tahoma",Font.PLAIN,14));
        ch.setBackground(Color.LIGHT_GRAY);
        ch.setForeground(Color.BLUE);
        add(ch);
        
        t = new JTable();
        t.setBounds(0,140,800,260);
        t.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,13));
        //t.setBackground(Color.LIGHT_GRAY);
        t.setForeground(Color.BLUE);
        add(t);
        
        b1 = new JButton("Submit");
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.BLACK);
        b1.setBounds(260,450,110,30);
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
        setTitle("SEARCH FOR ROOM");
        setBounds(550,200,800,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try{
                String str1 = "select * from room where type='"+cb1.getSelectedItem()+"'";
                String str2 = "select * from room where available='Available' AND type ='"+cb1.getSelectedItem()+"'";
                conn con = new conn();
                ResultSet rs;
                if(ch.isSelected())
                {
                    rs = con.s.executeQuery(str2);
                    t.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else{
                    rs = con.s.executeQuery(str1);
                    t.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2)
        {
            new AddReception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }
}
