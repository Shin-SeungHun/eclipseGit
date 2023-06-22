	import java.sql.*;
	
	public class Round27_Ex26 {
		public static void main(String[] args){
	Round27_Ex25 dm = Round27_Ex25.getInstance(false);

			Round27_Ex24 dc = dm.getDbConn();
			try{
				Statement stmt = dc.getStmt();
				String query = "select * from Round27_Ex22Table";
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					String msg = rs.getString("message");
					System.out.println("message = " + msg);
				}
				rs.close();
				stmt.close();
			}catch(SQLException ee){
				System.err.println("error = " + ee.toString());
			}
			dm.pooling();
		}
	}
