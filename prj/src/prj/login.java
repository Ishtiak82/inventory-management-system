package prj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame {
	JLabel un , un2, un3; 
	JPanel p1,p2;
	JButton b,b2 ;
	JTextField tf ;
	JPasswordField tf1;
	private Statement st ;
	private Connection con;
	public login() {
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		 Font font = new Font("Arial", Font.BOLD, 15);
		 Font font2 = new Font("Arial", Font.BOLD, 26);
//
//		ImageIcon img = new ImageIcon("C:\\Users\\FIGHTER\\eclipse-workspace\\prj\\img\\jeremy-bishop-G9i_plbfDgk-unsplash.jpg");
//		JLabel backg = new JLabel("",img,JLabel.CENTER);
//		backg.setIcon(new ImageIcon(img.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
//
//		backg.setBounds(0, 0, 500, 500);
//		add(backg);
		
		
		
		p1 = new JPanel();
		p1.setBounds(0,0,200,500);
		//p1.setBackground(new Color(128, 128, 0));
		//p1.setBackground(Color.DARK_GRAY);
		p1.setBackground(new Color(0, 128, 128));
		p1.setLayout(null);
		add(p1);
		
		p2 = new JPanel();
		p2.setBounds(200,0,400,500);
		//p2.setBackground(Color.LIGHT_GRAY);
		//p2.setBackground(new Color(189, 183, 107));
		p2.setBackground(new Color(44, 62, 80)); 
		
		p2.setLayout(null);
	add(p2);
		
	un3 = new JLabel("Welcome!");
	un3.setBounds(30,5,140,80);
	un3.setForeground(Color.WHITE);
	un3.setFont(font2);
	p1.add(un3);
		
		
		un = new JLabel("Username:");
		un.setBounds(50,80,100,80);
		un.setForeground(Color.WHITE);
		un.setFont(font);
		p2.add(un);
		
		un2 = new JLabel("Password:");
		un2.setBounds(50,180,100,80);
		un2.setForeground(Color.WHITE);
		un2.setFont(font);
		p2.add(un2);
		
		 tf = new JTextField();
		 tf.setBounds(50, 140, 250, 50);
		 tf.setFont(font);
		 //tf.setBorder(null);
		 tf.setBackground(p2.getBackground());
		 tf.setForeground(Color.WHITE); 
		 tf.setCaretColor(Color.GRAY);
		 p2.add(tf);

		 tf1 = new JPasswordField();
		 tf1.setBounds(50, 240, 250, 50);
		 tf1.setFont(font);
		 //tf1.setBorder(null);
		 tf1.setBackground(p2.getBackground());
		 tf1.setForeground(Color.white); 
		 tf1.setCaretColor(Color.GRAY);
		 p2.add(tf1);
		
		b = new JButton("LOGIN");
		b.setBounds(200,320,100,50);
		b.setFont(font);
		b.setBackground(Color.darkGray);
		b.setForeground(Color.white);
		b.setFocusable(false);
		p2.add(b);
		
		
		
		
		b.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admins_info", "root", "");
		            String dbusername = tf.getText();
		            String dbpass = tf1.getText();
		            st = con.createStatement();

		            if (tf.getText().isEmpty() || tf1.getText().isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Please Enter Username and Password", "Alert", JOptionPane.WARNING_MESSAGE);
		                tf.setText("");
		                tf1.setText("");
		            } else {
		                String sql = "SELECT * FROM info WHERE Username = '" + dbusername + "' AND password = '" + dbpass + "'";
		                ResultSet rs = st.executeQuery(sql);

		                if (rs.next()) {
		                    dispose();
		                    new Home();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Username or password is incorrect");
		                    tf.setText("");
		                    tf1.setText("");
		                }
		            }

		            con.close();
		        } catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		});

		
		b2 = new JButton("Exit");
		b2.setBounds(50,320,100,50);
		b2.setFont(font);
		b2.setBackground(Color.darkGray);
		b2.setForeground(Color.white);
		b2.setFocusable(false);
		p2.add(b2);
		 
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		

		setVisible(true);
		
	}

}
