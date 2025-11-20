package prj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Home extends JFrame {
	JButton btn1,btn2,btn3,btn4;
	JPanel p1,p2;
	JLabel un;
	public Home() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		 Font font = new Font("Arial", Font.BOLD, 18);
		
		p1 = new JPanel();
		p1.setBounds(0,0,500,60);
		//p1.setBackground(Color.DARK_GRAY);
		p1.setBackground(new Color(44, 62, 80));
		p1.setLayout(null);
		add(p1);

		un = new JLabel("Inventory Management System");
		un.setBounds(100,10,300,40);
		un.setForeground(Color.WHITE);
		un.setFont(font);
		p1.add(un);
		
		
		p2 = new JPanel();
		p2.setBounds(0,0,500,465);
		p2.setBackground(Color.gray);
		//p2.setBackground(new Color(189, 183, 107));
		
		//p2.setBackground(new Color(189, 183, 107));new Color(0, 128, 128)
		//p2.setBackground(new Color(0, 128, 128)); 
		
		p2.setLayout(null);
	add(p2);
		
		
		
		btn1=new JButton("ADD ADMIN");
		btn1.setBounds(90,90,300,70);
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(new Color(255,255,255));
		btn1.setFocusable(false);
		p2.add(btn1);
		
btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new regi();
			}
		});
		
		
		
		btn2=new JButton("MANAGE INVENTORY");
		btn2.setBounds(90,180,300,70);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(new Color(255,255,255));
		btn2.setFocusable(false);
	
		p2.add(btn2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new inv();
				
			}
		});
		
		btn3=new JButton("LOG OUT");
		btn3.setBounds(90,360,300,70);
		btn3.setBackground(Color.BLACK);
		btn3.setForeground(new Color(255,255,255));
		btn3.setFocusable(false);
		
		p2.add(btn3);
btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				  int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirm Log Out", JOptionPane.YES_NO_OPTION);

			        if (confirmResult == JOptionPane.YES_OPTION) {
			            dispose(); 
			        new login();
			        }
			}
		});
		
		
btn4=new JButton("Warrenty Products");
btn4.setBounds(90,270,300,70);
btn4.setBackground(Color.BLACK);
btn4.setBackground(Color.BLACK);
btn4.setForeground(new Color(255,255,255));
btn4.setFocusable(false);
p2.add(btn4);

btn4.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		new wrr();
	}
});

		
		
		
		setVisible(true);
}
}