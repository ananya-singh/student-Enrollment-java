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
public class SearchFaculty extends JFrame implements ActionListener
{
	Container c;
	JMenuBar mb1,mb2,mb3,mb4;
	JLabel l1,L5;
	JTextField t1;
	JButton b1;
	int flag=0;
	public SearchFaculty()
	{
		c = this.getContentPane();
		c.setLayout(null);
		
        mb1 = new JMenuBar();
		mb1.setBounds(0,0,700,30);
		mb1.setBackground(Color.ORANGE);
		c.add(mb1);
		
		mb2 = new JMenuBar();		
		mb2.setBounds(0,30,30,600);
		mb2.setBackground(Color.ORANGE);
		c.add(mb2);

		mb3 = new JMenuBar();
		mb3.setBounds(0,535,700,30);
		mb3.setBackground(Color.ORANGE);
		c.add(mb3);
		
		mb4 = new JMenuBar();
		mb4.setBounds(655,30,30,540);
		mb4.setBackground(Color.ORANGE);
		c.add(mb4);
		
		l1=new JLabel("Enter the Id  to be searched :");
		l1.setBounds(70,100,740,50);
		l1.setFont(new Font("Segoe Print", Font.BOLD , 24));
		l1.setForeground(Color.BLACK);
		c.add(l1);
		
		t1=new JTextField();
		t1.setBounds(450,100,180,55);
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
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		// SearchFaculty stf= new SearchFaculty();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			int id=Integer.parseInt(t1.getText().trim());
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("select * from faculty");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					if(id==rs.getInt(1))
					{
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
				new Searchdispfaculty(id);
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
