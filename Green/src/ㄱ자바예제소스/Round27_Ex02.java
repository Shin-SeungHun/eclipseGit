package ㄱ자바예제소스;

import java.sql.*;

public class Round27_Ex02 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		//데이터베이스와 연결하는 객체
		Connection conn = null;
		// 접속 주소 : 3306/db이름
		//  데이터베이스에 연결하기 위한 정보
		String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
//		String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "qwer";
		Statement stmt = null; //Connection으로 연결한 객체에게, Query 작업을 실행하기 위한 객체.
		ResultSet rs = null; //조회된 목록들의 저장된 객체를 반환
		String query = "select * from tb_member";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement(); // Statement객체를 생성
			rs = stmt.executeQuery(query); // 조회문(select, show 등)을 실행할 목적으로 사용
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + " : " + rs.getString(2) + " / " + rs.getString(3) + " / " + rs.getString(4));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString()); //에러표시
		}
	}
}
