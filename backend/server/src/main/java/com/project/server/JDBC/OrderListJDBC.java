package com.project.server.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.server.searchOrder.orderListEntity;

public class OrderListJDBC {
	public static List<orderListEntity> Get(String username) throws SQLException, ClassNotFoundException {
		List<orderListEntity> arrayList = new ArrayList<orderListEntity>();
		int res=0;
		String URL = "jdbc:postgresql://localhost:5432/express1";
		String userName = "postgres";
		String passWord = "123";
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(URL,userName,passWord);
		System.out.println("Comparing...");
			String sql="select * from orderinfo where hostid = \'"+username+"\'";
			Statement stmt=(Statement)conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				orderListEntity temp = new orderListEntity();
				temp.setNum(rs.getString("orderid"));
				temp.setName(rs.getString("goodsname"));
				//temp.add(rs.getString("sort"));
				//temp.add(rs.getString("number"));
				temp.setSendtime(rs.getString("date"));
				//temp.add(rs.getString("address_province"));
				//temp.add(rs.getString("address_city"));
				//temp.add(rs.getString("address_avenue"));
				//temp.add(rs.getString("address_specific"));
				//temp.add(rs.getString("time"));
				//temp.add(rs.getString("note"));
				//temp.add(rs.getString("hostid"));
				//temp.add(rs.getString("enterpriseid"));
				temp.setStorage("Chengdu Local Storage");
				arrayList.add(temp);
			}
		
		stmt.close();
		conn.close();
		return arrayList;
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		//Test
		System.out.println(OrderListJDBC.Get("001"));
	}
}
