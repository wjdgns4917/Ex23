package com.one.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	public static Connection makeConnection() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pw="123456";
		Connection con=null;
		//드라이버 적재
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
			con=DriverManager.getConnection(url, id, pw);
			System.out.println("데이터베이스 연결 성공");	
		} catch (SQLException sql) {
			System.out.println(sql+"연결실패");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 없음");
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con=makeConnection();
	}
}
