package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {
    
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JRadioButton rb1,rb2;
    Choice c;
    JButton b1,b2,b3;
    
    UpdateCheck()
    {
        JLabel l1 = new JLabel("Guest ID");
        l1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l1.setBounds(40,30,130,30);
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
        c.setBounds(190,30,160,90);
        c.setBackground(Color.DARK_GRAY);
        c.setForeground(Color.cyan);
        c.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(c);
        
        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l2.setBounds(40,80,160,30);
        add(l2);
        tf1 = new JTextField();
        
        tf1.setBounds(190,80,160,30);
        tf1.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf1.setBackground(Color.DARK_GRAY);
        tf1.setForeground(Color.CYAN);
        add(tf1);
        
        JLabel l3 = new JLabel("Room_no");
        l3.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l3.setBounds(40,130,160,30);
        add(l3);
        tf2 = new JTextField();
        tf2.setBounds(190,130,160,30);
        tf2.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf2.setBackground(Color.DARK_GRAY);
        tf2.setForeground(Color.CYAN);
        add(tf2);
        
        JLabel l4 = new JLabel("Check-in");
        l4.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l4.setBounds(40,180,160,30);
        add(l4);
        tf3 = new JTextField();
        tf3.setBounds(190,180,160,30);
        tf3.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf3.setBackground(Color.DARK_GRAY);
        tf3.setForeground(Color.CYAN);
        add(tf3);
        
        JLabel l5 = new JLabel("Total Amount");
        l5.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l5.setBounds(40,230,160,30);
        add(l5);
        tf4 = new JTextField();
        tf4.setBounds(190,230,160,30);
        tf4.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf4.setBackground(Color.DARK_GRAY);
        tf4.setForeground(Color.CYAN);
        add(tf4);
        
        JLabel l6 = new JLabel("Paid Amount");
        l6.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l6.setBounds(40,280,160,30);
        add(l6);
        tf5 = new JTextField();
        tf5.setBounds(190,280,160,30);
        tf5.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf5.setBackground(Color.DARK_GRAY);
        tf5.setForeground(Color.CYAN);
        add(tf5);
        
        JLabel l7 = new JLabel("Due Amount");
        l7.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l7.setBounds(40,330,180,30);
        add(l7);
        tf6 = new JTextField();
        tf6.setBounds(190,330,160,30);
        tf6.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf6.setBackground(Color.DARK_GRAY);
        tf6.setForeground(Color.CYAN);
        add(tf6);
        
        b1 = new JButton("Check");
        b1.setForeground(Color.RED);
        b1.setBackground(Color.BLACK);
        b1.setBounds(40,390,90,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setForeground(Color.GREEN);
        b2.setBackground(Color.BLACK);
        b2.setBounds(150,390,90,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setForeground(Color.LIGHT_GRAY);
        b3.setBackground(Color.BLACK);
        b3.setBounds(260,390,90,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/CHECK-IN.png"));
        Image i2 = i1.getImage().getScaledInstance(470,390,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lb = new JLabel(i3);
        lb.setBounds(375,30,470,390);
        add(lb);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setLayout(null);
        setTitle("UPDATE CHECK-IN DETAILS STATUS");
        setBounds(500,200,900,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String s1 = c.getSelectedItem();
            conn con = new conn();
            String s2 = null;
            String s3 = null;
            String s4 = null;
            try{
                ResultSet rs1 = con.s.executeQuery("Select * from customer where number='"+s1+"'");
                while(rs1.next()){
                    tf1.setText(rs1.getString("name"));
                    tf2.setText(rs1.getString("Room_no"));
                    tf3.setText(rs1.getString("check_in"));
                    tf5.setText(rs1.getString("deposit"));
                    s2 = rs1.getString("room_no");
                    s4 = rs1.getString("deposit");
                }
                ResultSet rs2 = con.s.executeQuery("Select * from room where room_no='"+s2+"'");
                while(rs2.next())
                {
                    tf4.setText(rs2.getString("price"));
                    s3 = rs2.getString("price");
                }
                int due = Integer.parseInt(s3)-Integer.parseInt(s4);
                tf6.setText(Integer.toString(due));
                
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
        new UpdateCheck().setVisible(true);
    }
}
