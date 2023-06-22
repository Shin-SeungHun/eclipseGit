package thread;

/* 로그인할때 아이디가 "admin"일 경우 프로그램에서 관리자화면 버튼이 보이고 그외는 안보이도록  버튼명.setVisible(false); */
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import thread.FactoryCheck;
import thread.Machine1;
import thread.Machine2;
import thread.Machine3;
import thread.Machine4;
import thread.Machine5;
import thread.Machine6;

public class MemberLogin extends Frame implements FocusListener, ActionListener {
	Label lbTitle = new Label("Login");
	Label lbId = new Label("아이디:");
	Label lbPw = new Label("비밀번호:");
	TextField tfId = new TextField();
	TextField tfPw = new TextField();
	Button btnLogin = new Button("로그인");
	Button btnJoin = new Button("회원가입");

	Font font35 = new Font("TimesRoman", Font.PLAIN, 35);
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	String id = "admin", pw = "1004";

	public MemberLogin() {
		super("login");
		this.setSize(300, 400);
		this.init();// 화면레이아웃구성메서드
		this.start();// 이벤트메서드처리
		this.setLocation(400, 200);
		this.setVisible(true);

	}

	void viewClose() {

		this.setVisible(false);
	}

	void start() {
		btnLogin.addActionListener(this);
		btnJoin.addActionListener(this);
		tfId.addFocusListener(this);
		tfPw.addFocusListener(this);
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
		lbTitle.setBounds(110, 40, 220, 40);
		lbTitle.setFont(font35);

		this.add(lbId);// 현재 클래스 내부에 생성해서 넣음...
		lbId.setBounds(40, 120, 70, 30);
		lbId.setFont(font15);

		this.add(tfId);// 현재 클래스 내부에 생성해서 넣음...
		tfId.setBounds(150, 120, 100, 30);
		tfId.setFont(font15);

		this.add(lbPw);// 현재 클래스 내부에 생성해서 넣음...
		lbPw.setBounds(40, 170, 100, 30);
		lbPw.setFont(font15);

		this.add(tfPw);// 현재 클래스 내부에 생성해서 넣음...
		tfPw.setBounds(150, 170, 100, 30);
		tfPw.setFont(font15);
		tfPw.setEchoChar('*'); // 비번 *

		this.add(btnLogin);// 현재 클래스 내부에 생성해서 넣음...
		btnLogin.setBounds(100, 250, 100, 30);
		btnLogin.setFont(font15);

		this.add(btnJoin);// 현재 클래스 내부에 생성해서 넣음...
		btnJoin.setBounds(100, 300, 100, 30);
		btnJoin.setFont(font15);

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfId) {
		} else if (e.getSource() == tfPw) {
			if (tfId.getText().equals("")) {
				tfId.requestFocus();
				System.out.println("Id input plz...");
			}
			int check = tfId.getText().trim().length();
			if (check > 12) {
				tfId.requestFocus();
				tfId.setText("");
				System.out.println("Id length MAX 12.....");
			}

		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			if (tfId.getText().equals("")) {
				dlgMsg("아이디를 입력해주세요.");
				return;
			}
			if (tfPw.getText().equals("")) {
				dlgMsg("비밀번호를 입력해주세요.");
				return;
			}

			String inputId = tfId.getText();
			String inputPw = tfPw.getText();
			////////////////////////////////////////
			/// 데이타베이스접속..

			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException ee) {
				System.exit(0);
			}
			Connection conn = null;
			// 접속 주소 : 3306/디비명
			String url = "jdbc:mysql://localhost:3306/factory?useUnicode=true&characterEncoding=utf8";
			// String url = "jdbc:mysql://127.0.0.1:3306/java";
			String id = "root";
			String pass = "qwer";
			Statement stmt = null;
			ResultSet rs = null;
			String query = "select * from member";
			try {
				conn = DriverManager.getConnection(url, id, pass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				boolean idOk = false; // 기본값
				while (rs.next()) { // db에서 결과값 불러오기
					if (inputId.equals(rs.getString(2))) {
						idOk = true;
						if (inputPw.equals(rs.getString(3))) {
							//memberDataLoad();
							//로그인 성공시 디비 데이터 static 저장
							ServerData.id = rs.getString("id");
							ServerData.pw = rs.getString("pw");
							ServerData.name = rs.getString("name");
							ServerData.grade = rs.getString("grade");
							ServerData.part = rs.getString("part");
							
							System.out.println("id: "+ rs.getString("id"));
							
							dlgMsg("로그인되었습니다.");
							viewClose();
							this.setVisible(false);

							FactoryCheck facotryCheck = new FactoryCheck();

							Thread th = new Thread(facotryCheck);
							th.start();// 동작

							Machine1 machine1 = new Machine1();
							Thread th1 = new Thread(machine1);
							th1.start();

							Machine2 machine2 = new Machine2();
							Thread th2 = new Thread(machine2);
							th2.start();

							Machine3 machine3 = new Machine3();
							Thread th3 = new Thread(machine3);
							th3.start();

							Machine4 machine4 = new Machine4();
							Thread th4 = new Thread(machine4);
							th4.start();

							Machine5 machine5 = new Machine5();
							Thread th5 = new Thread(machine5);
							th5.start();

							Machine6 machine6 = new Machine6();
							Thread th6 = new Thread(machine6);
							th6.start();

						} else {
							dlgMsg("비밀번호를 다시 입력해주세요.");
							break;
						}
					}

				}
				if (idOk == false) {
					dlgMsg("아이디를 확인해주세요.");
				}
				rs.close(); // 1
				stmt.close();// 2
				conn.close();// 3
			} catch (SQLException ee) {
				System.err.println("error = " + ee.toString()); // 에러
			}

		} else if (e.getSource() == btnJoin) {
			MemberJoin memberJoin = new MemberJoin();
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
