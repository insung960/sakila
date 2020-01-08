package sakila.service;

import java.sql.*;

// connection 수정될 수 있는 반복되는 코드를 간단히 하기 위해 패키지 생성
public class DBHelper {
	public static Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/sakila", "root", "java1234");
		//Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/insung960", "insung960", "deepdark0");
		return conn;
	}
	
// finally에서 rs,stmt,conn을 종료시켜주는 문이 매번 반복되기떄문에 줄이기 위한 메소드
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(stmt != null) {
			try {
				stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}