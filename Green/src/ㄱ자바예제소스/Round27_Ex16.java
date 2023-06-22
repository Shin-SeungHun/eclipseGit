import java.io.*;
import java.sql.*;

public class Round27_Ex16 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
		}
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pass = "12345678";
		String query = "insert into Round27_Ex16Table values (null, ?, ?)";
		try {
			Connection conn = DriverManager.getConnection(url, id, pass);
			PreparedStatement pstmt = conn.prepareStatement(query);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.print("ÆÄÀÏ = ");
			String filestr = in.readLine();
			File file = new File(filestr);
			pstmt.setString(1, file.getName());
			pstmt.setObject(2, file);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
		} catch (IOException ee) {
		}
	}
}
