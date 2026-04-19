package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable
{
    JLabel l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JLabel caption;
    Thread t;

    String[] names = {
        "Darjeeling Toy Train",
        "Tawang Monastery",
        "Pangong Lake",
        "Varanasi Ghats",
        "Munnar Tea Gardens",
        "Mysore Palace",
        "Humayun's Tomb",
        "India Gate",
        "Dal Lake",
        "Hampi Stone Chariot"
    };

    public void run()
    {
        try
        {
            l2.setVisible(true);
            caption.setText(names[0]);
            caption.setForeground(Color.BLACK);
            caption.setBounds(30,40,350,50);
            l2.add(caption);
            l2.setComponentZOrder(caption,0);
            Thread.sleep(2500);

            l2.setVisible(false);
            l3.setVisible(true);
            caption.setText(names[1]);
            caption.setForeground(Color.BLACK);
            caption.setBounds(30,40,350,50);
            l3.add(caption);
            l3.setComponentZOrder(caption,0);
            Thread.sleep(2500);

            l3.setVisible(false);
            l4.setVisible(true);
            caption.setText(names[2]);
            caption.setForeground(Color.WHITE);
            caption.setBounds(30,40,350,50);
            l4.add(caption);
            l4.setComponentZOrder(caption,0);
            Thread.sleep(2500);

            l4.setVisible(false);
            l5.setVisible(true);
            caption.setText(names[3]);
            caption.setForeground(Color.BLACK);
            caption.setBounds(30,40,350,50);
            l5.add(caption);
            l5.setComponentZOrder(caption,0);
            Thread.sleep(2500);

            l5.setVisible(false);
            l6.setVisible(true);
            caption.setText(names[4]);
            caption.setForeground(Color.WHITE);
            caption.setBounds(30,40,350,50);
            l6.add(caption);
            l6.setComponentZOrder(caption,0);
            Thread.sleep(2500);

            l6.setVisible(false);
            l7.setVisible(true);
            caption.setText(names[5]);
            caption.setForeground(Color.WHITE);
            caption.setBounds(30,40,350,50);
            l7.add(caption);
            l7.setComponentZOrder(caption,0);
            Thread.sleep(2500);

            l7.setVisible(false);
            l8.setVisible(true);
            caption.setText(names[6]);
            caption.setForeground(Color.BLACK);
            caption.setBounds(550,40,350,50);
            l8.add(caption);
            l8.setComponentZOrder(caption,0);
            Thread.sleep(2500);

            l8.setVisible(false);
            l9.setVisible(true);
            caption.setText(names[7]);
            caption.setForeground(Color.WHITE);
            caption.setBounds(30,40,350,50);
            l9.add(caption);
            l9.setComponentZOrder(caption,0);
            Thread.sleep(2500);
            
            l9.setVisible(false);
            l10.setVisible(true);
            caption.setText(names[8]);
            caption.setForeground(Color.BLACK);
            caption.setBounds(30,40,350,50);
            l10.add(caption);
            l10.setComponentZOrder(caption,0);
            Thread.sleep(2500);

            l10.setVisible(false);
            l11.setVisible(true);
            caption.setText(names[9]);
            caption.setForeground(Color.BLACK);
            caption.setBounds(550,40,350,50);
            l11.add(caption);
            l11.setComponentZOrder(caption,0);
            Thread.sleep(2500);

            setVisible(false);
        }
        catch(Exception e){e.printStackTrace();}
    }

    Destinations()
    {
        setSize(900,700);
        setLocationRelativeTo(null);
        setLayout(null);

        t = new Thread(this);

        caption = new JLabel();
        caption.setFont(new Font("Dialog",Font.BOLD,30));

        l2 = createLabel("/icons/dest1.jpeg");
        add(l2);

        l3 = createLabel("/icons/dest2.png");
        add(l3); l3.setVisible(false);

        l4 = createLabel("/icons/dest3.jpg");
        add(l4); l4.setVisible(false);

        l5 = createLabel("/icons/dest4.jpg");
        add(l5); l5.setVisible(false);

        l6 = createLabel("/icons/dest5.jpg");
        add(l6); l6.setVisible(false);

        l7 = createLabel("/icons/dest6.jpg");
        add(l7); l7.setVisible(false);

        l8 = createLabel("/icons/dest7.jpeg");
        add(l8); l8.setVisible(false);

        l9 = createLabel("/icons/dest8.jpg");
        add(l9); l9.setVisible(false);

        l10 = createLabel("/icons/dest9.jpg");
        add(l10); l10.setVisible(false);

        l11 = createLabel("/icons/dest10.jpg");
        add(l11); l11.setVisible(false);

        t.start();
        setVisible(true);
    }

    JLabel createLabel(String path)
    {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(900,700,Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(0,0,900,700);
        label.setLayout(null);
        return label;
    }

    public static void main(String args[])
    {
        new Destinations();
    }
}