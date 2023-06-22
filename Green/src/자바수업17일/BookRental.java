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

public class BookRental extends Frame implements ActionListener {
	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/book_db?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	//////////////////////////////////////////////////////////

	Label lbSubject = new Label("도서 대여하기");
	Label lbTitle = new Label("대여책 제목:");
	Label lbMember = new Label("대여자 이름:");
	Label lbMemberHp = new Label("대여자 연락처(-빼고 입력):");

	TextField tfTitle = new TextField();
	TextField tfMember = new TextField();
	TextField tfMemberHp = new TextField();

	Button btnBookCheck = new Button("찾기");
	Button btnRent = new Button("대여하기");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font10 = new Font("SansSerif", Font.BOLD, 10);

	BookRental() {
		super("도서 대여화면");
		dbCon();
		this.setSize(400, 350);
		this.init();// 화면레이아웃구성메서드
		start();
		this.setLocation(500, 200);
		this.setVisible(true);
	}

	void init() {
		this.setLayout(null);
		// 프레임에 추가..
		this.add(lbSubject);
		this.add(lbTitle);
		this.add(lbMember);
		this.add(lbMemberHp);
		this.add(tfTitle);
		this.add(tfMember);
		this.add(tfMemberHp);
		this.add(btnBookCheck);
		this.add(btnRent);

		// 폰트셋팅
		lbSubject.setFont(font25);
		lbTitle.setFont(font15);
		lbMember.setFont(font15);
		lbMemberHp.setFont(font15);
//		lbDate.setFont(font15);
		tfTitle.setFont(font15);
		btnBookCheck.setFont(font15);
		btnRent.setFont(font15);
		// 배치
		lbSubject.setBounds(90, 50, 200, 30);
		lbTitle.setBounds(30, 100, 120, 30);
		lbMember.setBounds(30, 150, 120, 30);
		lbMemberHp.setBounds(30, 200, 120, 30);

		tfTitle.setBounds(160, 100, 120, 30);
		tfMember.setBounds(160, 150, 120, 30);
		tfMemberHp.setBounds(160, 200, 120, 30);

		btnBookCheck.setBounds(290, 100, 70, 30);
		btnRent.setBounds(130, 270, 100, 30);
	}

	void start() {
		btnRent.addActionListener(this);
		btnBookCheck.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
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
//			pstmt.close();
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
		if (e.getSource() == btnBookCheck) {
			if (tfTitle.getText().equals("")) {
				dlgMsg("책 제목을 입력하세요");
				return;
			}
			detail(tfTitle.getText());
		} else if (e.getSource() == btnRent) {
			if (tfTitle.getText().equals("")) {
				dlgMsg("책 제목을 입력하세요");
				return;
			} else if (tfMember.getText().equals("")) {
				dlgMsg("대여자를 입력하세요");
				return;
			} else if (tfMemberHp.getText().equals("")) {
				dlgMsg("대여자의 연락처를 입력하세요");
				return;
			}
			updateBook(tfTitle.getText());
			bookRent(tfTitle.getText(), tfMember.getText(), tfMemberHp.getText());
		}

	}

	void detail(String bookTitle) {
		// 수정idx 찾기
		String query = "select * from book where title='" + bookTitle + "' and book_rent='yes'";
		try {
//			conn = DriverManager.getConnection(url, id, pass);
//			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			boolean titleCheck = false;
//			String result = "";
//			int cnt = 0;
			while (rs.next()) {
				titleCheck = true;
				dlgMsg("대여가능한 책입니다.");

				// 수정할 목록 가져옴

				break;
			}
			if (titleCheck == false) {
				dlgMsg("대여가능한 책이 아닙니다.");
			}
//				rs.close();
//				stmt.close();
//				conn.close();

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	void updateBook(String title) {
		System.out.println(title);
		String query = "update book set book_rent = ? where title = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "no");
			pstmt.setString(2, title);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("책 대여상태로 변경");
//			BookList.mList.removeAll();// 리시트항목 모두제거
//			BookList.dataLoad();// 삭제후 디비 새로읽기
			viewClose();
			dbClose();
		} catch (SQLException ee) {
			System.err.println("책 대여 상태로 실패");

		}
	}

	void bookRent(String title, String name, String hp) {

		String pquery = "insert into book_rental values (null, ?, ?, ?, now(), null)"; // 시간 함수 now()
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, hp);
//			pstmt.setString(4, "0000-00-00");

			pstmt.executeUpdate();
			System.out.println("대여완료");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
		dbClose();// 디비작업끝나서 닫기

//				tfSubject.setEnabled(true);
//				text.setEnabled(true);
		tfTitle.setText("");
		tfMember.setText("");
		tfMemberHp.setText("");

		dlgMsg("책을 대여하셨습니다.");

	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "책 대여화면", true);
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
