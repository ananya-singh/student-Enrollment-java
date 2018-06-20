package frametype;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;
public class FacultyDel extends JFrame implements ActionListener
{
	//admin login newregistration of faulty delete
	Container c;
	JLabel l1,l2;
	JTextField t1;
	JButton b1;
	JMenuBar mb1,mb2,mb3,mb4;
	public FacultyDel()
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
		
		l1=new JLabel("DELETE");
		l1.setBounds(250, 80, 200, 60);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Century", Font.BOLD ,33));
		c.add(l1);
		
		l2 = new JLabel("Enter Faculty Id:");
		l2.setForeground(Color.black);
		l2.setBounds(100, 200, 200, 30);
		l2.setFont(new Font("Segoe Print", Font.BOLD, 22));
		c.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(350,200,200,30);
		c.add(t1);
		
		b1= new JButton("DELETE");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(230,300,200,50);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		c.add(b1);
		
		c.setBackground(Color.WHITE);
		setSize(700,600);
	//	setTitle("Register");
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public static void main(String arg[])
	{
		FacultyDel fd=new FacultyDel();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("delete from faculty where faculty_id =?");
				 ps.setString(1,t1.getText().trim());
				int i =ps.executeUpdate();
				JOptionPane.showMessageDialog(this,1+"record deleted");
		        con.close();
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
		}
	}	
}
