package frametype;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
public class Schup extends JFrame implements ActionListener
{
	Container c;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1;
	JTextField t1,t2,t3,t4;
	JComboBox cb1,cb2;
	JMenuBar mb1,mb2,mb3,mb4;
	public Schup()
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

		l3 = new JLabel("UPDATE ENTRY");
		l3.setBounds(200, 80, 700, 60);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Century", Font.BOLD ,33));
		c.add(l3);
		
		l1 = new JLabel("Course");
		l1.setForeground(Color.BLACK);
		l1.setBounds(150,180, 200, 30);
		l1.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l2 = new JLabel("Faculty Name");
		l2.setForeground(Color.black);
		l2.setBounds(150, 240, 200, 30);
		l2.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		
		
		l6= new JLabel("Timing");
		l6.setForeground(Color.black);
		l6.setBounds(150, 300, 200, 30);
		l6.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l7 = new JLabel("to");
		l7.setForeground(Color.black);
		l7.setBounds(440, 300, 30, 30);
		l7.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		cb1= new JComboBox();
		cb1.setBounds(330,180,250,30);
		cb1.setFont(new Font("Segoe Print", Font.BOLD, 16));
		cb1.addActionListener(this);
		c.add(cb1);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
			PreparedStatement ps=con.prepareStatement("select cname from course");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cb1.addItem(rs.getString(1));
			}
			
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
		cb2 = new JComboBox();
		cb2.setBounds(330,240,250,30);
		cb2.addActionListener(this);
		c.add(cb2);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
			PreparedStatement ps=con.prepareStatement("select name from faculty");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cb2.addItem(rs.getString(1));
			}
				con.close();
		}
		catch(Exception e2)
		{
			System.out.println(e2);
		}
		

		t1= new JTextField();
		t1.setBounds(330,300,100,30);
		
		t2 = new JTextField();
		t2.setBounds(480,300,100,30);
		
		b1 = new JButton("Update");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(250,400,200,50);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l6);
		c.add(l7);
		//c.add(l4);
		c.add(b1);
		c.add(t1);
		c.add(t2);
		//c.add(t3);
		//c.add(t4);
		//c.add(cb);
		c.setBackground(Color.WHITE);
		setSize(700,600);
		setTitle("Schedule");
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public static void main(String[] args)
	{
	//	Schup ob = new Schup();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			int f=1;
			if(t1.getText().trim().equals("")&&t2.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "All fields are compulsary");
				f=0;
			}
			if(f!=0)
			{			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("update schdule set timing = ? where facname = ? and course = ?");
				ps.setString(1,t1.getText().trim()+" to "+t2.getText().trim());
				ps.setString(2,(String)cb2.getSelectedItem());
				ps.setString(3,(String)cb1.getSelectedItem());
				int i = ps.executeUpdate();
				
				System.out.println(i+" record updated!");
				JOptionPane.showMessageDialog(this, " record update!!");
				con.close();
			}
			catch(Exception e4)
			{
				System.out.println(e4);
			}
			}
		}							//new NewRegister();
	}
}
