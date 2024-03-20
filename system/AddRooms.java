package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField tf1,tf2;
    JButton b1,b2;
    JComboBox cb1,cb2,cb3;
    
    AddRooms()
    {
        JLabel room = new JLabel("ROOM NO");
        room.setForeground(Color.DARK_GRAY);
        room.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,16));
        room.setBounds(30,30,120,30);
        add(room);
        tf1 = new JTextField();
        tf1.setFont(new Font("Arial",Font.ITALIC,14));
        tf1.setForeground(Color.CYAN);
        tf1.setBackground(Color.DARK_GRAY);
        tf1.setBounds(210,30,160,30);
        add(tf1);
        
        JLabel available = new JLabel("AVAILABLE");
        available.setForeground(Color.DARK_GRAY);
        available.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,16));
        available.setBounds(30,80,120,30);
        add(available);
        cb1 = new JComboBox(new String[] {"Available","Occupied"});
        cb1.setFont(new Font("Arial",Font.ITALIC,14));
        cb1.setForeground(Color.CYAN);
        cb1.setBackground(Color.DARK_GRAY);
        cb1.setBounds(210,80,160,30);
        add(cb1);
        
        JLabel status = new JLabel("CLEANING STATUS");
        status.setForeground(Color.DARK_GRAY);
        status.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,16));
        status.setBounds(30,130,160,30);
        add(status);
        cb2 = new JComboBox(new String[] {"Clean","Dirty"});
        cb2.setFont(new Font("Arial",Font.ITALIC,14));
        cb2.setForeground(Color.CYAN);
        cb2.setBackground(Color.DARK_GRAY);
        cb2.setBounds(210,130,160,30);
        add(cb2);
                
        JLabel type = new JLabel("TYPE");
        type.setForeground(Color.DARK_GRAY);
        type.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,16));
        type.setBounds(30,180,120,30);
        add(type);
        cb3 = new JComboBox(new String[] {"Singel bed","Double bed"});
        cb3.setFont(new Font("Arial",Font.ITALIC,14));
        cb3.setForeground(Color.CYAN);
        cb3.setBackground(Color.DARK_GRAY);
        cb3.setBounds(210,180,160,30);
        add(cb3);
                
        JLabel price = new JLabel("PRICE");
        price.setForeground(Color.DARK_GRAY);
        price.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,16));
        price.setBounds(30,230,120,30);
        add(price);
        tf2 = new JTextField();
        tf2.setFont(new Font("Arial",Font.ITALIC,14));
        tf2.setForeground(Color.CYAN);
        tf2.setBackground(Color.DARK_GRAY);
        tf2.setBounds(210,230,160,30);
        add(tf2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/77292511.jpg"));
        Image i2 = i1.getImage().getScaledInstance(480,290,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lb = new JLabel(i3);
        lb.setBounds(410,30,480,290);
        add(lb);
        
        b1 = new JButton("Add Room");
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.BLACK);
        b1.setBounds(50,290,130,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.BLACK);
        b2.setBounds(210,290,130,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setTitle("ADD ROOMS");
        setBounds(500,200,940,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String room = tf1.getText();
            String available = (String)cb1.getSelectedItem();
            String status = (String)cb2.getSelectedItem();
            String type = (String)cb3.getSelectedItem();
            String price = tf2.getText();
            
            conn c = new conn();
            try{
                String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+type+"','"+price+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Room Added");
                this.setVisible(false);
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2)
        {
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }
}
