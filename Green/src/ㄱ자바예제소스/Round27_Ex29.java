import java.io.*;
import java.sql.*;

public class Round27_Ex29 {
	public static void main(String[] args) throws IOException {
		Round27_Ex25 dm = Round27_Ex25.getInstance(true);
		Round27_Ex24 db = dm.getDbConn();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�о���� Clob Data�� Number = ");
		int num = Integer.parseInt(in.readLine());

		String query = "select * from ClobTable where num = ?";
		try {
			PreparedStatement pstmt = db.getPstmt(query);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			rs.next();// ����Ÿ�� �ϳ��ۿ� ���ٰ� ����~!!
			// Oracle�� �Է��ϴ� �޼ҵ�� java�� ������ �������� ���� java�� �ִ�~!
			Reader r = rs.getCharacterStream("data");
			// rs.getCharacterStream(2);
			char[] ch = new char[1024];
			StringBuffer data = new StringBuffer();
			while (true) {
				int xx = r.read(ch, 0, ch.length);
				if (xx == -1)
					break;
				data.append(ch, 0, xx);
			}
			r.close();
			rs.close();
			pstmt.close();
			System.out.println(num + " -> " + data.toString());
		} catch (SQLException ee) {
			System.err.println("�˻� ����");
		}
		dm.pooling();
	}
}
