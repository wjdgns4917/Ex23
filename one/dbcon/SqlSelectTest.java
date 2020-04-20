package com.one.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlSelectTest {
	private static Connection dbConnection() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="scott";
		String pass="123456";
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pass);
			System.out.println("연결 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;

	}
	public static void main(String[] args) throws SQLException {
		Connection con=dbConnection();
		Statement stmt=con.createStatement();
		String sql="SELECT*FROM books";
		ResultSet rs=stmt.executeQuery(sql);
		while (rs.next()) {
			int id=rs.getInt("book_id");
			String title=rs.getString("title");
			System.out.println(id+" : "+title);
		}
	}
}
