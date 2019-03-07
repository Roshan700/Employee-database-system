package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class HomeFrame extends JFrame
{
	Container c;
	JButton btnAdd,btnView,btnUpdate,btnDelete;
    JPanel p1,p2;
	
	
	HomeFrame()
	{ 
	c=getContentPane();
	c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
	//c.setLayout(new FlowLayout());
	
	p1 = new JPanel();
	btnAdd=new JButton("Add");
	btnView=new JButton("View");
	p1.add(btnAdd);
	p1.add(btnView);
	c.add(p1);
	
	p2 = new JPanel();
	btnUpdate=new JButton("Update");
	btnDelete= new JButton("Delete");
	p2.add(btnUpdate);
	p2.add(btnDelete);
	c.add(p2);
	
	setSize(320,200);
	setLocationRelativeTo(null);
	setTitle("Student Management System");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	btnAdd.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		AddFrame a=new AddFrame();
          dispose();		
			
		}
		
	});
	
	btnView.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		ViewFrame a=new ViewFrame();
          dispose();		
			
		}
		
	});

	btnDelete.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		DeleteFrame a=new DeleteFrame();
          dispose();		
			
		}
		
	});
	
	btnUpdate.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		UpdateFrame a=new UpdateFrame();
          dispose();		
			
		}
		
	});
	
	}
	
	public static void main(String args[])
	{
		HomeFrame hf=new HomeFrame();
	
	}
	
		
}
		
		
		
	class Db
	{
		public void addStudent(int rno,String name)
		{
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ORACLE_051");
				
				String sql = "insert into student values(?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setInt(1,rno);
				pst.setString(2,name);
				int r= pst.executeUpdate();
				JOptionPane.showMessageDialog(new JDialog(),r+" Records inserted");
				
				con.close();
			}
			catch(SQLException e)
			{
			JOptionPane.showMessageDialog(new JDialog(),"Some Issue"+e);
			}
		}
		
		public String viewStudent()
		{ 
		StringBuffer sb= new StringBuffer();
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ORACLE_051");
				
				String sql = "select * from student";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next())
				{
					sb.append(" Rno: "+rs.getInt(1)+"        "+"Name: "+rs.getString(2)+ "\n");
				}
					
				con.close();
				
			}
			catch(SQLException e)
			{
			JOptionPane.showMessageDialog(new JDialog(),"Some Issue"+e);
			}
			return sb.toString();
		}
		
		
		public void updateStudent(int rno,String name)
		{
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ORACLE_051");
				
				String sql = "update student set name =(?) where rno =(?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1,name);
				pst.setInt(2,rno);
				int r= pst.executeUpdate();
				JOptionPane.showMessageDialog(new JDialog(),r+" Record Updated Successfully");
				
				con.close();
			}
			catch(SQLException e)
			{
			JOptionPane.showMessageDialog(new JDialog(),"Some Issue"+e);
			}
		}
		
		
			
		public void deleteStudent(int rno)
		{ 

			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ORACLE_051");
				
				String sql = "delete from student where rno =(?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setInt(1,rno);
				int r= pst.executeUpdate();
				JOptionPane.showMessageDialog(new JDialog(),r+" Record Deleted Successfully");
				
				con.close();
				
			}
			catch(SQLException e)
			{
			JOptionPane.showMessageDialog(new JDialog(),"Some Issue"+e);
			}
	
		}
		
	}
		
	
	
