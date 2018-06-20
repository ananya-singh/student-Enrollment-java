package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AdminNewReg extends JFrame implements ActionListener
{
	//admin newregistration
	//int flag = 0;
	Container c;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1;
	JTextField t1,t2,t3,t4;
	JComboBox cb;
	JMenuBar mb1,mb2,mb3,mb4;
	public AdminNewReg()
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

		l3 = new JLabel("ADMIN SIGNUP");
		l3.setBounds(200, 80, 700, 60);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Century", Font.BOLD ,33));
		c.add(l3);

		l1 = new JLabel("Username:");
		l1.setForeground(Color.BLACK);
		l1.setBounds(100,160, 200, 30);
		l1.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l2 = new JLabel("Password:");
		l2.setForeground(Color.black);
		l2.setBounds(100, 210, 200, 30);
		l2.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l5 = new JLabel("Confirm Password:");
		l5.setForeground(Color.black);
		l5.setBounds(100, 260, 250, 30);
		l5.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l6= new JLabel("Security Question:");
		l6.setForeground(Color.black);
		l6.setBounds(100, 310, 250, 30);
		l6.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l7 = new JLabel("Security Answer:");
		l7.setForeground(Color.black);
		l7.setBounds(100, 360, 250, 30);
		l7.setFont(new Font("Segoe Print", Font.BOLD, 22));

		t1 = new JTextField();
		t1.setBounds(320,160,280,30);
		
		t2 = new JTextField();
		t2.setBounds(320,210,280,30);
		
		t3 = new JTextField();
		t3.setBounds(320,260,280,30);
		
		t4 = new JTextField();
		t4.setBounds(320,360,280,30);
		
		cb = new JComboBox();
		cb.setBounds(320,310,280,30);
		cb.addItem("Which is your favourite movie ?");
		cb.addItem("Which is your favourite actor ?");
		cb.addItem("Which is your favourite book ?");
		cb.addItem("What is your nickname ?");
		cb.addItem("Which is your favourite colour ?");
		cb.setFont(new Font("Segoe Print", Font.BOLD, 16));
		cb.addActionListener(this);
		
		b1 = new JButton("Next");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(250,430,200,40);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		
		c.add(l1);
		c.add(l2);
		c.add(l6);
		c.add(l5);
		c.add(l7);
		//c.add(l4);
		c.add(b1);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.add(t4);
		c.add(cb);
		
		c.setBackground(Color.WHITE);
		setSize(700,600);
		//setTitle("Register");
		setLocationRelativeTo(null);
		setVisible(true);
	}
/*	public static void main(String arg[])
	{
		AdminNewReg mn=new AdminNewReg();
	}*/
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("insert into Adminlog_in values(?,?,?,?,?)");
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				ps.setString(3,t3.getText());
				ps.setString(4,(String)cb.getSelectedItem());
				ps.setString(5,t4.getText());
				//ps.setInt(3,25000);
				int i=ps.executeUpdate();
				System.out.println(i+" Registered!");
				
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			if(t1.getText().trim().equals("")||t2.getText().trim().equals("")||t3.getText().trim().equals("")||t4.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "all fields compulsory!");
				//break;
			}
			else
			{
				if((t2.getText()).equals(t3.getText()))
				{							
					//JOptionPane.showMessageDialog(this,"Successfully Signed in");	
					JOptionPane.showMessageDialog(this, "Registered!!");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Incorrect Password! Retry!");
					//break;
				}	
			}
				//int i=ps.executeUpdate();
				//System.out.println(i+" record updated!");
				//JOptionPane.showMessageDialog(this,i+ "record updated!!");
				
				//con.close();
		}
			/*catch(Exception e1)
			{
				System.out.println(e1);
			}*/
			//new NewRegister();
	}		
}