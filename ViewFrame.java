package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ViewFrame extends JFrame
{
	Container c;
	TextArea txtData;
	JButton Back;
	JPanel p1,p2;
	JScrollPane sp;
	
	ViewFrame()
	{
	c = getContentPane();
	c.setLayout(new BoxLayout(c,BoxLayout.X_AXIS));
	
	p1= new JPanel();
	txtData = new TextArea(5,25);
	sp = new JScrollPane(txtData);
   	p1.add(txtData);
	p1.add(sp);
	c.add(p1);
	
	Back = new JButton("Back");
	p2= new JPanel();
	p2.add(Back);
	c.add(p2);
	
	Back.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			HomeFrame hf = new HomeFrame();
			dispose();
			
		}
	}
	);
	
		setSize(500,200);
		setTitle("View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		txtData.setText(new Db().viewStudent());
		
	}
}
