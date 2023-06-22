import java.io.*;
import java.sql.*;

public class Round27_Ex34 {
	public static void main(String[] args) throws IOException {
		Round27_Ex25 dm = Round27_Ex25.getInstance(false);
		Round27_Ex24 db = dm.getDbConn();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("구입한 물건은 = ");
		String goodsname = in.readLine();
		System.out.print("구입할 개수는 = ");
		int goodsnum = Integer.parseInt(in.readLine());
		System.out.print("구매자 이름 = ");
		String buyer = in.readLine();

		Connection conn = db.getConn();
		boolean trust = true;
		try {
			conn.setAutoCommit(false);
		} catch (SQLException ee) {
			trust = false;
		}

		String query = "insert into Round27_Ex34Table values (?, ?, ?)";
		try {
			PreparedStatement pstmt = db.getPstmt(query);
			pstmt.setString(1, goodsname);
			pstmt.setInt(2, goodsnum);
			pstmt.setString(3, buyer);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
			trust = false;
		}

		query = "update Round27_Ex33Table set goodsnum = (goodsnum - ?) where goodsname = ?";
		try {
			PreparedStatement pstmt = db.getPstmt(query);
			pstmt.setInt(1, goodsnum);
			pstmt.setString(2, goodsname);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("error1 = " + ee.toString());
			trust = false;
		}

		try {
			if (trust) {
				conn.commit();
				System.out.println("Commit 되었습니다.");
				conn.setAutoCommit(true);
			} else {
				conn.rollback();
				System.out.println("Rollback 되었습니다.");
			}
		} catch (SQLException ee) {
			System.err.println("Transaction Error = " + ee.toString());
		}
		dm.pooling();
	}
}
