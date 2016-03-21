package com.gontuseries.dtucontroller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStudent {
	
//	@Autowired
//	private DataSource dataSource;

	public Student getStudentInfo(String username, String password) {
		Connection conn =null;
		
		try {
			String driver = "org.apache.derby.jdbc.ClientDriver";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
//			conn = dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Student where USERNAME = ?");
					
			ps.setString(1, username);
//			ps.setString(2, password);
			
			Student stu = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				stu = new Student(rs.getString("studentName"), rs.getString("branch"),rs.getDouble("aggregate"), rs.getInt(4), username, rs.getString(6));
			}
			rs.close();
			ps.close();
			return stu;
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			try{
				conn.close();
			}
			catch(SQLException e) {}
		
			
			
					
			
		}
	}
	
	
	
}
