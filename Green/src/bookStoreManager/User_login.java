package bookStoreManager;

import java.awt.*;
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

public class User_login extends Frame implements ActionListener {
	Connection conn = null;

	String url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	Label lbTitle = new Label("로그인 화면");
	Label lbId = new Label("아이디");
	Label lbPw = new Label("비밀번호");

	TextField tfId = new TextField();
	TextField tfPw = new TextField();

	Button btnLogin = new Button("로그인");
	Button btnJoin = new Button("회원가입");
	Button btnFindId = new Button("아이디 찾기");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

//	String id = "admin", pw = "1004";

	public User_login() {
		super("로그인 화면");
		this.setSize(300, 400);
		this.init();
		this.start();
		this.setLocation(400, 200);
		this.setVisible(true);

	}

	public void init() {
		this.setLayout(null);
		this.add(lbTitle);
		this.add(lbId);
		this.add(tfId);
		this.add(lbPw);
		this.add(tfPw);
		this.add(btnLogin);
		this.add(btnJoin);
		this.add(btnFindId);

		lbTitle.setFont(font25);
		lbId.setFont(font15);
		tfId.setFont(font15);
		lbPw.setFont(font15);
		tfPw.setFont(font15);
		btnLogin.setFont(font15);
		btnJoin.setFont(font15);
		btnFindId.setFont(font15);

		lbTitle.setBounds(80, 40, 220, 30);
		lbId.setBounds(40, 120, 70, 30);
		lbPw.setBounds(40, 170, 100, 30);
		tfId.setBounds(150, 120, 100, 30);
		tfPw.setBounds(150, 170, 100, 30);
		tfPw.setEchoChar('*'); // 비번 *
		btnLogin.setBounds(100, 250, 100, 30);
		btnJoin.setBounds(100, 300, 100, 30);
		btnFindId.setBounds(100, 350, 100, 30);

	}

	public void start() {
		btnLogin.addActionListener(this);
		btnJoin.addActionListener(this);
//		tfId.addFocusListener(this);
//		tfPw.addFocusListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void viewClose() {
		this.setVisible(false);
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
		if (e.getSource() == btnLogin) {
			if (tfId.getText().equals("")) {
				dlgMsg("아이디를 입력해 주세요.");
				return;
			}
			if (tfPw.getText().equals("")) {
				dlgMsg("패스워드를 입력해 주세요.");
				return;
			}

			String inputId = tfId.getText();
			String inputPw = tfPw.getText();

			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException ee) {
				System.exit(0);
			}

			String query = "select * from user";
			try {
				conn = DriverManager.getConnection(url, id, pass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				boolean idOk = false;
				while (rs.next()) {
					if (inputId.equals(rs.getString(2))) {
						idOk = true;
						if (inputPw.equals(rs.getString(3))) {
							dlgMsg("로그인되었습니다.");
							System.out.println("onLogin");
							viewClose();
//							MainProgram mp = new MainProgram(rs.getString(2));
							this.setVisible(false);
						} else {
							dlgMsg("입력하신 내용을 다시 확인해주세요.");
							break;
						}
					}

				}
				if (idOk == false) {
					dlgMsg("입력하신 내용을 다시 확인해주세요.");
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException ee) {
				System.err.println("error = " + ee.toString());
			}

		} else if (e.getSource() == btnJoin) {
			User_join userJoin = new User_join();
		} else if (e.getSource() == btnFindId) {
			dlgIdCheck();
		}
	}

	void dlgIdCheck() {
		Dialog dlg = new Dialog(this, "아이디 찾기", true);
		Label lbTitle = new Label("아이디 찾기");
		Label lbName = new Label("이름"); // 이름과 연락처로 조회
		Label lbHp = new Label("연락처");

		TextField tfName = new TextField();
		TextField tfHp = new TextField();

		Button btnOk = new Button("찾기");

		dlg.setLayout(null);

		dlg.add(lbTitle);
		dlg.add(lbName);
		dlg.add(lbHp);
		dlg.add(tfName);
		dlg.add(tfHp);
		dlg.add(btnOk);

		lbTitle.setFont(font25);
		lbName.setFont(font15);
		lbHp.setFont(font15);
		btnOk.setFont(font15);

		lbTitle.setBounds(50, 50, 200, 30);
		lbName.setBounds(50, 50, 200, 30);
		lbHp.setBounds(50, 50, 200, 30);
		btnOk.setBounds(80, 120, 120, 30);

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfName.getText().equals("")) {
					dlgMsg("이름을 입력해주세요.");
				} else if (tfHp.getText().equals("")) {
					dlgMsg("연락처를 입력해주세요.");
				}
				findId();

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

	void findId() {

		String query = "select * from user";
		try {
			rs = stmt.executeQuery(query);
			boolean nameHPCheck = false;
			while (rs.next()) {
				nameHPCheck = true;
				dlgMsg("아이디를 찾았습니다.");
				dlgMsg(rs.getString("id"));
				break;
			}

			if (nameHPCheck == false) {
				dlgMsg("수정대상이 없습니다.");
			}

		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}

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
