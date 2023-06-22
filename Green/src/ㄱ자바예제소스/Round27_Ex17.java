import java.io.*;
import java.sql.*;

public class Round27_Ex17 {
	public static void main(String[] args) throws Exception {
		Class.forName("org.gjt.mm.mysql.Driver");
		String url = "jdbc:mysql://localhost:3306/java";
		String id = "root";
		String pass = "12345678";
		String query = "select * from Round27_Ex16Table";
		Connection conn = DriverManager.getConnection(url, id, pass);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		int number = rs.getInt("number");
		String filename = rs.getString("filename");
		Blob blob = rs.getBlob("file");
		InputStream is = blob.getBinaryStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		File file = (File) ois.readObject();
		ois.close();
		rs.close();
		stmt.close();
		conn.close();
		BufferedReader in = new BufferedReader(new FileReader(file));
		System.out.println("number = " + number);
		System.out.println("filename = " + filename);
		while (true) {
			String str = in.readLine();
			if (str == null)
				break;
			System.out.println(str);
		}
		in.close();
	}
}
