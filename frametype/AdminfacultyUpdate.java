package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AdminfacultyUpdate extends JFrame implements ActionListener
{
	//admin login newfacultyregistration update
	//int flag = 0;
	Container c;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1;
	JTextField t1,t2,t3,t4;
	JComboBox cb;
	JMenuBar mb1,mb2,mb3,mb4;
	public AdminfacultyUpdate()
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
		
		l1 = new JLabel("Faculty Id:");
		l1.setForeground(Color.BLACK);
		l1.setBounds(150,180, 200, 30);
		l1.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l5 = new JLabel("Enter Value:");
		l5.setForeground(Color.BLACK);
		l5.setBounds(150,300, 200, 30);
		l5.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		l2= new JLabel("Field to Update:");
		l2.setForeground(Color.black);
		l2.setBounds(150, 240, 200, 30);
		l2.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		t1 = new JTextField();
		t1.setBounds(400,180,200,30);
		t2=new JTextField();
		t2.setBounds(400, 300, 200, 30);;
		
		cb = new JComboBox();
		cb.setBounds(400,240,200,30);
		cb.addItem("Qualification");
		cb.addItem("Expert Area");
		cb.addItem("Address");
		cb.addItem("Salary");
		cb.addItem("Mobile");
		cb.addItem("Email");
		cb.setFont(new Font("Segoe Print", Font.BOLD, 16));
		cb.addActionListener(this);
		
		b1 = new JButton("Update");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(250,380,200,50);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l5);
		//c.add(l7);
		//c.add(l4);
		c.add(b1);
		c.add(t1);
		c.add(t2);
		//c.add(t3);
		//c.add(t4);
		c.add(cb);
		c.setBackground(Color.WHITE);
		setSize(700,600);
		setTitle("Update");
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public static void main(String[] args)
	{
		AdminfacultyUpdate ob = new AdminfacultyUpdate();

	}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
	{
					
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
			PreparedStatement ps=con.prepareStatement("update faculty set "+ cb.getSelectedItem()+ " = ? where faculty_id = ? ");
			ps.setString(1,t2.getText().trim());
			ps.setString(2,t1.getText().trim());
			//ps.setString(3, t1.getText().trim());
			int i = ps.executeUpdate();
			
			JOptionPane.showMessageDialog(this,i+ " record update!!");
			con.close();
		}
		catch(Exception e4)
		{
			System.out.println(e4);
		}	
		}
		
		
			
						//new NewRegister();
	}
	
	
}





