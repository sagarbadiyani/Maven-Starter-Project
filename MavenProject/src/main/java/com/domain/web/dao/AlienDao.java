package com.domain.web.dao;

import com.domain.web.model.Alien;
import java.sql.*;
public class AlienDao {
	String url = "jdbc:mysql://localhost:3306/mario";
	String uname = "root";
	String pass = "password";
	String query = "select * from gadgets where gid = ?";
	
	public Alien getAlien(int gid) throws ClassNotFoundException, SQLException {
		Alien a = new Alien();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, gid + "");
		ResultSet rs = st.executeQuery();
		
//		System.out.println("Batao");
		if(rs.next()) {
			a.setGid(rs.getInt("gid"));
			a.setGname(rs.getString("gname"));
			a.setPrice(rs.getInt("price"));
			System.out.println(a);
		}
		
		
		
		return a;
	}
}
