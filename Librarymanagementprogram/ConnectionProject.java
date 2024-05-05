package Ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionProject {
	public static void main(String[] args) {
//		Connection conn = null;
//		try {
//	Class.forName("oracle.jdbc.OracleDriver");
//	conn = DriverManager.getConnection(
//			"jdbc:oracle:thin:@localhost:1521/xe",
//			"scott",
//			"tiger"
//			);
//	String sql = "insert into librarydb (title,author,publisher,price)" +
//			"VALUES ((varchr2(20),varchar2(10),varchar2(20),number(5))";
//	
//	Scanner sc = new Scanner(System.in);
//	String user = sc.nextLine(); 
//	user = sql; 
//	
//	PreparedStatement pstmt = conn.prepareStatement(sql);
//	pstmt.setString(1,sql);
//	pstmt.setString(2,sql);
//	pstmt.setString(3,sql);
//	pstmt.setString(4,sql);
//	
//	int rows = pstmt.executeUpdate();
//	System.out.println("저장된 행 수: " + rows);
//	
//	if(rows == 1) {
//		ResultSet rs = pstmt.getGeneratedKeys();
//		if(rs.next()) {
//			int bno = rs.getInt(1);
//			System.out.println("저장된 bno: " + bno);
//		}
//		rs.close();
//	}
//	
//	//PreparedStatement 닫기
//	pstmt.close();
//	sc.close();	
//		} catch (Exception e) {
//			e.printStackTrace();	
//		}finally {
//			if(conn != null) {
//				try { 
//					//연결 끊기
//					conn.close(); 
//				} catch (SQLException e) {}
//			}
//		}
		Connection conn = null;
		PreparedStatement = null;
		ResultSet rs = null;
		int cnt = 0;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id= "id";
		String db_pw = "pw";
		conn =DriverManager.getConnection(db_url,db_id,db_pw);
		
		String sql = "insert into modell values(?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setSting(1,title);
		psmt.setString(1,athor);
		
		
		
	}	
}