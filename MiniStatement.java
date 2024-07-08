package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;


public class MiniStatement extends JFrame implements ActionListener{
	
	
	String pinnumber;
	
	MiniStatement(String pinnumber){
		
		setLayout(null);
		
		setTitle("Mini Statement");
		
		JLabel mini = new JLabel();
		mini.setBounds(20,40,400,200);
		add(mini);
		
		JLabel bank = new JLabel("State Bank of India");
		bank.setBounds(140,20,200,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,320,20);
		add(balance);
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from Login where Pin_Number = '"+pinnumber+"'");
			//ResultSet rs = conn.s.executeQuery("select * from Login where Pin_Number = '1970'");
			while(rs.next()) {
				card.setText("Card Number: "+ rs.getString("Card_Number").substring(0,4) + "XXXXXXXX"+ rs.getString("Card_Number").substring(12,16));
			}	
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from Bank where Pin_Number = '"+pinnumber+"'");
			int bal = 0;
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") +  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>");
				if(rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your current account balance is Rs " + bal);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
	}
	
	public static void main(String args[]) {
		new MiniStatement("");
	}

	
	
}
