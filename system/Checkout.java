package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Checkout extends JFrame implements ActionListener {
    
    Choice c;
    JButton b1,b2,b3;
    JTextField tf1,tf2;
    
    Checkout()
    {
        JLabel l1 = new JLabel("Guest ID");
        l1.setBounds(30,40,100,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l1.setForeground(Color.DARK_GRAY);
        add(l1);
        c = new Choice();
        try{
            conn con = new conn();
            String str = "select * from customer";
            ResultSet rs = con.s.executeQuery(str);
            while(rs.next()){
                c.add(rs.getString("number"));
            }
        }catch(Exception e){}
        c.setBounds(140,40,145,90);
        c.setBackground(Color.DARK_GRAY);
        c.setForeground(Color.WHITE);
        c.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(c);
        
        JLabel l2 = new JLabel("Room_no");
        l2.setBounds(30,90,100,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        l2.setForeground(Color.DARK_GRAY);
        add(l2);
        tf1 = new JTextField();
        tf1.setBounds(140,90,150,30);
        tf1.setFont(new Font("Tahoma",Font.PLAIN,14));
        tf1.setBackground(Color.DARK_GRAY);
        tf1.setForeground(Color.WHITE);
        add(tf1);
        
        JLabel l3 = new JLabel("Due Amount");
        l3.setBounds(30,140,120,30);
        l3.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        l3.setForeground(Color.DARK_GRAY);
        add(l3);
        tf2 = new JTextField();
        tf2.setBounds(140,140,150,30);
        tf2.setFont(new Font("Tahoma",Font.PLAIN,14));
        tf2.setBackground(Color.DARK_GRAY);
        tf2.setForeground(Color.WHITE);
        add(tf2);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.jpg"));
        Image img2 = img1.getImage().getScaledInstance(23,23,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        b3 = new JButton(img3);
        b3.setBounds(290,40,23,23);
        b3.addActionListener(this);
        add(b3);
        
        b1 = new JButton("Checkout");
        b1.setForeground(Color.BLUE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(40,190,110,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.BLACK);
        b2.setBounds(170,190,110,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/check out.png"));
        Image i2 = i1.getImage().getScaledInstance(320,180,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lb2 = new JLabel(i3);
        lb2.setBounds(330,40,320,180);
        add(lb2);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setLayout(null);
        setTitle("CHECKING OUT");
        setBounds(610,200,700,300);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String id_no = c.getSelectedItem();
            String room_no = tf1.getText();
            String str1 = "delete from customer where number='"+id_no+"'";
            String str2 = "update room set available='Available' where room_no='"+room_no+"'";
            conn con = new conn();
            try{
                con.s.executeUpdate(str1);
                con.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Checkout done");
                new AddReception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2)
        {
            new AddReception().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==b3)
        {
            String s1 = c.getSelectedItem();
            conn con = new conn();
            try{
                ResultSet rs1 = con.s.executeQuery("select * from customer where number='"+s1+"'");
                while(rs1.next())
                {
                    tf1.setText(rs1.getString("room_no"));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            try{
            ResultSet rs2 = con.s.executeQuery("select * from customer where number='"+s1+"'");
            while(rs2.next()){
                int days=Integer.parseInt(rs2.getString("days"));
                System.out.println(days);
                int amount=Integer.parseInt(rs2.getString("amount"));
                System.out.println(days);
                int deposit=Integer.parseInt(rs2.getString("deposit"));
                System.out.println(days);
                int ans=(days*amount)-deposit;
                tf2.setText(String.valueOf(ans));
            }
        }catch(Exception e){System.out.println(e.getMessage());}
        }
    }
    
    public static void main(String[] args) {
        new Checkout().setVisible(true);
    }
}
