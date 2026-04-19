package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable
{
    JLabel l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JLabel caption;
    JPanel bg;
    Thread t;
    
    public void run()
    {
        try
        {
            l2.setVisible(true);
            caption.setText("JW Marriott Hotel");
            Thread.sleep(2500);
            
            l2.setVisible(false);
            l3.setVisible(true);
            caption.setText("Mandarin Oriental Hotel");
            Thread.sleep(2500);
            
            l3.setVisible(false);
            l4.setVisible(true);
            caption.setText("Four Seasons Hotel");
            Thread.sleep(2500);
            
            l4.setVisible(false);
            l5.setVisible(true);
            caption.setText("Radisson Hotel");
            Thread.sleep(2500);
            
            l5.setVisible(false);
            l6.setVisible(true);
            caption.setText("Classio Hotel");
            Thread.sleep(2500);
            
            l6.setVisible(false);
            l7.setVisible(true);
            caption.setText("The Bay Club Hotel");
            Thread.sleep(2500);
            
            l7.setVisible(false);
            l8.setVisible(true);
            caption.setText("Breeze Blows Hotel");
            Thread.sleep(2500);
            
            l8.setVisible(false);
            l9.setVisible(true);
            caption.setText("Quick Stop Hotel");
            Thread.sleep(2500);
            
            l9.setVisible(false);
            l10.setVisible(true);
            caption.setText("Happy Mornings Motel");
            Thread.sleep(2500);
            
            l10.setVisible(false);
            l11.setVisible(true);
            caption.setText("Moss View Hotel");
            Thread.sleep(2500);
            
            setVisible(false);
        }
        catch(Exception e){e.printStackTrace();}
    }
    
    CheckHotels()
    {
        setSize(900,700);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        t = new Thread(this);
        
        // Image 1
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/hotel1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(0,0,900,700);
        add(l2);
        
        // Image 2
        ImageIcon i4 = new ImageIcon(getClass().getResource("/icons/hotel2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.setBounds(0,0,900,700);
        add(l3);
        l3.setVisible(false);
        
        // Image 3
        ImageIcon i7 = new ImageIcon(getClass().getResource("/icons/hotel3.jpg"));
        Image i8 = i7.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        l4 = new JLabel(i9);
        l4.setBounds(0,0,900,700);
        add(l4);
        l4.setVisible(false);
        
        // Image 4
        ImageIcon i10 = new ImageIcon(getClass().getResource("/icons/hotel4.jpg"));
        Image i11 = i10.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i12 = new ImageIcon(i11);
        l5 = new JLabel(i12);
        l5.setBounds(0,0,900,700);
        add(l5);
        l5.setVisible(false);
        
        // Image 5
        ImageIcon i13 = new ImageIcon(getClass().getResource("/icons/hotel5.jpg"));
        Image i14 = i13.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(0,0,900,700);
        add(l6);
        l6.setVisible(false);
        
        // Image 6
        ImageIcon i16 = new ImageIcon(getClass().getResource("/icons/hotel6.jpg"));
        Image i17 = i16.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i18 = new ImageIcon(i17);
        l7 = new JLabel(i18);
        l7.setBounds(0,0,900,700);
        add(l7);
        l7.setVisible(false);
        
        // Image 7
        ImageIcon i19 = new ImageIcon(getClass().getResource("/icons/hotel7.jpg"));
        Image i20 = i19.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i21 = new ImageIcon(i20);
        l8 = new JLabel(i21);
        l8.setBounds(0,0,900,700);
        add(l8);
        l8.setVisible(false);
        
        // Image 8
        ImageIcon i22 = new ImageIcon(getClass().getResource("/icons/hotel8.jpg"));
        Image i23 = i22.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i24 = new ImageIcon(i23);
        l9 = new JLabel(i24);
        l9.setBounds(0,0,900,700);
        add(l9);
        l9.setVisible(false);
        
        // Image 9
        ImageIcon i25 = new ImageIcon(getClass().getResource("/icons/hotel9.jpg"));
        Image i26 = i25.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i27 = new ImageIcon(i26);
        l10 = new JLabel(i27);
        l10.setBounds(0,0,900,700);
        add(l10);
        l10.setVisible(false);
        
        // Image 10
        ImageIcon i28 = new ImageIcon(getClass().getResource("/icons/hotel10.jpg"));
        Image i29 = i28.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        ImageIcon i30 = new ImageIcon(i29);
        l11 = new JLabel(i30);
        l11.setBounds(0,0,900,700);
        add(l11);
        l11.setVisible(false);
        
        // Background Panel
        bg = new JPanel();
        bg.setBounds(0,530,900,80);
        bg.setBackground(new Color(0,0,0,180));
        bg.setLayout(null);
        add(bg);
        
        // Forcing Top Layer
        getContentPane().setComponentZOrder(bg,0);
        
        caption = new JLabel();
        caption.setBounds(0,10,900,60);
        caption.setHorizontalAlignment(JLabel.CENTER);
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Dialog",Font.BOLD,40));
        bg.add(caption);
        
        t.start();
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new CheckHotels();
    }
}