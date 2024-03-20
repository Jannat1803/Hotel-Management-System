package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    JTextField tf1,tf2,tf3;
    JRadioButton rb1,rb2;
    Choice c;
    JButton b1,b2,b3;
    
    UpdateRoom()
    {
        JLabel l1 = new JLabel("Guest ID");
        l1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l1.setBounds(30,40,150,30);
        add(l1);
        c = new Choice();
        try{
            conn con = new conn();
            String str = "select * from customer";
            ResultSet rs = con.s.executeQuery(str);
            while(rs.next()){
                c.add(rs.getString("Number"));
            }
        }catch(Exception e){}
        c.setBounds(180,40,160,90);
        c.setBackground(Color.DARK_GRAY);
        c.setForeground(Color.cyan);
        c.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(c);
        
        JLabel l2 = new JLabel("Room_no");
        l2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l2.setBounds(30,110,160,30);
        add(l2);
        tf1 = new JTextField();
        tf1.setBounds(180,110,160,30);
        tf1.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf1.setBackground(Color.DARK_GRAY);
        tf1.setForeground(Color.CYAN);
        add(tf1);
        
        JLabel l3 = new JLabel("Availability");
        l3.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l3.setBounds(30,180,160,30);
        add(l3);
        tf2 = new JTextField();
        tf2.setBounds(180,180,160,30);
        tf2.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf2.setBackground(Color.DARK_GRAY);
        tf2.setForeground(Color.CYAN);
        add(tf2);
        
        JLabel l4 = new JLabel("Cleaning Status");
        l4.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l4.setBounds(30,250,160,30);
        add(l4);
        tf3 = new JTextField();
        tf3.setBounds(180,250,160,30);
        tf3.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf3.setBackground(Color.DARK_GRAY);
        tf3.setForeground(Color.CYAN);
        add(tf3);
        
        b1 = new JButton("Check");
        b1.setForeground(Color.RED);
        b1.setBackground(Color.BLACK);
        b1.setBounds(30,330,90,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setForeground(Color.GREEN);
        b2.setBackground(Color.BLACK);
        b2.setBounds(140,330,90,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setForeground(Color.LIGHT_GRAY);
        b3.setBackground(Color.BLACK);
        b3.setBounds(250,330,90,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/room1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(470,320,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lb = new JLabel(i3);
        lb.setBounds(370,40,470,320);
        add(lb);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setLayout(null);
        setTitle("UPDATE ROOM STATUS");
        setBounds(520,200,900,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String s1 = c.getSelectedItem();
            conn con = new conn();
            try{
                String s2=null;
                ResultSet rs1 = con.s.executeQuery("Select * from customer where number='"+s1+"'");
                while(rs1.next())
                {
                    tf1.setText(rs1.getString("room_no"));
                    s2 = rs1.getString("room_no");
                }
                ResultSet rs2 = con.s.executeQuery("Select * from room where room_no='"+s2+"'");
                while(rs2.next())
                {
                    tf2.setText(rs2.getString("available"));
                    tf3.setText(rs2.getString("status"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2)
        {
            try{
                conn con = new conn();
                String s1 = tf1.getText();
                String s2 = tf2.getText();
                String s3 = tf3.getText();
                
                con.s.executeQuery("update room set available='"+s2+"',status='"+s3+"' where room_no='"+s1+"'");
                JOptionPane.showMessageDialog(null,"Room Update Successful");
                new AddReception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b3)
        {
            new AddReception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateRoom().setVisible(true);
    }
}
