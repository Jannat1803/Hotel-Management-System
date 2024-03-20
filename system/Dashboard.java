
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem mi1,mi2,mi3,mi4;
    
    Dashboard()
    {
        mb = new JMenuBar();
        //mb.setBackground(Color.GRAY);
        add(mb);
        
        m1 = new JMenu("HOTEL_MANAGEMENT");
        m1.setForeground(Color.red);
        mb.add(m1);
        
        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.blue);
        mb.add(m2);
        
        mi1 = new JMenuItem("RECEPTION");
        mi1.addActionListener(this);
        m1.add(mi1);
        
        mi2 = new JMenuItem("ADD EMPLOYEE");
        mi2.addActionListener(this);
        m2.add(mi2);
        
        mi3 = new JMenuItem("ADD ROOMS");
        mi3.addActionListener(this);
        m2.add(mi3);
        
        mi4 = new JMenuItem("ADD DRIVERS");
        mi4.addActionListener(this);
        m2.add(mi4);
        
        mb.setBounds(0,0,1920,30);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1940,1020,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lb = new JLabel(i3);
        lb.setBounds(0,0,1940,1020);
        add(lb);
        
        JLabel lb2 = new JLabel("WELCOME");
        lb2.setBounds(810,70,1500,90);
        lb2.setForeground(Color.yellow);
        lb2.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,60));
        lb.add(lb2);
        
        setLayout(null);
        setBounds(0,0,1940,1040);
        setVisible(true);     
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("RECEPTION"))
        {
            new AddReception().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD ROOMS"))
        {
            new AddRooms().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS"))
        {
            new AddDrivers().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
