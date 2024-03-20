package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {
    
    Choice c;
    JCheckBox ch;
    JButton b1,b2;
    JTable t;
    
    Pickup()
    {
        JLabel l1 = new JLabel("Name");
        l1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l1.setBounds(0,110,100,30);
        add(l1);
                
        JLabel l2 = new JLabel("Age");
        l2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l2.setBounds(115,110,100,30);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l3.setBounds(230,110,100,30);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l4.setBounds(343,110,100,30);
        add(l4);

        JLabel l5 = new JLabel("Model");
        l5.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l5.setBounds(457,110,100,30);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l6.setBounds(570,110,100,30);
        add(l6);
        
        JLabel l7 = new JLabel("licence");
        l7.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l7.setBounds(685,110,100,30);
        add(l7);
        
        JLabel lb = new JLabel("Type of Car");
        lb.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        lb.setBounds(40,35,120,30);
        add(lb);
        c = new Choice();
        try{
            conn con = new conn();
            String str = "select * from driver";
            ResultSet rs = con.s.executeQuery(str);
            while(rs.next()){
                c.add(rs.getString("model"));
            }
        }catch(Exception e){}
        c.setBounds(160,40,145,90);
        c.setBackground(Color.DARK_GRAY);
        c.setForeground(Color.WHITE);
        c.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(c);
        
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
        setTitle("PICKUP SERVICE");
        setBounds(550,200,800,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try{
                String str1 = "select * from driver where model='"+c.getSelectedItem()+"' AND available='Available'";
                String str2 = "select * from driver where model='"+c.getSelectedItem()+"'";
                conn con = new conn();
                if(ch.isSelected())
                {
                    ResultSet rs1 = con.s.executeQuery(str1);
                    t.setModel(DbUtils.resultSetToTableModel(rs1));
                }
                else{
                    ResultSet rs2 = con.s.executeQuery(str2);
                    t.setModel(DbUtils.resultSetToTableModel(rs2));
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
        new Pickup().setVisible(true);
    }
}

