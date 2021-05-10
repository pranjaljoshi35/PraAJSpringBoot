package com.nagarro.web.dao;

import java.sql.*;
import com.nagarro.web.model.User;

public class UserDao {
	static public boolean getUser(String aid,String password)
	{
		User user=null;
		boolean isuser=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
			String sql="select * from logindetail where name = ? and password = ? ";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,aid);
			st.setString(2, password);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setAid(aid);
				user.setPassword(password);
				isuser=true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(user);
		return isuser;

	}
}
