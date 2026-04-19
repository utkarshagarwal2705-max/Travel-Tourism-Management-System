package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener
{
    private JButton create,back;
    private JTextField tfname,tfusername;
    private JPasswordField tfpassword,tfanswer;
    private Choice security;
    
    Signup()
    {
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(125,200,250));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50,20,125,25);
        lblusername.setFont(new Font("Dialog",Font.BOLD,15));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,60,125,25);
        lblname.setFont(new Font("Dialog",Font.BOLD,15));
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(50,100,125,25);
        lblpassword.setFont(new Font("Dialog",Font.BOLD,15));
        p1.add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setBounds(50,140,140,25);
        lblsecurity.setFont(new Font("Dialog",Font.BOLD,15));
        p1.add(lblsecurity);
        
        security = new Choice();
        security.add("Favourite Show");
        security.add("Favourite Game");
        security.add("Favourite Food");
        security.add("Favourite Color");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(50,180,125,25);
        lblanswer.setFont(new Font("Dialog",Font.BOLD,15));
        p1.add(lblanswer);
        
        tfanswer = new JPasswordField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        create = new JButton("Login");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(125,200,250));
        create.setFont(new Font("Dialog",Font.BOLD,15));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(125,200,250));
        back.setFont(new Font("Dialog",Font.BOLD,15));
        back.setBounds(250,250,100,30);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        back.addActionListener(this);
        add(image);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==create)
        {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = new String(tfpassword.getPassword());
            String question = security.getSelectedItem();
            String answer = new String(tfanswer.getPassword());
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Created Successfully!");
                
                setVisible(false);
                new Login();
            }catch(Exception e){e.printStackTrace();}
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[])
    {
        new Signup();
    }
}
