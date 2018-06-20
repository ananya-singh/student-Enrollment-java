package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminLogedin extends JFrame implements ActionListener
{
	//admin login
	Container c;
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
	JMenuBar mb1,mb2,mb3,mb4;

	 AdminLogedin()
	{
		c = this.getContentPane();
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
		mb3.setBounds(0,595,710,30);
		mb3.setBackground(Color.orange);
		c.add(mb3);
		
		mb4 = new JMenuBar();
		mb4.setBounds(655,30,30,640);
		mb4.setBackground(Color.orange);
		c.add(mb4);
		/*l1 = new JLabel("HELLO " + );
		l1.setBounds(150, 70, 400, 60);
		l1.setFont(new Font("GILL SANS", Font.BOLD ,40));
		l1.setBackground(Color.black);
		
		c.add(l1);*/
		b4 = new JButton("NEW RECEPTIONIST REGISTRATION");
		b4.setBackground(Color.orange);
		b4.setForeground(Color.black);
		b4.setBounds(50,40,590,45);
		b4.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b4.addActionListener(this);

		b1 = new JButton("INSERT AND UPDATE COURSE");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(50,150,590,45);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		
		b2 = new JButton("SEARCH");
		b2.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setBounds(50,260,590,45);
		b2.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b2.addActionListener(this);
		
		b3 = new JButton("DISPLAY FACULTY");
		b3.setBackground(Color.orange);
		b3.setForeground(Color.black);
		b3.setBounds(50,315,590,45);
		b3.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b3.addActionListener(this);
		
		b5 = new JButton("INSERT AND UPDATE SCHEDULE");
		b5.setBackground(Color.orange);
		b5.setForeground(Color.black);
		b5.setBounds(50,205,590,45);
		b5.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b5.addActionListener(this);
		
		b6 = new JButton("DISPLAY OF SCHEDULE");
		b6.setBackground(Color.orange);
		b6.setForeground(Color.black);
		b6.setBounds(50,425,590,45);
		b6.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b6.addActionListener(this);
		
		b7 = new JButton("DISPLAY OF COURSE");
		b7.setBackground(Color.orange);
		b7.setForeground(Color.black);
		b7.setBounds(50,370,590,45);
		b7.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b7.addActionListener(this);
		
		b8 = new JButton("DISPLAY OF STUDENT DETAILS");
		b8.setBackground(Color.orange);
		b8.setForeground(Color.black);
		b8.setBounds(50,480,590,45);
		b8.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b8.addActionListener(this);
		
		b9 = new JButton("REGISTRATION OF FACULTY");
		b9.setBackground(Color.orange);
		b9.setForeground(Color.black);
		b9.setBounds(50,95,590,45);
		b9.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b9.addActionListener(this);
		
		b10 = new JButton("DISPLAY OF RECEPTIONIST");
		b10.setBackground(Color.orange);
		b10.setForeground(Color.black);
		b10.setBounds(50,535,590,45);
		b10.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b10.addActionListener(this);
		
		b11 = new JButton("FACULTY AND COURSE");
		b11.setBackground(Color.orange);
		b11.setForeground(Color.black);
		b11.setBounds(50,590,590,45);
		b11.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b11.addActionListener(this);
		
		//c.add(b11);
		c.add(b10);
		c.add(b9);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b5);
		c.add(b6);
		c.add(b7);		
		c.add(b8);
		setSize(700,660);
		c.setBackground(Color.white);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String args[])
	{
		AdminLogedin oj = new AdminLogedin();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== b4)
		{
			Signup obj = new Signup();
		}
		if(e.getSource()== b6)
		{
			new Scheduletable();
}
		if(e.getSource()== b7)
		{
			new DisplayCourse();
			
		}
		if(e.getSource()==b1)
		{
			new InsertCourse();
		}
		
		 if(e.getSource()==b2)
		{
			new Search();
		}
		if(e.getSource()==b3)
		{
			new DisplayFacultyDetails();
		}
		if(e.getSource()==b5)
		{
			new Schedule();
		}
		if(e.getSource()==b8)
		{
			new DisplayStudentDetails();
		}
		if(e.getSource()==b9)
		{
			new FacultyRegis();
		}
		if(e.getSource()==b10)
		{
			new DisplayrecepDetails();
		}
		if(e.getSource()==b11)
		{
		//	new Facultyandcourse();
		}
	}

}

