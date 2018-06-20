package frametype;



import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Courses extends JFrame
{
	//receptionist login courses
	Container c;
	JTable t;
	//JMenuBar mb1,mb2,mb3,mb4;

	Courses()
	{
		c=this.getContentPane();
		c.setLayout(new BorderLayout());
				
		String heading[]={"Courses"};
		//int sn = 1;
		String data[][]=new String[17][1];
		int r=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
			PreparedStatement ps=con.prepareStatement("select * from Course");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				data[r][0]=rs.getString(1);
				//data[r][1]=rs.getString(2);
				//data[r][2]=rs.getString(3);
				//data[r][3]=rs.getString(4);
				r++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		t=new JTable(data,heading);
		t.setFont(new Font("Times New Roman", Font.BOLD ,20));
		//t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//t.getColumnModel().getColumn(0).setPreferredWidth(100);
		//t.getColumnModel().getColumn(1).setPreferredWidth(100);
		//t.getColumnModel().getColumn(1).setPreferredWidth(100);
		//t.getColumnModel().getColumn(1).setPreferredWidth(100);
		t.setRowHeight(30);
		//t.setColumnWidth(30);
		//t.setColumnWidths(100,30,200,60);
		t.setBackground(Color.white);
		t.setForeground(Color.black);
		JScrollPane jsp=new JScrollPane(t);
		c.add(new JLabel("Courses available in C-DAC"),BorderLayout.NORTH);
		c.add(jsp,BorderLayout.CENTER);
		setTitle("Recruiters");
		setSize(700,600);
		setLocationRelativeTo(null);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	/*public static void main(String arg[])
	{
		new Courses();
	}
	*/
}
