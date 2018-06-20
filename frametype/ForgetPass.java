package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgetPass extends JFrame implements ActionListener
{
	//receptionist forgotpass
	Container c;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1;
	JTextField t1,t2,t3,t4;
	JComboBox cb;
	JMenuBar mb1,mb2,mb3,mb4;
	
	public ForgetPass()
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

		l3 = new JLabel("RETRIVE PASSWORD");
		l3.setBounds(150, 90, 700, 50);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Century", Font.BOLD ,33));
		c.add(l3);

		l1 = new JLabel("Receptionist Name");
		l1.setForeground(Color.black);
		l1.setBounds(100,180, 200, 30);
		l1.setFont(new Font("Segoe Print", Font.BOLD, 20));
		
		l2 = new JLabel("Receptionist Id");
		l2.setForeground(Color.black);
		l2.setBounds(100, 240, 200, 30);
		l2.setFont(new Font("Segoe Print", Font.BOLD, 20));
		

		t1 = new JTextField();
		t1.setBounds(350,180,240,30);
		
		t2 = new JTextField();
		t2.setBounds(350,240,240,30); 
		
		b1 = new JButton("Retrive");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(250,340,200,50);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.setToolTipText("Tap to recover password");
		b1.addActionListener(this);
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		//c.add(l5);
		//c.add(l7);
		//c.add(l4);
		c.add(b1);
		c.add(t1);
		c.add(t2);
		//c.add(t3);
		//c.add(t4);
		//c.add(cb);
		c.setBackground(Color.WHITE);
		setSize(700,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	/*public static void main(String[] args)
	{
		ForgetPass ob = new ForgetPass();
	}
*/
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			String name = t1.getText().trim();
			//String q = ((String)cb.getSelectedItem()).trim();
			String id = t2.getText().trim();
			int flag=0;
			String k=null;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
				PreparedStatement ps=con.prepareStatement("select * from recptionist");
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					if(name.equals(rs.getString(2).trim()))
					{
						if(id.equals(rs.getString(1).trim()) )
						{
						//t2.setText(rs.getString(2));
							flag=1;
							k=rs.getString(5);
							break;
						}
					
					}
				}	
				if(flag==1)
				{
				JOptionPane.showMessageDialog(this,k+ "  was your password!");
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
public static void main(String arg[])
{
//	new ForgetPass();
}
}
