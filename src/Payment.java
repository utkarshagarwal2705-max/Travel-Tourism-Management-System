package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;              
import java.awt.Desktop;          

public class Payment extends JFrame implements ActionListener
{
    private JButton pay,back;
    
    Payment()
    {
        setBounds(600,220,800,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Pay using Paytm");
        heading.setBounds(50,20,400,45);
        heading.setFont(new Font("Dialog",Font.BOLD,35));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,150,800,600);
        add(image);
        
        pay = new JButton("Pay");
        pay.setBounds(420,20,100,35);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setFocusPainted(false);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBounds(540,20,100,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==pay)
        {
            try
            {
                Desktop.getDesktop().browse(new URI("https://paytm.com"));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new Payment();
    }
}