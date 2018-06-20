package frametype;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Search extends JFrame implements ActionListener
{
	Container c;
	JButton b1,b2,b3;
	JMenuBar mb1,mb2,mb3,mb4;
	//JLabel l3;
	public Search()
	{
		c=this.getContentPane();
		c.setLayout(null);
	/*	
		l3 = new JLabel("SEARCH ");
		l3.setBounds(200, 90, 700, 50);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Century", Font.BOLD ,33));
		c.add(l3);*/
		
		mb1 = new JMenuBar();
		mb1.setBounds(0,0,700,30);
		mb1.setBackground(Color.orange);
		c.add(mb1);
		
		mb2 = new JMenuBar();		
		mb2.setBounds(0,30,30,700);
		mb2.setBackground(Color.orange);
		c.add(mb2);

		mb3 = new JMenuBar();
		mb3.setBounds(0,535,700,30);
		mb3.setBackground(Color.orange);
		c.add(mb3);

		mb4 = new JMenuBar();
		mb4.setBounds(555,30,30,640);
		mb4.setBackground(Color.orange);
		c.add(mb4);

		b1 = new JButton("RECEPTIONIST");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(120,160,350,70);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 32));
		b1.addActionListener(this);
		c.add(b1);
		
		b2 = new JButton("FACULTY");
		b2.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setBounds(120,260,350,70);
		b2.setFont(new Font("Modern No. 20", Font.BOLD , 32));
		b2.addActionListener(this);
		c.add(b2);
		
		b3 = new JButton("STUDENT");
		b3.setBackground(Color.orange);
		b3.setForeground(Color.black);
		b3.setBounds(120,360,350,70);
		b3.setFont(new Font("Modern No. 20", Font.BOLD , 32));
		b3.addActionListener(this);
		c.add(b3);
		
		c.setBackground(Color.WHITE);
		setSize(600,600);
		setTitle("Search");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String args[])
	{
	//Search opj = new Search();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			new Searchreceptionist();
		}
		if(e.getSource()==b2)
		{
			new SFaculty();
		}
		if(e.getSource()==b3)
		{
			new Sstudent();
		}
	}	
}
