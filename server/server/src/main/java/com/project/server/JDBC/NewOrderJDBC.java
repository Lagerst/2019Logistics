package com.project.server.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.project.server.searchOrder.Neworder;

public class NewOrderJDBC {
	public static Boolean Get(Neworder t) throws SQLException, ClassNotFoundException {
		try {
			int res=0;
			String URL = "jdbc:postgresql://localhost:5432/express1";
			String userName = "postgres";
			String passWord = "123";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(URL,userName,passWord);
			System.out.println("Adding...");
			String strn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis()));
			String sql="insert into orderinfo values(\'"+t.num+"\',\'";
			sql+=t.name+"\',\'";
			sql+=t.type+"\',\'";
			sql+=t.quantity+"\',to_date(\'";
			sql+=strn+"\','yyyy-mm-dd hh24:mi:ss'),\'";
			sql+=t.province+"\',\'";
			sql+=t.city+"\',\'";
			sql+=t.district+"\',\'";
			sql+=t.address+"\',to_timestamp(\'";
			sql+=strn+"\','yyyy-mm-dd hh24:mi:ss'),\'";
			sql+=t.desc+"\',\'";
			sql+="001"+"\',\'";
			sql+="101"+"\')\n";
			System.out.print(sql);
			Statement stmt=(Statement)conn.createStatement();
			stmt.executeQuery(sql);
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
			
		}
		return true;
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		//Test
		Neworder test=new Neworder();		
		System.out.println(NewOrderJDBC.Get(new Neworder()));
	}
}
