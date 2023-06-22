package 자바수업18일_스레드;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
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

class SubCom4 extends Frame implements ActionListener, Runnable {

	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/factory?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	//////////////////////////////////////////////////////////

	private Dimension dimen;
	int fullSizeWidth, fullSizeHeight;
	int x, y;
	Label lbTitle = new Label("기계 4 조작");
	Button btnCom1 = new Button("전원ON");
	Button btnCom2 = new Button("전원OFF");

	Font font35 = new Font("TimesRoman", Font.PLAIN, 35);
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	static int com4Cnt;

	static boolean com4Start = false;

	SubCom4() {
		super("기계4 조작반");
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		fullSizeWidth = (int) (dimen.getWidth() / 4);// 모든해상도 화면가로의반
		fullSizeHeight = (int) (dimen.getHeight() / 3);// 모든해상도 화면세로꽉
		x = (int) dimen.getWidth() / 2 + (int) dimen.getWidth() / 4;
		y = 0;
		this.setSize(fullSizeWidth, fullSizeHeight);
		this.init();
		control();
		this.start();
		this.setLocation(x, y);
		this.setVisible(true);

//		System.out.println("사이즈 체크w :" + dimen.getWidth());
//		System.out.println("사이즈 체크h :" + dimen.getHeight());

	}

	void start() {
		btnCom1.addActionListener(this);
		btnCom2.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(100, 50, 300, 50);
		lbTitle.setFont(font25);

		this.add(btnCom1);
		btnCom1.setFont(font25);
		this.add(btnCom2);
		btnCom2.setFont(font25);

		btnCom1.setBounds(50, 130, 120, 50);
		btnCom2.setBounds(250, 130, 120, 50);

	}

	void control() {
		btnCom1.setEnabled(false);
		btnCom2.setEnabled(false);

		// 관리자일경우에만 보임
		if (ServerData.grade.equals("반장") || ServerData.grade.equals("공장장") || ServerData.part.equals("기계4")
				|| ServerData.part.equals("관리자")) {
			btnCom1.setEnabled(true);
			btnCom2.setEnabled(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCom1) {
			MainProgram.btnCom4.enable(false);
			MainProgram.lbCom4.setForeground(Color.RED);
			MainProgram.lbCom4.setText("가동중");
			com4Start = true;
		} else if (e.getSource() == btnCom2) {
			MainProgram.btnCom4.enable(true);
			MainProgram.lbCom4.setForeground(Color.BLACK);
			MainProgram.lbCom4.setText("대기중");
			com4Start = false;
		}
	}

	@Override
	public void run() {
		while (true) {
			// 바로 인식이 안되서 살짝 딜레이주기...
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}

			if (com4Start == true) {
				com4Cnt++;
				update(ServerData.productName[3], com4Cnt);
				try {
					Thread.sleep(2000);
					MainProgram.lbCom4Cnt.setText("기계4출하량:" + com4Cnt + "개");
				} catch (InterruptedException e) {
				}
			}
		}

	}

	// 수량변경 업데이트
	void update(String name, int cnt) {
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

		String query = "update product set cnt_tot =? where name = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cnt);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException ee) {

		}

	}

}
