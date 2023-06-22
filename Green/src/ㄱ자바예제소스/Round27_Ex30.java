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
			System.out.println("���� ����~!");
		} catch (SQLException ee) {
			System.err.println("���̺� ���� ����!!");
		}
		query = "create table Round27_Ex30Table (name varchar(20), age int)";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("���̺� ���� ����~!");
		} catch (SQLException ee) {
			System.err.println("���̺� ���� ����!!");
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
			System.out.println("������ ���� ����~!");
		} catch (SQLException ee) {
			System.err.println("���̺� ���� ����!!");
		}
		dm.pooling();
	}
}
