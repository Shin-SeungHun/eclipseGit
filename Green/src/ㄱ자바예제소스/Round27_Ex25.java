import java.util.Vector;

public class Round27_Ex25 {
	private static Vector db_conn;// DbConn 객체 저장

	private static Vector db_status;// DbConn 사용여부 0:사용안함, 1:사용하고 있음.

	private static Vector db_bool;// 로컬 실행 여부 true:로컬객체, false:애플릿 객체.
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
				// DB Pool에 로컬이나 애플식 객체에 해당하는 객체가 존재하는지 검색.
				if (db_status.elementAt(i).equals(String.valueOf("0"))) {
					// 찾은 객체가 사용중인지 아닌지 검색.
					pos = i;
					break;
				}
			}
		}
		if (pos == -1) {// 현재 DB Pool에는 사용가능한 객체가 없다. 그래서...
			// 사용가능한 객체를 만듦.
			Round27_Ex24 dc = Round27_Ex24.getInstance(bool);
			db_conn.add(dc);
			db_status.add("0");
			db_bool.add(String.valueOf(bool));
			pos = db_conn.size() - 1;// Vector는 0부터 시작하기 때문에 마지막 값을 출력→하기
										// 위해서는 -1을 해준다.
		}
	}

	public static Round27_Ex25 getInstance(boolean bool) {
		// DbMgr의 객체를 만들면서 기존에 만들어진 객체를 사용할 수 있는지 조사하여 →pos라는 field에 그 위치값을
		// 저장한다.
		return new Round27_Ex25(bool);
	}

	public Round27_Ex24 getDbConn() {
		// DbMgr의 객체를 통해 사용할 수 있는 객체의 위치를 통해 DbConn의 객체를 획→득한다.
		Round27_Ex25.db_status.setElementAt("1", pos);
		return (Round27_Ex24) Round27_Ex25.db_conn.elementAt(pos);
	}

	public void pooling() {
		// 사용이 종료된 DbConn의 객체는 상태값을 1 -> 0으로 변경시켜 다음에 사용할 →수 있는 상태라는 것을 알려준다.
		db_bool.setElementAt("0", pos);
	}
}
