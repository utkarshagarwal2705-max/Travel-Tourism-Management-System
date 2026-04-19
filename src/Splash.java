package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame
{
    Splash()
    {
        setSize(800,400);
        setLocationRelativeTo(null);
        setUndecorated(true);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,400,Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setLayout(null);
        add(image);

        // Project Title
        JLabel text = new JLabel("Travel & Tourism Management System");
        text.setBounds(0,330,800,30);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Dialog", Font.BOLD, 18));
        image.add(text);

        setOpacity(0f);   // Starts fully transparent
        setVisible(true);

        fadeIn();
    }

    void fadeIn()
    {
        try
        {
            for(float i = 0f; i <= 1f; i += 0.05f)
            {
                setOpacity(i);
                Thread.sleep(40);   // Smooth fade
            }

            Thread.sleep(1200);   // Hold briefly

            dispose();
            new Login();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Splash();
    }
}