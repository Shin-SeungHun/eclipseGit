//package 자바수업13일_;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///*성별을 추가해서 만들고 선택시 값 출력하게 아이템 리스너 처리
// * 
// * chocie Man
// * chocie Girl
// * */
//
//
//
//class MemberJoin extends Frame implements FocusListener, ActionListener {
//
//	private Choice ch = new Choice();
//
//	Label lbTitle = new Label("회원가입화면", Label.LEFT);
//	Label lbId = new Label("아이디:");
//	Label lbPw = new Label("패스워드:");
//	Label lbName = new Label("이름:");
//	Label lbHp = new Label("연락처:");
//	Label lbGender = new Label("성별:");
//
//	TextField tfId = new TextField();
//	TextField tfPw = new TextField();
//	TextField tfName = new TextField();
//	TextField tfHp = new TextField();
//	TextField tfGender = new TextField();
//
//	Button btnIdCheck = new Button("중복확인");
//	Button btnJoin = new Button("가입하기");
//	String gender = "남자";
//
//	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
//	Font font15 = new Font("SansSerif", Font.BOLD, 15);
//
//	MemberJoin() {
//		super("회원가입");
//		this.setSize(300, 400);
//		this.init(); // 화면 구성 레이아웃 구성
//		this.start();
//		this.setLocation(500, 200);
//		this.setVisible(true);
//	}
//
//	public void init() { // 레이아웃 구성하기
//		this.setLayout(null); // 레이아웃을 직접좌표처리하는 방식
//		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
//		lbTitle.setBounds(80, 30, 300, 30);
//		lbTitle.setFont(font25);
//
////		lbTitle.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
//
//		this.add(lbId);// 현재 클래스 내부에 생성해서 넣음...
//		lbId.setBounds(20, 80, 55, 30);
//		lbId.setFont(font15);
//		// lbId.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);
//		this.add(tfId);// 현재 클래스 내부에 생성해서 넣음...
//		tfId.setBounds(95, 83, 90, 25);
//		tfId.setFont(font15);
//
//		this.add(btnIdCheck);
//		btnIdCheck.setBounds(195, 80, 70, 30);
//		btnIdCheck.setFont(font15);
//
//		this.add(lbPw);// 현재 클래스 내부에 생성해서 넣음...
//		lbPw.setBounds(20, 115, 69, 30);
//		lbPw.setFont(font15);
//
//		this.add(tfPw);// 현재 클래스 내부에 생성해서 넣음...
//		tfPw.setBounds(95, 117, 120, 25);
//		tfPw.setFont(font15);
//
//		this.add(lbName);// 현재 클래스 내부에 생성해서 넣음...
//		lbName.setBounds(20, 147, 50, 30);
//		lbName.setFont(font15);
//
//		this.add(tfName);// 현재 클래스 내부에 생성해서 넣음...
//		tfName.setBounds(95, 150, 100, 25);
//		tfName.setFont(font15);
//
//		this.add(lbHp);// 현재 클래스 내부에 생성해서 넣음...
//		lbHp.setBounds(20, 180, 55, 30);
//		lbHp.setFont(font15);
//
//		this.add(tfHp);// 현재 클래스 내부에 생성해서 넣음...
//		tfHp.setBounds(95, 185, 120, 25);
//		tfHp.setFont(font15);
//
//		this.add(lbGender);
//		lbGender.setBounds(20, 230, 50, 30);
//		lbGender.setFont(font15);
//
//		this.add(tfGender);
//		tfGender.setBounds(95, 230, 100, 30);
//		tfGender.setFont(font15);
//
//		this.add(btnJoin);
//		btnJoin.setBounds(100, 300, 100, 30);
//		btnJoin.setFont(font15);
//	}
//
//	public void start() {
//		this.btnIdCheck.addActionListener(this);
//		this.btnJoin.addActionListener(this);
//		this.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
//	}
//
//	@Override
//	public void focusGained(FocusEvent e) {
////		if(e.getSource()==tfGender) {
////			if(tfGender.getText().equals("남자")) {
////				System.out.println("chocie Man");
////			}else if(tfGender.getText().equals("여자")) {
////				System.out.println("choice girl");
////			}
////		}
//
////		String Check = tfGender.getText().trim().length();
////		if()
//	}
//
//	@Override
//	public void focusLost(FocusEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == btnJoin) {
//			if (tfId.getText().equals("")) {
//				dlgMsg("아이디를 입력하시오.");
//				return;
//			}else if(tfPw.getText().equals("")) {
//				dlgMsg("비번입력");
//				return;
//			}else if(tfName.getText().equals("")) {
//				dlgMsg("이름입력");
//			}else if(tfHp.getText().equals("")) {
//				dlgMsg("전화번호를 입력");
//				return;
//			}
//			
//			
//		}else if(e.getSource() == btnIdCheck) {
//			if (tfId.getText().equals("")) {
//				dlgMsg("아이디를 입력하시오.");
//				return;
//			}else if(tfPw.getText().equals("")) {
//				dlgMsg("비번입력");
//				return;
//			}else if(tfName.getText().equals("")) {
//				dlgMsg("이름입력");
//			}else if(tfHp.getText().equals("")) {
//				dlgMsg("전화번호를 입력");
//				return;
//			}
//		}
//
//			
//			String inputId = tfId.getText();
//			String inputPw = tfPw.getText();
//			String inputName = tfName.getText();
//			String inputHp = tfHp.getText();
//			
//		////////////////////////////////////////
//		/// 데이타베이스접속..
//
//		try {
//			Class.forName("org.gjt.mm.mysql.Driver");
//		} catch (ClassNotFoundException ee) {
//			System.exit(0);
//		}
//		Connection conn = null;
//		// 접속 주소 : 3306/디비명
//		String url = "jdbc:mysql://localhost:3306/member?useUnicode=true&characterEncoding=utf8";
//		// String url = "jdbc:mysql://127.0.0.1:3306/java";
//		String id = "root";
//		String pass = "qwer";
//		Statement stmt = null;
//		ResultSet rs = null;
//		String query = "select * from tb_member2";
//		try {
//			conn = DriverManager.getConnection(url, id, pass);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//			boolean idCheck = true;
//			while (rs.next()) {
//				
//				if(inputId.equals(rs.getString("id"))) {
//					dlgMsg("중복된 아이디");
//					idCheck =false;
//					break;
//				}
//				
//			}
//			if(idCheck==true) {
//				dlgMsg("사용가능한 아이디");
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException ee) {
//			System.err.println("error = " + ee.toString());
//		}
//
//	}
//
//	void dlgMsg(String msg) {
//		Dialog dlg = new Dialog(this, "회원가입", true);
//		Label lbContent = new Label(msg);
//		Button bt = new Button("확인");
//		dlg.setLayout(null);
//		dlg.add(lbContent);
//		lbContent.setFont(font15);
//		dlg.add(bt);
//		bt.setFont(font15);
//		lbContent.setBounds(50, 50, 200, 30);
//		bt.setBounds(80, 120, 120, 30);
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
//		dlg.setSize(300, 200);
//		dlg.setVisible(true);
//	}
//}