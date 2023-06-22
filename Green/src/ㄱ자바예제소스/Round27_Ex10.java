package ㄱ자바예제소스;

import java.sql.*;

public class Round27_Ex10 {
	private Connection dc;

	public Round27_Ex10() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			return;
		}
		String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pass = "qwer";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
	}

	// 회원가입을 위해서...
	public boolean registerMember(String id, String pw, String name, String hp, String sex) {
		String query = "insert into tb_member2 values (null, ?, ?, ?, ?, ?)";
		// 테이블 이름 수정!
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, hp);
			pstmt.setString(5, sex);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("회원 가입 실패!! : " + ee.toString());
			return false;
		}
		return true;
	}

	// login을 위해서...
	public boolean loginMember(String id, String pw) {
		String query = "select * from tb_member2 where id = ? and pw = ?";
		// 테이블 이름 수정!
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				rs.close();
				pstmt.close();
				return false; // 결과값이 false면 리턴
			}
			rs.close();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("login 처리 실패!!");
		}
		return true;
	}

	// 회원 정보수정을 위해서...
	public boolean editMember(String id, String pw, String name, String hp, String sex) {
		String query = "update tb_member2 set id = ?, pw = ?, name = ?, hp= ? ,sex= ? where id = ?";
		// 테이블 이름 수정!
		try {
			PreparedStatement pstmt = dc.prepareStatement(query); // statement 그냥 실행 / preparedStatement ? 동작
			pstmt.setString(1, id); // 아이디 조회
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, hp);
			pstmt.setString(5, sex);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("회원 정보수정 실패!!");
			return false; // 결과값이 false면 리턴
		}
		return true;
	}

	// 회원삭제를 위해서...
	public boolean deleteMember(String id) {
		String query = "delete from tb_member2 where id = ?";
		// 테이블 이름 수정!

		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("회원 삭제 실패!!");
			return false; // 결과값이 false면 리턴
		}
		return true;
	}

	public void dataLoad() {

		String query = "select * from tb_member2";
		try {

			Statement stmt = dc.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			String result = "";
			while (rs.next()) {
//				result = rs.getString("idx") + " / " + rs.getString("id") + " / " + rs.getString("pw") + " / "
//						+ rs.getString("name") + " / " + rs.getString("hp") + " / " + rs.getString("sex");
				result = rs.getString(1) + " / " + rs.getString(2) + " / " + rs.getString(3) + " / " + rs.getString(4)
						+ " / " + rs.getString(5) + " / " + rs.getString(6);
				System.out.println("회원: " + result);
			}
			System.out.println();
			rs.close();
			stmt.close();
			dc.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString()); // 에러표시
		}

	}
}
