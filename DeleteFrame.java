package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class DeleteFrame extends JFrame
{
	Container c;
	JPanel p1,p2;
	JLabel lblrno;
	JTextField txtrno;
	JButton btnDelete,btnBack;
	
	DeleteFrame()
	{
	  c = getContentPane();
	  c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
	  
	  p1 = new JPanel();
	  lblrno = new JLabel("Enter Roll no:");
	  txtrno = new JTextField(4);
	  p1.add(lblrno);
	  p1.add(txtrno);
	  c.add(p1);
	  
	  p2 = new JPanel();
	  btnDelete = new JButton("Delete");
	  btnBack = new JButton("Back");
	  p2.add(btnDelete);
	  p2.add(btnBack);
	  c.add(p2);
		
	  setSize(500,200);
	  setTitle("Delete");
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setVisible(true);
	  setLocationRelativeTo(null);
	
	
	btnBack.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			HomeFrame hf = new HomeFrame();
			dispose();
		}
	});
	
	btnDelete.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			
			String rno = txtrno.getText();
		if(rno.length()==0 ) JOptionPane.showMessageDialog(new JDialog(),"Please Enter Roll no");
        else	
			new Db().deleteStudent(Integer.parseInt(rno));
			txtrno.setText("");
			txtrno.requestFocus();
			
		}
	});
	}
}