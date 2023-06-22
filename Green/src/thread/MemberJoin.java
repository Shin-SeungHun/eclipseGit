package thread;

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

class MemberJoin extends Frame implements ItemListener, ActionListener {
	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/factory?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	/////////////////////////////////////////////////////////////////////////

	Label lbTitle = new Label("Join");
	Label lbName = new Label("사원명:");
	Label lbId = new Label("아이디: ");
	Label lbPw = new Label("비밀번호: ");

	Label lbGrade = new Label("직급: ");

	Label lbPart = new Label("담당파트: ");

	TextField tfName = new TextField();
	TextField tfId = new TextField();
	TextField tfPw = new TextField();

	Button btnIdCheck = new Button("중복확인");
	Button btnJoin = new Button("가입하기");

	String grade = "사원";

	String part = "기계1";

	private Choice chGrade = new Choice();
	private Choice chPart = new Choice();

	// 회원가입여부 체크변수
	boolean joinOk = false;// 회원가입가능시 true 아니면 false

	Font font35 = new Font("TimesRoman", Font.PLAIN, 35);
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	MemberJoin() {
		super("join");
		dbCon();// 디비접속
		this.setSize(300, 450);
		this.init();// 화면레이아웃구성메서드
		start();
		this.setLocation(500, 200);
		this.setVisible(true);

	}

	void start() {
		btnJoin.addActionListener(this);
		btnIdCheck.addActionListener(this);
		chGrade.addItemListener(this);
		chPart.addItemListener(this);

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
		this.add(lbName);
		this.add(tfName);
		this.add(btnIdCheck);
		this.add(lbId);
		this.add(tfId);
		this.add(lbPw);
		this.add(tfPw);
		this.add(lbGrade);
		this.add(chGrade);
		this.add(lbPart);
		this.add(chPart);
		this.add(btnJoin);

		lbTitle.setFont(font35);
		lbName.setFont(font15);
		lbId.setFont(font15);
		btnIdCheck.setFont(font15);
		lbPw.setFont(font15);
		lbGrade.setFont(font15);
		lbPart.setFont(font15);
		tfName.setFont(font15);
		tfId.setFont(font15);
		tfPw.setFont(font15);
		chGrade.setFont(font15);
		chPart.setFont(font15);
		btnJoin.setFont(font15);

		lbTitle.setBounds(120, 35, 200, 30);
		lbName.setBounds(30, 100, 80, 30);
		lbGrade.setBounds(30, 250, 80, 30);
		lbPart.setBounds(30, 300, 80, 30);
		lbId.setBounds(30, 150, 80, 30);
		lbPw.setBounds(30, 200, 80, 30);
		tfName.setBounds(110, 100, 80, 30);
		tfId.setBounds(110, 150, 80, 30);
		tfPw.setBounds(110, 200, 120, 30);
		tfPw.setEchoChar('*');

		chGrade.setBounds(110, 250, 120, 30);
		chPart.setBounds(110, 300, 120, 30);

		btnIdCheck.setBounds(200, 150, 80, 30);
		btnJoin.setBounds(110, 380, 80, 30);

		chGrade.add("사원");
		chGrade.add("반장");
		chGrade.add("공장장");

		chPart.add("기계1");
		chPart.add("기계2");
		chPart.add("기계3");
		chPart.add("기계4");
		chPart.add("기계5");
		chPart.add("기계6");
		chPart.add("관리자");

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

	void dbClose() {
		// Close 작업
		try {
			rs.close();
			stmt.close();
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
	public void itemStateChanged(ItemEvent e) {
		grade = chGrade.getSelectedItem();
		part = chPart.getSelectedItem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 회원가입버튼
		if (e.getSource() == btnJoin) {
			if (tfName.getText().equals("")) {
				dlgMsg("사원명을 입력해주세요.");
				return;
			} else if (tfId.getText().equals("")) {
				dlgMsg("아이디를 입력해주세요.");
				return;
			} else if (tfPw.getText().equals("")) {
				dlgMsg("비밀번호를 입력해주세요.");
				return;
			}

			if (joinOk == false) {
				dlgMsg("아이디를 중복체크를 해주세요");
				return;
			}

			// 회원가입 디비메서드

			join();
		}
		// 회원가입시 아이디 중복체크 버튼
		else if (e.getSource() == btnIdCheck) {
			if (tfId.getText().equals("")) {
				dlgMsg("아이디를 입력해주세요.");
				return;
			}
			// 회원가입 아이디중복체크
			idCheck();
		}
	}

	void idCheck() {
		// 아이디중복체크...
		String query = "select * from member";
		try {
			rs = stmt.executeQuery(query);
			boolean idCheck = true;
			while (rs.next()) {

				if (tfId.getText().equals(rs.getString("id"))) {
					dlgMsg("중복된 아이디입니다.");
					idCheck = false;

					break;
				}
			}
			if (idCheck == true) {
				dlgMsg("사용가능한 아이디입니다.");
				joinOk = true;
				tfId.setEnabled(false);
				btnIdCheck.setEnabled(false);
			}

		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}

	}

	void join() {
		String pquery = "insert into member values (null, ?, ?, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfName.getText());
			pstmt.setString(2, tfId.getText());
			pstmt.setString(3, tfPw.getText());
			pstmt.setString(4, grade);
			pstmt.setString(5, part);
			pstmt.executeUpdate();
			System.out.println("실행성공");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
		dbClose();
		// 회원가입처리후 사후제어처리...
		tfId.setEnabled(true);
		btnIdCheck.setEnabled(true);
		tfName.setText("");
		tfId.setText("");
		tfPw.setText("");
		joinOk = false;

		dlgMsg("회원가입되었습니다.");
		viewClose();
	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "alert", true);
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
}
