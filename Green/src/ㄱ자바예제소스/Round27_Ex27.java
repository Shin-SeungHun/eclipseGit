import java.sql.*;

//Clob(char type) 타입에는 4기가바이트까지 데이타를 저장가능~!
public class Round27_Ex27 {
	public static void main(String[] args) {
		Round27_Ex25 dm = Round27_Ex25.getInstance(true);
		Round27_Ex24 db = dm.getDbConn();

		String query = "drop table Round27_Ex27Table";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("삭제 성공!!");
		} catch (SQLException ee) {
			System.err.println("해당 테이블이 없습니다.");
		}
		query = "create table Round27_Ex27Table (num int, data clob)";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("테이블 생성 성공!!");
		} catch (SQLException ee) {
			System.err.println("테이블 생성 에러 : " + ee.toString());
		}
		dm.pooling();
	}
}
