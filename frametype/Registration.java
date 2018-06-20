package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Registration extends  JFrame implements ActionListener
{
	//receptionist
	Container c;
	JLabel l1,l2,l5;
	JButton b1,b2,b3;
	JTextField t1,t2;
	JMenuBar mb1,mb2,mb3,mb4;
	Registration()
	{
		c = this.getContentPane();
		c.setLayout(null);
		
		mb1 = new JMenuBar();
		mb1.setBounds(0,0,700,30);
		mb1.setBackground(Color.orange);
		c.add(mb1);
		
		mb2 = new JMenuBar();		
		mb2.setBounds(0,30,30,600);
		mb2.setBackground(Color.orange);
		c.add(mb2);

		mb3 = new JMenuBar();
		mb3.setBounds(0,535,700,30);
		mb3.setBackground(Color.orange);
		c.add(mb3);

		mb4 = new JMenuBar();
		mb4.setBounds(655,30,30,540);
		mb4.setBackground(Color.orange);
		c.add(mb4);

		l1 = new JLabel("Username");
		l1.setForeground(Color.black);
		l1.setBounds(150,200, 200, 30);
		l1.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l2 = new JLabel("Password");
		l2.setForeground(Color.black);
		l2.setBounds(150, 260, 200, 30);
		l2.setFont(new Font("Segoe Print", Font.BOLD, 22));
		/*b3 = new JButton("new registration");
		b3.setBounds(100, 470, 200, 30);
		b3.setForeground(Color.BLACK);
		b3.setBackground(Color.ORANGE);
		b3.setFont(new Font("Forte", Font.BOLD , 20));
		b3.addActionListener(this);*/
		b2 = new JButton("Forgot Password");
		b2.setBounds(250, 430, 200, 30);
		b2.setForeground(Color.BLACK);
		b2.setBackground(Color.ORANGE);
		b2.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b2.addActionListener(this);
		
		l5 = new JLabel("LOGIN");
		l5.setBounds(250, 100, 200, 40);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Century", Font.BOLD ,40));
		c.add(l5);
		
		t1 = new JTextField();
		t1.setBounds(300,200,200,30);
		
		t2 = new JTextField();
		t2.setBounds(300,260,200,30);
		
		b1 = new JButton("Login");
		b1.setBackground(Color.ORANGE);
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 26));
		b1.setBounds(250,350,200,50);
		b1.addActionListener(this);
		
		c.add(l1);
		c.add(l2);
		c.add(b2);
		//c.add(b3);
		c.add(b1);
		c.add(t1);
		c.add(t2);
		
		c.setBackground(Color.WHITE);
		setSize(700,600);
//		setTitle("Register");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/*public static void main(String arg[])
	{
		Registration qw=new Registration();
	}
	*/
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()== b1)
		{
			String id = t1.getText().trim();
			String pass = t2.getText().trim();
			int flag=0;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("select * from recptionist");
				ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(2).trim());
				if((id.equals(rs.getString(2).trim())) &&( pass.equals(rs.getString(5).trim())))
				{
					//l3.setText(rs.getString(2));	
						flag=1;
						break;
				}
			}	
			if(flag==1)
			{
				new Login(t1.getText());
				flag=0;			
			}
			else
			{	
				JOptionPane.showMessageDialog(this, "Incorrect username or password!! Try again");
				flag=0;
					
			}		
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		}

		if(e.getSource()== b2)
		{
			ForgetPass ob  = new ForgetPass();
		}
		/*if(e.getSource()==b3)
		{
			Signup  mnb = new Signup();
		}*/	
	}
}