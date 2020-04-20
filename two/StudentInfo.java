package com.two;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInfo {
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
		String sql="SELECT*FROM stu";
		ResultSet rs=stmt.executeQuery(sql);
		while (rs.next()) {
			int 학번=rs.getInt("학번");
			String 이름=rs.getString("이름");
			String 나이=rs.getString("나이");
			String 학년=rs.getString("학년");
			String 학부=rs.getString("학부");
			String 학과=rs.getString("학과");
			System.out.println(학번+"학번"+" : "+이름+" "+나이+"세 "+학년+"학년 "+학부+" "+학과);
	}}}
