package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class Customer  extends JFrame implements ActionListener{
   
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JRadioButton rb1,rb2,rb3,rb4;
    JComboBox cb;
    Choice c;
    JButton b1,b2,b3,b4;
    
    Customer()
    {
        JLabel id = new JLabel("ID");
        id.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        id.setBounds(30,30,120,30);
        add(id);
        String str[] = {"Passport","Voter_ID","Driving Licence","Ration_Card"};
        cb = new JComboBox(str);
        cb.setBounds(190,30,160,30);
        cb.setBackground(Color.DARK_GRAY);
        cb.setForeground(Color.ORANGE);
        cb.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(cb);
        
        JLabel age = new JLabel("Number");
        age.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        age.setBounds(30,70,120,30);
        add(age);
        tf2 = new JTextField();
        tf2.setBounds(190,70,160,30);
        tf2.setFont(new Font("Tahoma",Font.PLAIN,14));
        tf2.setBackground(Color.DARK_GRAY);
        tf2.setForeground(Color.ORANGE);
        add(tf2);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        name.setBounds(30,110,120,30);
        add(name);
        tf1 = new JTextField();
        tf1.setBounds(190,110,160,30);
        tf1.setFont(new Font("Tahoma",Font.PLAIN,14));
        tf1.setBackground(Color.DARK_GRAY);
        tf1.setForeground(Color.ORANGE);
        add(tf1);
        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        gender.setBounds(30,150,120,30);
        add(gender);
        rb1 = new JRadioButton("Male");
        rb1.setFont(new Font("Tahoma",Font.PLAIN,14));
        rb1.setBackground(Color.DARK_GRAY);
        rb1.setForeground(Color.ORANGE);
        rb1.setBounds(190,150,70,30);
        add(rb1);
        rb2 = new JRadioButton("Female");
        rb2.setBackground(Color.DARK_GRAY);
        rb2.setForeground(Color.ORANGE);
        rb2.setFont(new Font("Tahoma",Font.PLAIN,14));
        rb2.setBounds(270,150,80,30);
        add(rb2);
        
        
        JLabel cnty = new JLabel("Country");
        cnty.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        cnty.setBounds(30,190,120,30);
        add(cnty);
        tf3 = new JTextField();
        tf3.setBounds(190,190,160,30);
        tf3.setFont(new Font("Tahoma",Font.PLAIN,14));
        tf3.setBackground(Color.DARK_GRAY);
        tf3.setForeground(Color.ORANGE);
        add(tf3);
        
        JLabel type = new JLabel("Room type");
        type.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        type.setBounds(30,230,120,30);
        add(type);
        JLabel s = new JLabel("Single");
        s.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        s.setBounds(220,230,120,30);
        add(s);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.jpg"));
        Image img2 = img1.getImage().getScaledInstance(23,23,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        b3 = new JButton(img3);
        b3.setBounds(190,230,23,23);
        b3.addActionListener(this);
        add(b3);
        JLabel d = new JLabel("Double");
        d.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        d.setBounds(220,270,120,30);
        add(d);
        ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.jpg"));
        Image img5 = img4.getImage().getScaledInstance(23,23,Image.SCALE_DEFAULT);
        ImageIcon img6 = new ImageIcon(img2);
        b4 = new JButton(img3);
        b4.setBounds(190,270,23,23);
        b4.addActionListener(this);
        add(b4);
                
        
        JLabel arn = new JLabel("Allocated Room_no");
        arn.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        arn.setBounds(30,310,160,30);
        add(arn);
        c = new Choice();
        try{
            conn con = new conn();
            String tp = tf7.getText();
            String str3 = "select * from room where available='Available'";
            ResultSet rs = con.s.executeQuery(str3);
            while(rs.next()){
                c.add(rs.getString("room_no"));
            }
        }catch(Exception e){}
        c.setBounds(190,310,160,30);
        c.setBackground(Color.DARK_GRAY);
        c.setForeground(Color.ORANGE);
        c.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(c);
        
        JLabel days = new JLabel("Days to stay");
        days.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        days.setBounds(30,350,120,30);
        add(days);
        tf4 = new JTextField();
        tf4.setBounds(190,350,160,30);
        tf4.setFont(new Font("Tahoma",Font.PLAIN,14));
        tf4.setBackground(Color.DARK_GRAY);
        tf4.setForeground(Color.ORANGE);
        add(tf4);
        
        JLabel amount = new JLabel("Amount");
        amount.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        amount.setBounds(30,390,120,30);
        add(amount);
        tf5 = new JTextField();
        tf5.setBounds(190,390,160,30);
        tf5.setFont(new Font("Tahoma",Font.PLAIN,14));
        tf5.setBackground(Color.DARK_GRAY);
        tf5.setForeground(Color.ORANGE);
        add(tf5);
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        deposit.setBounds(30,430,120,30);
        add(deposit);
        tf6 = new JTextField();
        tf6.setBounds(190,430,160,30);
        tf6.setFont(new Font("Tahoma",Font.PLAIN,14));
        tf6.setBackground(Color.DARK_GRAY);
        tf6.setForeground(Color.ORANGE);
        add(tf6);
        
        b1 = new JButton("Check in");
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.BLACK);
        b1.setBounds(50,480,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.BLACK);
        b2.setBounds(190,480,120,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/customer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(420,420,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lb = new JLabel(i3);
        lb.setBounds(380,30,420,420);
        add(lb);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setLayout(null);
        setTitle("NEW GUEST FORM");
        setBounds(550,200,850,580);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String type = null;
        if(ae.getSource()==b3)
        {
            type="Single";
            conn con = new conn();
            try{
                ResultSet rs1 = con.s.executeQuery("select * from room where available='Available' and type='Single'");
                while(rs1.next())
                {
                    c.add(rs1.getString("room_no"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            String s1 = c.getSelectedItem();
            try{
                ResultSet rs1 = con.s.executeQuery("select * from room where room_no='"+s1+"'");
                while(rs1.next())
                {
                    tf5.setText(rs1.getString("price"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b4)
        {
            type="Double";
            conn con = new conn();
            try{
                ResultSet rs1 = con.s.executeQuery("select * from room where available='Available' and type='Double'");
                while(rs1.next())
                {
                    c.add(rs1.getString("room_no"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            String s1 = c.getSelectedItem();
            try{
                ResultSet rs1 = con.s.executeQuery("select * from room where room_no='"+s1+"'");
                while(rs1.next())
                {
                    tf5.setText(rs1.getString("price"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==b1){
            String id = (String)cb.getSelectedItem();
            String number = tf2.getText();
            String name = tf1.getText();
            String gender = null;
            if(rb1.isSelected())
            {
                gender = "Male"; 
            }
            else if(rb2.isSelected())
            {
                gender = "Female";
            }
            String country = tf3.getText();
            String room_no = c.getSelectedItem();
            String days = tf4.getText();
            String amount = tf5.getText();
            String deposit = tf6.getText();

            String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+type+"','"+room_no+"','"+days+"','"+amount+"','"+deposit+"')";
            String str2 = "update room set available='Occupied' where room_no ='"+room_no+"'";
            try{
                conn c = new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null,"New Customer Checked in");
                new AddReception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){}
        }
        else if(ae.getSource()==b2){
            new AddReception().setVisible(true);
            this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args) {
        new Customer().setVisible(true);
    }
}
