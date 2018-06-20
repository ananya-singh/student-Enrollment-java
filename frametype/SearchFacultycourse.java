package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchFacultycourse extends JFrame implements ActionListener
{
	Container c;
	int count=0;
	int flag =0;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1;
	JTextField t1,t2,t3,t4;
	JComboBox cb;
	JMenuBar mb1,mb2,mb3,mb4;
	String id;
	public SearchFacultycourse()
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
		
		l5 = new JLabel("SEARCH BY COURSE");
		l5.setBounds(130, 90, 700, 50);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Century", Font.BOLD ,34));
		c.add(l5);
		
		
		l1=new JLabel("Enter Course:");
		l1.setBounds(130,190,740,50);
		l1.setFont(new Font("Segoe Print", Font.BOLD , 24));
		l1.setForeground(Color.BLACK);
		c.add(l1);
		
		t1=new JTextField();
		t1.setBounds(350,190,180,55);
		t1.addActionListener(this);
		c.add(t1);
		
		b1=new JButton("SHOW");
		b1.setBounds(200,310,300,55);
		b1.setBackground(Color.ORANGE);
		b1.setForeground(Color.black);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		c.add(b1);
		
		
		
		c.setBackground(Color.WHITE);
		setSize(700,600);
		setTitle("Search");
		setLocationRelativeTo(null);
		setVisible(true);
		


	}
	public static void main(String[] args)
	{
		//SearchFacultycourse fgt=new SearchFacultycourse();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			//System.out.println("he");
			id=(t1.getText().trim());
			//System.out.println("hell");
			try
			{
				//System.out.println("hello");

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("select cname from course ");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					//System.out.println("llo");
					if(id.equals(rs.getString(1).trim()))
					{
						
						//System.out.println("hhhh");
						//System.out.println(id);
						//System.out.println(rs.getString(1));
						flag=1;
						
						break;						
					}
					
				}
				con.close();
				
				
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			
			if(flag==1)
			{
				new SearchFacultycoursedisp(id);
				flag=0;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"User not found !");
				flag=0;
			}
		}
		// TODO Auto-generated method stub
	}
		
}



