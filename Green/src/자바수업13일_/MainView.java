//package 자바수업13일_;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class MainView {
//
//	public static void main(String[] args) {
//		Main main = new Main();
//
//	}
//
//}
//
//class Main extends Frame implements ActionListener {
//	Label lbTitle = new Label("메인 화면");
//
//	List mList = new List();
//
//	Button btnList = new Button("회원목록보기");
//
//	Button btnModify = new Button("회원정보수정");
//
//	Button btnDelete = new Button("회원삭제");
//
//	Button btnJoin = new Button("회원가입");
//
//	Button btnClose = new Button("닫기");
//
//	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
//	Font font15 = new Font("SansSerif", Font.BOLD, 15);
//
//	private Connection main;
//
//	Main() {
//		super("메인 화면");
//		this.setSize(300, 400);
//		this.init();
//		this.start();
//		this.setLocation(500, 200);
//
//		this.setVisible(true);
//
//		try {
//			Class.forName("org.gjt.mm.mysql.Driver");
//		} catch (ClassNotFoundException ee) {
//			return;
//		}
//		String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
//		String id = "root";
//		String pass = "qwer";
//		try {
//			main = DriverManager.getConnection(url, id, pass);
//		} catch (SQLException ee) {
//		}
//	}
//
//	public void init() {
//		this.setLayout(null);
//		this.add(lbTitle);
//		lbTitle.setBounds(100, 40, 300, 30);
//		lbTitle.setFont(font25);
//
//		this.add(btnList);
//		btnList.setBounds(95, 100, 110, 30);
//		btnList.setFont(font15);
//
//		this.add(btnModify);
//		btnModify.setBounds(95, 160, 110, 30);
//		btnModify.setFont(font15);
//
//		this.add(btnDelete);
//		btnDelete.setBounds(110, 220, 80, 30);
//		btnDelete.setFont(font15);
//
//		this.add(btnJoin);
//		btnJoin.setBounds(110, 280, 80, 30);
//		btnJoin.setFont(font15);
//
//		this.add(btnClose);
//		btnClose.setBounds(125, 340, 50, 30);
//		btnClose.setFont(font15);
//
//	}
//
//	public void start() {
//
//		btnList.addActionListener(this);
//		btnModify.addActionListener(this);
//		btnDelete.addActionListener(this);
//		btnJoin.addActionListener(this);
//
//		this.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//
//			}
//		});
//
//		this.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == btnList) {
//			dlgLoad();
//		}
//
//		if (e.getSource() == btnJoin) {
//			dlgSign();
//		}
//
//		if (e.getSource() == btnModify) {
//
//		}
//
//		if (e.getSource() == btnDelete) {
//
//		}
//	}
//
//	// 회원목록리스트
//	public void dataLoad() {
//
//		String query = "select * from tb_member2";
//		try {
//
//			Statement stmt = main.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//
//			String result = "";
//			while (rs.next()) {
////				result = rs.getString("idx") + " / " + rs.getString("id") + " / " + rs.getString("pw") + " / "
////						+ rs.getString("name") + " / " + rs.getString("hp") + " / " + rs.getString("sex");
//				result = rs.getString(1) + " / " + rs.getString(2) + " / " + rs.getString(3) + " / " + rs.getString(4)
//						+ " / " + rs.getString(5) + " / " + rs.getString(6);
//				System.out.println("회원: " + result);
//				mList.add(result);
//			}
//			System.out.println();
//			rs.close();
//			stmt.close();
//			main.close();
//		} catch (SQLException ee) {
//			System.err.println("error = " + ee.toString()); // 에러표시
//		}
//
//	}
//
//	public void dlgLoad() {
//		Dialog dlg = new Dialog(this, "회원목록", true);
//		Label lbTitle = new Label("회원리스트");
//		Button bt = new Button("확인");
//		dlg.setLayout(null);
//		dataLoad();
//
//		lbTitle.setBounds(100, 50, 150, 30);
//
//		dlg.add(mList);
//		mList.setFont(font15);
//		mList.setBounds(25, 100, 300, 200);
//
//		dlg.add(lbTitle);
//		lbTitle.setFont(font25);
//
//		dlg.add(bt);
//		bt.setFont(font15);
//
//		bt.setBounds(110, 330, 120, 30);
//		bt.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dlg.setVisible(false);
//			}
//		});
//		dlg.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				dlg.setVisible(false);
//			}
//		});
//		dlg.setLocation(480, 250);
//		dlg.setSize(350, 400);
//		dlg.setVisible(true);
//	}
//
//	// 회원가입
//	public boolean registerMember(String id, String pw, String name, String hp, String sex) {
//		String query = "insert into tb_member2 values (null, ?, ?, ?, ?, ?)";
//		// 테이블 이름 수정!
//		try {
//			PreparedStatement pstmt = main.prepareStatement(query);
//			pstmt.setString(1, id);
//			pstmt.setString(2, pw);
//			pstmt.setString(3, name);
//			pstmt.setString(4, hp);
//			pstmt.setString(5, sex);
//			pstmt.executeUpdate();
//			pstmt.close();
//		} catch (SQLException ee) {
//			System.err.println("회원 가입 실패!! : " + ee.toString());
//			return false;
//		}
//		return true;
//	}
//
//	public void dlgSign() {
//		Dialog dlg = new Dialog(this, "회원가입", true);
//		Label lbTitle = new Label("회원가입");
//		Button bt = new Button("확인");
//		Label lbId = new Label("아이디");
//		Label lbPw = new Label("패스워드");
//		Label lbName = new Label("이름");
//		Label lbHp = new Label("연락처");
//		Label lbSex = new Label("성별(남자/여자):");
//
//		TextField tfId = new TextField();
//		TextField tfPw = new TextField();
//		TextField tfName = new TextField();
//		TextField tfHp = new TextField();
//		TextField tfSex = new TextField();
//
//		Button btnIdCheck = new Button("중복확인");
//
//		dlg.setLayout(null);
//
//		dlg.add(lbTitle);
//		dlg.add(lbId);
//		dlg.add(lbPw);
//		dlg.add(lbName);
//		dlg.add(lbHp);
//		dlg.add(lbSex);
//		dlg.add(tfId);
//		dlg.add(tfPw);
//		dlg.add(tfName);
//		dlg.add(tfHp);
//		dlg.add(tfSex);
//		dlg.add(btnIdCheck);
//		dlg.add(bt);
//
//		lbTitle.setFont(font25);
//		lbId.setFont(font15);
//		lbPw.setFont(font15);
//		lbName.setFont(font15);
//		lbHp.setFont(font15);
//		lbSex.setFont(font15);
//		tfId.setFont(font15);
//		tfPw.setFont(font15);
//		tfName.setFont(font15);
//		tfHp.setFont(font15);
//		tfSex.setFont(font15);
//		btnIdCheck.setFont(font15);
//		bt.setFont(font15);
//
//		lbTitle.setBounds(50, 50, 200, 30);
//		lbId.setBounds(30, 100, 80, 30);
//		lbPw.setBounds(30, 150, 80, 30);
//		lbName.setBounds(30, 200, 80, 30);
//		lbHp.setBounds(30, 250, 80, 30);
//		lbSex.setBounds(30, 300, 80, 30);
//		tfId.setBounds(110, 100, 80, 30);
//		tfPw.setBounds(110, 150, 80, 30);
//		tfName.setBounds(110, 200, 120, 30);
//		tfHp.setBounds(110, 250, 120, 30);
//		tfSex.setBounds(110, 300, 120, 30);
//
//		btnIdCheck.setBounds(200, 100, 80, 30);
//
//		bt.setBounds(110, 330, 120, 30);
//
//		dlg.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				dlg.setVisible(false);
//			}
//		});
//
//		dlg.setLocation(480, 250);
//		dlg.setSize(350, 400);
//		dlg.setVisible(true);
//	}
//
//	// 회원 정보수정
//	public boolean editMember(String id, String pw, String name, String hp, String sex) {
//		String query = "update tb_member2 set id = ?, pw = ?, name = ?, hp= ? ,sex= ? where id = ?";
//		// 테이블 이름 수정!
//		try {
//			PreparedStatement pstmt = main.prepareStatement(query); // statement 그냥 실행 / preparedStatement ? 동작
//			pstmt.setString(1, id); // 아이디 조회
//			pstmt.setString(2, pw);
//			pstmt.setString(3, name);
//			pstmt.setString(4, hp);
//			pstmt.setString(5, sex);
//			pstmt.setString(6, id);
//			pstmt.executeUpdate();
//			pstmt.close();
//		} catch (SQLException ee) {
//			System.err.println("회원 정보수정 실패!!");
//			return false; // 결과값이 false면 리턴
//		}
//		return true;
//	}
//
//	public void dlgModify() {
//		Dialog dlg = new Dialog(this, "회원가입", true);
//		Label lbTitle = new Label("회원가입");
//		Button bt = new Button("확인");
//		Label lbId = new Label("아이디");
//		Label lbPw = new Label("패스워드");
//		Label lbName = new Label("이름");
//		Label lbHp = new Label("연락처");
//		Label lbSex = new Label("성별(남자/여자):");
//
//		TextField tfId = new TextField();
//		TextField tfPw = new TextField();
//		TextField tfName = new TextField();
//		TextField tfHp = new TextField();
//		TextField tfSex = new TextField();
//
//		Button btnIdCheck = new Button("중복확인");
//
//		dlg.setLayout(null);
//
//		dlg.add(lbTitle);
//		dlg.add(lbId);
//		dlg.add(lbPw);
//		dlg.add(lbName);
//		dlg.add(lbHp);
//		dlg.add(lbSex);
//		dlg.add(tfId);
//		dlg.add(tfPw);
//		dlg.add(tfName);
//		dlg.add(tfHp);
//		dlg.add(tfSex);
//		dlg.add(btnIdCheck);
//		dlg.add(bt);
//
//		lbTitle.setFont(font25);
//		lbId.setFont(font15);
//		lbPw.setFont(font15);
//		lbName.setFont(font15);
//		lbHp.setFont(font15);
//		lbSex.setFont(font15);
//		tfId.setFont(font15);
//		tfPw.setFont(font15);
//		tfName.setFont(font15);
//		tfHp.setFont(font15);
//		tfSex.setFont(font15);
//		btnIdCheck.setFont(font15);
//		bt.setFont(font15);
//
//		lbTitle.setBounds(50, 50, 200, 30);
//		lbId.setBounds(30, 100, 80, 30);
//		lbPw.setBounds(30, 150, 80, 30);
//		lbName.setBounds(30, 200, 80, 30);
//		lbHp.setBounds(30, 250, 80, 30);
//		lbSex.setBounds(30, 300, 80, 30);
//		tfId.setBounds(110, 100, 80, 30);
//		tfPw.setBounds(110, 150, 80, 30);
//		tfName.setBounds(110, 200, 120, 30);
//		tfHp.setBounds(110, 250, 120, 30);
//		tfSex.setBounds(110, 300, 120, 30);
//
//		btnIdCheck.setBounds(200, 100, 80, 30);
//
//		bt.setBounds(110, 330, 120, 30);
//
//		dlg.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				dlg.setVisible(false);
//			}
//		});
//
//		dlg.setLocation(480, 250);
//		dlg.setSize(350, 400);
//		dlg.setVisible(true);
//	}
//	
//	// 회원삭제
//	public boolean deleteMember(String id) {
//
//		
//		String query = "delete from tb_member2 where id = ?";
//		// 테이블 이름 수정!
//
//		try {
//			PreparedStatement pstmt = main.prepareStatement(query);
//			pstmt.setString(1, id);
//			pstmt.executeUpdate();
//			pstmt.close();
//		} catch (SQLException ee) {
//			System.err.println("회원 삭제 실패!!");
//			return false; // 결과값이 false면 리턴
//		}
//		return true;
//	}
//
//	public void dlgDelete() {
//		Dialog dlg = new Dialog(this, "회원가입", true);
//		Label lbTitle = new Label("회원가입");
//		Button bt = new Button("확인");
//		Label lbId = new Label("아이디");
//		Label lbPw = new Label("패스워드");
//		Label lbName = new Label("이름");
//		Label lbHp = new Label("연락처");
//		Label lbSex = new Label("성별(남자/여자):");
//
//		TextField tfId = new TextField();
//		TextField tfPw = new TextField();
//		TextField tfName = new TextField();
//		TextField tfHp = new TextField();
//		TextField tfSex = new TextField();
//
//		Button btnIdCheck = new Button("중복확인");
//
//		dlg.setLayout(null);
//
//		dlg.add(lbTitle);
//		dlg.add(lbId);
//		dlg.add(lbPw);
//		dlg.add(lbName);
//		dlg.add(lbHp);
//		dlg.add(lbSex);
//		dlg.add(tfId);
//		dlg.add(tfPw);
//		dlg.add(tfName);
//		dlg.add(tfHp);
//		dlg.add(tfSex);
//		dlg.add(btnIdCheck);
//		dlg.add(bt);
//
//		lbTitle.setFont(font25);
//		lbId.setFont(font15);
//		lbPw.setFont(font15);
//		lbName.setFont(font15);
//		lbHp.setFont(font15);
//		lbSex.setFont(font15);
//		tfId.setFont(font15);
//		tfPw.setFont(font15);
//		tfName.setFont(font15);
//		tfHp.setFont(font15);
//		tfSex.setFont(font15);
//		btnIdCheck.setFont(font15);
//		bt.setFont(font15);
//
//		lbTitle.setBounds(50, 50, 200, 30);
//		lbId.setBounds(30, 100, 80, 30);
//		lbPw.setBounds(30, 150, 80, 30);
//		lbName.setBounds(30, 200, 80, 30);
//		lbHp.setBounds(30, 250, 80, 30);
//		lbSex.setBounds(30, 300, 80, 30);
//		tfId.setBounds(110, 100, 80, 30);
//		tfPw.setBounds(110, 150, 80, 30);
//		tfName.setBounds(110, 200, 120, 30);
//		tfHp.setBounds(110, 250, 120, 30);
//		tfSex.setBounds(110, 300, 120, 30);
//
//		btnIdCheck.setBounds(200, 100, 80, 30);
//
//		bt.setBounds(110, 330, 120, 30);
//
//		dlg.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				dlg.setVisible(false);
//			}
//		});
//
//		dlg.setLocation(480, 250);
//		dlg.setSize(350, 400);
//		dlg.setVisible(true);
//	}
//}
