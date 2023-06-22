import java.util.Vector;

public class Round27_Ex25 {
	private static Vector db_conn;// DbConn ��ü ����

	private static Vector db_status;// DbConn ��뿩�� 0:������, 1:����ϰ� ����.

	private static Vector db_bool;// ���� ���� ���� true:���ð�ü, false:���ø� ��ü.
	static {
		if (db_conn == null || db_status == null || db_bool == null) {
			db_conn = new Vector();
			db_status = new Vector();
			db_bool = new Vector();
		}
	}

	private int pos = -1;

	public Round27_Ex25(boolean bool) {
		pos = -1;
		for (int i = 0; i < db_bool.size(); i++) {
			if (db_bool.elementAt(i).equals(String.valueOf(bool))) {
				// DB Pool�� �����̳� ���ý� ��ü�� �ش��ϴ� ��ü�� �����ϴ��� �˻�.
				if (db_status.elementAt(i).equals(String.valueOf("0"))) {
					// ã�� ��ü�� ��������� �ƴ��� �˻�.
					pos = i;
					break;
				}
			}
		}
		if (pos == -1) {// ���� DB Pool���� ��밡���� ��ü�� ����. �׷���...
			// ��밡���� ��ü�� ����.
			Round27_Ex24 dc = Round27_Ex24.getInstance(bool);
			db_conn.add(dc);
			db_status.add("0");
			db_bool.add(String.valueOf(bool));
			pos = db_conn.size() - 1;// Vector�� 0���� �����ϱ� ������ ������ ���� ��¡��ϱ�
										// ���ؼ��� -1�� ���ش�.
		}
	}

	public static Round27_Ex25 getInstance(boolean bool) {
		// DbMgr�� ��ü�� ����鼭 ������ ������� ��ü�� ����� �� �ִ��� �����Ͽ� ��pos��� field�� �� ��ġ����
		// �����Ѵ�.
		return new Round27_Ex25(bool);
	}

	public Round27_Ex24 getDbConn() {
		// DbMgr�� ��ü�� ���� ����� �� �ִ� ��ü�� ��ġ�� ���� DbConn�� ��ü�� ȹ����Ѵ�.
		Round27_Ex25.db_status.setElementAt("1", pos);
		return (Round27_Ex24) Round27_Ex25.db_conn.elementAt(pos);
	}

	public void pooling() {
		// ����� ����� DbConn�� ��ü�� ���°��� 1 -> 0���� ������� ������ ����� ��� �ִ� ���¶�� ���� �˷��ش�.
		db_bool.setElementAt("0", pos);
	}
}
