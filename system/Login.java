
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JLabel lb1,lb2;
    JTextField t1;
    JPasswordField p;
    JButton b1,b2;
    private Container c;
    
    Login()
    {
        c = this.getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        
        lb1 = new JLabel("Username");
        lb1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        lb1.setForeground(Color.BLACK);
        lb1.setBounds(40,40,100,30);
        add(lb1);
        
        lb2 = new JLabel("Password");
        lb2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,15));
        lb2.setForeground(Color.BLACK);
        lb2.setBounds(40,90,100,30);
        add(lb2);
        
        t1 = new JTextField();
        t1.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,13));
        t1.setBounds(150,40,150,30);
        t1.setBackground(Color.BLACK);
        t1.setForeground(Color.LIGHT_GRAY);
        add(t1);
        
        p = new JPasswordField();
        p.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,13));
        p.setBounds(150,90,150,30);
        p.setBackground(Color.BLACK);
        p.setForeground(Color.LIGHT_GRAY);
        add(p);
        
        b1 = new JButton("Login");
        b1.setBackground(Color.black);
        b1.setForeground(Color.LIGHT_GRAY);
        b1.setBounds(40,170,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.LIGHT_GRAY);
        b2.setBounds(180,170,120,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/REG-201542.png"));
        //Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        //ImageIcon i3 = new ImageIcon(i2);
        JLabel lb3 = new JLabel(i1);
        lb3.setBounds(350,20,220,220);
        add(lb3);
                
        setTitle("Login");
        setLayout(null);
        setBounds(600,300,600,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String username = t1.getText();
            String password = p.getText();
            conn c = new conn();
            
            String str = "select * from login where username = '"+username+"' and password = '"+password+"'";
            try{
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next())
                {
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    this.setVisible(false);
                }
            }catch(Exception e)
            {
                
            }
        }
        else if(ae.getSource()==b2)
        {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
