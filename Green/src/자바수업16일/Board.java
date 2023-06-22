package 자바수업16일;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.*;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
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


public class Board extends Frame implements ActionListener {
	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/db_board?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	//////////////////////////////////////////////////////////

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font10 = new Font("SansSerif", Font.BOLD, 10);

	Label lbTitle = new Label("게시글 등록");

	Label lbSubject = new Label("제목:");
	Label lbContent = new Label("내용:");

	TextField tfSubject = new TextField();

	TextArea text = new TextArea();

	Button btnRegist = new Button("등록");

	Board() {
		super("게시판");
		dbCon();
		this.setSize(450, 550);
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
//			rs.close();
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
		this.add(lbTitle);
		this.add(lbSubject);
		this.add(lbContent);
		this.add(tfSubject);
		this.add(text);
		this.add(btnRegist);
		// 폰트셋팅
		lbTitle.setFont(font25);
		lbSubject.setFont(font15);
		lbContent.setFont(font15);
		tfSubject.setFont(font15);
		text.setFont(font15);
		btnRegist.setFont(font15);
		// 배치
		lbTitle.setBounds(160, 30, 150, 30);
		lbSubject.setBounds(40, 70, 40, 30);
		lbContent.setBounds(40, 120, 40, 30);
		tfSubject.setBounds(100, 70, 250, 30);
		text.setBounds(50, 150, 350, 300);
		btnRegist.setBounds(190, 480, 70, 30);
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
		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegist) {

			if (tfSubject.getText().equals("")) {
				dlgMsg("제목을 입력하세요");
				tfSubject.requestFocus();
				return;
			} else if (text.getText().equals("")) {
				dlgMsg("글을 작성해주세요");
				text.requestFocus();
				return;
			}
			// 게시글 등록
			regist();
			
			BoardList.mList.removeAll();// 리시트항목 모두제거
			BoardList.dataLoad();// 삭제후 디비 새로읽기
//			new BoardList();
			
		}

	}

	void regist() {

		String pquery = "insert into board values (null, ?, ?, now())"; // 시간 함수 now()
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfSubject.getText());
			pstmt.setString(2, text.getText());
			pstmt.executeUpdate();
			System.out.println("등록완료");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
		dbClose();// 디비작업끝나서 닫기

//		tfSubject.setEnabled(true);
//		text.setEnabled(true);
		tfSubject.setText("");
		text.setText("");

		dlgMsg("게시글이 등록되었습니다.");

	}

	// 등록 메세지
	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "게시판", true);
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
