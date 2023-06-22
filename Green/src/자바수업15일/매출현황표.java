package 자바수업15일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class 매출현황표 {
	public static void main(String[] args) {
		JapagiHistory jj = new JapagiHistory();
	}
}

class JapagiHistory extends Frame {
	int MAX = 100;
	String goodsName[] = new String[MAX];
	int goodsPrice[] = new int[MAX];
	int goodsCnt[] = new int[MAX];
	int totCnt[] = new int[MAX]; // 누적판매량
	int totPrice[] = new int[MAX]; // 누적판매금액

	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	Label lbTitle = new Label("[[    매출현황표    ]]");
	Label lbGoods1 = new Label("상품1");
	Label lbGoods1Name = new Label("아메리카노");
	Label lbGoods1Cnt = new Label("현재10개");
	Label lbGoods1CntTot = new Label("누적판매량100개");
	Label lbGoods1Price = new Label("현재단가:4800원");
	Label lbGoods1PriceTot = new Label("총매출:480000원");

	Label lbGoods2 = new Label("상품2");
	Label lbGoods2Name = new Label("아메리카노");
	Label lbGoods2Cnt = new Label("현재10개");
	Label lbGoods2CntTot = new Label("누적판매량100개");
	Label lbGoods2Price = new Label("현재단가:4800원");
	Label lbGoods2PriceTot = new Label("총매출:480000원");

	Label lbGoods3 = new Label("상품3");
	Label lbGoods3Name = new Label("아메리카노");
	Label lbGoods3Cnt = new Label("현재10개");
	Label lbGoods3CntTot = new Label("누적판매량100개");
	Label lbGoods3Price = new Label("현재단가:4800원");
	Label lbGoods3PriceTot = new Label("총매출:480000원");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	JapagiHistory() {
		super("매출현황");
		dbCon();// 디비접속
		this.setSize(850, 330);
		this.init();// 화면레이아웃구성메서드
		start();
		dbDataLoad();
		this.setLocation(200, 200);
		this.setVisible(true);

	}

	void viewClose() {
		this.setVisible(false);
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);
		lbTitle.setFont(font25);
		lbTitle.setBounds(320, 50, 300, 30);

		this.add(lbGoods1);
		lbGoods1.setFont(font15);
		this.add(lbGoods1Name);
		lbGoods1Name.setFont(font15);
		this.add(lbGoods1Cnt);
		lbGoods1Cnt.setFont(font15);
		this.add(lbGoods1CntTot);
		lbGoods1CntTot.setFont(font15);
		this.add(lbGoods1Price);
		lbGoods1Price.setFont(font15);
		this.add(lbGoods1PriceTot);
		lbGoods1PriceTot.setFont(font15);

		this.add(lbGoods2);
		lbGoods2.setFont(font15);
		this.add(lbGoods2Name);
		lbGoods2Name.setFont(font15);
		this.add(lbGoods2Cnt);
		lbGoods2Cnt.setFont(font15);
		this.add(lbGoods2CntTot);
		lbGoods2CntTot.setFont(font15);
		this.add(lbGoods2Price);
		lbGoods2Price.setFont(font15);
		this.add(lbGoods2PriceTot);
		lbGoods2PriceTot.setFont(font15);

		this.add(lbGoods3);
		lbGoods3.setFont(font15);
		this.add(lbGoods3Name);
		lbGoods3Name.setFont(font15);
		this.add(lbGoods3Cnt);
		lbGoods3Cnt.setFont(font15);
		this.add(lbGoods3CntTot);
		lbGoods3CntTot.setFont(font15);
		this.add(lbGoods3Price);
		lbGoods3Price.setFont(font15);
		this.add(lbGoods3PriceTot);
		lbGoods3PriceTot.setFont(font15);

		lbGoods1.setBounds(30, 100, 80, 30);
		lbGoods1Name.setBounds(110, 100, 120, 30);
		lbGoods1Cnt.setBounds(230, 100, 100, 30);
		lbGoods1CntTot.setBounds(330, 100, 150, 30);
		lbGoods1Price.setBounds(480, 100, 150, 30);
		lbGoods1PriceTot.setBounds(630, 100, 200, 30);

		lbGoods2.setBounds(30, 150, 80, 30);
		lbGoods2Name.setBounds(110, 150, 120, 30);
		lbGoods2Cnt.setBounds(230, 150, 100, 30);
		lbGoods2CntTot.setBounds(330, 150, 150, 30);
		lbGoods2Price.setBounds(480, 150, 150, 30);
		lbGoods2PriceTot.setBounds(630, 150, 200, 30);

		lbGoods3.setBounds(30, 200, 80, 30);
		lbGoods3Name.setBounds(110, 200, 120, 30);
		lbGoods3Cnt.setBounds(230, 200, 100, 30);
		lbGoods3CntTot.setBounds(330, 200, 150, 30);
		lbGoods3Price.setBounds(480, 200, 150, 30);
		lbGoods3PriceTot.setBounds(630, 200, 200, 30);

	}

	void dbDataLoad() {
		String query = "select * from japangi";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			int i = 0;
			while (rs.next()) {
				// 결과값읽어오는곳 여기서 화면에 뿌려주면됨.
				goodsName[i] = rs.getString("name");
				goodsPrice[i] = rs.getInt("price");
				goodsCnt[i] = rs.getInt("count");

				totCnt[i] = rs.getInt("total");
				totPrice[i] = totCnt[i] * goodsPrice[i];
				i++;
			}

			// 디비로 배열에 저장후 출력호출
			output();

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	//출력 메소드
	void output() {

		lbGoods1Name.setText(goodsName[0]);
		lbGoods1Cnt.setText("현재" + goodsCnt[0] + "개");
		lbGoods1CntTot.setText("누적판매량:" + totCnt[0] + "개");
		lbGoods1Price.setText("현재단가:" + goodsPrice[0] + "원");
		lbGoods1PriceTot.setText("총매출:" + totPrice[0] + "원");

		lbGoods2Name.setText(goodsName[1]);
		lbGoods2Cnt.setText("현재" + goodsCnt[1] + "개");
		lbGoods2CntTot.setText("누적판매량:" + totCnt[1] + "개");
		lbGoods2Price.setText("현재단가:" + goodsPrice[1] + "원");
		lbGoods2PriceTot.setText("총매출:" + totPrice[1] + "원");

		lbGoods3Name.setText(goodsName[2]);
		lbGoods3Cnt.setText("현재" + goodsCnt[2] + "개");
		lbGoods3CntTot.setText("누적판매량:" + totCnt[2] + "개");
		lbGoods3Price.setText("현재단가:" + goodsPrice[2] + "원");
		lbGoods3PriceTot.setText("총매출:" + totPrice[2] + "원");

	}
	//db연결
	void dbCon() {
		////////////////////////////////////////
		/// 데이타베이스접속..
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		////////////////////////////////////////////
	}
	//db닫기
	void dbClose() {
		// Close 작업
		try {
			pstmt.close();
			if (conn != null) {
				if (!conn.isClosed()) {
					conn.close();
				}
				conn = null;
			}
		} catch (SQLException ee) {
			System.err.println("닫기 실패~!!");
		}
	}

	void start() {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

}
