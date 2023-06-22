import java.sql.*;
import java.io.*;

import oracle.jdbc.driver.*;//OracleResultSet을 사용하기 위해 import.
import oracle.sql.*;//CLOB을 사용하기 위해 import.

public class Round27_Ex28 {
	public static void main(String[] args) throws IOException {
		Round27_Ex25 dm = Round27_Ex25.getInstance(true);
		Round27_Ex24 db = dm.getDbConn();
		Connection conn = db.getConn();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException ee) {
		}
		String query = "insert into Round27_Ex27Table values (?, empty_clob())";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("num = ");
		int num = Integer.parseInt(in.readLine());
		try {
			PreparedStatement pstmt = db.getPstmt(query);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("1차 데이타  입력 성공~!!");
		} catch (SQLException ee) {
			System.err.println("insert 실패 = " + ee.toString());
		}
		query = "select * from Round27_Ex27Table where num = ?";
		System.out.print("넣을 Chars Data = ");
		String data = in.readLine();
		try {
			PreparedStatement pstmt = db.getPstmt(query);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			CLOB clob = ((OracleResultSet) rs).getCLOB(2);
			// CLOB는 Empty Clob에 쓰기기능이 있다~! ^_^';;
			Writer out = clob.getCharacterOutputStream();
			out.write(data);
			out.close();
			rs.close();
			pstmt.close();
			System.out.println("최종 업로드 성공~!!");
		} catch (SQLException ee) {
			System.err.println("최종 업로드 실패 = " + ee.toString());
		}
		try {
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException ee) {
		}
		dm.pooling();
	}
}
