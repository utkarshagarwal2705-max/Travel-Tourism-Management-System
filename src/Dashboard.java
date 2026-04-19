package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Dashboard extends JFrame implements ActionListener
{
    private JButton addPersonalDetails,updatePersonalDetails,viewPersonalDetails,deletePersonalDetails;
    private JButton checkpackage,bookpackage,viewpackage,viewhotels,bookhotels,viewbookedhotel;
    private JButton destinations,payments,calculator,notepad,about;
    private String username;

    Dashboard(String username)
    {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int width = d.width;
        int height = d.height;

        // Top Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,width,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(10,5,50,50);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(70,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Dialog",Font.BOLD,28));
        p1.add(heading);

        // Sidebar
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));

        int sidebarHeight = height - 80; // safe margin for taskbar
        p2.setBounds(0,65,300,sidebarHeight);
        add(p2);

        JButton[] buttons = {
            addPersonalDetails = new JButton("Add Personal Details"),
            updatePersonalDetails = new JButton("Update Personal Details"),
            viewPersonalDetails = new JButton("View Personal Details"),
            deletePersonalDetails = new JButton("Delete Personal Details"),
            checkpackage = new JButton("Check Package"),
            bookpackage = new JButton("Book Package"),
            viewpackage = new JButton("View Package"),
            viewhotels = new JButton("View Hotels"),
            bookhotels = new JButton("Book Hotels"),
            viewbookedhotel = new JButton("View Booked Hotel"),
            destinations = new JButton("Destinations"),
            payments = new JButton("Payments"),
            calculator = new JButton("Calculator"),
            notepad = new JButton("Notepad"),
            about = new JButton("About")
        };

        int y = 0;
        int btnHeight = sidebarHeight / buttons.length;

        for(int i = 0; i < buttons.length; i++)
        {
            JButton b = buttons[i];

            // For last button (About), fill remaining space
            if(i == buttons.length - 1)
            {
                b.setBounds(0, y, 300, sidebarHeight - y);
            }
            else
            {
                b.setBounds(0, y, 300, btnHeight);
            }

            b.setBackground(new Color(0,0,102));
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Dialog", Font.BOLD, 18));
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.addActionListener(this);

            p2.add(b);
            y += btnHeight;
        }

        // Background Image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(width-300,height-65,Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i5));
        image.setBounds(300,65,width-300,height-65);
        add(image);

        // Title With Shadow
        JLabel shadow = new JLabel("Travel & Tourism Management System");
        shadow.setBounds(2,22,width-300,60);
        shadow.setHorizontalAlignment(SwingConstants.CENTER);
        shadow.setForeground(Color.BLACK);
        shadow.setFont(new Font("Dialog",Font.BOLD,40));
        image.add(shadow);

        JLabel text = new JLabel("Travel & Tourism Management System");
        text.setBounds(0,20,width-300,60);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Dialog",Font.BOLD,40));
        image.add(text);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==addPersonalDetails)
        {
            new AddCustomer(username);
        }
        else if(ae.getSource()==updatePersonalDetails)
        {
            new UpdateCustomer(username);
        }
        else if(ae.getSource()==viewPersonalDetails)
        {
            new ViewCustomer(username);
        }
        else if(ae.getSource()==deletePersonalDetails)
        {
            new DeleteCustomer(username);
        }
        else if(ae.getSource()==checkpackage)
        {
            new CheckPackage();
        }
        else if(ae.getSource()==bookpackage)
        {
            new BookPackage(username);
        }
        else if(ae.getSource()==viewpackage)
        {
            new ViewPackage(username);
        }
        else if(ae.getSource()==viewhotels)
        {
            new CheckHotels();
        }
        else if(ae.getSource()==viewbookedhotel)
        {
            new ViewBookedHotel(username);
        }
        else if(ae.getSource()==bookhotels)
        {
            new BookHotel(username);
        }
        else if(ae.getSource()==destinations)
        {
            new Destinations();
        }
        else if(ae.getSource()==payments)
        {
            new Payment();
        }
        else if(ae.getSource()==calculator)
        {
            try
            {
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){e.printStackTrace();}
        }
        else if(ae.getSource()==notepad)
        {
            try
            {
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){e.printStackTrace();}
        }
        else if(ae.getSource()==about)
        {
            new About();
        }
    }

    public static void main(String args[])
    {
        new Dashboard("");
    }
}