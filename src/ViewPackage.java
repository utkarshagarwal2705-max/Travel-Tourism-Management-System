package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame
{
    ViewPackage(String username)
    {
        setBounds(580,220,850,450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,40,350,350);
        add(image);
        
        JLabel lblname = new JLabel("VIEW PACKAGE DETAILS");
        lblname.setBounds(88,11,350,53);
        lblname.setFont(new Font("Dialog",Font.BOLD,20));
        add(lblname);
        
        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(35,70,200,20);
        add(lblusername);
        
        JLabel l1 = new JLabel();
        l1.setBounds(271,70,200,20);
        add(l1);
        
        JLabel lblpackage = new JLabel("Package :");
        lblpackage.setBounds(35,110,200,20);
        add(lblpackage);
        
        JLabel l2 = new JLabel();
        l2.setBounds(271,110,200,20);
        add(l2);
        
        JLabel lblpersons = new JLabel("Number of Persons :");
        lblpersons.setBounds(35,150,200,20);
        add(lblpersons);
        
        JLabel l3 = new JLabel();
        l3.setBounds(271,150,200,20);
        add(l3);
        
        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(35,190,200,20);
        add(lblid);
        
        JLabel l4 = new JLabel();
        l4.setBounds(271,190,200,20);
        add(l4);
        
        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setBounds(35,230,200,20);
        add(lblnumber);
        
        JLabel l5 = new JLabel();
        l5.setBounds(271,230,200,20);
        add(l5);
        
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(35,270,200,20);
        add(lblphone);
        
        JLabel l6 = new JLabel();
        l6.setBounds(271,270,200,20);
        add(l6);
        
        JLabel lblprice = new JLabel("Price :");
        lblprice.setBounds(35,310,200,20);
        add(lblprice);
        
        JLabel l7 = new JLabel();
        l7.setBounds(271,310,200,20);
        add(l7);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookPackage where username = '"+username+"'");
            while(rs.next())
            {
                l1.setText(rs.getString(1));
                l2.setText(rs.getString(2));
                l3.setText(rs.getString(3));
                l4.setText(rs.getString(4));
                l5.setText(rs.getString(5));
                l6.setText(rs.getString(6));
                l7.setText(rs.getString(7));
            }
            rs.close();
        }catch(Exception e){e.printStackTrace();}
        
        JButton back = new JButton("Back");
        back.setBounds(160,350,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                setVisible(false);
            }
        });
        add(back);
        
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new ViewPackage("");
    }
}