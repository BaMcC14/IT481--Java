import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	
	private Connection conn = null;
	
	private String dbURL;
	
	public DB() {
		
	}
	
	public DB(String connection) {
		dbURL = connection;
	}

	public String getCustomerCount() {
		String count = null;
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				String countQuery = "select count(*) as count from customers;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while (rs.next()) {
					count = rs.getString("count");
				}
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch(SQLException ex) {
				
				ex.printStackTrace();
			}
		}
		
		return count;
	}

	public String getCompanyName() {
		String result = "";
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				String countQuery = "select companyname from customers;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while(rs.next()) {
					result += rs.getString("companyname");
					result += "\n";
				}
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public String getOrderCount() {
		String count = null;
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				String countQuery = "select count(*) as count from orders;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				while(rs.next()) {
					count = rs.getString("count");
				}
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return count;
	}

	public String getShipNames() {
		String result = "";
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				String countQuery = "select shipname from orders;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while(rs.next()) {
					result += rs.getString("shipname");
					result += "\n";
				}
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public String getEmployeeCount() {
		String count = null;
		
		try {
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				String countQuery = "select count(*) as count from employees;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while(rs.next()) {
					count = rs.getString("count");
				}
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return count;
		
	}

	public String getEmployeeNames() {
		String result = "";
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				String countQuery = "select FirstName + ' ' + LastName as name from employees;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while(rs.next()) {
					result += rs.getString("name");
					result += "\n";
				}
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return result;
		
	}
}
