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
			System.out.println("���� ����");
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
			int �й�=rs.getInt("�й�");
			String �̸�=rs.getString("�̸�");
			String ����=rs.getString("����");
			String �г�=rs.getString("�г�");
			String �к�=rs.getString("�к�");
			String �а�=rs.getString("�а�");
			System.out.println(�й�+"�й�"+" : "+�̸�+" "+����+"�� "+�г�+"�г� "+�к�+" "+�а�);
	}}}
