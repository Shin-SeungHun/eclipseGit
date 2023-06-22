package 자바수업14일;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*디비명: test_db
 * 테이블명: japangi
 * 구조
 * idx int pk nn ai
 * 
 * name varchar(45)
 * price int
 * count int
 * 
 * 디비 제어 추가설명
 * 1.상품결제시 수량이 차감
 * 	라떼(10)->라떼(9)
 * 2.디비에 있는 이름과 가격, 수량이 상품쪽에 적용되서 보이도록 수정
 * 
 * 관리자 화면
 * 상품관리
 * 상품1 이름:             적용
 * 상품2 가격:             적용
 * 상품3
 * 
 * 입고관리
 * 상품1 상품명: 아메리카노 현재재고: 10개
 * 상품2 수량:          적용
 * 상품3
 * 
 * 매출현황
 * 
 * 매출현황 다이얼로그
 * 상품1 아메리카노 현재10개 누적판매량 100개 현재단가:4800 총매출:480000
 * 상품2 라떼     현재10개 누적판매량 100개 현재단가:4800 총매출:480000
 * 상품3 딸기요거트 현재10개 누적판매량 100개 현재단가:4800 총매출:480000
 * */

public class Study1_자판기 {
	public static void main(String[] args) {
		Japangi jj = new Japangi();

	}
}

class Japangi extends Frame implements ActionListener {
	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////
	List mList = new ArrayList();
	// 변수
	int totPrice;// 총결제금액
	int jan;// 현재잔액

	// 디비에서 데이터를 읽어들일 공간
	String goodsName[] = new String[3];
	int goodsPrice[] = new int[3];
	int goodsCount[] = new int[3];

	// 상품 선택 여부 체크변수...
	boolean goods1Sel = false;
	boolean goods2Sel = false;
	boolean goods3Sel = false;

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font10 = new Font("SansSerif", Font.PLAIN, 10);
	Label lbTitle = new Label("자판기프로그램");

	Label lbGoods1 = new Label("아메리카노(0잔 남음)", Label.CENTER);
	Label lbGoods2 = new Label("라떼(0잔 남음)", Label.CENTER);
	Label lbGoods3 = new Label("딸기요거트(0잔 남음)", Label.CENTER);

	Label lbPrice1 = new Label("가격: 0원");
	Label lbPrice2 = new Label("가격: 0원");
	Label lbPrice3 = new Label("가격: 0원");

	Label lbSelPrice1 = new Label("현재주문상품", Label.CENTER);
	Label lbSelPrice2 = new Label("결제금액", Label.CENTER);
	Label lbSelPrice3 = new Label("0원", Label.RIGHT);
	Label lbCoin1 = new Label("투입금액");
	Label lbCoin2 = new Label("현재잔액");
	Label lbCoin3 = new Label("0원", Label.RIGHT);

	Button btnGoods1 = new Button("상품1");
	Button btnGoods2 = new Button("상품2");
	Button btnGoods3 = new Button("상품3");
	Button btnSel1 = new Button("상품1취소");
	Button btnSel2 = new Button("상품2취소");
	Button btnSel3 = new Button("상품3취소");
	Button btn1000 = new Button("1000원");
	Button btn5000 = new Button("5000원");
	Button btn10000 = new Button("10000원");
	Button btnCash = new Button("결제하기");
	Button btnCancel = new Button("결제취소(반환)");

	// 디비값 변경시 새로고침
	Button btnRefresh = new Button("새로고침");

	Button btnStatus = new Button("관리자화면");

	Image imgGoods1;
	Image imgGoods2;
	Image imgGoods3;

	Image imgIng1;
	Image imgIng2;
	Image imgIng3;

	Japangi() {
		super("자판기프로그램");
		dbCon();
		this.setSize(450, 550);
		this.init();
		this.start();
		this.setLocation(500, 150);
		dataLoad();
		
		this.setVisible(true);
	}

	void init() {
		this.setLayout(null);

		// 프레임에 추가..
		this.add(lbTitle);
		this.add(lbGoods1);
		this.add(lbGoods2);
		this.add(lbGoods3);
		this.add(lbPrice1);
		this.add(lbPrice2);
		this.add(lbPrice3);
		this.add(lbSelPrice1);
		this.add(lbSelPrice2);
		this.add(lbSelPrice3);
		this.add(lbCoin1);
		this.add(lbCoin2);
		this.add(lbCoin3);

		this.add(btnGoods1);
		this.add(btnGoods2);
		this.add(btnGoods3);
		this.add(btnSel1);
		this.add(btnSel2);
		this.add(btnSel3);
		this.add(btn1000);
		this.add(btn5000);
		this.add(btn10000);
		this.add(btnCash);
		this.add(btnCancel);
		this.add(btnRefresh);
		this.add(btnStatus);

//		this.add(mList);
		// 폰트셋팅
		lbTitle.setFont(font25);
		lbGoods1.setFont(font10);
		lbGoods2.setFont(font10);
		lbGoods3.setFont(font10);
		lbPrice1.setFont(font15);
		lbPrice2.setFont(font15);
		lbPrice3.setFont(font15);
		lbSelPrice1.setFont(font15);
		lbSelPrice2.setFont(font15);
		lbSelPrice3.setFont(font15);
		lbCoin1.setFont(font15);
		lbCoin2.setFont(font15);
		lbCoin3.setFont(font15);
		btnGoods1.setFont(font15);
		btnGoods2.setFont(font15);
		btnGoods3.setFont(font15);
		btnSel1.setFont(font15);
		btnSel2.setFont(font15);
		btnSel3.setFont(font15);
		btn1000.setFont(font15);
		btn5000.setFont(font15);
		btn10000.setFont(font15);
		btnCash.setFont(font15);
		btnCancel.setFont(font15);
		btnRefresh.setFont(font15);
		btnStatus.setFont(font15);

		imgGoods1 = Toolkit.getDefaultToolkit().getImage("img/goods1.png");
		imgGoods2 = Toolkit.getDefaultToolkit().getImage("img/goods2.png");
		imgGoods3 = Toolkit.getDefaultToolkit().getImage("img/goods3.png");

		imgIng1 = Toolkit.getDefaultToolkit().getImage("img/ing.gif");
		imgIng2 = Toolkit.getDefaultToolkit().getImage("img/ing.gif");
		imgIng3 = Toolkit.getDefaultToolkit().getImage("img/ing.gif");

		// 배치
		lbTitle.setBounds(120, 50, 200, 30);

		lbGoods1.setBounds(50, 190, 110, 30);
		lbGoods2.setBounds(160, 190, 110, 30);
		lbGoods3.setBounds(270, 190, 110, 30);

		lbPrice1.setBounds(50, 220, 110, 20);
		lbPrice2.setBounds(160, 220, 110, 20);
		lbPrice3.setBounds(270, 220, 110, 20);

		btnGoods1.setBounds(50, 240, 110, 30);
		btnGoods2.setBounds(160, 240, 110, 30);
		btnGoods3.setBounds(270, 240, 110, 30);

		lbSelPrice1.setBounds(30, 290, 110, 30);
		lbSelPrice2.setBounds(30, 320, 110, 30);
		lbSelPrice3.setBounds(30, 350, 110, 30);

		btnSel1.setBounds(170, 350, 80, 30);
		btnSel2.setBounds(260, 350, 80, 30);
		btnSel3.setBounds(350, 350, 80, 30);

		lbCoin1.setBounds(50, 390, 80, 30);
		btn1000.setBounds(50, 420, 70, 30);
		btn5000.setBounds(130, 420, 70, 30);
		btn10000.setBounds(210, 420, 70, 30);

		lbCoin2.setBounds(50, 460, 100, 30);
		lbCoin3.setBounds(190, 460, 100, 30);

		btnCash.setBounds(320, 420, 115, 30);
		btnCancel.setBounds(320, 470, 115, 30);
		btnRefresh.setBounds(350, 30, 70, 30);
		btnStatus.setBounds(20, 30, 90, 30);

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
			e.printStackTrace(); // printStackTrace는 리턴값이 없다 호출하면 메소드가 내부적으로 예외 결과를 화면에 출력, 가장 자세한 예외 정보를 제공, 에러의
									// 발생근원지를 찾아서 단계별로 에러를 출력
		}
		////////////////////////////////////////////
	}

	void dataLoad() {
////////////////////////////////////////
///데이타베이스접속..

		String query = "select * from japangi";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			int i = 0;
			while (rs.next()) {
				// 결과값 읽어오는 곳 여기서 화면에 뿌려주면 됨
				goodsName[i] = rs.getString("name");
				goodsPrice[i] = rs.getInt("price");
				goodsCount[i] = rs.getInt("count");
				i++;
			}

//			for (i = 0; i < 3; i++) {
//				System.out.println("1" + goodsName[i] + "2" + goodsPrice + "3" + goodsCount);
//			}
			lbGoods1.setText(goodsName[0] + "(" + goodsCount[0] + "잔남음)");
			lbPrice1.setText(goodsPrice[0] + "");

			lbGoods2.setText(goodsName[1] + "(" + goodsCount[1] + "잔남음)");
			lbPrice2.setText(goodsPrice[1] + "");

			lbGoods3.setText(goodsName[2] + "(" + goodsCount[2] + "잔남음)");
			lbPrice3.setText(goodsPrice[2] + "");
//			lbGoods2.setText(goodsPrice[i]);
//			lbGoods3.setText(goodsCount[i]);

//			rs.close();
//			stmt.close();
//			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	public void paint(Graphics g) {
		g.drawImage(imgGoods1, 50, 100, 100, 90, this);
		g.drawImage(imgGoods2, 170, 100, 100, 90, this);
		g.drawImage(imgGoods3, 290, 100, 100, 90, this);

		g.drawImage(imgIng1, 170, 290, 80, 60, this);
		g.drawImage(imgIng2, 260, 290, 80, 60, this);
		g.drawImage(imgIng3, 350, 290, 80, 60, this);

	}

	void start() {
		btnGoods1.addActionListener(this);
		btnGoods2.addActionListener(this);
		btnGoods3.addActionListener(this);

		btnSel1.addActionListener(this);
		btnSel2.addActionListener(this);
		btnSel3.addActionListener(this);

		btn1000.addActionListener(this);
		btn5000.addActionListener(this);
		btn10000.addActionListener(this);

		btnCash.addActionListener(this);
		btnCancel.addActionListener(this);

		btnRefresh.addActionListener(this);

		btnStatus.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "자판기알림!", true);
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

	void dlgStatus() {
		Dialog dlg = new Dialog(this, "관리자화면", true);

		Label lbTitle = new Label("관리자 화면");
		Label lbGoods = new Label("상품관리");
//		List mList = new List();

		Choice chGoods1 = new Choice();
		Choice chGoods2 = new Choice();
		Choice chGoods3 = new Choice();
		Choice chGoods4 = new Choice();
		Choice chGoods5 = new Choice();
		Choice chGoods6 = new Choice();

		chGoods1.add("상품1");
		chGoods2.add("상품2");
		chGoods3.add("상품3");
		chGoods4.add("상품1");
		chGoods5.add("상품2");
		chGoods6.add("상품3");

//		List mList = new ArrayList();
		Label lbGoodsName1 = new Label("이름:");
		Label lbGoodsPrice = new Label("가격:");

		Label lbReceive = new Label("입고관리");

		Label lbGoodsName2 = new Label("상품명:");
		Label lbRest = new Label("현재재고:");

		Label lbAmount = new Label("수량:");

		TextField tfGoodsName1 = new TextField();
		TextField tfGoodsPrice1 = new TextField();
		TextField tfAmount = new TextField();

		Button btnApply1 = new Button("적용");
		Button btnApply2 = new Button("적용");
		Button btnApply3 = new Button("적용");
		Button btnSaleStatus = new Button("매출현황");
		Button btnAdd = new Button("상품추가");

		Label lbContent = new Label();
		Button bt = new Button("확인");

		dlg.setLayout(null);
		dlg.add(lbTitle);
		dlg.add(lbGoods);
		dlg.add(chGoods1);
		dlg.add(chGoods2);
		dlg.add(chGoods3);
		dlg.add(chGoods4);
		dlg.add(chGoods5);
		dlg.add(chGoods6);
		dlg.add(lbGoodsName1);
		dlg.add(lbGoodsPrice);
		dlg.add(lbReceive);
		dlg.add(lbGoodsName2);
		dlg.add(lbRest);
		dlg.add(lbAmount);
		dlg.add(tfGoodsName1);
		dlg.add(tfGoodsPrice1);
		dlg.add(tfAmount);
		dlg.add(btnApply1);
		dlg.add(btnApply2);
		dlg.add(btnApply3);
		dlg.add(btnSaleStatus);
		dlg.add(btnAdd);

		dlg.add(lbContent);
		dlg.add(bt);

		lbTitle.setFont(font25);
		lbGoods.setFont(font15);
		chGoods1.setFont(font15);
		chGoods2.setFont(font15);
		chGoods3.setFont(font15);
		chGoods4.setFont(font15);
		chGoods5.setFont(font15);
		chGoods6.setFont(font15);
		lbGoodsName1.setFont(font15);
		lbGoodsPrice.setFont(font15);
		lbReceive.setFont(font15);
		lbGoodsName2.setFont(font15);
		lbRest.setFont(font15);
		lbAmount.setFont(font15);
		tfGoodsName1.setFont(font15);
		tfGoodsPrice1.setFont(font15);
		tfAmount.setFont(font15);
		btnApply1.setFont(font15);
		btnApply2.setFont(font15);
		btnApply3.setFont(font15);
		btnSaleStatus.setFont(font15);
		btnAdd.setFont(font15);

		lbTitle.setBounds(130, 40, 150, 30);
		lbGoods.setBounds(20, 70, 100, 30);

		chGoods1.setBounds(20, 100, 100, 30);
		chGoods2.setBounds(20, 130, 100, 30);
		chGoods3.setBounds(20, 160, 100, 30);
		chGoods4.setBounds(20, 250, 100, 30);
		chGoods5.setBounds(20, 280, 100, 30);
		chGoods6.setBounds(20, 310, 100, 30);

		lbGoodsName1.setBounds(130, 100, 50, 30);
		lbGoodsPrice.setBounds(130, 130, 50, 30);

		lbReceive.setBounds(20, 220, 100, 30);
		lbGoodsName2.setBounds(130, 250, 60, 30);
		lbRest.setBounds(280, 250, 70, 30);
		lbAmount.setBounds(145, 280, 40, 30);

		tfGoodsName1.setBounds(180, 100, 110, 30);
		tfGoodsPrice1.setBounds(180, 130, 110, 30);
		tfAmount.setBounds(190, 280, 110, 30);

		btnApply1.setBounds(310, 100, 50, 30);
		btnApply2.setBounds(310, 130, 50, 30);
		btnApply3.setBounds(310, 280, 50, 30);

		btnSaleStatus.setBounds(150, 350, 100, 30);
		btnAdd.setBounds(150, 390, 100, 30);

		lbContent.setFont(font15);
		bt.setFont(font15);

		lbContent.setBounds(50, 50, 200, 30);
//		bt.setBounds(100, 500, 120, 30);

		btnApply1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnApply2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnApply3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnSaleStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgStatus1();
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgAdd();
			}
		});

//		bt.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dlg.setVisible(false);
//			}
//		});
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setLocation(480, 250);
		dlg.setSize(400, 450);
		dlg.setVisible(true);
	}

	void dlgStatus1() {
		Dialog dlg = new Dialog(this, "매출현황", true);
		dlg.setLayout(null);
//		Label lbContent = new Label();
		Label lbTitle = new Label("매출현황 다이얼로그", Label.CENTER);
		List mList = new ArrayList();
		dlg.add(lbTitle);
//		dlg.add(lbContent);

		lbTitle.setFont(font25);
//		lbContent.setFont(font15);
		lbTitle.setBounds(150, 50, 250, 30);
//		lbContent.setBounds(50, 50, 200, 30);
		dbDataLoad();
//		dlg.add(mList);
//		mList.setFont(font15);
//		mList.setBounds(10, 100, 280, 220);
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});

		dlg.setLocation(480, 250);
		dlg.setSize(600, 300);
		dlg.setVisible(true);
	}

	void dlgAdd() {
		Dialog dlg = new Dialog(this, "상품추가", true);
		dlg.setLayout(null);
//		Label lbContent = new Label();
		Label lbTitle = new Label("상품등록화면", Label.CENTER);
		Label lbGoods = new Label("상품명:");
		Label lbGoodsPrice = new Label("상품가격:");
		Label lbGoodsNum = new Label("수량:");

		TextField tfGoods = new TextField();
		TextField tfGoodsPrice = new TextField();
		TextField tfGoodsNum = new TextField();

		Button btnGoodsRegister = new Button("상품등록");

		dlg.add(lbTitle);
		dlg.add(lbGoods);
		dlg.add(lbGoodsPrice);
		dlg.add(lbGoodsNum);
		dlg.add(tfGoods);
		dlg.add(tfGoodsPrice);
		dlg.add(tfGoodsNum);
		dlg.add(btnGoodsRegister);
//		dlg.add(lbContent);

		lbTitle.setFont(font25);
		lbGoods.setFont(font15);
		lbGoodsPrice.setFont(font15);
		lbGoodsNum.setFont(font15);
		tfGoods.setFont(font15);
		tfGoodsPrice.setFont(font15);
		tfGoodsNum.setFont(font15);
		btnGoodsRegister.setFont(font15);

//		lbContent.setFont(font15);
		lbTitle.setBounds(100, 40, 200, 30);
		lbGoods.setBounds(35, 90, 60, 30);
		lbGoodsPrice.setBounds(35, 130, 70, 30);
		lbGoodsNum.setBounds(35, 170, 70, 30);

		tfGoods.setBounds(130, 90, 150, 30);
		tfGoodsPrice.setBounds(130, 130, 150, 30);
		tfGoodsNum.setBounds(130, 170, 150, 30);

		btnGoodsRegister.setBounds(160, 230, 80, 30);
//		lbContent.setBounds(50, 50, 200, 30);

		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		btnGoodsRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		dlg.setLocation(480, 250);
		dlg.setSize(400, 300);
		dlg.setVisible(true);
	}

	void dbDataLoad() {
////////////////////////////////////////
///데이타베이스접속..

		String query = "select * from japangi2";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			String result = "";
			while (rs.next()) {
				// 결과값 읽어오는 곳 여기서 화면에 뿌려주면 됨
				result = rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5)
						+ rs.getString(6);
				mList.add(result);
				System.out.println("result" + result);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStatus) {
			dlgStatus();
		}

		if (e.getSource() == btnGoods1) {
			if (goodsCount[0] <= 0) {
				dlgMsg("해당 상품 매진");
				return;
			}

			if (jan == 0) {
				dlgMsg("잔액이 없습니다.선택X");
				return;
			}

			if (goods1Sel == false) {
				// 선택상품 결제금액에 누적
				totPrice += 4500;
				// 선택상품 결제금액 표시
				lbSelPrice3.setText(totPrice + "원");

				// 선택상품 이미지변경
				imgIng1 = imgGoods1;
				this.repaint();

				// 상품선택유지변수
				goods1Sel = true;
			}

		} else if (e.getSource() == btnGoods2) {
			if (goodsCount[1] <= 0) {
				dlgMsg("해당 상품 매진");
				return;
			}

			if (jan == 0) {
				dlgMsg("잔액이 없습니다.선택X");
				return;
			}

			if (goods2Sel == false) {
				totPrice += 5000;
				lbSelPrice3.setText(totPrice + "원");
				// 선택상품 이미지변경
				imgIng2 = imgGoods2;
				this.repaint();

				// 상품선택유지변수
				goods2Sel = true;
			}
		} else if (e.getSource() == btnGoods3) {
			if (goodsCount[2] <= 0) {
				dlgMsg("해당 상품 매진");
				return;
			}

			if (jan == 0) {
				dlgMsg("잔액이 없습니다.선택X");
				return;
			}

			if (goods3Sel == false) {
				totPrice += 6000;
				lbSelPrice3.setText(totPrice + "원");
				// 선택상품 이미지변경
				imgIng3 = imgGoods3;
				this.repaint();

				// 상품선택유지변수
				goods3Sel = true;
			}
		} else if (e.getSource() == btnSel1) {
			// 선택상품 이미지변경
			imgIng1 = Toolkit.getDefaultToolkit().getImage("img/ing.gif");
			this.repaint();

			// 상품선택유지변수
			goods1Sel = false;
			totPrice -= 4500;// 금액다시차감
			lbSelPrice3.setText(totPrice + "원");

		} else if (e.getSource() == btnSel2) {
			// 선택상품 이미지변경
			imgIng2 = Toolkit.getDefaultToolkit().getImage("img/ing.gif");
			this.repaint();

			goods2Sel = false;
			totPrice -= 5000;// 금액다시차감
			lbSelPrice3.setText(totPrice + "원");

		} else if (e.getSource() == btnSel3) {
			// 선택상품 이미지변경
			imgIng3 = Toolkit.getDefaultToolkit().getImage("img/ing.gif");
			this.repaint();

			goods3Sel = false;
			totPrice -= 6000;// 금액다시차감
			lbSelPrice3.setText(totPrice + "원");
		} else if (e.getSource() == btn1000) {
			jan += 1000;
			lbCoin3.setText(jan + "원");

		} else if (e.getSource() == btn5000) {
			jan += 5000;
			lbCoin3.setText(jan + "원");
		} else if (e.getSource() == btn10000) {
			jan += 10000;
			lbCoin3.setText(jan + "원");
		} else if (e.getSource() == btnCash) {

			if (jan <= 0 || totPrice > jan) {
				dlgMsg("잔액이 " + (totPrice - jan) + "원 부족합니다.");
				return;
			}

			jan -= totPrice;// 결제
			totPrice = 0;// 결제완료시 상품총결제금액 초기화

			lbSelPrice3.setText(0 + "원");
			lbCoin3.setText(jan + "원");

			imgIng1 = Toolkit.getDefaultToolkit().getImage("img/ing.gif");
			imgIng2 = Toolkit.getDefaultToolkit().getImage("img/ing.gif");
			imgIng3 = Toolkit.getDefaultToolkit().getImage("img/ing.gif");

			// 상품수량차감
			if (goods1Sel == true) {
				goodsCount[0]--;
				lbGoods1.setText(goodsName[0] + "(" + goodsCount[0] + "잔남음)");
				goodsUpdate(1, goodsCount[0]);

				dlgMsg(goodsName[0] + "주문완료!");
			}
			if (goods2Sel == true) {
				goodsCount[1]--;
				lbGoods2.setText(goodsName[1] + "(" + goodsCount[1] + "잔남음)");
				goodsUpdate(2, goodsCount[0]);

				dlgMsg(goodsName[1] + "주문완료!");
			}

			if (goods3Sel == true) {
				goodsCount[2]--;
				lbGoods3.setText(goodsName[2] + "(" + goodsCount[2] + "잔남음)");
				goodsUpdate(3, goodsCount[0]);

				dlgMsg(goodsName[2] + "주문완료!");
			}

			// 상품선택유지변수
			goods1Sel = false;
			goods2Sel = false;
			goods3Sel = false;

		} else if (e.getSource() == btnCancel) {

			if (jan == 0) {
				dlgMsg("반환할 금액이 없습니다.");
				return;
			}

			// 잔액 반환 알림..
			dlgMsg(jan + "원이 반환 되었습니다.");

			// 선택상품초기화.
			totPrice = 0;
			lbSelPrice3.setText(totPrice + "원");

			jan = 0;
			lbCoin3.setText(jan + "원");

			// 상품선택유지변수
			goods1Sel = false;
			goods2Sel = false;
			goods3Sel = false;

		} else if (e.getSource() == btnRefresh) {
			dataLoad(); // 디비 변경값 새로 읽기
			this.repaint();
		}

	}

	// 업데이트
	void goodsUpdate(int idx, int count) {
		String query = "update japangi set count = ? where idx = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, count);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException ee) {
			System.err.println("자판기 정보변경 실패!!");
			System.err.println("에러내용:" + ee.getMessage());
		}
	}

	
}
