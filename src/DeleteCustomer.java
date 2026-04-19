package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteCustomer extends JFrame implements ActionListener
{
    private JLabel labelusername,t1,t2,t3,t4,t5,t6,t7,t8;
    private JButton delete;
    String username;
    
    DeleteCustomer(String username)
    {
        this.username = username;
        setBounds(580,220,900,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblheading = new JLabel("VIEW CUSTOMER DETAILS");
        lblheading.setBounds(250,20,400,30);
        lblheading.setFont(new Font("Dialog",Font.BOLD,28));
        lblheading.setForeground(Color.BLACK);
        add(lblheading);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(80,100,120,25);
        lblusername.setFont(new Font("Dialog",Font.BOLD,16));
        lblusername.setForeground(new Color(60,60,60));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220,100,200,25);
        labelusername.setFont(new Font("Dialog",Font.BOLD,16));
        labelusername.setForeground(Color.BLACK);
        add(labelusername);
        
        // Left Column
        JLabel lblid = new JLabel("Id Type");
        lblid.setBounds(80,160,120,25);
        lblid.setFont(new Font("Dialog",Font.BOLD,16));
        lblid.setForeground(new Color(60,60,60));
        add(lblid);
        
        t1 = new JLabel();
        t1.setBounds(220,160,200,25);
        t1.setFont(new Font("Dialog",Font.BOLD,16));
        add(t1);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(80,200,120,25);
        lblnumber.setFont(new Font("Dialog",Font.BOLD,16));
        lblnumber.setForeground(new Color(60,60,60));
        add(lblnumber);
        
        t2 = new JLabel();
        t2.setBounds(220,200,200,25);
        t2.setFont(new Font("Dialog",Font.BOLD,16));
        add(t2);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(80,240,120,25);
        lblname.setFont(new Font("Dialog",Font.BOLD,16));
        lblname.setForeground(new Color(60,60,60));
        add(lblname);
        
        t3 = new JLabel();
        t3.setBounds(220,240,200,25);
        t3.setFont(new Font("Dialog",Font.BOLD,16));
        add(t3);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(80,280,120,25);
        lblgender.setFont(new Font("Dialog",Font.BOLD,16));
        lblgender.setForeground(new Color(60,60,60));
        add(lblgender);
        
        t4 = new JLabel();
        t4.setBounds(220,280,200,25);
        t4.setFont(new Font("Dialog",Font.BOLD,16));
        add(t4);
        
        // Right Column
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500,160,120,25);
        lblcountry.setFont(new Font("Dialog",Font.BOLD,16));
        lblcountry.setForeground(new Color(60,60,60));
        add(lblcountry);
        
        t5 = new JLabel();
        t5.setBounds(650,160,220,25);
        t5.setFont(new Font("Dialog",Font.BOLD,16));
        add(t5);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500,200,120,25);
        lbladdress.setFont(new Font("Dialog",Font.BOLD,16));
        lbladdress.setForeground(new Color(60,60,60));
        add(lbladdress);
        
        t6 = new JLabel();
        t6.setBounds(650,200,300,25);
        t6.setFont(new Font("Dialog",Font.BOLD,16));
        add(t6);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500,240,120,25);
        lblphone.setFont(new Font("Dialog",Font.BOLD,16));
        lblphone.setForeground(new Color(60,60,60));
        add(lblphone);
        
        t7 = new JLabel();
        t7.setBounds(650,240,200,25);
        t7.setFont(new Font("Dialog",Font.BOLD,16));
        add(t7);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500,280,120,25);
        lblemail.setFont(new Font("Dialog",Font.BOLD,16));
        lblemail.setForeground(new Color(60,60,60));
        add(lblemail);
        
        t8 = new JLabel();
        t8.setBounds(650,280,250,25);
        t8.setFont(new Font("Dialog",Font.BOLD,16));
        add(t8);
        
        delete = new JButton("Delete");
        delete.setBounds(380,350,140,35);
        delete.setFont(new Font("Dialog",Font.BOLD,16));
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFocusPainted(false);
        delete.addActionListener(this);
        add(delete);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,400,900,200);
        add(image);
        
        // Auto Fetch
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            
            if(rs.next())
            {
                labelusername.setText(rs.getString("username"));
                t1.setText(rs.getString("id"));
                t2.setText(rs.getString("number"));
                t3.setText(rs.getString("name"));
                t4.setText(rs.getString("gender"));
                t5.setText(rs.getString("country"));
                t6.setText(rs.getString("address"));
                t7.setText(rs.getString("phone"));
                t8.setText(rs.getString("email"));
            }
            
        }catch(Exception e){e.printStackTrace();}
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username = '"+username+"'");
            c.s.executeUpdate("delete from customer where username = '"+username+"'");
            c.s.executeUpdate("delete from bookPackage where username = '"+username+"'");
            c.s.executeUpdate("delete from bookHotel where username = '"+username+"'");
            
            JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
            System.exit(0);
        }catch(Exception e){e.printStackTrace();}
    }
    
    public static void main(String args[])
    {
        new DeleteCustomer("");
    }
}