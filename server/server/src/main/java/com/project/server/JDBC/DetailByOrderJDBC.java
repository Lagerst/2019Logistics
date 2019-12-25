package com.project.server.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.project.server.searchOrder.Neworder;
import com.project.server.searchOrder.infoEntity;
import com.project.server.searchOrder.infoRequest;
import com.project.server.searchOrder.orderListEntity;
import com.project.server.searchOrder.storageListEntity;

public class DetailByOrderJDBC {
	public static List<infoEntity> Get(infoRequest request) throws SQLException, ClassNotFoundException {
		if (request.num.charAt(request.num.length()-1)=='E') {
			System.out.print("\nsearching external:"+request.num.substring(0,request.num.length()-1)+"\n");
			return External_Data_Source.Get(request.num.substring(0,request.num.length()-1));
		}
		List<infoEntity> arrayList = new ArrayList<infoEntity>();
		try {
			String URL = "jdbc:postgresql://localhost:5432/express1";
			String userName = "postgres";
			String passWord = "123";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(URL,userName,passWord);
			System.out.println("Getting...");
			String sql="select * from expressinfo where orderid = \'"+request.num+"\'";
			Statement stmt=(Statement)conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				infoEntity temp = new infoEntity();
				temp.setContent(rs.getString("location"));
				temp.setTimestamp(rs.getString("date"));
				arrayList.add(temp);
			}
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
		}
		return arrayList;
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		//Test
	}
}
