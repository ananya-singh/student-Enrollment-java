package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminForgotPass extends JFrame implements ActionListener
{
	//admin  forgotpass
	Container c;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1;
	JTextField t1,t2,t3,t4;
	JComboBox cb;
	JMenuBar mb1,mb2,mb3,mb4;
	public AdminForgotPass()
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
			
			l3 = new JLabel("ADMIN RETRIVE PASSWORD");
			l3.setBounds(90, 90, 700, 50);
			l3.setForeground(Color.BLACK);
			l3.setFont(new Font("Century", Font.BOLD ,33));
			c.add(l3);
			
			l1 = new JLabel("Username ");
			l1.setForeground(Color.black);
			l1.setBounds(100,180, 200, 30);
			l1.setFont(new Font("Segoe Print", Font.BOLD, 22));
			c.add(l1);
			
			l2 = new JLabel("Security Question");
			l2.setForeground(Color.black);
			l2.setBounds(100, 240, 200, 30);
			l2.setFont(new Font("Segoe Print", Font.BOLD, 22));
			c.add(l2);
			
			l5 = new JLabel("Security Answer");
			l5.setForeground(Color.black);
			l5.setBounds(100, 300, 200, 30);
			l5.setFont(new Font("Segoe Print", Font.BOLD, 22));
			c.add(l5);
			
			t1 = new JTextField();
			t1.setBounds(320,180,280,30);
			c.add(t1);
			
			t2 = new JTextField();
			t2.setBounds(320,300,280,30); 
			c.add(t2);
			
			cb = new JComboBox();
			cb.setBounds(320,240,280,30);
			cb.addItem("Which is your favourite movie ?");
			cb.addItem("Which is your favourite actor ?");
			cb.addItem("Which is your favourite book ?");
			cb.addItem("What is your nickname ?");
			cb.addItem("Which is your favourite colour ?");
			cb.setFont(new Font("Segoe Print", Font.BOLD, 16));
			cb.addActionListener(this);
			c.add(cb);
			
			b1 = new JButton("Retrive");
			b1.setBackground(Color.orange);
			b1.setForeground(Color.black);
			b1.setBounds(240, 400, 220, 50);
			b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
			b1.addActionListener(this);
			c.add(b1);
			
			c.setBackground(Color.WHITE);
			setSize(700,600);
			//setTitle("Register");
			setLocationRelativeTo(null);
			setVisible(true);
		}
	/*	public static void main(String arg[])
		{
			AdminForgotPass ij=new AdminForgotPass();
		}*/
		@Override
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==b1)
			{
				String name = t1.getText().trim();
				String q = ((String)cb.getSelectedItem()).trim();
				String a = t2.getText().trim();
				int flag=0;
				String k=null;
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
					PreparedStatement ps=con.prepareStatement("select * from Adminlog_in");
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						if(name.equals(rs.getString(1).trim()))
						{
							if(q.equals(rs.getString(4).trim())&&a.equals(rs.getString(5).trim()) )
							{
								 k=(rs.getString(2));
								//JOptionPane.showMessageDialog(this,rs.getString(2)+ "  was your password!");
								flag=1;
								break;
							}
						}	
					}	
					if(flag==1)
					{
						JOptionPane.showMessageDialog(this,k+" was your password!","",JOptionPane.INFORMATION_MESSAGE);
						flag=0;
					
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Retry");
					
					}
					con.close();
				}
				catch(Exception e3)
				{
					System.out.println(e3);
				}
			

			}		
	}
}
