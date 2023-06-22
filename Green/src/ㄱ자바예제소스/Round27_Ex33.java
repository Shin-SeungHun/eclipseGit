import java.sql.*;

public class Round27_Ex33 {
	public static void main(String[] args) {
		Round27_Ex25 dm = Round27_Ex25.getInstance(false);
		Round27_Ex24 db = dm.getDbConn();

		String query = "drop table Round27_Ex33Table";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("테이블 삭제 성공~!");
		} catch (SQLException ee) {
			System.err.println("테이블 삭제 실패!!");
		}
		query = "create table Round27_Ex33Table (goodsname varchar(20), goodsnum int, seller varchar(20))";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("테이블 생성 성공~!");
		} catch (SQLException ee) {
			System.err.println("테이블 생성 실패!!");
		}
		query = "drop table Round27_Ex34Table";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("테이블 삭제 성공~!");
		} catch (SQLException ee) {
			System.err.println("테이블 삭제 실패!!");
		}
		query = "create table Round27_Ex34Table (goodsname varchar(20), goodsnum int, buyer varchar(20))";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("테이블 생성 성공~!");
		} catch (SQLException ee) {
			System.err.println("테이블 생성 실패!!");
		}
		query = "insert into Round27_Ex33Table values (?, ?, ?)";
		try {
			PreparedStatement pstmt = db.getPstmt(query);
			pstmt.setString(1, "필통");
			pstmt.setInt(2, 10);
			pstmt.setString(3, "KIM");
			pstmt.executeUpdate();
			pstmt.setString(1, "연필");
			pstmt.setInt(2, 100);
			pstmt.setString(3, "LEE");
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("상품 등록 성공~!");
		} catch (SQLException ee) {
			System.err.println("상품 등록 실패!!");
		}
		dm.pooling();
	}
}
