import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Round27_Ex18 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.err.println("드라이브 검색 오류!");
			System.exit(-1);
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pass = "12345678";
		try {
			conn = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
			System.err.println("접속 실패 = " + ee.toString());
			System.exit(-1);
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("저장할 메세지 = ");
		String msg = null;
		try {
			msg = in.readLine();
		} catch (IOException ee) {
		}
		// DB에 저장...
		String query = "insert into Round27_Ex18Table values (null, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, msg);
			java.util.Date d = new java.util.Date();
			long time = d.getTime();
			java.sql.Date dd = new java.sql.Date(time);
			pstmt.setDate(2, dd);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("Query Update 실패!");
		}
		// DB에 저장 완료...
		System.out.println("The End!!");
	}
}
