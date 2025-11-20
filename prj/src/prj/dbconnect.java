package prj;
import java.sql.*;

import javax.swing.JOptionPane;
public class dbconnect {
	private Statement st ;
private Connection con;
	public dbconnect() {
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admins_info","root","");
		
		 st = con.createStatement();
		
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void regiinsert(String qins) {
		try {
			st.executeUpdate(qins);
			JOptionPane.showMessageDialog(null, "Information Recorded");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
            close();
        }
	}

	private void close() {
		// TODO Auto-generated method stub
		try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
