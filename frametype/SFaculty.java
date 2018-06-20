package frametype;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class SFaculty extends JFrame implements ActionListener
{
	Container c;
	JButton b3,b2;
	JMenuBar mb1,mb2,mb3,mb4;
	public SFaculty()
	{
		c=this.getContentPane();
		c.setLayout(null);


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
		
		b2 = new JButton("Search by Course");
		b2.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setBounds(120,180,350,100);
		b2.setFont(new Font("Modern No. 20", Font.BOLD , 32));
		b2.addActionListener(this);
		c.add(b2);
		
		b3 = new JButton("Search by Id");
		b3.setBackground(Color.orange);
		b3.setForeground(Color.black);
		b3.setBounds(120,300,350,100);
		b3.setFont(new Font("Modern No. 20", Font.BOLD , 32));
		b3.addActionListener(this);
		c.add(b3);
		
		
		c.setBackground(Color.WHITE);
		setSize(600,600);
		setTitle("Search");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b3)
		{
			new SearchFaculty();
		}
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			new SearchFacultycourse();
		}
	}
	public static void main(String arg[])
	{
		//SFaculty hg=new SFaculty();
	}
}
