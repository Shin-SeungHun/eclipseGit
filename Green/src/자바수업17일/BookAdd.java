package 자바수업17일;

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

import 자바수업16일.BoardList;

public class BookAdd extends Frame implements ActionListener {
	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/book_db?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	//////////////////////////////////////////////////////////

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font10 = new Font("SansSerif", Font.BOLD, 10);

	Label lbSubject = new Label("책 등록화면");
	Label lbTitle = new Label("책 제목:");
	Label lbWriter = new Label("책 저자:");
	Label lbPublishing = new Label("출판사:");
//	Label lbDate = new Label("등록일:");

	TextField tfTitle = new TextField();
	TextField tfWriter = new TextField();
	TextField tfPublishing = new TextField();
//	TextField tfDate = new TextField();

	Button btnRegist = new Button("등록하기");

	BookAdd() {
		super();
		dbCon();
		this.setSize(300, 400);
		this.init();
		this.start();

		this.setLocation(500, 150);
//		dbDataLoad();
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

	void dbClose() {
		// Close 작업
		try {
//				rs.close();
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

	// 초기화 함수
	void init() {
		this.setLayout(null);
		// 프레임에 추가..
		this.add(lbSubject);
		this.add(lbTitle);
		this.add(lbWriter);
		this.add(lbPublishing);
//		this.add(lbDate);
		this.add(tfTitle);
		this.add(tfWriter);
		this.add(tfPublishing);
//		this.add(tfDate);

		this.add(btnRegist);
		// 폰트셋팅
		lbSubject.setFont(font25);
		lbTitle.setFont(font15);
		lbWriter.setFont(font15);
		lbPublishing.setFont(font15);
//		lbDate.setFont(font15);
		btnRegist.setFont(font15);
		// 배치
		lbSubject.setBounds(80, 30, 150, 30);
		lbTitle.setBounds(20, 100, 60, 30);
		lbWriter.setBounds(20, 150, 60, 30);
		lbPublishing.setBounds(20, 200, 60, 30);
//		lbDate.setBounds(20, 250, 60, 30);

		tfTitle.setBounds(100, 100, 150, 30);
		tfWriter.setBounds(100, 150, 150, 30);
		tfPublishing.setBounds(100, 200, 150, 30);
//		tfDate.setBounds(100, 250, 150, 30);

		btnRegist.setBounds(100, 300, 100, 40);
	}

	void start() {
		this.btnRegist.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	void viewClose() {
		dbClose();
		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegist) {

			if (tfTitle.getText().equals("")) {
				dlgMsg("책 제목을 입력하세요");
				tfTitle.requestFocus();
				return;
			} else if (tfWriter.getText().equals("")) {
				dlgMsg("작가를 입력하세요");
				return;
			} else if (tfPublishing.getText().equals("")) {
				dlgMsg("출판사를 입력하세요");
				return;
			}
			// 게시글 등록
			regist();
		}
//				new BoardList();

	}

	void regist() {

		String pquery = "insert into book values (null, ?, ?, ?, now(), ?)"; // 시간 함수 now()
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfTitle.getText());
			pstmt.setString(2, tfWriter.getText());
			pstmt.setString(3, tfPublishing.getText());
			pstmt.setString(4, "yes");

			pstmt.executeUpdate();
			System.out.println("책 등록완료");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
		dbClose();// 디비작업끝나서 닫기

//				tfSubject.setEnabled(true);
//				text.setEnabled(true);
		tfTitle.setText("");
		tfWriter.setText("");
		tfPublishing.setText("");

		dlgMsg("책이 등록되었습니다.");

	}

	// 등록 메세지
	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "책 등록화면", true);
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
