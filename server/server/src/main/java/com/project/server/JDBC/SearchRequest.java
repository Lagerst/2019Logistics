package com.project.server.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.server.searchOrder.orderListEntity;
import com.project.server.searchOrder.storageListEntity;
import com.project.server.searchOrder.storageRequest;

public class SearchRequest {
	public static List<storageListEntity> Get(storageRequest storagenum,String storeid)throws SQLException, ClassNotFoundException{
		List<storageListEntity> arrayList = new ArrayList<storageListEntity>();
		int res=0;
		String URL = "jdbc:postgresql://localhost:5432/express1";
		String userName = "postgres";
		String passWord = "123";
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(URL,userName,passWord);
		System.out.println("Comparing...");
		String sql="select * from storageinfo where storeid = \'"+storeid+"\'";
		Statement stmt=(Statement)conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while (rs.next()) {
			storageListEntity temp=new storageListEntity();
			temp.setNum(rs.getString("num"));
			temp.setName(rs.getString("name"));
			temp.setQuantity(rs.getString("quantity"));
			temp.setType(rs.getString("type"));
			arrayList.add(temp);
		}
		stmt.close();
		conn.close();
		return arrayList;
	}
}
