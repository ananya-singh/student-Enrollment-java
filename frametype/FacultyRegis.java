package frametype;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class FacultyRegis extends JFrame implements ActionListener
{
	//admin login facultyregistration
	Container c;
	int id = 101;
	JMenuBar mb1,mb2,mb3,mb4;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,ln,lr,la;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t15,ta;
	//JTextArea t4;
	JRadioButton r1,r2,r3,r4,r5,r6,r7;
	//JCheckBox c1,c2,c3,c4,c5;
	//JComboBox cb1,cb2,cb3,cb4;
	JButton b1,b2,b3;
	public FacultyRegis()
	{
		c=this.getContentPane();
		c.setLayout(null);
		
		mb1 = new JMenuBar();
		mb1.setBounds(0,0,700,30);
		mb1.setBackground(Color.orange);
		c.add(mb1);
		
		mb2 = new JMenuBar();		
		mb2.setBounds(0,30,30,700);
		mb2.setBackground(Color.orange);
		c.add(mb2);

		mb3 = new JMenuBar();
		mb3.setBounds(0,635,700,30);
		mb3.setBackground(Color.orange);
		c.add(mb3);

		mb4 = new JMenuBar();
		mb4.setBounds(655,30,30,640);
		mb4.setBackground(Color.orange);
		c.add(mb4);

		l1 = new JLabel("Centre Name:");
		l1.setBounds(50,110,100,30);
		c.add(l1);

		ln = new JLabel("Patna");
		ln.setBounds(150,110,200,30);
		c.add(ln);
		
		lr =new JLabel("REGISTER");
		lr.setBounds(250,60,200,40);
		lr.setForeground(Color.black);
		lr.setFont(new Font("Century", Font.BOLD ,34));
		c.add(lr);
		/*l2 = new JLabel("Course:");
		l2.setBounds(50,90,50,30);
		c.add(l2);
		t2 = new JTextField();
		t2.setBounds(150,90,200,30);
		c.add(t2);
		*/
		ta = new JTextField();
		ta.setBounds(150,150,200,30);
		c.add(ta);
		try
		{
			if(id ==101)
			{
				ta.setText(" "+id);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
			PreparedStatement ps=con.prepareStatement("select Faculty_id from faculty");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				id= rs.getInt(1);
			}
			id++;
			ta.setText(" "+id);
			}
		
		}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
		id++;
		
		la = new JLabel("Faculty Id:");
		la.setBounds(50,150,100,30);
		c.add(la);
		
		l3 = new JLabel("Name:");
		l3.setBounds(50,190,100,30);
		c.add(l3);
		
		t3 = new JTextField();
		t3.setBounds(150,190,200,30);
		c.add(t3);
		
		l4 = new JLabel("Gender:");
		l4.setBounds(50,230,100,30);
		c.add(l4);
		
		r1 = new JRadioButton("Female");
		r1.setBounds(150,230,100,30);
		r1.addActionListener(this);
		
		r2 = new JRadioButton("Male");
		r2.setBounds(300,230,100,30);
		r2.addActionListener(this);
		
		c.add(r1);
		c.add(r2);
		ButtonGroup grp = new ButtonGroup();
		grp.add(r1);
		grp.add(r2);
		
		/*l18 = new JLabel("Female:");
		l18.setBounds(5,5,50,30);
		c.add(l18);
		l19 = new JLabel("Male:");
		l19.setBounds(5,5,50,30);
		c.add(l19);
		l5 = new JLabel("Date Of Birth:");
		l5.setBounds(50,250,100,30);
		c.add(l5);
		cb1 = new JComboBox();
		cb1.setBounds(150,250,100,30);
		for(int i = 1;i<=31;i++)
		{
			cb1.addItem(" "+i);
		}
		c.add(cb1);
		cb2 = new JComboBox();
		cb2.setBounds(300,250,100,30);
		for(int i = 1;i<=12;i++)
		{
			cb2.addItem(" "+i);
		}
		cb2.addActionListener(this);
		c.add(cb2);
		cb3 = new JComboBox();
		cb3.setBounds(450,250,100,30);
		for(int i = 1990;i<=2017;i++)
		{
			cb3.addItem(" "+i);
		}
		cb3.addActionListener(this);
		c.add(cb3);
		l4 = new JLabel("Age:");
		l4.setBounds(50,170,100,30);
		c.add(l4);
		t2 = new JTextField();
		t2.setBounds(150,170,200,30);
		c.add(t2);
		l5 = new JLabel("Marital Status:");
		l5.setBounds(50,210,100,30);
		c.add(l5);
		r3 = new JRadioButton("Single");
		r3.setBounds(150,210,100,30);
		r3.addActionListener(this);
		r4 = new JRadioButton("Married");
		r4.setBounds(300,210,100,30);
		r4.addActionListener(this);
		c.add(r3);
		c.add(r4);*/
		l6 = new JLabel("Qualification:");
		l6.setBounds(50,270,100,30);
		c.add(l6);
		t4 = new JTextField();
		t4.setBounds(150,270,200,30);
		c.add(t4);
		/*l7 = new JLabel("Religion:");
		l7.setBounds(50,290,100,30);
		c.add(l7);
		cb4 = new JComboBox();
		cb4.setBounds(150,290,200,30);
		//cb4.setBackground(Color.orange);
		//cb4.setForeground(Color.black);
		cb4.addItem("hindu");
		cb4.addItem("Muslim");
		cb4.addItem("shikh");
		cb4.addItem("christian");
		cb4.addActionListener(this);
		c.add(cb4);
		l17 = new JLabel("Nationality");
		l17.setBounds(50,330,100,30);
		c.add(l17);
		r5 = new JRadioButton("Indian");
		r5.setBounds(150,330,100,30);
		r5.addActionListener(this);
		r6 = new JRadioButton("NRI");
		r6.setBounds(300,330,100,30);
		r6.addActionListener(this);
		r7 = new JRadioButton("Others");
		r7.setBounds(450,330,100,30);
		r7.addActionListener(this);
		c.add(r5);
		c.add(r6);
		c.add(r7);*/
		l7 = new JLabel("Address:");
		l7.setBounds(50,310,100,30);
		c.add(l7);
		t12 = new JTextField();
		t12.setBounds(150,310,500,60);
		//t4.setLineWrap(true);
		c.add(t12);
		/*l9 = new JLabel("pincode");
		l9.setBounds(50,410,100,30);
		c.add(l9);
		t5 = new JTextField();
		t5.setBounds(150,410,150,30);
		c.add(t5);

		l11 = new JLabel("city");
		l11.setBounds(350,410,100,30);
		c.add(l11);
		t7 = new JTextField();
		t7.setBounds(450,410,150,30);
		c.add(t7);*/
		l10 = new JLabel("Expert Area:");
		l10.setBounds(50,380,100,30);
		c.add(l10);
	
		t6 = new JTextField();
		t6.setBounds(150,380,200,30);
		c.add(t6);
		
		l15 = new JLabel("Salary:");
		l15.setBounds(380,380,100,30);
		c.add(l15);

		t11 = new JTextField();
		t11.setBounds(430,380,200,30);
		c.add(t11);
		
		l12 = new JLabel("Mobile No. :");
		l12.setBounds(50,420,100,30);
		c.add(l12);
		
		t8 = new JTextField();
		t8.setBounds(150,420,200,30);
		c.add(t8);
		
		l13 = new JLabel("Email");
		l13.setBounds(380,420,100,30);
		c.add(l13);
		
		t9 = new JTextField();
		t9.setBounds(430,420,200,30);
		c.add(t9);
		
		l14 = new JLabel("Pan NO. :");
		l14.setBounds(50,460,100,30);
		c.add(l14);
		
		t10 = new JTextField();
		t10.setBounds(150,460,200,30);
		c.add(t10);
		
		l16 = new JLabel("Date of Joining:");
		l16.setBounds(50,500,100,30);
		c.add(l16);
		
		t15 = new JTextField();
		t15.setBounds(150,500,200,30);
		c.add(t15);
		
		b1 = new JButton("SUBMIT");
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setBounds(70,560,170,50);
		b1.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b1.addActionListener(this);
		c.add(b1);
		
		b2 = new JButton("UPDATE");
		b2.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setBounds(250,560,170,50);
		b2.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b2.addActionListener(this);
		c.add(b2);
		
		b3 = new JButton("DELETE");
		b3.setBackground(Color.orange);
		b3.setForeground(Color.black);
		b3.setBounds(430,560,170,50);
		b3.setFont(new Font("Modern No. 20", Font.BOLD , 22));
		b3.addActionListener(this);
		c.add(b3);
		
		c.setBackground(Color.WHITE);
		setSize(700,700);
		setTitle("Faculty's Registration");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
	FacultyRegis obj = new FacultyRegis();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			int f[]=new int[8];
			int m=0;
			if(t6.getText().trim().equals("")||t3.getText().trim().equals("")||t4.getText().trim().equals("")||t12.getText().trim().equals("")||t11.getText().trim().equals("")||t9.getText().trim().equals("")||t15.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "These  fields are compulsory!");
				m=1;
				//break;
			}
			if(m!=1)
			{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Manisha","mukul");
				PreparedStatement ps=con.prepareStatement("insert into faculty values(?,?,?,?,?,?,?,?,?,?,?)");
			
			
				ps.setString(1,ta.getText());
				if(t3.getText().trim().matches("[A-Za-z]+"))
				{
					ps.setString(2,t3.getText());
					f[0]=0;
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Plzz Enter Correct Name");
					f[0]=1;
				}
					if(r1.isSelected())
				{
					ps.setString(3,"female");
				}
				if(r2.isSelected())
				{
					ps.setString(3,"male");
				}

				
				//ps.setString(4,t.getNumb));//gender
				//ps.setString(5,(String)cb1.getSelectedItem()+"/"+(String)cb2.getSelectedItem()+"/"+(String)cb3.getSelectedItem());//dob
				ps.setString(4,t4.getText());
				ps.setString(5,t6.getText());
				ps.setString(6,t12.getText());
				ps.setString(7,t11.getText());
				//ps.setString(8,t8.getText());
				//ps.setString(9,t9.getText());
				if(t8.getText().trim().matches("[0-9]+")&&t8.getText().trim().length()==10)
				{
					ps.setString(12,t8.getText());//mob
					f[1]=0;
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Incorrect mobile no.");
					f[1]=1;
				}
				if(t9.getText().trim().matches("[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))
				{
				ps.setString(13,t9.getText());
				f[2]=0;
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Incorrect emailId");
				f[2]=1;
				}
				
				if(t10.getText().trim().matches("[A-Z]{3}[P]{1}[A-Z]{1}[0-9]{4}[A-Z]{1}")&&t10.getText().trim().length()==10&&t3.getText().trim().charAt(0)==(t10.getText().trim()).charAt(4))
				{
					f[3]=0;
					ps.setString(14,t10.getText());//pan
				}
				else
				{
					f[3]=1;
					JOptionPane.showMessageDialog(this,"Incorrect PAN No.");
				}
				ps.setString(11,t15.getText());
				//ps.setString(14,t10.getText());//
				//ps.setString(15,t15.getText());
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
			}
		
		if((t8.getText()).length()==10 &&(t10.getText()).length()==10)
		{							
			f[4]=0;;		
		}
		else
		{
			JOptionPane.showMessageDialog(this,"incorrect adhaar no. or mobile no. or pincode");
			f[4]=1;
		}
		int h=0;
		for(int i=0;i<5;i++)
		if(f[i]==1)
		{
			h=1;
			break;
		}
		if(h!=1&&m!=1)
		{
			JOptionPane.showMessageDialog(this,"Successfully registered");
		}
	}
	if(e.getSource()==b2)
	{
		new AdminfacultyUpdate();
	}
	if(e.getSource()==b3)
	{
		new FacultyDel();
	}
	}
}
