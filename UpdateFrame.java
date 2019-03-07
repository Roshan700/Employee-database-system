package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class UpdateFrame extends JFrame
{
 Container c;
 JPanel p1,p2;
 JButton btnSave,btnBack;
 JTextField txtrno,txtname;
 JLabel lblrno,lblname;
 
 UpdateFrame()
 {
  c = getContentPane();
  c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
  
  p1 = new JPanel();
  lblname = new JLabel("Enter the name");
  lblrno = new JLabel("Enter Roll no:");
  txtrno = new JTextField(3);
  txtname = new JTextField(10);
  p1.add(lblrno);
  p1.add(txtrno);
  p1.add(lblname);
  p1.add(txtname);
  c.add(p1);
  
  
  p2 = new JPanel();
  btnSave =new JButton("Update");
  btnBack =new JButton("Back");
  p2.add(btnSave);
  p2.add(btnBack);
  c.add(p2);
  
  setSize(500,200);
  setTitle("Update");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
  setLocationRelativeTo(null);
  
  
  btnSave.addActionListener(new ActionListener()
  {
    public void actionPerformed(ActionEvent ae)
	{
		String rno = txtrno.getText();
		String name = txtname.getText();
		if(rno.length()==0 || name.length()==0) JOptionPane.showMessageDialog(new JDialog(),"Enter correct combination of Roll no and Name");
        else		new Db().updateStudent(Integer.parseInt(rno),name);
		txtrno.setText("");
		txtname.setText("");
		txtrno.requestFocus();
	}
  });
  
  btnBack.addActionListener(new ActionListener()
  {
	  public void actionPerformed(ActionEvent ae)
	  {
		  HomeFrame hf = new HomeFrame();
		  dispose();  
	  }
	  
	  
  });
 }
}

