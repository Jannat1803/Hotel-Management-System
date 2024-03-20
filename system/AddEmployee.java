package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JRadioButton rb1,rb2;
    JComboBox cb;
    JButton b,b1;
    
    AddEmployee()
    {
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        name.setBounds(40,30,120,30);
        add(name);
        tf1 = new JTextField();
        tf1.setBounds(180,30,180,30);
        tf1.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf1.setBackground(Color.DARK_GRAY);
        tf1.setForeground(Color.CYAN);
        add(tf1);
        
        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        age.setBounds(40,80,120,30);
        add(age);
        tf2 = new JTextField();
        tf2.setBounds(180,80,180,30);
        tf2.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf2.setBackground(Color.DARK_GRAY);
        tf2.setForeground(Color.CYAN);
        add(tf2);
        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        gender.setBounds(40,130,120,30);
        add(gender);
        rb1 = new JRadioButton("Male");
        rb1.setFont(new Font("Tahoma",Font.ITALIC,14));
        rb1.setBackground(Color.DARK_GRAY);
        rb1.setForeground(Color.CYAN);
        rb1.setBounds(180,130,75,30);
        add(rb1);
        rb2 = new JRadioButton("Female");
        rb2.setBackground(Color.DARK_GRAY);
        rb2.setForeground(Color.CYAN);
        rb2.setFont(new Font("Tahoma",Font.ITALIC,14));
        rb2.setBounds(270,130,85,30);
        add(rb2);
        
        
        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        job.setBounds(40,180,120,30);
        add(job);
        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiiter/Waitress","Manager","Accountant","Chef"};
        cb = new JComboBox(str);
        cb.setBounds(180,180,180,30);
        cb.setBackground(Color.DARK_GRAY);
        cb.setForeground(Color.CYAN);
        cb.setFont(new Font("Tahoma",Font.ITALIC,14));
        add(cb);
        
        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        salary.setBounds(40,230,120,30);
        add(salary);
        tf3 = new JTextField();
        tf3.setBounds(180,230,180,30);
        tf3.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf3.setBackground(Color.DARK_GRAY);
        tf3.setForeground(Color.CYAN);
        add(tf3);
        
        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        phone.setBounds(40,280,120,30);
        add(phone);
        tf4 = new JTextField();
        tf4.setBounds(180,280,180,30);
        tf4.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf4.setBackground(Color.DARK_GRAY);
        tf4.setForeground(Color.CYAN);
        add(tf4);
        
        JLabel id_no = new JLabel("ID_no");
        id_no.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        id_no.setBounds(40,330,120,30);
        add(id_no);
        tf5 = new JTextField();
        tf5.setBounds(180,330,180,30);
        tf5.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf5.setBackground(Color.DARK_GRAY);
        tf5.setForeground(Color.CYAN);
        add(tf5);
        
        JLabel email = new JLabel("Email");
        email.setFont(new Font("Tahoma",Font.PLAIN+Font.BOLD,17));
        email.setBounds(40,380,120,30);
        add(email);
        tf6 = new JTextField();
        tf6.setBounds(180,380,180,30);
        tf6.setFont(new Font("Tahoma",Font.ITALIC,14));
        tf6.setBackground(Color.DARK_GRAY);
        tf6.setForeground(Color.CYAN);
        add(tf6);
        
        b = new JButton("Add Employee");
        b.setForeground(Color.GREEN);
        b.setBackground(Color.BLACK);
        b.setBounds(40,430,130,30);
        b.addActionListener(this);
        add(b);
        
        b1 = new JButton("Cancel");
        b1.setForeground(Color.LIGHT_GRAY);
        b1.setBackground(Color.BLACK);
        b1.setBounds(190,430,130,30);
        b1.addActionListener(this);
        add(b1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/job.jpg"));
        Image i2 = i1.getImage().getScaledInstance(410,430,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lb = new JLabel(i3);
        lb.setBounds(390,30,410,430);
        add(lb);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setLayout(null);
        setTitle("ADD EMPLOYEE");
        setBounds(530,200,850,530);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b){
        String name = tf1.getText();
            String age = tf2.getText();
            String salary = tf3.getText();
            String phone = tf4.getText();
            String id_no = tf5.getText();
            String email = tf6.getText();

            String gender = null;
            if(rb1.isSelected())
            {
                gender = "Male";
            }
            else
            {
                gender = "Female";
            }

            String job = (String)cb.getSelectedItem();

            conn c = new conn();

            String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+id_no+"','"+email+"')";

            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Employee Added");
                this.setVisible(false);

            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b1)
        {
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }
}
