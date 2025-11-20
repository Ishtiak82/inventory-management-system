package prj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class regi extends JFrame {
	JPanel p1,p2;
	JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6,un;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton btn1,btn2;
	Font f,j;

	public regi() {
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		f = new Font("Arial",Font.BOLD,18 );
		j = new Font("Arial",Font.BOLD,15 );
		
		Font font2 = new Font("Arial", Font.BOLD, 22);
		
		
		
		
		p1 = new JPanel();
		p1.setBounds(0,0,600,70);
		//p1.setBackground(Color.DARK_GRAY);
		//p1.setBackground(new Color(0, 128, 128));
		p1.setBackground(new Color(44, 62, 80));
		
		p1.setLayout(null);
		add(p1);
		
		p2 = new JPanel();
		p2.setBounds(0,70,600,530);
		p2.setBackground(Color.GRAY);
		//p2.setBackground(new Color(0, 128, 128));
		p2.setLayout(null);
		add(p2);
		
		
		
		un = new JLabel("Admin Registration");
		un.setBounds(190,13,300,40);
		un.setForeground(Color.WHITE);
		un.setFont(font2);
		p1.add(un);
		
		
		
		
		
		lb = new JLabel("Name:");
		lb.setBounds(140,5,80,60);
		lb.setFont(f);
		p2.add(lb);
		
		tf1=new JTextField();	
		tf1.setBounds(230,15,300,40);
		tf1.setFont(j);
	p2.add(tf1);
		
		lb1 = new JLabel("Mobile:");
		lb1.setBounds(130,55,80,60);
		lb1.setFont(f);
		p2.add(lb1);
		
		tf2=new JTextField();
		tf2.setBounds(230,63,300,40);
		tf2.setFont(j);
		p2.add(tf2);
		
		lb2 = new JLabel("Email:");
		lb2.setBounds(140,90,80,80);
		lb2.setFont(f);
		p2.add(lb2);
		
		
		
		tf3=new JTextField();
		tf3.setBounds(230,112,300,40);
		tf3.setFont(j);
		p2.add(tf3);
		
		
		
		lb3 = new JLabel("Address:");
		lb3.setBounds(117,141,80,80);
		lb3.setFont(f);
		p2.add(lb3);
		
		tf4=new JTextField();
		tf4.setBounds(230,160,300,40);
		tf4.setFont(j);
		p2.add(tf4);
		
		lb4 = new JLabel("Username:");
		lb4.setBounds(101,185,100,90);
		lb4.setFont(f);
		p2.add(lb4);
		
		tf5=new JTextField();
		tf5.setBounds(230,209,300,40);
		tf5.setFont(j);
		p2.add(tf5);
		
		lb5 = new JLabel("Password:");
		lb5.setBounds(102,235,100,90);
		lb5.setFont(f);
		p2.add(lb5);
		
		
		tf6=new JTextField();
		tf6.setBounds(230,258,300,40);
		tf6.setFont(j);
		p2.add(tf6);
		

		lb6 = new JLabel("Confirm Password:");
		lb6.setBounds(28,283,190,90);
		lb6.setFont(f);
		p2.add(lb6);
		
		

		tf7=new JTextField();
		tf7.setBounds(230,308,300,40);
		tf7.setFont(j);
		p2.add(tf7);
		
		
		
	
		
		
		
		btn2=new JButton("Register");
		btn2.setBounds(430,380,100,50);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(new Color(255,255,255));
		btn2.setFocusable(false);
		p2.add(btn2);
		
		
		btn2.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String name = tf1.getText();
		        String mobile = tf2.getText();
		        String email = tf3.getText();
		        String address = tf4.getText();
		        String username = tf5.getText();
		        String pass = tf6.getText();
		        String conpass = tf7.getText();

		        String namerx = "^[A-Za-z]{3,10}$";
		        String mobrx = "^(\\+88)?01[2-9]\\d{8}$";
		        String emailrx = "^[a-z0-9]+@[a-z]+\\.[a-z]+$";
		        String passrx = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}$";
		        String usnamerx = "^(?=(?:[^0-9]*[0-9]){2,4}[^0-9]*$)[a-zA-Z0-9]{4,10}$";
		        //String adr = "^[a-zA-Z\\s'-]+$";

		        if (!Pattern.matches(namerx, name)) {
		            JOptionPane.showMessageDialog(null, "ONLY 3-10 Characters for Name");
		        } else if (!Pattern.matches(mobrx, mobile)) {
		            JOptionPane.showMessageDialog(null, "Invalid mobile number");
		        } else if (!Pattern.matches(emailrx, email)) {
		            JOptionPane.showMessageDialog(null, "Invalid email");
		        } else if (!Pattern.matches(passrx, pass)) {
		            JOptionPane.showMessageDialog(null, "Password must have 1 uppercase, 1 lowercase, 1 digit, 1 special character, and be 6-20 characters long");
		        } else if (!conpass.equals(pass)) {
		            JOptionPane.showMessageDialog(null, "Passwords do not match");
//		        } else if (!Pattern.matches(adr, address)) {
//		            JOptionPane.showMessageDialog(null, "Invalid address");
//		        } else if (!Pattern.matches(usnamerx, username)) {
		            JOptionPane.showMessageDialog(null, "Invalid username");
		        } else {
		            String qins = "INSERT INTO `info`(`Name`, `Mobile`, `Email`, `Address`, `Username`, `password`)" +
		                    "VALUES ('" + name + "','" + mobile + "','" + email + "','" + address + "','" + username + "','" + pass + "')";
		            dbconnect db = new dbconnect();
		            db.regiinsert(qins);
		        }
		    }
		});

		
		
		
		
		
//		btn2.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String name = tf1.getText();
//				String mobile = tf2.getText();
//				String email = tf3.getText();
//				String address = tf4.getText();
//				String username = tf5.getText();
//				String pass = tf6.getText();
//				String conpass = tf7.getText();
//				
//				String namerx= "^[A-Za-z]{3,10}$";
//				String mobrx= "^(\\+88)?01[2-9]\\d(8)$";
//				String emailrx= "^[a-z0-9]+@[a-z]+.[a-z]+$";
//				String passrx="^((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%&*-+])).{6,20}$";
//			String usnamerx = "^(?=(?:[^0-9]*[0-9]){2,4}[^0-9]*$)[a-zA-Z0-9]{4,10}$";
//		String adr=	"^[a-zA-Z\\s'-]+$";
//			
//		if(!Pattern.matches(namerx,name)) {
//			JOptionPane.showMessageDialog(null, "ONLY 3-10 Characters ");
//			
//		}
//		else if(!Pattern.matches(emailrx,email)) {
//			JOptionPane.showMessageDialog(null, "invalid email");
//			
//		}
//			
//		else if(!Pattern.matches(passrx,pass)) {
//			JOptionPane.showMessageDialog(null, "1 uppercase, 1 lowercase, 1 digit,1 special character and 6-20 leanth");
//			
//		}
//		else if(!conpass.equals(pass)) {
//			JOptionPane.showMessageDialog(null, "invalid address");
//			
//		}
//		else if(!Pattern.matches(mobrx,mobile)) {
//			JOptionPane.showMessageDialog(null, "invalid mobile number");
//			
//		}	
//		else if(!Pattern.matches(adr,address)) {
//			JOptionPane.showMessageDialog(null, "invalid address");
//			
//		}	
//			
//		else if(!Pattern.matches(usnamerx,username)) {
//			JOptionPane.showMessageDialog(null, "invalid username");
//			
//		}	
//		else {
//			
//		String qins =	"INSERT INTO `info`(`Name`, `Mobile`, `Email`, `Address`, `Username`, `password`)" + "VALUES ('"+name+"','"+mobile+"','"+email+"','"+address+"','"+username+"','"+pass+"')";
//		dbconnect db = new dbconnect();
//		db.regiinsert(qins);
//		}
//			
//			}
//			
//		});
//		
		
		
		btn1=new JButton("Back");
		btn1.setBounds(230,382,100,50);
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(new Color(255,255,255));
		btn1.setFocusable(false);
		p2.add(btn1);
		
btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				  int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back?", "Cancel Registration!!", JOptionPane.YES_NO_OPTION);

			        if (confirmResult == JOptionPane.YES_OPTION) {
			            dispose();
			            new Home();
			        }
			}
		});
		
		
		setVisible(true);
	
	
}
}