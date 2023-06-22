package ㄱ자바예제소스;

import java.sql.*;

public class Round27_Ex03 {
	public static void main(String[] args) {
		// 1. 드라이브를 검색 (Readme.txt 참조)
		// oracle => com.oracle.OracleDriver
		// my-sql => org.gjt.mm.mysql.Driver
		// odbc => jdbc.odbc.JdbcOdbcDriver : jdk1.2 이상에서는 기본설치
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
//			System.out.println("드라이브가 있습니당~! ^_^v");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브 없음!!");
		}
		// 2. Connection 객체생성 (Readme.txt 참조)
		// Connection conn = DriverManager.getConnection(
		// "protocol:subprotocol:sid", "id", "pass");
		// oracle => "jdbc:oracle:thin@124.61.53.124:1521/java"
		// my-sql => "jdbc:mysql://124.61.53.124:3306/java"
		// odbc => "jdbc:odbc:java"
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
		String user = "root";// ID
		String password = "qwer";// 비밀번호
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결되었습니다.");
		} catch (SQLException ee) {
			System.err.println("연결객체 생성실패!!");
		}
		// 3. Query 실행 클래스 생성
		// Statement stmt = conn.createStatement();
		// PrepareStatment pstmt = conn.prepareStatement(query);

		Statement stmt = null;
		String pquery = "insert into tb_member2 values (null, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, "abc1");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "김춘향");
			pstmt.setString(4, "01011111");
			pstmt.setString(5, "여자");
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
		// 4. ResultSet 객체생성
		// ResultSet rs = stmt.executeQuery(query);
		// ResultSet rs = pstmt.executeQuery();
		String query = "select * from tb_member2";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String sex = rs.getString("sex");
				System.out.println(idx + " : " + id + " : " + pw + " : " + name + " : " + hp + " : " + sex);
			}
		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}
		// 5. Close 작업
		try {
			rs.close();
			pstmt.close();
			stmt.close();
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("닫기 실패~!!");
		}
	}
}
