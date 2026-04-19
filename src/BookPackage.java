package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame
{
    JTextField t1,t2;
    Choice c1;
    
    BookPackage(String username)
    {
        setBounds(420,220,1100,450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,50,700,300);
        add(image);
        
        JLabel lblname = new JLabel("BOOK PACKAGE");
        lblname.setBounds(118,11,300,53);
        lblname.setFont(new Font("Dialog",Font.BOLD,20));
        add(lblname);
        
        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(35,70,200,20);
        add(lblusername);
        
        JLabel l1 = new JLabel(username);
        l1.setBounds(271,70,200,20);
        add(l1);
        
        JLabel lblid = new JLabel("Select Package :");
        lblid.setBounds(35,110,200,20);
        add(lblid);
        
        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(271,110,150,25);
        add(c1);
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(35,150,200,20);
        add(lblpersons);
        
        t1 = new JTextField("0");
        t1.setBounds(271,150,150,25);
        add(t1);
        
        JLabel lblid2 = new JLabel("ID :");
        lblid2.setBounds(35,190,200,20);
        add(lblid2);
        
        JLabel l2 = new JLabel();
        l2.setBounds(271,190,200,20);
        add(l2);
        
        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setBounds(35,230,200,20);
        add(lblnumber);
        
        JLabel l3 = new JLabel();
        l3.setBounds(271,230,200,20);
        add(l3);
        
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(35,270,200,20);
        add(lblphone);
        
        JLabel l4 = new JLabel();
        l4.setBounds(271,270,200,20);
        add(l4);
        
        JLabel lblprice = new JLabel("Total Price :");
        lblprice.setBounds(35,310,200,20);
        add(lblprice);
        
        JLabel l5 = new JLabel();
        l5.setBounds(271,310,200,20);
        l5.setForeground(Color.RED);
        add(l5);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next())
            {
                l2.setText(rs.getString("id"));
                l3.setText(rs.getString("number"));
                l4.setText(rs.getString("phone"));
            }
            rs.close();
        }catch(Exception e){e.printStackTrace();}
        
        JButton check = new JButton("Check Price");
        check.setBounds(50,350,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String p = c1.getSelectedItem();
                int cost = 0;
                
                if(p.equals("Gold Package"))
                {
                    cost += 12000;
                }
                else if(p.equals("Silver Package"))
                {
                    cost += 25000;
                }
                else if(p.equals("Bronze Package"))
                {
                    cost += 32000;
                }
                
                cost *= Integer.parseInt(t1.getText());
                l5.setText("Rs "+cost);
            }
        });
        add(check);
        
        JButton book = new JButton("Book");
        book.setBounds(200,350,120,30);
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    Conn c = new Conn();
                    
                    String query = "insert into bookPackage values('"+username+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+l2.getText()+"','"+l3.getText()+"','"+l4.getText()+"','"+l5.getText()+"')";
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                    setVisible(false);
                }catch(Exception e){e.printStackTrace();}
            }
        });
        add(book);
        
        JButton back = new JButton("Back");
        back.setBounds(350,350,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
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
        new BookPackage("");
    }
}