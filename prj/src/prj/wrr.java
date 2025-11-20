package prj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class wrr extends JFrame {
	JTable tbl;
	JPanel pl,p2;
	JButton b;
	JLabel un;
	
	public wrr () {
		setSize(700,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pl = new JPanel();
		pl.setBounds(0, 70, 700, 600);
		//pl.setBackground(Color.blue);
		pl.setBackground(new Color(44, 62, 80));
	pl.setLayout(null);
		add(pl);
		
		p2 = new JPanel();
		p2.setBounds(0, 0, 700, 60);
		//p2.setBackground(Color.DARK_GRAY);
		p2.setBackground(new Color(0, 128, 128));
	p2.setLayout(null);
		add(p2);
		
		
		Font font2 = new Font("Arial", Font.BOLD, 22);
		
		
		un = new JLabel("Warranty Available Product List");
		un.setBounds(170,13,400,40);
		un.setForeground(Color.WHITE);
		un.setFont(font2);
		p2.add(un);
		
		
		
		
		  b= new JButton("Back");
			b.setBounds(280,440,100,30);
			pl.add(b);
			
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Home();
					
				}
			});
		
		
		DefaultTableModel model = new DefaultTableModel();
		tbl = new JTable(model);
		
		

	JScrollPane sp = new JScrollPane(tbl);
	sp.setBounds(5,10,674,420);
	pl.add(sp);
	showtable();
	setVisible(true);
}
	
	private void showtable() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admins_info", "root", "");
			 Statement st = con.createStatement();
			 String quary = "SELECT * FROM `inventory` WHERE `Warranty`='Available'";
			 ResultSet rs =st.executeQuery(quary);
			 java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			 DefaultTableModel model = (DefaultTableModel) tbl.getModel();
			 
			 int col = rsmd.getColumnCount();
			 String[] colname = new String[col];
			 for (int i =0; i<col;i++) {
				 colname[i]=rsmd.getColumnName(i+1);
				 model.setColumnIdentifiers(colname);
				 model.setColumnIdentifiers(colname);
				 String pname,price,catagory,serial,cond,wr;
				 while(rs.next()) {
					 pname =rs.getString(1);
					price =rs.getString(2);
					catagory =rs.getString(3);
					 serial =rs.getString(4);
					 cond =rs.getString(5);
					wr =rs.getString(6);
					String[] row= {pname,price,catagory,serial,cond,wr};
					model.addRow(row);
				 }
			 }
			 st.close();
			 con.close();
			 
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	
	
	
}
