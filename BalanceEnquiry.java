package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	String pinnnumber;
	
	BalanceEnquiry(String pinnnumber){
		this.pinnnumber = pinnnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		back = new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		Conn conn = new Conn();
		int balance = 0;

		try {
			ResultSet rs = conn.s.executeQuery("select * from bank where Pin_Number = '"+pinnnumber+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		JLabel l1 = new JLabel("Your current Account Balance is Rs " + balance);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("System",Font.BOLD,16));
		l1.setBounds(180,280,500,35);
		image.add(l1);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true); 
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transactions(pinnnumber).setVisible(true);
		
	}
	
	public static void main (String args[]) {
		new BalanceEnquiry("");
	}


	
}
