package lab03;

import java.sql.*;

public class Lab03 {
	private static Connection con;
	public static void main(String[] args) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//ConnectionString
				String dbUsername = "anoch";
				String dbPassword = "6633801936";
				String dbURL = "jdbc:mysql://10.199.7.40:3306/anoch_lab03?characterEncoding=utf-8";
				con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
				//Query
				PreparedStatement psmt = con.prepareStatement("SELECT * FROM teachers WHERE gender = ?");
				psmt.setString(1, "m");
				
				ResultSet rs = psmt.executeQuery();
				
				//Fetch to show on application
				while (rs.next()) {
					String x = rs.getString("tname");
					String z = rs.getString("gender");
					if(z.equals("m")) {
						z = "ชาย";
					}else {
						z = "หญิง";
					}
					System.out.println("Name : " + x + ", gender : " + z );
				}
				//Close Connection
				con.close();
				
			} catch (ClassNotFoundException e) {
				System.err.println("Error loading driver: " + e);
			} catch (SQLException e) {
				System.err.println("Error database connection: " + e);
			}
		}
	}




