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

public class BookEdit extends Frame implements ActionListener {
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

	Label lbSubject = new Label("책 수정화면");

	Label lbTitle = new Label("책 제목:");
	Label lbWriter = new Label("책 저자:");
	Label lbPublishing = new Label("출판사:");
//		Label lbDate = new Label("등록일:");

	TextField tfTitle = new TextField();
	TextField tfWriter = new TextField();
	TextField tfPublishing = new TextField();

	Button btnTitleCheck = new Button("찾기");
	Button btnEdit = new Button("수정하기");
	Button btnCancel = new Button("닫기");

	int idx;

	BookEdit() {
		super("책수정");
//		this.idx = idx;
		this.setSize(300, 400);
		this.init();// 화면레이아웃구성메서드
		this.dbCon();

		this.start();
		this.setLocation(500, 200);
		this.setVisible(true);
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);
		this.add(lbSubject);
		this.add(lbTitle);
		this.add(lbWriter);
		this.add(lbPublishing);

		this.add(tfTitle);
		this.add(tfWriter);
		this.add(tfPublishing);

		this.add(btnTitleCheck);
		this.add(btnTitleCheck);
		this.add(btnEdit);
		this.add(btnCancel);

		// 폰트셋팅
		lbSubject.setFont(font25);
		lbTitle.setFont(font15);
		lbWriter.setFont(font15);
		lbPublishing.setFont(font15);
		btnTitleCheck.setFont(font15);
		btnEdit.setFont(font15);
		btnCancel.setFont(font15);

		// 배치
		lbSubject.setBounds(80, 30, 150, 30);
		lbTitle.setBounds(20, 100, 60, 30);
		lbWriter.setBounds(20, 150, 60, 30);
		lbPublishing.setBounds(20, 200, 60, 30);

		tfTitle.setBounds(100, 100, 120, 30);
		tfWriter.setBounds(100, 150, 120, 30);
		tfPublishing.setBounds(100, 200, 120, 30);

		btnTitleCheck.setBounds(230, 100, 50, 30);
		btnEdit.setBounds(110, 280, 80, 30);
		btnCancel.setBounds(110, 320, 80, 30);
	}

	void start() {
		btnTitleCheck.addActionListener(this);
		btnEdit.addActionListener(this);
		btnCancel.addActionListener(this);
		
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

	void detail(String findTitle) {
		// 수정idx 찾기
		String query = "select * from book where title='" + findTitle + "'";
		try {
//			conn = DriverManager.getConnection(url, id, pass);
//			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			boolean titleCheck = false;
//			String result = "";
//			int cnt = 0;
			while (rs.next()) {
				titleCheck = true;
					dlgMsg("수정대상을 찾았습니다.");
				// 수정할 목록 가져옴
			
				break;
			}
			if(titleCheck == false) {
				dlgMsg("수정대상이 없습니다.");
			}
//				rs.close();
//				stmt.close();
//				conn.close();

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	//
	void updateBook(String title, String writer, String publishing) {
		String query = "update book set title = ?, writer = ?, publishing = ? where title = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, publishing);
			pstmt.setString(4, title);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("책 수정완료");
//			BookList.mList.removeAll();// 리시트항목 모두제거
//			BookList.dataLoad();// 삭제후 디비 새로읽기
			viewClose();
		} catch (SQLException ee) {
			System.err.println("책 수정 실패");

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTitleCheck) {
			if (tfTitle.getText().equals("")) {
				dlgMsg("책제목을 입력하시오.");
				return;
			}
			detail(tfTitle.getText());
		} else if (e.getSource() == btnEdit) {
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
			updateBook(tfTitle.getText(), tfWriter.getText(), tfPublishing.getText());
		} else if (e.getSource() == btnCancel) {
			viewClose();
		}
	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "책수정", true);
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
