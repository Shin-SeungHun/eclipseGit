import java.sql.*;

//Clob(char type) Ÿ�Կ��� 4�Ⱑ����Ʈ���� ����Ÿ�� ���尡��~!
public class Round27_Ex27 {
	public static void main(String[] args) {
		Round27_Ex25 dm = Round27_Ex25.getInstance(true);
		Round27_Ex24 db = dm.getDbConn();

		String query = "drop table Round27_Ex27Table";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("���� ����!!");
		} catch (SQLException ee) {
			System.err.println("�ش� ���̺��� �����ϴ�.");
		}
		query = "create table Round27_Ex27Table (num int, data clob)";
		try {
			Statement stmt = db.getStmt();
			stmt.executeUpdate(query);
			stmt.close();
			System.out.println("���̺� ���� ����!!");
		} catch (SQLException ee) {
			System.err.println("���̺� ���� ���� : " + ee.toString());
		}
		dm.pooling();
	}
}
