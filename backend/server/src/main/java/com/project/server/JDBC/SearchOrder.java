package com.project.server.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.server.searchOrder.orderListEntity;
import com.project.server.searchOrder.searchRequest;
import com.project.server.searchOrder.storageListEntity;
import com.project.server.searchOrder.storageRequest;

public class SearchOrder {
	public static List<orderListEntity> Get(searchRequest request) throws ClassNotFoundException {
		List<orderListEntity> arrayList = new ArrayList<orderListEntity>();

		orderListEntity temp2 = new orderListEntity();
		temp2.setNum(request.num+"E");
		temp2.setName("External data");
		temp2.setSendtime("Click to watch");
		temp2.setStorage("Not Apply");
		arrayList.add(temp2);
		try {
			int res=0;
			String URL = "jdbc:postgresql://localhost:5432/express1";
			String userName = "postgres";
			String passWord = "123";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(URL,userName,passWord);
			System.out.println("Comparing...");
			String sql;
			if (!request.num.equals("")&&request.data1.equals("")) {
				sql="select * from orderinfo where orderid = \'"+request.num+"\'";
			}else if (request.num.equals("")&&!request.data1.equals("")) {
				sql="select * from orderinfo where date >= \'"+request.data1.substring(0,10)+"\' and date <= \'"+request.data2.substring(0,10)+"\'";
			}else {
				sql="select * from orderinfo where orderid = \'"+request.num+"\' and date >= \'"+request.data1.substring(0,10)+"\' and date <= \'"+request.data2.substring(0,10)+"\'";
			}
			System.out.print(sql);
			Statement stmt=(Statement)conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				orderListEntity temp = new orderListEntity();
				temp.setNum(rs.getString("orderid"));
				temp.setName(rs.getString("goodsname"));
				temp.setSendtime(rs.getString("date"));
				temp.setStorage("Chengdu Local Storage");
				arrayList.add(temp);
			}
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
		}
		return arrayList;
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException  {
	}
}
