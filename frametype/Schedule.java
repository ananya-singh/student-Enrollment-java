package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Schedule extends JFrame implements ActionListener
{
	
	Container c;
	String s1 = " ";
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JTextField t1,t2;
	JComboBox cb1,cb2;
	JMenuBar mb1,mb2,mb3,mb4;
	Schedule()
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

		l3 = new JLabel("SHEDULE");
		l3.setBounds(250, 80, 200, 60);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Century", Font.BOLD ,33));
		c.add(l3);

		l1 = new JLabel("Course");
		l1.setForeground(Color.BLACK);
		l1.setBounds(100,180, 200, 30);
		l1.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l2 = new JLabel("Faculty Name");
		l2.setForeground(Color.black);
		l2.setBounds(100, 240, 200, 30);
		l2.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l5 = new JLabel("Days");
		l5.setForeground(Color.black);
		l5.setBounds(100, 300, 200, 30);
		l5.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l6= new JLabel("Timing");
		l6.setForeground(Color.black);
		l6.setBounds(100, 360, 200, 30);
		l6.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l7 = new JLabel("to");
		l7.setForeground(Color.black);
		l7.setBounds(400, 360, 30, 30);
		l7.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		c1 = new JCheckBox("M");
		c1.setForeground(Color.black);
		c1.setBounds(300, 300, 40, 40);
		c1.setFont(new Font("Segoe Print", Font.BOLD, 14));
		c1.addActionListener(this);
		c.add(c1);
		
		c2 = new JCheckBox("T");
		c2.setForeground(Color.black);
		c2.setBounds(340, 300, 40, 40);
		c2.setFont(new Font("Segoe Print", Font.BOLD, 14));
		c2.addActionListener(this);
		c.add(c2);

		c3 = new JCheckBox("W");
		c3.setForeground(Color.black);
		c3.setBounds(380, 300, 40, 40);
		c3.setFont(new Font("Segoe Print", Font.BOLD, 14));
		c3.addActionListener(this);
		c.add(c3);

		c4 = new JCheckBox("T");
		c4.setForeground(Color.black);
		c4.setBounds(420, 300, 40, 40);
		c4.setFont(new Font("Segoe Print", Font.BOLD, 14));
		c4.addActionListener(this);
		c.add(c4);

		c5 = new JCheckBox("F");
		c5.setForeground(Color.black);
		c5.setBounds(460, 300, 40, 40);
		c5.setFont(new Font("Segoe Print", Font.BOLD, 14));
		c5.addActionListener(this);
		c.add(c5);

		c6 = new JCheckBox("S");
		c6.setForeground(Color.black);
		c6.setBounds(500, 300, 40, 40);
		c6.setFont(new Font("Segoe Print", Font.BOLD, 14));
		c6.addActionListener(this);
		c.add(c6);

		c7 = new JCheckBox("S");
		c7.setForeground(Color.black);
		c7.setBounds(540, 300, 40, 40);
		c7.setFont(new Font("Segoe Print", Font.BOLD, 14));
		c7.addActionListener(this);
		c.add(c7);
	
		cb1= new JComboBox();
		cb1.setBounds(290,180,290,30);
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
		cb2.setBounds(290,240,290,30);
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
		
		t1 = new JTextField();
		t1.setBounds(290,360,100,30);
		
		t2 = new JTextField();
		t2.setBounds(440,360,100,30);
	
		b1 = new JButton("Insert");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(150,430,150,50);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		
		b2 = new JButton("Update");
		b2.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setBounds(350,430,150,50);
		b2.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b2.addActionListener(this);
		
		c.add(l1);
		c.add(l2);
		c.add(l6);
		c.add(l5);
		c.add(l7);
		c.add(b2);
		c.add(b1);
		c.add(t1);
		c.add(t2);
		//c.add(t3);
		//c.add(t4);
	//	c.add(cb);
		c.setBackground(Color.WHITE);
		setSize(700,600);
		setTitle("Register");
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args)
	{
	//	Schedule ob = new Schedule();
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==c1)
		{
		if(c1.isSelected())
		{
			s1= s1.concat("mon ");
		}
		}
		
		if(e.getSource()==c2)
		{
		if(c2.isSelected())
		{
			s1= s1.concat("tues ");
		}
		}

		if(e.getSource()==c3)
		{
		if(c3.isSelected())
		{
			s1= s1.concat("wed ");
		}
		}
		
		if(e.getSource()==c4)
		{
		if(c4.isSelected())
		{
			s1= s1.concat("thur ");
		}
		}
		
		if(e.getSource()==c5)
		{
		if(c5.isSelected())
		{
			s1= s1.concat("fri ");
		}
		}
		
		if(e.getSource()==c6)
		{
		if(c6.isSelected())
		{
			s1= s1.concat("sat ");
		}
		}
		
		if(e.getSource()==c7)
		{
		if(c7.isSelected())
		{
			s1= s1.concat("sun ");
		}
		}

		if(e.getSource()==b1)
		{
			int f=0;
			if(t1.getText().trim().equals("")&&t2.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "All fields are compulsary");
				f=1;
			}
			if(f!=1)
			{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("insert into schdule values(?,?,?,?)");
				ps.setString(1,(String)cb1.getSelectedItem());
				ps.setString(2,(String)cb2.getSelectedItem());
				ps.setString(3,t1.getText()+" to " + t2.getText()) ;
				ps.setString(4,s1);

				//ps.setString(4,(String)cb.getSelectedItem());
				//ps.setString(5,t4.getText());
				//ps.setInt(3,25000);
				int i=ps.executeUpdate();
				System.out.println("1 record updated!");
				JOptionPane.showMessageDialog(this,i+ "record updated!!");
				con.close();
			}
			
			catch(Exception e3)
			{
				System.out.println(e3);
			}
			}
		}
		if(e.getSource()==b2)
		{
			new Schup();
		}
	}
}
		
			
		


