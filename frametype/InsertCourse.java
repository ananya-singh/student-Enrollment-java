package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class InsertCourse extends JFrame implements ActionListener
{
	//admin login insertcourse
	Container c;
	JLabel l1,l2,l3,l5;
	JButton b1,b2,b3;
	JTextField t1,t2,t3;
	
	JMenuBar mb1,mb2,mb3,mb4;
	InsertCourse()
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

		l3 = new JLabel("Insert And Update Courses");
		l3.setBounds(100, 80, 700, 60);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Century", Font.BOLD ,33));
		c.add(l3);
		
		l1 = new JLabel("Course Name");
		l1.setForeground(Color.BLACK);
		l1.setBounds(100,180, 200, 30);
		l1.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l2 = new JLabel("Course fee");
		l2.setForeground(Color.black);
		l2.setBounds(100, 240, 200, 30);
		l2.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l5 = new JLabel("Course Period");
		l5.setForeground(Color.black);
		l5.setBounds(100, 300, 250, 30);
		l5.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		t1 = new JTextField();
		t1.setBounds(400,180,200,30);
		
		t2 = new JTextField();
		t2.setBounds(400,240,200,30);
		
		t3 = new JTextField();
		t3.setBounds(400,300,200,30);
		
		b1 = new JButton("INSERT");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(80,400,160,50);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		
		b2 = new JButton("UPDATE");
		b2.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setBounds(260,400,160,50);
		b2.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b2.addActionListener(this);
		
		b3 = new JButton("DELETE");
		b3.setBackground(Color.orange);
		b3.setForeground(Color.black);
		b3.setBounds(440,400,160,50);
		b3.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b3.addActionListener(this);
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l5);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.setBackground(Color.WHITE);
		setSize(700,600);
		setTitle("Register");
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
/*	public static void main(String arg[])
	{
		InsertCourse kk=new InsertCourse();
	}

*/

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)//insert
		{
			int flag=0;
			if(t1.getText().trim().equals("")||t2.getText().trim().equals("")||t3.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "all fields compulsory!");
				flag=1;
			}
			if(flag!=1)
			{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("insert into course values(?,?,?)");
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				ps.setString(3,t3.getText());
				//ps.setInt(3,25000);
				int i=ps.executeUpdate();
				
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}

			}
			
			
			if(flag!=1)
			{
				System.out.println(" record updated!");
				
				JOptionPane.showMessageDialog(this, "record inserted!!");
			}
		}
		if (e.getSource()==b2)//update
		{
			
			int flag=0;
			if(t1.getText().trim().equals("")||t2.getText().trim().equals("")||t3.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "all fields compulsory!");
				flag=1;
			}
			if(flag!=1)
			{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("update course set cfee=?,cperiod =? where cname= ?");
				ps.setString(1,t2.getText().trim());
				 ps.setString(2,t3.getText().trim());
				 ps.setString(3,t1.getText().trim());
				 
				int i =ps.executeUpdate();
				//JOptionPane.showMessageDialog(this,"record updated");
		        con.close();
			}
			catch(Exception e3)
			{
				System.out.println(e3);
			}
			}
			
			if(flag!=1)
			{
				System.out.println(" record updated!");
				
				JOptionPane.showMessageDialog(this, "record inserted!!");
			}
		}
		if (e.getSource()==b3)//delete
		{ 
			int flag=0;
			if(t1.getText().trim().equals(""))
			{
			flag=1;
				JOptionPane.showMessageDialog(this, "Plzz fill the name");
			}
			if(flag!=1)
			{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("delete from course where cname =?");
				 ps.setString(1,t1.getText().trim());
				int i =ps.executeUpdate();
				JOptionPane.showMessageDialog(this,1+"record deleted");
		        con.close();
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
		}		}
	}	
}


