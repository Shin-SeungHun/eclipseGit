import java.io.*;
import java.sql.*;
import java.util.*;

public class Round27_Ex15 {
	public static void main(String[] args) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
		}
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pass = "12345678";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from Round27_Ex14Table";
		Vector vc = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			int number = rs.getInt(1);// 1Àº number
			ObjectInputStream ois = null;
			try {
				Blob blob = rs.getBlob(2);// 2´Â data
				InputStream is = blob.getBinaryStream();
				ois = new ObjectInputStream(is);
				vc = (Vector) ois.readObject();
				ois.close();
			} catch (IOException eee) {
			} catch (ClassNotFoundException eee) {
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
		}
		for (int i = 0; i < vc.size(); i++) {
			MyPoint mp = (MyPoint) vc.elementAt(i);
			mp.disp();
		}
	}
}
