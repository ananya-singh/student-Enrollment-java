package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class CompleteForm extends JFrame implements ActionListener
{
	Container c;
//main form
	
	
	JLabel l1,l2,l3;
	JMenuBar mb,mb1,mb2,mb3,mb4,mb5,mb6,mb7,mb8,mb9,mb10,mb11,mb12,mb13,mb14,mb15,mb16;
	JMenu m1,m2,m3,m4;
	JMenuItem exit,r1,r2,r3;
	public void clock()
	{
		Thread clock =new Thread()
		{
			public void run()
			{
				try {
					for(;;){
						
						Calendar cal=new GregorianCalendar();
						int day=cal.get(Calendar.DAY_OF_MONTH);
						int month=cal.get(Calendar.MONTH);
						int year=cal.get(Calendar.YEAR);
						int sec=cal.get(Calendar.SECOND);
						int minute=cal.get(Calendar.MINUTE);
						int hour=cal.get(Calendar.HOUR_OF_DAY);
						int t=cal.get(Calendar.AM_PM);
						l2.setText("DATE :"+day+"/"+(month+1)+"/"+year);
						l3.setText("TIME :"+hour+":"+minute+":"+sec);
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		clock.start();
		}
	public CompleteForm()
	{
		c=this.getContentPane();
		c.setLayout(null);
		
		l1=new JLabel("...C-DAC...");
		l1.setBounds(320, 270, 900, 200);
		l1.setFont(new Font("algerian", Font.ITALIC, 150));
		l1.setForeground(Color.white);
	h	c.add(l1);
		
		l2=new JLabel();
		l2.setBounds(550, 435, 900, 200);
		l2.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		l2.setForeground(Color.white);
		c.add(l2);
		
		l3=new JLabel();
		l3.setBounds(550, 465, 900, 200);
		l3.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		l3.setForeground(Color.white);
		c.add(l3);
		
		mb = new JMenuBar();
		mb.setBounds(0, 10, 1380,50);
		//mb.setBounds(0, 10, 25,800);
		mb.setBackground(Color.ORANGE);
		c.add(mb);
		
		mb1=new JMenuBar();
		mb1.setBounds(20, 80, 10, 600);
		mb1.setBackground(Color.white);
		c.add(mb1);
		
		mb3=new JMenuBar();
		mb3.setBounds(20, 80, 1320, 10);
		mb3.setBackground(Color.white);
		c.add(mb3);
		
		mb4=new JMenuBar();
		mb4.setBounds(20, 680, 1320, 10);
		mb4.setBackground(Color.white);
		c.add(mb4);
		
		mb2=new JMenuBar();
		mb2.setBounds(1330, 80, 10, 600);
		mb2.setBackground(Color.white);
		c.add(mb2);
		
		mb5=new JMenuBar();
		mb5.setBounds(50, 110, 10, 540);
		mb5.setBackground(Color.white);
		c.add(mb5);
		
		mb6=new JMenuBar();
		mb6.setBounds(50, 110, 1260, 10);
		mb6.setBackground(Color.white);
		c.add(mb6);
		
		mb7=new JMenuBar();
		mb7.setBounds(50, 650, 1260, 10);
		mb7.setBackground(Color.white);
		c.add(mb7);
		
		mb8=new JMenuBar();
		mb8.setBounds(1300, 110, 10, 540);
		mb8.setBackground(Color.white);
		c.add(mb8);
		
		mb9=new JMenuBar();
		mb9.setBounds(80, 110, 10, 540);
		mb9.setBackground(Color.white);
		c.add(mb9);
		
		mb10=new JMenuBar();
		mb10.setBounds(50, 140, 1260, 10);
		mb10.setBackground(Color.white);
		c.add(mb10);
		
		mb11=new JMenuBar();
		mb11.setBounds(50, 620, 1260, 10);
		mb11.setBackground(Color.white);
		c.add(mb11);
		
		mb12=new JMenuBar();
		mb12.setBounds(1270, 110, 10, 540);
		mb12.setBackground(Color.white);
		c.add(mb12);
		
		mb13=new JMenuBar();
		mb13.setBounds(110, 140, 10, 480);
		mb13.setBackground(Color.white);
		c.add(mb13);
		
		mb14=new JMenuBar();
		mb14.setBounds(80, 170, 1200, 10);
		mb14.setBackground(Color.white);
		c.add(mb14);
		
		mb15=new JMenuBar();
		mb15.setBounds(80, 590, 1200, 10);
		mb15.setBackground(Color.white);
		c.add(mb15);
		
		mb16=new JMenuBar();
		mb16.setBounds(1240, 140, 10, 480);
		mb16.setBackground(Color.white);
		c.add(mb16);
		
		m1 = new JMenu("     ADMIN LOGIN      ");
		m1.setFont(new Font("Century", Font.BOLD, 24));
		m1.setForeground(Color.black);
		mb.add(m1);
		
		m2 = new JMenu("   RECEPTIONIST LOGIN   ");
		m2.setFont(new Font("Century", Font.BOLD, 24));
		m2.setForeground(Color.black);
		mb.add(m2);
		
		m3 = new JMenu("    ABOUT    ");
		m3.setFont(new Font("Century", Font.BOLD, 24));
		m3.setForeground(Color.black);
		mb.add(m3);
		
		m4 = new JMenu("     HELP      ");
		m4.setFont(new Font("Century", Font.BOLD, 24));
		m4.setForeground(Color.black);
		mb.add(m4);
		
		exit = new JMenuItem("Exit");
		exit.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		exit.addActionListener(this);
		m4.add(exit);
		
		r2 = new JMenuItem("Admin");
		r2.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		r2.addActionListener(this);
		m1.add(r2);
        
		r3 = new JMenuItem("About Us");
		r3.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		r3.addActionListener(this);
		m3.add(r3);
        
		r1 = new JMenuItem("Receptionist");
        r1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		r1.addActionListener(this);
		m2.add(r1);
		
		c.setBackground(Color.BLACK);
		setUndecorated(false);
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);
		clock();
	}
	public static void main(String[] args) 
	{
		CompleteForm ob = new CompleteForm();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		if(e.getSource()== r1)
		{
		 new Registration();
		}
		if(e.getSource()== r2)
		{
		 new Adminsignin();
		}
		if(e.getSource()== r3)
		{
		 new Aboutus();
		}	
	}
}