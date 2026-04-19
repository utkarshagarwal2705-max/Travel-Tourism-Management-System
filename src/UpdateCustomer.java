package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener
{
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    private JButton update,back;
    private String username; 
    
    UpdateCustomer(String username)
    {
        this.username = username;
        
        setBounds(580,220,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,200,400);
        add(image);
        
        JLabel heading = new JLabel("UPDATE CUSTOMER DETAILS");
        heading.setBounds(118,11,300,53);
        heading.setFont(new Font("Dialog",Font.BOLD,20));
        add(heading);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(35,70,200,25);
        add(lblusername);
        
        t1 = new JTextField();
        t1.setBounds(271,70,150,25);
        add(t1);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,110,200,25);
        add(lblid);
        
        t2 = new JTextField();
        t2.setBounds(271,110,150,25);
        add(t2);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35,150,200,25);
        add(lblnumber);
        
        t3 = new JTextField();
        t3.setBounds(271,150,150,25);
        add(t3);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,190,200,25);
        add(lblname);
        
        t4 = new JTextField();
        t4.setBounds(271,190,150,25);
        add(t4);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,230,200,25);
        add(lblgender);
        
        t5 = new JTextField();
        t5.setBounds(271,230,150,25);
        add(t5);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,270,200,25);
        add(lblcountry);
        
        t6 = new JTextField();
        t6.setBounds(271,270,150,25);
        add(t6);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(35,310,200,25);
        add(lbladdress);
        
        t7 = new JTextField();
        t7.setBounds(271,310,150,25);
        add(t7);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(35,350,200,25);
        add(lblphone);
        
        t8 = new JTextField();
        t8.setBounds(271,350,150,25);
        add(t8);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(35,390,200,25);
        add(lblemail);
        
        t9 = new JTextField();
        t9.setBounds(271,390,150,25);
        add(t9);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            if(rs.next())
            {
                t1.setText(rs.getString("username"));
                t2.setText(rs.getString("id"));
                t3.setText(rs.getString("number"));
                t4.setText(rs.getString("name"));
                t5.setText(rs.getString("gender"));
                t6.setText(rs.getString("country"));
                t7.setText(rs.getString("address"));
                t8.setText(rs.getString("phone"));
                t9.setText(rs.getString("email"));
            }
        }catch(Exception e){e.printStackTrace();}
        
        update = new JButton("Update");
        update.setBounds(100,430,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(260,430,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {
            try
            {
                Conn c = new Conn();
                
                String s2 = t2.getText();
                String s3 = t3.getText();
                String s4 = t4.getText();
                String s5 = t5.getText();
                String s6 = t6.getText();
                String s7 = t7.getText();
                String s8 = t8.getText();
                String s9 = t9.getText();
                
                String query = "update customer set id = '"+s2+"', number = '"+s3+"', name = '"+s4+"', gender = '"+s5+"', country = '"+s6+"', address = '"+s7+"', phone = '"+s8+"', email = '"+s9+"' where username = '"+username+"'";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Customer Detail Updated Successfully");
                setVisible(false);
            }catch(Exception e){e.printStackTrace();}
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new UpdateCustomer("");
    }
}