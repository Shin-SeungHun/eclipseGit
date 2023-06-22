import java.sql.*;

public class Round27_Ex30 {
	public static void main(String[] args) {
		Round27_Ex25 dm = Round27_Ex25.getInstance(true);
		Round27_Ex24 db = dm.getDbConn();

		String query = "drop table Round27_Ex30Table";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("삭제 성공~!");
		} catch (SQLException ee) {
			System.err.println("테이블 삭제 에러!!");
		}
		query = "create table Round27_Ex30Table (name varchar(20), age int)";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("테이블 생성 성공~!");
		} catch (SQLException ee) {
			System.err.println("테이블 생성 에러!!");
		}
		query = "insert into Round27_Ex30Table values (?, ?)";
		try {
			PreparedStatement pstmt = db.getPstmt(query);
			for (int i = 0; i < 26; i++) {
				pstmt.setString(1, "" + (char) (i + 65) + (char) (i + 65)
						+ (char) (i + 65));
				pstmt.setInt(2, (int) (Math.random() * 60));
				pstmt.executeUpdate();
			}
			pstmt.close();
			System.out.println("데이터 삽입 성공~!");
		} catch (SQLException ee) {
			System.err.println("테이블 생성 에러!!");
		}
		dm.pooling();
	}
}
