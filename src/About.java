package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener
{
    private JButton back;
    private JLabel heading;
    private TextArea text;
    
    About()
    {
        setBounds(700,220,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        heading = new JLabel("About Project");
        heading.setBounds(170,10,200,40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Dialog",Font.BOLD,20));
        add(heading);
        
        String s = "The Travel and Tourism Management System is a desktop-based "
        + "application developed using Java Swing and MySQL.\n\n"
        + "The objective of this project is to automate travel and tourism "
        + "operations such as customer management, package booking, and hotel booking.\n\n"
        + "The system provides a user-friendly interface for managing travel data "
        + "efficiently and reduces manual work.\n\n"
        + "Key Features:\n"
        + "- User authentication (Login/Signup)\n"
        + "- Customer details management\n"
        + "- Travel package viewing and booking\n"
        + "- Hotel booking system\n"
        + "- Payment module (simulated using external redirection)\n\n"
        + "Advantages:\n"
        + "- Reduces manual effort and paperwork\n"
        + "- Provides quick and accurate information\n"
        + "- Easy to use graphical interface\n"
        + "- Centralized data storage using database\n"
        + "- Improves efficiency and data management";
        
        text = new TextArea(s,10,40,Scrollbar.VERTICAL);
        text.setBounds(20,70,450,350);
        text.setEditable(false);
        text.setFont(new Font("Dialog",Font.PLAIN,14));
        add(text);
        
        back = new JButton("Back");
        back.setBounds(180,440,120,30);
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
        new About();
    }
}