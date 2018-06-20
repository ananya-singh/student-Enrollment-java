
package  frametype;

import javax.swing.*;

import java.awt.*;
import java.sql.*;

class DisplayStudentDetails extends JFrame
{
	Container c;
	JTable t;
	DisplayStudentDetails()
	{
		c=this.getContentPane();
		c.setLayout(new BorderLayout());
		String heading[]={"Course","Std_id","Name","Gender","Dob","F_name","Add","Pin","City","State","Country","Mob_no","Email","PAN","Date"};
		
		
		String data[][]=new String[40][15];
		int r=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ananya");
			PreparedStatement ps=con.prepareStatement("select * from student");
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
				data[r][11]=rs.getString(12);
				data[r][12]=rs.getString(13);
				data[r][13]=rs.getString(14);
				data[r][14]=rs.getString(15);
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
		c.add(new JLabel("DETAILS OF STUDENT"),BorderLayout.NORTH);
		c.add(jsp,BorderLayout.CENTER);
		setTitle("STUDENT DETAILS");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	/*public static void main(String arg[])
	{
		DisplayStudentDetails dsd=new DisplayStudentDetails();
	}*/
	
}