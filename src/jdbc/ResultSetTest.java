package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {

	public static void main(String[] args) throws SQLException{
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/devstudy", "devstudy",
				"password")){
			try (Statement st = c.createStatement()){
				try(ResultSet rs = st.executeQuery("select * from student")){
					while (rs.next()) {
						System.out.println(rs.getLong(1)+", "+rs.getString(2)+", "+rs.getShort(3)+", "+rs.getInt(4));
					}
				}
				System.out.println("----------------------------------------");
				try (ResultSet rs = st.executeQuery("select * from student")){
					while (rs.next()) {
						System.out.println(rs.getLong("id")+", "+rs.getString("firstName")+", "+rs.getString("lastName")+", "+rs.getInt("age"));
					}
				}
			}
		}
	}

}
