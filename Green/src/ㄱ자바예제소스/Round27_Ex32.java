import java.io.*;
import java.sql.*;

public class Round27_Ex32 {
	public static void main(String[] args) throws IOException {
		Round27_Ex25 dm = Round27_Ex25.getInstance(true);
		Round27_Ex24 db = dm.getDbConn();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("누구의 나이를 알고 싶습니까? = ");
		String name = in.readLine();
		String query = "{call myproc(?, ?)}";
		try {
			CallableStatement call = db.getCall(query);
			call.setString(1, name);
			call.registerOutParameter(2, Types.INTEGER);
			call.executeQuery();
			// ResultSet rs = call.getResultSet();
			int age = call.getInt(2);
			System.out.println(name + "님의 나이는 " + age + "세 이십니다.");
			call.close();
		} catch (SQLException ee) {
			System.err.println("Call 에러 = " + ee.toString());
		}
		dm.pooling();		
	}
}
