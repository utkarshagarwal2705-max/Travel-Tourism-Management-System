package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame
{
    CheckPackage()
    {
        setBounds(550,220,900,600);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);
        
        String[] package1 = new String[]{"package1.jpg","GOLD PACKAGE","6 days and 7 Nights", "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 12000 only"};
        String[] package2 = new String[]{"package2.jpg","SILVER PACKAGE","4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 25000 only"};
        String[] package3 = new String[]{"package3.jpg","BRONZE PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 32000 only"};
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel p1 = createPackage(package1);
        tabbedPane.addTab("Package 1",null,p1);
        
        JPanel p2 = createPackage(package2);
        tabbedPane.addTab("Package 2",null,p2);
        
        JPanel p3 = createPackage(package3);
        tabbedPane.addTab("Package 3",null,p3);
        
        add(tabbedPane);
        
        setVisible(true);
    }
    
    public JPanel createPackage(String[] pack)
    {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/"+pack[0]));
        Image i2 = i1.getImage().getScaledInstance(550,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,450,420);
        p1.add(image);
        
        JLabel lblname = new JLabel(pack[1]);
        lblname.setBounds(50,5,350,53);
        lblname.setFont(new Font("Dialog",Font.BOLD,30));
        p1.add(lblname);
        
        JLabel l3 = new JLabel(pack[2]);
        l3.setForeground(Color.RED);
        l3.setBounds(35,70,300,20);
        p1.add(l3);
        
        JLabel lblid = new JLabel(pack[3]);
        lblid.setForeground(Color.BLUE);
        lblid.setBounds(35,110,300,20);
        p1.add(lblid);
        
        JLabel l2 = new JLabel(pack[4]);
        l2.setForeground(Color.RED);
        l2.setBounds(35,150,300,20);
        p1.add(l2);
        
        JLabel lblname1 = new JLabel(pack[5]);
        lblname1.setForeground(Color.BLUE);
        lblname1.setBounds(35,190,300,20);
        p1.add(lblname1);
        
        JLabel lblgender = new JLabel(pack[6]);
        lblgender.setForeground(Color.RED);
        lblgender.setBounds(35,230,300,20);
        p1.add(lblgender);
        
        JLabel lblcountry = new JLabel(pack[7]);
        lblcountry.setForeground(Color.BLUE);
        lblcountry.setBounds(35,270,300,20);
        p1.add(lblcountry);
        
        JLabel lblreserve = new JLabel(pack[8]);
        lblreserve.setForeground(Color.RED);
        lblreserve.setBounds(35,310,300,20);
        p1.add(lblreserve);
        
        JLabel lblstatus = new JLabel(pack[9]);
        lblstatus.setForeground(Color.BLUE);
        lblstatus.setFont(new Font("Dialog",Font.BOLD,20));
        lblstatus.setBounds(35,400,300,30);
        p1.add(lblstatus);
        
        JLabel lbldeposit = new JLabel(pack[10]);
        lbldeposit.setFont(new Font("Dialog",Font.BOLD,30));
        lbldeposit.setBounds(35,460,400,40);
        p1.add(lbldeposit);
        
        JLabel la1 = new JLabel(pack[11]);
        la1.setForeground(Color.RED);
        la1.setFont(new Font("Dialog",Font.BOLD,30));
        la1.setBounds(600,460,400,40);
        p1.add(la1);
        
        return p1;
    }
    
    public static void main(String args[])
    {
        new CheckPackage();
    }
}