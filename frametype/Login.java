package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame implements ActionListener
{
	//receptionist login
	Container c;
	JLabel l1;
	JButton b1,b2,b3;
	//JTextField t1,t2,t3,t4;
	//JComboBox cb;
	JMenuBar mb1,mb2,mb3,mb4;

	public Login(String s)
	{
		c = this.getContentPane();
		c.setLayout(null);
		mb1 = new JMenuBar();
		
		mb1.setBounds(0,0,700,30);
		mb1.setBackground(Color.orange);
		c.add(mb1);
		
		mb2 = new JMenuBar();
		mb2.setBounds(0,30,30,600);
		mb2.setBackground(Color.ORANGE);
		c.add(mb2);
		
		mb3 = new JMenuBar();
		mb3.setBounds(0,535,700,30);
		mb3.setBackground(Color.orange);
		c.add(mb3);
		
		mb4 = new JMenuBar();
		mb4.setBounds(655,30,30,540);
		mb4.setBackground(Color.ORANGE);
		c.add(mb4);
		
		l1 = new JLabel("Hello " + s);
		l1.setBounds(70, 45, 400, 60);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		l1.setBackground(Color.black);
		c.add(l1);
		
		b1 = new JButton("New Student Registration");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(100,140,500,90);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 34));
		b1.setToolTipText("To register details of a new student");
		b1.addActionListener(this);
		
		b2 = new JButton("Courses Available");
		b2.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setBounds(100,250,500,90);
		b2.setFont(new Font("Modern No. 20", Font.BOLD , 34));
		b2.setToolTipText("To see the courses availabe ");
		b2.addActionListener(this);
		
		b3 = new JButton("Schedule");
		b3.setBackground(Color.orange);
		b3.setForeground(Color.black);
		b3.setBounds(100,360,500,90);
		b3.setFont(new Font("Modern No. 20", Font.BOLD , 34));
		b3.setToolTipText("To see the schedule");
		b3.addActionListener(this);
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		setSize(700,600);
		c.setBackground(Color.white);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/*public static void main(String args[])
	{
		Login ll=new Login("Juhi");
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== b1)
		{
			NewRegister obj = new NewRegister();
		}
		if(e.getSource()== b3)
		{
			new Scheduletable();
					}
		if(e.getSource()== b2)
		{
			new Courses();
			
		}	
	}
}
