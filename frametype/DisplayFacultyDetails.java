
package  frametype;

import javax.swing.*;

import java.awt.*;
import java.sql.*;

class DisplayFacultyDetails extends JFrame
{
	Container c;
	JTable t;
	DisplayFacultyDetails()
	{
		c=this.getContentPane();
		c.setLayout(new BorderLayout());
		String heading[]={"Faculty_ID","Faculty_Name","Gender","Qualification","Expert Area","Address","Salary","Mob_no","Email","PAN","DOJ"};
		
		
		String data[][]=new String[50][11];
		int r=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
			PreparedStatement ps=con.prepareStatement("select * from faculty");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				data[r][0]=rs.getString(1);
				data[r][1]=rs.getString(2);
				data[r][2]=rs.getString(3);
				data[r][3]=rs.getString(4);
				data[r][4]=rs.getString(5);
				data[r][5]=rs.getString(6);
				data[r][6]=rs.getString(7);
				data[r][7]=rs.getString(8);
				data[r][8]=rs.getString(9);
				data[r][9]=rs.getString(10);
				data[r][10]=rs.getString(11);
				r++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		t=new JTable(data,heading);
		t.setBackground(Color.WHITE);
		t.setForeground(Color.black);
		JScrollPane jsp=new JScrollPane(t);
		c.add(new JLabel("Details of Faculty in C-DAC"),BorderLayout.NORTH);
		c.add(jsp,BorderLayout.CENTER);
		setTitle("Faculty's Detail");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	public static void main(String arg[])
	{
	//	DisplayFacultyDetails dfd=new DisplayFacultyDetails();
	}
	
}