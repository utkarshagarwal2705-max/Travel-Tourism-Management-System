package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener
{
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    private JButton back;
    
    ViewBookedHotel(String username)
    {
        setBounds(580,220,850,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,350,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,50,350,350);
        add(image);
        
        JLabel heading = new JLabel("VIEW BOOKED HOTEL DETAILS");
        heading.setBounds(88,11,400,53);
        heading.setFont(new Font("Dialog",Font.BOLD,20));
        add(heading);
        
        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(35,70,200,20);
        add(lblusername);
        
        l1 = new JLabel();
        l1.setBounds(271,70,200,20);
        add(l1);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(35,110,200,20);
        add(lblname);
        
        l2 = new JLabel();
        l2.setBounds(271,110,200,20);
        add(l2);
        
        JLabel lblpersons = new JLabel("Number of Persons :");
        lblpersons.setBounds(35,150,200,20);
        add(lblpersons);
        
        l3 = new JLabel();
        l3.setBounds(271,150,200,20);
        add(l3);
        
        JLabel lbldays = new JLabel("Number of Days :");
        lbldays.setBounds(35,190,200,20);
        add(lbldays);
        
        l4 = new JLabel();
        l4.setBounds(271,190,200,20);
        add(l4);
        
        JLabel lblac = new JLabel("AC / Non-AC :");
        lblac.setBounds(35,230,200,20);
        add(lblac);
        
        l5 = new JLabel();
        l5.setBounds(271,230,200,20);
        add(l5);
        
        JLabel lblfood = new JLabel("Food Included :");
        lblfood.setBounds(35,270,200,20);
        add(lblfood);
        
        l6 = new JLabel();
        l6.setBounds(271,270,200,20);
        add(l6);
        
        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(35,310,200,20);
        add(lblid);
        
        l7 = new JLabel();
        l7.setBounds(271,310,200,20);
        add(l7);
        
        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setBounds(35,350,200,20);
        add(lblnumber);
        
        l8 = new JLabel();
        l8.setBounds(271,350,200,20);
        add(l8);
        
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(35,390,200,20);
        add(lblphone);
        
        l9 = new JLabel();
        l9.setBounds(271,390,200,20);
        add(l9);
        
        JLabel lblprice = new JLabel("Cost :");
        lblprice.setBounds(35,430,200,20);
        add(lblprice);
        
        l10 = new JLabel();
        l10.setBounds(271,430,200,20);
        add(l10);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookHotel where username = '"+username+"'");
            
            if(rs.next())
            {
                l1.setText(rs.getString(1));
                l2.setText(rs.getString(2));
                l3.setText(rs.getString(3));
                l4.setText(rs.getString(4));
                l5.setText(rs.getString(5));
                l6.setText(rs.getString(6));
                l7.setText(rs.getString(7));
                l8.setText(rs.getString(8));
                l9.setText(rs.getString(9));
                l10.setText("Rs "+rs.getString(10));
            }
            
        }catch(Exception e){e.printStackTrace();}
        
        back = new JButton("Back");
        back.setBounds(160,470,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new ViewBookedHotel("");
    }
}