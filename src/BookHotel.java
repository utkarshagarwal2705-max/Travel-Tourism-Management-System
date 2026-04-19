package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener
{
    private JTextField t1,t2;
    private Choice c1,c2,c3;
    private JLabel l1,l2,l3,l4,l5;
    private JButton check,book,back;
    
    BookHotel(String username)
    {
        setBounds(420,220,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,100,700,300);
        add(image);
        
        JLabel heading = new JLabel("BOOK HOTEL");
        heading.setBounds(118,11,300,53);
        heading.setFont(new Font("Dialog",Font.BOLD,20));
        add(heading);
        
        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(35,70,200,20);
        add(lblusername);
        
        l1 = new JLabel(username);
        l1.setBounds(271,70,200,20);
        add(l1);
        
        JLabel lblhotel = new JLabel("Select Hotel :");
        lblhotel.setBounds(35,110,200,20);
        add(lblhotel);
        
        c1 = new Choice();
        c1.setBounds(271,110,150,30);
        add(c1);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotels");
            while(rs.next())
            {
                c1.add(rs.getString("name"));
            }
            rs.close();
        }catch(Exception e){e.printStackTrace();}
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(35,150,200,20);
        add(lblpersons);
        
        t1 = new JTextField("0");
        t1.setBounds(271,150,150,25);
        add(t1);
        
        JLabel lbldays = new JLabel("Number of Days");
        lbldays.setBounds(35,190,200,20);
        add(lbldays);
        
        t2 = new JTextField("0");
        t2.setBounds(271,190,150,25);
        add(t2);
        
        JLabel lblac = new JLabel("AC / Non-AC");
        lblac.setBounds(35,230,200,20);
        add(lblac);
        
        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setBounds(271,230,150,30);
        add(c2);
        
        JLabel lblfood = new JLabel("Food Included :");
        lblfood.setBounds(35,270,200,20);
        add(lblfood);
        
        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(271,270,150,30);
        add(c3);
        
        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(35,310,200,20);
        add(lblid);
        
        l2 = new JLabel();
        l2.setBounds(271,310,200,20);
        add(l2);
        
        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setBounds(35,350,200,20);
        add(lblnumber);
        
        l3 = new JLabel();
        l3.setBounds(271,350,200,20);
        add(l3);
        
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(35,390,200,20);
        add(lblphone);
        
        l4 = new JLabel();
        l4.setBounds(271,390,200,20);
        add(l4);
        
        JLabel lblprice = new JLabel("Total Price :");
        lblprice.setBounds(35,430,200,20);
        add(lblprice);
        
        l5 = new JLabel();
        l5.setBounds(271,430,200,20);
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
        
        check = new JButton("Check Price");
        check.setBounds(50,470,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);
        
        book = new JButton("Book");
        book.setBounds(200,470,120,30);
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.addActionListener(this);
        add(book);
        
        back = new JButton("Back");
        back.setBounds(350,470,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==check)
        {
            try
            {
                Conn c = new Conn();
                String query = "select * from hotels where name = '"+c1.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next())
                {
                    int cost = Integer.parseInt(rs.getString("cost_per_day"));
                    int food = Integer.parseInt(rs.getString("food_charges"));
                    int ac = Integer.parseInt(rs.getString("ac_charges"));
                    
                    int persons = Integer.parseInt(t1.getText());
                    int days = Integer.parseInt(t2.getText());
                    
                    int total = 0;
                    
                    if(persons * days > 0)
                    {
                        total += c2.getSelectedItem().equals("AC") ? ac : 0;
                        total += c3.getSelectedItem().equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        
                        l5.setText("Rs "+total);
                    }
                }
            }catch(Exception e){e.printStackTrace();}
        }
        
        else if(ae.getSource()==book)
        {
            try
            {
                Conn c = new Conn();
                String query = "insert into bookHotel values('"+l1.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+t2.getText()+"','"+c2.getSelectedItem()+"','"+c3.getSelectedItem()+"','"+l2.getText()+"','"+l3.getText()+"','"+l4.getText()+"','"+l5.getText().replace("Rs ","")+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
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
        new BookHotel("");
    }
}