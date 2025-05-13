package Java_project;

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","Mukti@2003");
			s = c.createStatement();
		} catch (Exception e){
			e.printStackTrace();
			
		}
	}
}
