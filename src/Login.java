package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    private JTextField tfusername;
    private JPasswordField tfpassword;
    private JButton login,signup,password;
    
    Login()
    {
          setSize(900,400);
          setLocation(350,200);
          setLayout(null);
          
          getContentPane().setBackground(Color.WHITE);
          
          JPanel p1 = new JPanel();
          p1.setBackground(new Color(70,130,180));
          p1.setBounds(0,0,400,400);
          p1.setLayout(null);
          add(p1);
          
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
          Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
          ImageIcon i3 = new ImageIcon(i2);
          JLabel image = new JLabel(i3);
          image.setBounds(100,120,200,200);
          p1.add(image);
          
          JPanel p2 = new JPanel();
          p2.setLayout(null);
          p2.setBounds(400,30,450,300);
          p2.setBackground(Color.WHITE);
          p2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200,200,200)),BorderFactory.createEmptyBorder(20,20,20,20)));
          add(p2);
          
          JLabel lblusername = new JLabel("Username");
          lblusername.setBounds(60,25,100,25);
          lblusername.setFont(new Font("Dialog",Font.PLAIN,20));
          p2.add(lblusername);
          
          tfusername = new JTextField();
          tfusername.setBounds(60,60,300,35);
          tfusername.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),BorderFactory.createEmptyBorder(5,5,5,5)));
          p2.add(tfusername);
          
          JLabel lblpassword = new JLabel("Password");
          lblpassword.setBounds(60,115,100,25);
          lblpassword.setFont(new Font("Dialog",Font.PLAIN,20));
          p2.add(lblpassword);
          
          tfpassword = new JPasswordField();
          tfpassword.setBounds(60,150,300,35);
          tfpassword.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),BorderFactory.createEmptyBorder(5,5,5,5)));
          p2.add(tfpassword);
          
          login = new JButton("Login");
          login.setBounds(60,200,130,35);
          login.setBackground(new Color(125,200,250));
          login.setForeground(Color.WHITE);
          login.setBorder(new LineBorder(new Color(125,200,250)));
          login.setFocusPainted(false);
          login.setCursor(new Cursor(Cursor.HAND_CURSOR));
          login.addActionListener(this);
          p2.add(login);
          
          signup = new JButton("Signup");
          signup.setBounds(230,200,130,35);
          signup.setBackground(new Color(125,200,250));
          signup.setForeground(Color.WHITE);
          signup.setBorder(new LineBorder(new Color(125,200,250)));
          signup.setFocusPainted(false);
          signup.addActionListener(this);
          p2.add(signup);
          
          password = new JButton("Forgot Password");
          password.setBounds(140,250,170,35);
          password.setBackground(new Color(125,200,250));
          password.setForeground(Color.white);
          password.setBorder(new LineBorder(new Color(125,200,250)));
          password.setFocusPainted(false);
          password.addActionListener(this);
          p2.add(password);
          
          setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            try
            {
                String username = tfusername.getText();
                String pass = new String(tfpassword.getPassword());
                String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Loading(username);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password.");
                }
            }catch(Exception e){e.printStackTrace();}
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new Signup();
        }
        else if(ae.getSource()==password)
        {
            setVisible(false);
            new ForgotPassword();
        }
    }
    
    public static void main(String args[])
    {
        Login l = new Login();
    }
}
    
