package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable
{
    private Thread t;
    private JProgressBar bar;
    private String username;
    
    @Override
    public void run()
    {
        try
            {
                for(int i=1;i<=101;i++)
                {
                    int max = bar.getMaximum(); //100
                    int value = bar.getValue();
                    
                    if(value<max) //101<100
                    {bar.setValue(bar.getValue()+1);}
                    else
                    {
                        setVisible(false);
                        new Dashboard(username);
                        break;
                    }
                    Thread.sleep(10);
                }
            }catch(Exception e){e.printStackTrace();}
    }
    
    Loading(String username)
    {
        this.username = username;
        t = new Thread(this);
        
        setBounds(500,200,746,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel & Tourism Management System");
        text.setBounds(0,20,746,50);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setForeground(Color.RED);
        text.setFont(new Font("Dialog",Font.BOLD,35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(223,120,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(0,160,746,30);
        loading.setHorizontalAlignment(JLabel.CENTER);
        loading.setForeground(Color.BLUE);
        loading.setFont(new Font("Dialog", Font.BOLD, 16));
        add(loading);

        JLabel lblusername = new JLabel("Welcome "+username+"!");
        lblusername.setBounds(0,300,746,40);
        lblusername.setHorizontalAlignment(JLabel.CENTER);
        lblusername.setFont(new Font("Dialog", Font.BOLD, 18));
        add(lblusername);
        
        t.start();
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new Loading("");
    }   
}
