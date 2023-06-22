import java.io.*;
import java.sql.*;

public class Round27_Ex05 {
	public static void main(String[] args) throws IOException {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
		}
		Connection conn = null;
		String url = "jdbc:mysql://124.61.53.124:3306/java";
		// "jdbc:mysql://localhost:3306/java"
		String id = "root";
		String pass = "12345678";
		PreparedStatement pstmt = null;
		String pquery = "select * from zipcode where dong like ?";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
		} catch (SQLException ee) {
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("검색할 데이터는 ? ");
			String str = in.readLine();
			try {
				pstmt.setString(1, "%" + str + "%");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt(1) + " : " + rs.getString(2)
							+ " : " + rs.getString(3) + " : " + rs.getString(4)
							+ " : " + rs.getString(5) + " : " + rs.getString(6)
							+ " : " + rs.getString(7));
				}
				rs.close();
			} catch (SQLException ee) {
			}
		}
	}
}
