package prj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;


public class inv extends JFrame {
JPanel pl , pl2,pl3;	
JTable table;
JButton b , b1 , b2, b3;
JLabel un,un2,un3,un4,un5,un6,u;
JTextField tf , tf2,tf3;

public inv () {
	setSize(700,600);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	
	 Font font = new Font("Arial", Font.BOLD, 15);
	 Font font2 = new Font("Arial", Font.BOLD, 22);
	
	pl = new JPanel();
	pl.setBounds(0, 60, 300, 600);
	//pl.setBackground(Color.DARK_GRAY);
	pl.setBackground(new Color(0, 128, 128));
	//p2.setBackground(new Color(189, 183, 107));
pl.setLayout(null);
	add(pl);
	
	
	pl2 = new JPanel();
	pl2.setBounds(300, 60, 400,600);
	//pl2.setBackground(Color.gray);
	//pl2.setBackground(new Color(189, 183, 107));
	pl2.setBackground(new Color(44, 62, 80));
	pl2.setLayout(null);
	add(pl2);
	
	pl3 = new JPanel();
	pl3.setBounds(0, 0, 700,60);
	pl3.setBackground(Color.DARK_GRAY);
	//pl3.setBackground(new Color(230, 230, 250));
	//pl3.setBackground(new Color(106, 90, 205));
	
	pl3.setLayout(null);
	add(pl3);
	
	
	
	u = new JLabel("Manage Product Information");
	u.setBounds(200,10,350,40);
	u.setForeground(Color.WHITE);
	u.setFont(font2);
	pl3.add(u);
	
	
	
	
	
	un = new JLabel("Product Name:");
	un.setBounds(7,11,140,80);
	un.setForeground(Color.WHITE);
	un.setFont(font);
	pl.add(un);
	
	un = new JLabel("Serial No:");
	un.setBounds(43,60,140,80);
	un.setForeground(Color.WHITE);
	un.setFont(font);
	pl.add(un);
		
	
	un = new JLabel("Price:");
	un.setBounds(70,110,140,80);
	un.setForeground(Color.WHITE);
	un.setFont(font);
	pl.add(un);
	
	un = new JLabel("Catagory:");
	un.setBounds(40,157,140,80);
	un.setForeground(Color.WHITE);
	un.setFont(font);
	pl.add(un);
	
	un = new JLabel("Condition:");
	un.setBounds(38,210,140,80);
	un.setForeground(Color.WHITE);
	un.setFont(font);
	pl.add(un);
	
	
	un = new JLabel("Warranty:");
	un.setBounds(40,260,140,80);
	un.setForeground(Color.WHITE);
	un.setFont(font);
	pl.add(un);
		
		
	
	
	
	
//	Object data[][]= {{"10","x","101010"},{"12","y","12121"}};
//	String columnNames[]= {"serial" , "name" ,"id"};
//	
DefaultTableModel model = new DefaultTableModel();
	table = new JTable(model);

JScrollPane sp = new JScrollPane(table);
sp.setBounds(5,60,380,400);

pl2.add(sp);

	
	tf = new JTextField();
	tf.setBounds(130,30,140,40);
	pl.add(tf);
	
	
	
	tf2 = new JTextField();
	tf2.setBounds(130,80,140,40);
	
	pl.add(tf2);
	
	tf3 = new JTextField();
	tf3.setBounds(130,130,140,40);
	pl.add(tf3);
	
	String prd[]={"Smartphone","Laptop","Mouse","Keyboard","Smart TV"};        
    JComboBox cb=new JComboBox(prd);    
    cb.setBounds(130, 180,140,40);    
    pl.add(cb); 
    
    String prd1[]={"Good","Average","Bad","Very Bad"};        
    JComboBox cb1=new JComboBox(prd1);    
    cb1.setBounds(130, 230,140,40);    
    pl.add(cb1);
    
    String prd2[]={"Available","Not Available"};        
    JComboBox cb2=new JComboBox(prd2);    
    cb2.setBounds(130, 280,140,40);    
    pl.add(cb2);
	
    b3= new JButton("Home");
	b3.setBounds(115,415,75,50);
	b3.setBackground(Color.BLACK);
	b3.setForeground(new Color(255,255,255));
	b3.setFocusable(false);
	pl.add(b3);
	
	b3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new Home();
			
		}
	});
	
	
	
    
	b= new JButton("Insert");
	b.setBounds(20,350,75,50);
	b.setBackground(Color.BLACK);
	b.setForeground(new Color(255,255,255));
	b.setFocusable(false);
	pl.add(b);
	
	b.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	      
	        String productName = tf.getText();
	        String serialNo = tf2.getText();
	        String price = tf3.getText();
	       
	        String condition = cb1.getSelectedItem().toString();
	        String category = cb.getSelectedItem().toString();
	        String wr = cb2.getSelectedItem().toString();

	       
	        String[] row = {productName,   serialNo,price, condition,category, wr};
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.addRow(row);

	        // Optionally, you can add the new data to the database here
	        // Perform the database insert operation
	        // Example: insertDataIntoDatabase(productName, price, category, serialNo, condition, availability);
	        
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admins_info","root","");
				Statement st = con.createStatement();
				String qins = "INSERT INTO `inventory`(`Product_name`, `serial_no`, `Price`, `Catagory`, `Warranty`,`Condition`)" +
			               "VALUES ('" + productName + "','" + serialNo + "','" + price + "','" + category + "','" + wr + "','" +condition + "')";

				st.executeUpdate(qins);
				JOptionPane.showMessageDialog(null, "Information Recorded");
				 st.close();
				 con.close(); 
			} 
	       
	        catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
	    }
	});
	
	
	
	
	b1= new JButton("Update");
	b1.setBounds(115,350,75,50);
	b1.setBackground(Color.BLACK);
	b1.setForeground(new Color(255,255,255));
	b1.setFocusable(false);
	pl.add(b1);

b1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 String productName = tf.getText();
	            String serialNo = tf2.getText();
	            String price = tf3.getText();
	            String category = cb.getSelectedItem().toString();
	            String condition = cb1.getSelectedItem().toString();
	            String wr = cb2.getSelectedItem().toString();
			
			int row = table.getSelectedRow();
			model.setValueAt(productName, row, 0);
			model.setValueAt(serialNo, row, 1);
			model.setValueAt(price, row, 2);
			model.setValueAt(condition, row, 3);
			model.setValueAt(category, row, 4);
			model.setValueAt(wr, row, 5);
			
			
			try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admins_info", "root", "");
                Statement st = con.createStatement();
                String qupdate = "UPDATE `inventory` SET `Product_name`='" + productName +
                        "', `serial_no`='" + serialNo + "', `Price`='" + price +
                        "', `Condition`='" + condition +
                        "', `Catagory`='" + category + "', `Warranty`='" + wr + "' WHERE `serial_no`='" + serialNo + "'";

                st.executeUpdate(qupdate);
                JOptionPane.showMessageDialog(null, "Information Updated");
                st.close();
                con.close();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        }
		
	});
	
	
	
	b2= new JButton("Delete");
	b2.setBounds(210,350,75,50);
	b2.setBackground(Color.BLACK);
	b2.setForeground(new Color(255,255,255));
	b2.setFocusable(false);
	pl.add(b2);
b2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Warning", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
	                model.removeRow(table.getSelectedRow());

	                try {
	                    Class.forName("com.mysql.cj.jdbc.Driver");
	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admins_info", "root", "");
	                    Statement st = con.createStatement();
	                    String qdelete = "DELETE FROM `inventory` WHERE `serial_no`='" + tf2.getText() + "'";

	                    st.executeUpdate(qdelete);
	                    JOptionPane.showMessageDialog(null, "Record Deleted");
	                    st.close();
	                    con.close();
	                } catch (ClassNotFoundException | SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
			
		
	});
	
	
	table.addMouseListener(new MouseAdapter() {

		public void mouseClicked(MouseEvent e) {
			int rowclicked = table.getSelectedRow();
			
			String pn = (String) model.getValueAt(rowclicked , 0);
		 String sl = (String) model.getValueAt(rowclicked , 1);
		String pr = (String) model.getValueAt(rowclicked , 2);
		String con = (String) model.getValueAt(rowclicked ,3 );
		 String cat = (String) model.getValueAt(rowclicked ,4 );
		String wr = (String) model.getValueAt(rowclicked , 5);
		 
		 tf.setText(pn);
		 tf2.setText(sl);
		 tf3.setText(pr);
		 cb.setSelectedItem(cat);
	        cb1.setSelectedItem(con);
	        cb2.setSelectedItem(wr);

	  
		}
		});
	
	showtable();

	
			
			setVisible(true);
}

private void showtable() {
	// TODO Auto-generated method stub
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admins_info", "root", "");
		 Statement st = con.createStatement();
		 String quary = "SELECT * FROM `inventory`";
		 ResultSet rs =st.executeQuery(quary);
		 java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 
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