import java.sql.*;
import java.util.Date;
import java.io.*;

public class Round27_Ex24 {
	private Connection conn;// 외부에서 접근하지 못하게 private으로 설정!!

	private static PrintWriter log_out;
	static {
		try {
			log_out = new PrintWriter(new BufferedWriter(new FileWriter(
					new File("debug.log"), true)));
			log_out.flush();
		} catch (IOException ee) {
		}
	}
	
	private Round27_Ex24(boolean local) {
		String driver = "", url = "", id = "", pass = "";
		if (local) {// local에서 실행할 경우
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(new File("db.property")));
				driver = in.readLine();
				url = in.readLine();
				id = in.readLine();
				pass = in.readLine();
				in.close();
				log_out
						.println(new java.util.Date()
								+ " : db.property read!\n");
				log_out.flush();
			} catch (IOException ee) {
				log_out.println(new java.util.Date()
						+ " : db.property Error = " + ee.toString() + "\n");
				log_out.flush();
			}
		} else {// 웹 애플릿에서 실행할 경우
			driver = "org.gjt.mm.mysql.Driver";
			url = "jdbc:mysql://localhost:3306/java";
			id = "root";
			pass = "12345678";
			log_out.println(new java.util.Date() + " : auto set sucess!\n");
			log_out.flush();
		}

		try {
			Class.forName(driver);
			log_out.println(new java.util.Date()
					+ " : Driver Search Success!\n");
			log_out.flush();
		} catch (ClassNotFoundException ee) {
			log_out.println(new java.util.Date() + " : Driver Search Fail = "
					+ ee.toString() + "\n");
			log_out.flush();
		}

		try {
			conn = DriverManager.getConnection(url, id, pass);
			log_out.println(new java.util.Date() + " : Conn Create Success!\n");
			log_out.flush();
		} catch (SQLException ee) {
			log_out.println(new java.util.Date() + " : Conn Create Fail = "
					+ ee.toString() + "\n");
			log_out.flush();
		}
	}

	public static Round27_Ex24 getInstance(boolean bool) {
		log_out.println(new java.util.Date() + " : DbConn Instance Create!\n");
		log_out.flush();
		return new Round27_Ex24(bool);
	}

	public void close() {
		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
					log_out.println(new java.util.Date()
							+ " : conn Close Success!\n");
					log_out.flush();
				}
			} catch (SQLException ee) {
				log_out.println(new java.util.Date() + " : conn Close Fail = "
						+ ee.toString() + "\n");
				log_out.flush();
			}
			conn = null;
		}
	}
	public Connection getConn() { return conn; }
	public Statement getStmt() {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			log_out.println(new java.util.Date()
					+ " : Statement Create Success!\n");
			log_out.flush();
		} catch (SQLException ee) {
			log_out.println(new java.util.Date()
					+ " : Statement Create Fail = " + ee.toString() + "\n");
			log_out.flush();
		}
		return stmt;
	}

	public PreparedStatement getPstmt(String query) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			log_out.println(new java.util.Date()
					+ " : PreparedStatement Create Success!\n");
			log_out.flush();
		} catch (SQLException ee) {
			log_out.println(new java.util.Date()
					+ " : PreparedStatement Create Fail = " + ee.toString()
					+ "\n");
			log_out.flush();
		}
		return pstmt;
	}

	public CallableStatement getCall(String query) {
		CallableStatement call = null;
		try {
			call = conn.prepareCall(query);
			log_out.println(new java.util.Date()
					+ " : CallableStatement Create Success!\n");
			log_out.flush();
		} catch (SQLException ee) {
			log_out.println(new java.util.Date()
					+ " : CallableStatement Create Fail = " + ee.toString()
					+ "\n");
			log_out.flush();
		}
		return call;
	}
}
