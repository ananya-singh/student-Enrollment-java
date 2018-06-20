package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Signup extends JFrame implements ActionListener
{
//admin login newreceptionist	
	Container c;
	int id=101;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,ta,l10,l12,l11,l13,l15,lr;
	//JTextArea t12;
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t10,t11,t12;
	JRadioButton r1,r2;
	JComboBox cb;
	JMenuBar mb1,mb2,mb3,mb4;
	public Signup()
	{
		
		c = this.getContentPane();
		c.setLayout(null);
		
        mb1 = new JMenuBar();
		mb1.setBounds(0,0,700,30);
		mb1.setBackground(Color.orange);
		c.add(mb1);
		
		mb2 = new JMenuBar();		
		mb2.setBounds(0,30,30,640);
		mb2.setBackground(Color.orange);
		c.add(mb2);
	
		mb3 = new JMenuBar();
		mb3.setBounds(0,635,700,30);
		mb3.setBackground(Color.orange);
		c.add(mb3);

		mb4 = new JMenuBar();
		mb4.setBounds(655,30,30,630);
		mb4.setBackground(Color.orange);
		c.add(mb4);


		l1 = new JLabel("Receptionist Id");
		l1.setBounds(50,50,100,30);
		c.add(l1);
	
		t1 = new JTextField();
		t1.setBounds(150,50,200,30);
		c.add(t1);
		try
		{
			if(id ==101)
			{
				//t1.setText(" "+id);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
			PreparedStatement ps=con.prepareStatement("select rid from recptionist");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				id= Integer.parseInt(rs.getString(1).trim());
			}
			id++;
			t1.setText(" "+id);
			}
		
		}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
		id++;
		
		l2 = new JLabel("Name");
		l2.setBounds(50,90,50,30);
		c.add(l2);
		
		t2 = new JTextField();
		t2.setBounds(150,90,200,30);
		c.add(t2);
	
		l4 = new JLabel("Gender:");
		l4.setBounds(50,130,100,30);
		c.add(l4);
		
		r1 = new JRadioButton("Female");
		r1.setBounds(150,130,100,30);
		r1.addActionListener(this);
		r2 = new JRadioButton("Male");
		r2.setBounds(300,130,100,30);
		r2.addActionListener(this);
		
		c.add(r1);
		c.add(r2);
		ButtonGroup grp = new ButtonGroup();
		grp.add(r1);
		grp.add(r2);
	
		l3 = new JLabel("Qualification");
		l3.setBounds(50,170,100,30);
		c.add(l3);

		t3 = new JTextField();
		t3.setBounds(150,170,200,30);
		c.add(t3);
		
		l4 = new JLabel("Password");
		l4.setBounds(50,210,100,30);
		c.add(l4);

		t4 = new JTextField();
		t4.setBounds(150,210,200,30);
		c.add(t4);
						
		
		l7 = new JLabel("Address");
		l7.setBounds(50,250,100,30);
		c.add(l7);
		
		t12 = new JTextField();
		t12.setBounds(150,250,400,70);
		//t12.setLineWrap(true);
		c.add(t12);
		
		l9 = new JLabel("Salary");
		l9.setBounds(50,330,100,30);
		c.add(l9);
		
		t5 = new JTextField();
		t5.setBounds(150,330,200,30);
		c.add(t5);

		l11 = new JLabel("Mobile No.");
		l11.setBounds(50,370,100,30);
		c.add(l11);
		
		t7 = new JTextField();
		t7.setBounds(150,370,200,30);
		c.add(t7);
		
		l10 = new JLabel("Email");
		l10.setBounds(380,370,100,30);
		c.add(l10);

		t6 = new JTextField();
		t6.setBounds(430,370,200,30);
		c.add(t6);
		
		
		l15 = new JLabel("PAN");
		l15.setBounds(50,410,100,30);
		c.add(l15);

		t11 = new JTextField();
		t11.setBounds(150,410,200,30);
		c.add(t11);
		
		l12 = new JLabel("D.O.J");
		l12.setBounds(380,410,100,30);
		c.add(l12);

		t8 = new JTextField();
		t8.setBounds(430,410,200,30);
		c.add(t8);
		
		b1 = new JButton("SUBMIT");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(70,510,170,50);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		c.add(b1);
		
		b2 = new JButton("UPDATE");
		b2.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setBounds(250,510,170,50);
		b2.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b2.addActionListener(this);
		c.add(b2);
		
		b3 = new JButton("DELETE");
		b3.setBackground(Color.orange);
		b3.setForeground(Color.black);
		b3.setBounds(430,510,170,50);
		b3.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b3.addActionListener(this);
		c.add(b3);

		c.setBackground(Color.WHITE);
		setSize(700,700);
		setTitle("Receptionist's Details");
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	public static void main(String args[])
	{
	Signup obj = new Signup();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Manisha","mukul");
				PreparedStatement ps=con.prepareStatement("insert into recptionist values(?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,t1.getText().trim());
				if(t2.getText().trim().matches("[A-Za-z]+"))
				{
					ps.setString(2,t2.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Plzz Enter Correct Name");
				}
				
				if(r1.isSelected())
				{
					ps.setString(3,"Female");
				}
				if(r2.isSelected())
				{
					ps.setString(3,"Male");
				}
				ps.setString(4,t3.getText().trim());
				ps.setString(5,t4.getText().trim());

				
				//ps.setString(4,t.getNumb));//gender
				//ps.setString(6,(String)cb1.getSelectedItem()+"/"+(String)cb2.getSelectedItem()+"/"+(String)cb3.getSelectedItem());//dob
				ps.setString(6,t12.getText().trim());
				ps.setString(7,t5.getText().trim());
				//ps.setString(8,t7.getText().trim());//pin
				//ps.setString(9,t6.getText().trim());
				if(t7.getText().trim().matches("[0-9]+")&&t7.getText().trim().length()==10)
				{
					ps.setString(8,t7.getText());//mob
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Incorrect mobile no.");
				}
				if(t6.getText().trim().matches("[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))
				{
					ps.setString(9,t6.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Incorrect emailId");
				}
				//ps.setString(10,t11.getText().trim());
				if(t11.getText().trim().matches("[A-Z]{3}[P]{1}[A-Z]{1}[0-9]{4}[A-Z]{1}")&&t11.getText().trim().length()==10&&t2.getText().trim().charAt(0)==(t11.getText().trim()).charAt(4))
				{
					ps.setString(10,t11.getText());//pan
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Incorrect PAN No.");
				}
				ps.setString(11,t8.getText().trim());
				
				//ps.setInt(3,25000);
				int i=ps.executeUpdate();
				System.out.println(i+" record updated!");
				//JOptionPane.showMessageDialog(this,i+ "record updated!!");
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			if(t2.getText().trim().equals("")||t1.getText().trim().equals("")||t11.getText().trim().equals("")||t12.getText().trim().equals("")||t3.getText().trim().equals("")||t4.getText().trim().equals("")||t5.getText().trim().equals("")||t8.getText().trim().equals("")||t6.getText().trim().equals("")||t7.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "These  fields are compulsory!");
				//break;
			}
			else
			{
				if((t7.getText()).length()==10 &&(t11.getText()).length()==10)
				{
										
					JOptionPane.showMessageDialog(this,"Successfully registered");
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"incorrect adhaar no. or mobile no.");

				}
			}
		}

				if(e.getSource()== b2)
				{
					new SignUpdate();	
				}
				if(e.getSource()== b3)
				{
					new SignDelete();
				}


		}
		
	}
	
	