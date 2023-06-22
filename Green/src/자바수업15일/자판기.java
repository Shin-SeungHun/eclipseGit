package 자바수업15일;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
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
import java.util.Date;

public class 자판기 {
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
	//////////////////////////////////////////////////////////

	// 변수
	int totPrice;// 총결제금액
	int jan;// 현재잔액

	// 디비에서 데이타를 읽어들일 공간...
	int MAX = 100;
	String goodsName[] = new String[MAX];
	int goodsPrice[] = new int[MAX];
	int goodsCount[] = new int[MAX];

	// 상품 선택 여부 체크변수...
	boolean goods1Sel = false;
	boolean goods2Sel = false;
	boolean goods3Sel = false;

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font10 = new Font("SansSerif", Font.BOLD, 10);

	Label lbTitle = new Label("자판기프로그램");
	Label lbGoods1 = new Label("포카리(0잔남음)", Label.CENTER);
	Label lbGoods2 = new Label("사이다(0잔남음)", Label.CENTER);
	Label lbGoods3 = new Label("게토레이(0잔남음)", Label.CENTER);
	Label lbGoods1Price = new Label("가격: 0원", Label.CENTER);
	Label lbGoods2Price = new Label("가격: 0원", Label.CENTER);
	Label lbGoods3Price = new Label("가격: 0원", Label.CENTER);
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

	Image imgGoods1;
	Image imgGoods2;
	Image imgGoods3;
	Image imgIng1;
	Image imgIng2;
	Image imgIng3;

	// 생성자
	Japangi() {
		super("자판기프로그램");
		dbCon();
		this.setSize(450, 550);
		this.init();
		this.start();
		this.setLocation(500, 150);
		dbDataLoad();
		this.setVisible(true);
	}

	// db접속
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
				goodsCount[i] = rs.getInt("count");
				i++;
			}
//		for(i=0; i<3;i++)
//		{
//			System.out.println(i+1+"번정보:"+goodsName[i]+goodsPrice[i]+goodsCount[i]);			
//		}

			lbGoods1.setText(goodsName[0] + "(" + goodsCount[0] + "잔남음)");
			lbGoods1Price.setText(goodsPrice[0] + "");

			lbGoods2.setText(goodsName[1] + "(" + goodsCount[1] + "잔남음)");
			lbGoods2Price.setText(goodsPrice[1] + "");

			lbGoods3.setText(goodsName[2] + "(" + goodsCount[2] + "잔남음)");
			lbGoods3Price.setText(goodsPrice[2] + "");
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}

	// 초기화 함수
	void init() {
		this.setLayout(null);

		// 프레임에 추가..
		this.add(lbTitle);
		this.add(lbGoods1);
		this.add(lbGoods2);
		this.add(lbGoods3);
		this.add(lbGoods1Price);
		this.add(lbGoods2Price);
		this.add(lbGoods3Price);
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

		// 폰트셋팅
		lbTitle.setFont(font25);
		lbGoods1.setFont(font10);
		lbGoods2.setFont(font10);
		lbGoods3.setFont(font10);
		lbGoods1Price.setFont(font15);
		lbGoods2Price.setFont(font15);
		lbGoods3Price.setFont(font15);
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

		imgGoods1 = Toolkit.getDefaultToolkit().getImage("img/포카리.jpg");
		imgGoods2 = Toolkit.getDefaultToolkit().getImage("img/사이다.jpg");
		imgGoods3 = Toolkit.getDefaultToolkit().getImage("img/게토레이.jpg");
		imgIng1 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
		imgIng2 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
		imgIng3 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");

		// 배치
		lbTitle.setBounds(120, 30, 200, 30);
		btnRefresh.setBounds(350, 30, 70, 30);

		lbGoods1.setBounds(50, 180, 110, 30);
		lbGoods2.setBounds(160, 180, 110, 30);
		lbGoods3.setBounds(270, 180, 110, 30);

		lbGoods1Price.setBounds(50, 210, 110, 30);
		lbGoods2Price.setBounds(160, 210, 110, 30);
		lbGoods3Price.setBounds(270, 210, 110, 30);

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

	}

	// 이미지 배치
	public void paint(Graphics g) {
		g.drawImage(imgGoods1, 50, 80, 90, 90, this);
		g.drawImage(imgGoods2, 170, 80, 90, 90, this);
		g.drawImage(imgGoods3, 290, 80, 90, 90, this);
		g.drawImage(imgIng1, 170, 290, 80, 60, this);
		g.drawImage(imgIng2, 260, 290, 80, 60, this);
		g.drawImage(imgIng3, 350, 290, 80, 60, this);
		// g.drawImage(imgIng, 290, 100, 100, 100, this);
		// g.drawImage(imgIng, 290, 100, 100, 100, this);
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

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// 자판기 메세지
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGoods1) {

			if (goodsCount[0] <= 0) {
				dlgMsg("해당상품 매진!구입불가!");
				return;
			}

			if (jan == 0) {
				dlgMsg("잔액이 없습니다.선택X");
				return;
			}

			if (goods1Sel == false) {
				// 선택상품 결제금액에 누적
				totPrice += goodsPrice[0];
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
				dlgMsg("해당상품 매진!구입불가!");
				return;
			}
			if (jan == 0) {
				dlgMsg("잔액이 없습니다.선택X");
				return;
			}

			if (goods2Sel == false) {
				totPrice += goodsPrice[1];
				lbSelPrice3.setText(totPrice + "원");
				// 선택상품 이미지변경
				imgIng2 = imgGoods2;
				this.repaint();

				// 상품선택유지변수
				goods2Sel = true;
			}
		} else if (e.getSource() == btnGoods3) {
			if (goodsCount[2] <= 0) {
				dlgMsg("해당상품 매진!구입불가!");
				return;
			}
			if (jan == 0) {
				dlgMsg("잔액이 없습니다.선택X");
				return;
			}

			if (goods3Sel == false) {
				totPrice += goodsPrice[2];
				lbSelPrice3.setText(totPrice + "원");
				// 선택상품 이미지변경
				imgIng3 = imgGoods3;
				this.repaint();

				// 상품선택유지변수
				goods3Sel = true;
			}
		} else if (e.getSource() == btnSel1) {
			// 선택상품 이미지변경
			imgIng1 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
			this.repaint();

			// 상품선택유지변수
			goods1Sel = false;
			totPrice -= 4500;// 금액다시차감
			lbSelPrice3.setText(totPrice + "원");

		} else if (e.getSource() == btnSel2) {
			// 선택상품 이미지변경
			imgIng2 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
			this.repaint();

			goods2Sel = false;
			totPrice -= 5000;// 금액다시차감
			lbSelPrice3.setText(totPrice + "원");

		} else if (e.getSource() == btnSel3) {
			// 선택상품 이미지변경
			imgIng3 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
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
			totPrice = 0;// 결제완료시 상품총결제금액 초기화..

			lbSelPrice3.setText(0 + "원");
			lbCoin3.setText(jan + "원");

			imgIng1 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
			imgIng2 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
			imgIng3 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");

			// 상품수량 차감
			if (goods1Sel == true) {
				goodsCount[0]--;
				lbGoods1.setText(goodsName[0] + "(" + goodsCount[0] + "잔남음)");
				goodsUpdate(1, goodsCount[0]);

				dlgMsg(goodsName[0] + " 주문완료!");
			}
			if (goods2Sel == true) {
				goodsCount[1]--;
				lbGoods2.setText(goodsName[1] + "(" + goodsCount[1] + "잔남음)");
				goodsUpdate(2, goodsCount[1]);
				dlgMsg(goodsName[1] + " 주문완료!");
			}
			if (goods3Sel == true) {
				goodsCount[2]--;
				lbGoods3.setText(goodsName[2] + "(" + goodsCount[2] + "잔남음)");
				goodsUpdate(3, goodsCount[2]);
				dlgMsg(goodsName[2] + " 주문완료!");
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
			dbDataLoad();// 디비변경값 새로 읽기..
			this.repaint(); // 갱신
		}
	}

	void goodsUpdate(int idx, int count) {
		String query = "update japangi set count = ?, total=total+1 where idx = ?";

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
