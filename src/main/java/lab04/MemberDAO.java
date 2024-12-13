package lab04;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import lab04.Member;

public class MemberDAO {
	private Connection con;

	// constructor ส าหรบั เชอื่ มตอ่ ฐานขอ้ มลู
	public MemberDAO() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbUsername = "anoch";
		String dbPassword = "6633801936";
		String dbURL = "jdbc:mysql://10.199.7.40:3306/anoch_blueshop?characterEncoding=utf-8";
		con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

	}
	
	public void closeConnection() throws SQLException {
		con.close();
	}
	
	public Member getMember(String username) throws SQLException {
		PreparedStatement pStatement = con.prepareStatement("SELECT * FROM member WHERE username = ?");
		pStatement.setString(1, username);
		ResultSet rs = pStatement.executeQuery();

		if (rs.next()) {
			Member member = new Member();
			member.setUsername(rs.getString("username"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
			member.setAddress(rs.getString("address"));
			member.setMobile(rs.getString("mobile"));
			member.setEmail(rs.getString("email"));
			return member;
		} else {
			return null;
		}

	}
	
	public ArrayList<Member> getAllMember() throws SQLException {
		PreparedStatement pStatement = con.prepareStatement("SELECT * FROM member");
		ResultSet rs = pStatement.executeQuery();
		ArrayList<Member> memberList = new ArrayList<Member>();
		while (rs.next()) {
			Member member = new Member();
			member.setUsername(rs.getString("username"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
			member.setAddress(rs.getString("address"));
			member.setMobile(rs.getString("mobile"));
			member.setEmail(rs.getString("email"));
			memberList.add(member); 
		}
		return memberList; // สง่ อารเ์รยก์ ลบั
	}
	
	public void createMember(Member member) throws SQLException {
		PreparedStatement pStatement = con
				.prepareStatement("INSERT INTO member (username, password, name , address , mobile , email) VALUES (?, ?, ?, ?, ? , ?)");
		pStatement.setString(1, member.getUsername());
		pStatement.setString(2, member.getPassword());
		pStatement.setString(3, member.getName());
		pStatement.setString(4, member.getAddress());
		pStatement.setString(5, member.getMobile());
		pStatement.setString(6, member.getEmail());
		// สง่ คา สง่ั SQL ไปยังฐานข้อมูล
		pStatement.executeUpdate();
		closeConnection();
	}
	
	public void updateMember(Member member) throws SQLException {
		PreparedStatement pStatement = con
				.prepareStatement("UPDATE member SET username = ?, password = ?,name = ? ,address = ?,mobile = ?,email = ? WHERE username = ?");
		pStatement.setString(1, member.getUsername());
		pStatement.setString(2, member.getPassword());
		pStatement.setString(3, member.getName());
		pStatement.setString(4, member.getAddress());
		pStatement.setString(5, member.getMobile());
		pStatement.setString(6, member.getEmail());
		pStatement.setString(7, member.getUsername());
		// สง่ คา สง่ั SQL ไปยังฐานข้อมูล
		pStatement.executeUpdate();
		closeConnection();
	}
	public void deleteMember(String username) throws SQLException {
		// เตรยีมคา สง่ั SQL
		PreparedStatement pStatement = con.prepareStatement("DELETE FROM member WHERE username = ?");
		pStatement.setString(1, username);
		// สง่ คา สง่ั SQL ไปยังฐานข้อมูล
		pStatement.executeUpdate();
		closeConnection();
	}

}
