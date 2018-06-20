
package  frametype;

import javax.swing.*;

import java.awt.*;
import java.sql.*;

class DisplayCourse extends JFrame
{
	Container c;
	JTable t;
	DisplayCourse()
	{
		c=this.getContentPane();
		c.setLayout(new BorderLayout());
		String heading[]={"Course_Name","Course_Fee","Course_Period"};
		
		
		String data[][]=new String[40][4];
		int r=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
			PreparedStatement ps=con.prepareStatement("select * from course");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				data[r][0]=rs.getString(1);
				data[r][1]=rs.getString(2);
				data[r][2]=rs.getString(3);
				r++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		t=new JTable(data,heading);
		t.setBackground(Color.white);
		t.setForeground(Color.black);
		JScrollPane jsp=new JScrollPane(t);
		c.add(new JLabel("SCHEDULE OF CLASSES"),BorderLayout.NORTH);
		c.add(jsp,BorderLayout.CENTER);
		setTitle("Schedule");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	public static void main(String arg[])
			{
		//	DisplayCourse dc=new DisplayCourse();
			}
	
}