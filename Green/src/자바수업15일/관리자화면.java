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

public class 관리자화면 {
	public static void main(String[] args) {
		JapangiManager jj = new JapangiManager();
	}
}

class JapangiManager extends Frame implements ActionListener, ItemListener {
	// 디비 데이타 로드할 배열들..
	int MAX = 100;
	String goodsName[] = new String[MAX];
	int goodsPrice[] = new int[MAX];
	int goodsCnt[] = new int[MAX];

	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	Label lbTitle = new Label("[[    관리자 화면    ]]");
	Label lbGoods = new Label("[상품관리]");
	Choice ch1 = new Choice();
	Label lbName = new Label("상 품 명:");
	Label lbPrice = new Label("상품 가격:");
	Button btnUpdateName = new Button("적용");
	Button btnUpdatePrice = new Button("적용");

	TextField tfName = new TextField();
	TextField tfPrice = new TextField();

	Label lbInTitle = new Label("[입고관리]");
	Choice ch2 = new Choice();
	Label lbInName = new Label("상품명:");
	Label lbInName2 = new Label("상품명자리..");
	Label lbInCnt = new Label("현재재고:");
	Label lbInCnt2 = new Label("0개");
	Label lbUpdateName = new Label("수  량:");
	TextField tfCnt = new TextField();
	Button btnUpdateCnt = new Button("적용");

	Button btnHistory = new Button("매출현황");
	Button btnAdd = new Button("상품추가");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	JapangiManager() {
		super("자판기 관리자화면");
		dbCon();// 디비접속
		this.setSize(450, 500);
		this.init();// 화면레이아웃구성메서드
		start();
		dbDataLoad(); // 디비 데이타가져오기....
		this.setLocation(450, 100);
		this.setVisible(true);

	}

	void start() {
		btnHistory.addActionListener(this);
		btnUpdateName.addActionListener(this);
		btnUpdatePrice.addActionListener(this);
		btnUpdateCnt.addActionListener(this);
		btnAdd.addActionListener(this);
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	void viewClose() {
		this.setVisible(false);
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);
		lbTitle.setFont(font25);
		lbTitle.setBounds(120, 50, 250, 30);

		// 판매관리
		this.add(lbGoods);
		lbGoods.setFont(font15);
		lbGoods.setBounds(30, 100, 80, 30);
		this.add(ch1);
		ch1.setFont(font15);
		ch1.setBounds(30, 130, 80, 30);

		this.add(lbName);
		lbName.setFont(font15);
		lbName.setBounds(150, 100, 80, 30);
		this.add(tfName);
		tfName.setFont(font15);
		tfName.setBounds(230, 100, 120, 30);
		this.add(btnUpdateName);
		btnUpdateName.setFont(font15);
		btnUpdateName.setBounds(360, 100, 50, 30);

		this.add(lbPrice);
		lbPrice.setFont(font15);
		lbPrice.setBounds(150, 150, 80, 30);
		this.add(tfPrice);
		tfPrice.setFont(font15);
		tfPrice.setBounds(230, 150, 120, 30);
		this.add(btnUpdatePrice);
		btnUpdatePrice.setFont(font15);
		btnUpdatePrice.setBounds(360, 150, 50, 30);

		// 입고관리
		this.add(lbInTitle);
		lbInTitle.setFont(font15);
		lbInTitle.setBounds(30, 250, 80, 30);
		this.add(ch2);
		ch2.setFont(font15);
		ch2.setBounds(30, 280, 80, 30);

		this.add(lbInName);
		lbInName.setFont(font15);
		lbInName.setBounds(150, 270, 60, 30);
		this.add(lbInName2);
		lbInName2.setFont(font15);
		lbInName2.setBounds(210, 270, 110, 30);
		this.add(lbInCnt);
		lbInCnt.setFont(font15);
		lbInCnt.setBounds(320, 270, 70, 30);
		this.add(lbInCnt2);
		lbInCnt2.setFont(font15);
		lbInCnt2.setBounds(400, 270, 60, 30);

		this.add(lbUpdateName);
		lbUpdateName.setFont(font15);
		lbUpdateName.setBounds(150, 320, 80, 30);
		this.add(tfCnt);
		tfCnt.setFont(font15);
		tfCnt.setBounds(230, 320, 120, 30);
		this.add(btnUpdateCnt);
		btnUpdateCnt.setFont(font15);
		btnUpdateCnt.setBounds(360, 320, 50, 30);
		this.add(btnAdd);
		btnAdd.setFont(font15);
		btnAdd.setBounds(110, 500, 80, 30);

		this.add(btnHistory);
		btnHistory.setFont(font15);
		btnHistory.setBounds(150, 360, 120, 30);
		this.add(btnAdd);
		btnAdd.setFont(font15);
		btnAdd.setBounds(150, 400, 120, 30);

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
				i++;

				ch1.add("상품" + i);
				ch2.add("상품" + i);

			}
//		for(i=0; i<3;i++)
//		{
//			System.out.println(i+1+"번정보:"+goodsName[i]+goodsPrice[i]+goodsCount[i]);			
//		}

//		lbGoods1.setText(goodsName[0]+"("+goodsCount[0]+"잔남음)");
//		lbGoods1Price.setText(goodsPrice[0]+"");
//		
//		lbGoods2.setText(goodsName[1]+"("+goodsCount[1]+"잔남음)");
//		lbGoods2Price.setText(goodsPrice[1]+"");
//		
//		lbGoods3.setText(goodsName[2]+"("+goodsCount[2]+"잔남음)");
//		lbGoods3Price.setText(goodsPrice[2]+"");
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}

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

	@Override
	public void actionPerformed(ActionEvent e) {

		// 자판기 관리자화면버튼
		if (e.getSource() == btnHistory) {
			JapagiHistory jj = new JapagiHistory();
		} else if (e.getSource() == btnUpdateName) {
			if (tfName.getText().equals("")) {
				dlgMsg("상품명을 입력하시오.");
				return;
			}
			String query = "update japangi set name = ? where idx = ?";
			goodsNameUpdate(ch1.getSelectedIndex(), tfName.getText(), query);
		} else if (e.getSource() == btnUpdatePrice) {
			if (tfPrice.getText().equals("")) {
				dlgMsg("가격을 입력하시오.");
				return;
			}

			String query = "update japangi set price = ? where idx = ?";
			goodsPriceUpdate(ch1.getSelectedIndex(), Integer.parseInt(tfPrice.getText()), query);
		} else if (e.getSource() == btnUpdateCnt) {
			if (tfCnt.getText().equals("")) {
				dlgMsg("수량을 입력하시오.");
				return;
			}
			String query = "update japangi set count = ? where idx = ?";
			goodsCntUpdate(ch2.getSelectedIndex(), Integer.parseInt(tfCnt.getText()), query);
		} else if (e.getSource() == btnAdd) {
			AddGoods jj = new AddGoods();
		}

	}

	void add() {
		String pquery = "insert into japangi values (null, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfName.getText());
			pstmt.setString(2, tfPrice.getText());
			pstmt.setString(3, tfCnt.getText());

			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}

		// 자판기 관리자화면처리후 사후제어처리...

		tfCnt.setText("");
		tfPrice.setText("");
		tfName.setText("");

		dlgMsg("자판기 관리자화면 처리 완료!");

		dbClose();

	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "자판기 관리자화면", true);
		Label lbContent = new Label(msg);
		Button bt = new Button("확인");
		dlg.setLayout(null);
		dlg.add(lbContent);
		lbContent.setFont(font15);
		dlg.add(bt);
		bt.setFont(font15);
		lbContent.setBounds(50, 50, 200, 30);
		bt.setBounds(80, 120, 120, 30);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setLocation(480, 250);
		dlg.setSize(300, 200);
		dlg.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getSource() == ch1) {
			tfName.setText(goodsName[ch1.getSelectedIndex()]);
			tfPrice.setText(goodsPrice[ch1.getSelectedIndex()] + "");
		} else if (e.getSource() == ch2) {
			tfCnt.setText(goodsCnt[ch2.getSelectedIndex()] + "");

			lbInName2.setText(goodsName[ch2.getSelectedIndex()]);
			lbInCnt2.setText(goodsCnt[ch2.getSelectedIndex()] + "개");

		}

	}

	void goodsNameUpdate(int idx, String name, String query) {

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, idx + 1);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("자판기 정보변경 실패!!");
			System.err.println("에러내용:" + ee.getMessage());

		}

	}

	void goodsPriceUpdate(int idx, int price, String query) {

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, price);
			pstmt.setInt(2, idx + 1);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("자판기 정보변경 실패!!");
			System.err.println("에러내용:" + ee.getMessage());

		}

	}

	void goodsCntUpdate(int idx, int cnt, String query) {

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, idx + 1);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {
			System.err.println("자판기 정보변경 실패!!");
			System.err.println("에러내용:" + ee.getMessage());

		}

	}
}
