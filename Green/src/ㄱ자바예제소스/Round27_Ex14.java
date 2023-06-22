import java.io.*;
import java.sql.*;
import java.util.*;

//Blob(binary type) Ÿ���� 2�Ⱑ����Ʈ���� ���尡��~!!

class MyPoint implements Serializable {
	private transient static BufferedReader in;
	static {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	private int x;

	private int y;

	public MyPoint() {
		try {
			System.out.print("x = ");
			x = Integer.parseInt(in.readLine());
			System.out.print("y = ");
			y = Integer.parseInt(in.readLine());
		} catch (IOException ee) {
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void disp() {
		System.out.println("�� (" + x + ", " + y + ")");
	}
}

public class Round27_Ex14 {
	public static void main(String[] at) throws IOException {
		Vector vc = new Vector();
		while (true) {
			System.out.print("1.�߰� 2.���� = ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				MyPoint mp = new MyPoint();
				vc.add(mp);
			} else if (x == 2) {
				// DB�� ����
				try {
					Class.forName("org.gjt.mm.mysql.Driver");
				} catch (ClassNotFoundException ee) {
				}
				Connection conn = null;
				PreparedStatement pstmt = null;
				String url = "jdbc:mysql://localhost:3306/java";
				String id = "root";
				String pass = "12345678";
				String query = "insert into Round27_Ex14Table values (null, ?)";
				try {
					conn = DriverManager.getConnection(url, id, pass);
					pstmt = conn.prepareStatement(query);
					pstmt.setObject(1, vc);// BlobŸ�Կ����� setObject()�޼ҵ带 ���!!
					pstmt.executeUpdate();
					pstmt.close();
				} catch (SQLException ee) {
				}
				System.exit(0);
			} else {
				System.out.println("�߸� �Է�!!");
			}
		}
	}
}
