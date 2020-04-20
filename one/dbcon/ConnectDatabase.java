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
		//����̹� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���� ����");
			con=DriverManager.getConnection(url, id, pw);
			System.out.println("�����ͺ��̽� ���� ����");	
		} catch (SQLException sql) {
			System.out.println(sql+"�������");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ����");
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con=makeConnection();
	}
}
