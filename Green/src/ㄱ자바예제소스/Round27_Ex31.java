import java.sql.*;

public class Round27_Ex31 {
	public static void main(String[] args) {
		Round27_Ex25 dm = Round27_Ex25.getInstance(false);
		Round27_Ex24 db = dm.getDbConn();

		String query = "create or replace procedure myproc "
				+ "(n in varchar, a out int) is begin "
				+ "select age into a from ProcedureTable where name = n;"
				+ "end;";
		// void myproc (String n, int a){
		// select * from ... where name = n;
		// }
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("프로시저 생성 성공~!");
		} catch (SQLException ee) {
			System.err.println("프로시저 업데이트 실패 = " + ee.toString());
		}
		dm.pooling();		
	}
}
