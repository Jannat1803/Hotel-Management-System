package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener{
    
    JTextField tf1,tf2,tf3,tf4,tf5;
    JButton b1,b2;
    JRadioButton rb1,rb2;
    JComboBox cb1;
    
    AddDrivers()
    {
        JLabel name = new JLabel("NAME");
        name.setBounds(30,30,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        add(name);
        tf1 = new JTextField();
        tf1.setFont(new Font("Arial",Font.ITALIC,14));
        tf1.setForeground(Color.CYAN);
        tf1.setBackground(Color.DARK_GRAY);
        tf1.setBounds(190,30,160,30);
        add(tf1);
        
        JLabel age = new JLabel("AGE");
        age.setBounds(30,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        add(age);
        tf2 = new JTextField();
        tf2.setFont(new Font("Arial",Font.ITALIC,14));
        tf2.setForeground(Color.CYAN);
        tf2.setBackground(Color.DARK_GRAY);
        tf2.setBounds(190,80,160,30);
        add(tf2);
        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        gender.setBounds(30,130,120,30);
        add(gender);
        rb1 = new JRadioButton("Male");
        rb1.setFont(new Font("Tahoma",Font.ITALIC,14));
        rb1.setBackground(Color.DARK_GRAY);
        rb1.setForeground(Color.CYAN);
        rb1.setBounds(190,130,70,30);
        add(rb1);
        rb2 = new JRadioButton("Female");
        rb2.setBackground(Color.DARK_GRAY);
        rb2.setForeground(Color.CYAN);
        rb2.setFont(new Font("Tahoma",Font.ITALIC,14));
        rb2.setBounds(270,130,80,30);
        add(rb2);
        
        JLabel company = new JLabel("CAR COMPANY");
        company.setBounds(30,180,120,30);
        company.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        add(company);
        tf3 = new JTextField();
        tf3.setFont(new Font("Arial",Font.ITALIC,14));
        tf3.setForeground(Color.CYAN);
        tf3.setBackground(Color.DARK_GRAY);
        tf3.setBounds(190,180,160,30);
        add(tf3);
        
        JLabel model = new JLabel("CAR MODEL");
        model.setBounds(30,230,120,30);
        model.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        add(model);
        tf4 = new JTextField();
        tf4.setFont(new Font("Arial",Font.ITALIC,14));
        tf4.setForeground(Color.CYAN);
        tf4.setBackground(Color.DARK_GRAY);
        tf4.setBounds(190,230,160,30);
        add(tf4);
        
        JLabel available = new JLabel("AVAILABLE");
        available.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        available.setBounds(30,280,120,30);
        add(available);
        cb1 = new JComboBox(new String[] {"Available","Occupied"});
        cb1.setFont(new Font("Arial",Font.ITALIC,14));
        cb1.setForeground(Color.CYAN);
        cb1.setBackground(Color.DARK_GRAY);
        cb1.setBounds(190,280,160,30);
        add(cb1);
        
        JLabel licence = new JLabel("LICENCE");
        licence.setBounds(30,330,120,30);
        licence.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        add(licence);
        tf5 = new JTextField();
        tf5.setFont(new Font("Arial",Font.ITALIC,14));
        tf5.setForeground(Color.CYAN);
        tf5.setBackground(Color.DARK_GRAY);
        tf5.setBounds(190,330,160,30);
        add(tf5);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/turning_key_in_ignition.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,390,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lb = new JLabel(i3);
        lb.setBounds(400,30,450,390);
        add(lb);
        
        b1 = new JButton("Add Driver");
        b1.setForeground(Color.GREEN);
        b1.setBackground(Color.BLACK);
        b1.setBounds(40,390,130,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBackground(Color.BLACK);
        b2.setBounds(190,390,130,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setTitle("ADD DRIVERS");
        setBounds(525,200,900,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String name = tf1.getText();
            String age = tf2.getText();
            String company = tf3.getText();
            String model = tf4.getText();
            String available = (String)cb1.getSelectedItem();
            String licence = tf5.getText();
            String gender = null;
            if(rb1.isSelected())
            {
                gender = "Male";
            }
            else
            {
                gender = "Female";
            }
            
            conn c = new conn();
            try{
                String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+licence+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Driver Added");
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
        new AddDrivers().setVisible(true);
    }
}
