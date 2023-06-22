import java.sql.*;
import java.io.*;

public class Round27_Ex04 {
	public static void main(String[] args) throws IOException {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.err.println("error = " + ee.getMessage());
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://124.61.53.124:3306/java";
		String id = "root";
		String pass = "12345678";
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "insert into Round27_Ex04Table values (null, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(query);
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
			System.exit(0);
		}
		// DB 기초작업 끝~!!
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("1.입력  2.출력  3.종료 = ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				System.out.print("이 름 : ");
				String name = in.readLine();
				System.out.print("주민번호 : ");
				String jumin = in.readLine();
				try {
					pstmt.setString(1, name);
					pstmt.setString(2, jumin);
					pstmt.executeUpdate();
				} catch (SQLException ee) {
				}
			} else if (x == 2) {
				try {
					rs = stmt.executeQuery("select * from Round27_Ex04Table");
					while (rs.next()) {
						System.out.println(rs.getInt("num") + " : "
								+ rs.getString("name") + ", "
								+ rs.getString("jumin"));
						// System.out.println(
						// rs.getInt(1) + " : " +
						// rs.getString(2) + ", " +
						// rs.getString(3));
					}
					rs.close();
				} catch (SQLException ee) {
				}
			} else if (x == 3)
				break;
			else
				System.err.println("잘못 입력!!");
		}
		// DB 종료!!
		try {
			conn.close();
		} catch (Exception ee) {
		}
	}
}
