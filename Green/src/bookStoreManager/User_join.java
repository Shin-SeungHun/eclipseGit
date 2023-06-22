package bookStoreManager;

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

public class User_join extends Frame implements ActionListener, ItemListener {

	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	Label lbTitle = new Label("회원가입");
	Label lbId = new Label("아이디:");
	Label lbPw = new Label("패스워드:");
	Label lbName = new Label("이름:");
	Label lbNickname = new Label("닉네임:");
	Label lbAge = new Label("나이:");
	Label lbHp = new Label("연락처:");
	Label lbGender = new Label("성별:");

	TextField tfId = new TextField();
	TextField tfPw = new TextField();
	TextField tfName = new TextField();
	TextField tfNickname = new TextField();
	TextField tfAge = new TextField();
	TextField tfHp = new TextField();

	Button btnIdCheck = new Button("중복확인");
	Button btnJoin = new Button("가입");
	String gender = "남자";

	private Choice chSex = new Choice();

	boolean joinOk = false;

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	public User_join() {
		super("회원가입");
		dbCon();
		this.setSize(300, 400);
		this.init();
		start();
		this.setLocation(500, 200);
		this.setVisible(true);
	}

	void start() {
		btnJoin.addActionListener(this);
		btnIdCheck.addActionListener(this);
		chSex.addItemListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	void viewClose() {
		this.setVisible(false);
	}

	void init() {
		this.setLayout(null);

		this.add(lbTitle);
		this.add(lbId);
		this.add(lbPw);
		this.add(lbName);
		this.add(lbNickname);
		this.add(lbAge);
		this.add(lbGender);

		this.add(tfId);
		this.add(tfPw);
		this.add(tfName);
		this.add(tfNickname);
		this.add(tfAge);
		this.add(lbHp);
		this.add(tfHp);

		this.add(chSex);

		this.add(btnIdCheck);
		this.add(btnJoin);

		lbTitle.setFont(font25);// 제목
		lbId.setFont(font15);// 아이디
		lbPw.setFont(font15);// 비번
		lbName.setFont(font15);// 이름
		lbNickname.setFont(font15);// 닉네임
		lbAge.setFont(font15);// 나이
		lbHp.setFont(font15);// 연락처
		lbGender.setFont(font15);// 성별

		tfId.setFont(font15);// 아이디
		tfPw.setFont(font15);// 비번
		tfName.setFont(font15);// 이름
		tfNickname.setFont(font15);// 닉네임
		tfAge.setFont(font15);// 나이
		tfHp.setFont(font15);// 연락처

		chSex.setFont(font15);// 성별
		btnIdCheck.setFont(font15);// 중복확인
		btnJoin.setFont(font15);// 가입하기

		lbTitle.setBounds(50, 50, 200, 30);//제목
		lbId.setBounds(30, 100, 80, 30);
		lbPw.setBounds(30, 150, 80, 30);
		lbName.setBounds(30, 200, 80, 30);

		lbNickname.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
		lbAge.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);

		lbHp.setBounds(30, 250, 80, 30);
		lbGender.setBounds(30, 300, 80, 30);

		tfId.setBounds(110, 100, 80, 30);
		tfPw.setBounds(110, 150, 80, 30);
		tfPw.setEchoChar('*');
		tfName.setBounds(110, 200, 120, 30);

		tfNickname.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
		tfAge.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);

		tfHp.setBounds(110, 250, 120, 30);

		chSex.setBounds(110, 300, 120, 30);
		chSex.add("남자");
		chSex.add("여자");

		btnIdCheck.setBounds(200, 100, 80, 30);
		btnJoin.setBounds(110, 340, 80, 30);
	}

	void dbCon() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void dbClose() {
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) {
			if (tfId.getText().equals("")) {
				dlgMsg("아이디를 입력하시오.");
				return;
			} else if (tfPw.getText().equals("")) {
				dlgMsg("패스워드를 입력하시오.");
				return;
			} else if (tfName.getText().equals("")) {
				dlgMsg("이름을 입력하시오.");
				return;
			} else if (tfHp.getText().equals("")) {
				dlgMsg("연락처를 입력하시오.");
				return;
			}

			if (joinOk == false) {
				dlgMsg("중복체크를 하세요!");
				return;
			}

			dbClose();
			join();
		}

		else if (e.getSource() == btnIdCheck) {
			if (tfId.getText().equals("")) {
				dlgMsg("아이디를 입력하시오.");
				return;
			}

			idCheck();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	void idCheck() {
		String query = "select * from user";
		try {
			rs = stmt.executeQuery(query);
			boolean idCheck = true;
			while (rs.next()) {

				if (tfId.getText().equals(rs.getString("id"))) {
					dlgMsg("아이디가 중복됩니다.");
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
		String pquery = "insert into user values (null, ?, ?, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfId.getText());
			pstmt.setString(2, tfPw.getText());
			pstmt.setString(3, tfName.getText());
			pstmt.setString(4, tfHp.getText());
			pstmt.setString(5, gender);
			pstmt.executeUpdate();
			System.out.println("가입되었습니다.");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}

		tfId.setEnabled(true);
		btnIdCheck.setEnabled(true);
		tfId.setText("");
		tfPw.setText("");
		tfName.setText("");
		tfHp.setText("");
		joinOk = false;

		dlgMsg("회원가입되었습니다.");

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
