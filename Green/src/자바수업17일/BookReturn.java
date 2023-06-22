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

public class BookReturn extends Frame implements ActionListener {
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

	Label lbSubject = new Label("도서 반납하기");

	Label lbTitle = new Label("반납할 책 제목:");

	TextField tfTitle = new TextField();

	Button btnCheck = new Button("찾기");

	BookReturn() {

		super("도서 반납화면");
		this.dbCon();
		this.setSize(400, 250);
		this.init();// 화면레이아웃구성메서드
		this.start();
		this.setLocation(300, 200);
		this.setVisible(true);
	}

	void init() {
		this.setLayout(null);
		// 프레임에 추가..
		this.add(lbSubject);
		this.add(lbTitle);

		this.add(tfTitle);

		this.add(btnCheck);

		// 폰트셋팅
		lbSubject.setFont(font25);
		lbTitle.setFont(font15);
		tfTitle.setFont(font15);
		btnCheck.setFont(font15);
		// 배치
		lbSubject.setBounds(100, 30, 180, 30);
		lbTitle.setBounds(20, 100, 150, 30);

		tfTitle.setBounds(170, 100, 180, 30);

		btnCheck.setBounds(150, 180, 100, 30);
	}

	void start() {
		btnCheck.addActionListener(this);

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

	void nameCheck(String bookTitle) {
		// 수정아이디 찾기
		String query = "select * from book_rental where book_title='" + bookTitle + "'";
		try {
			rs = stmt.executeQuery(query);
			boolean idCheck = false;
			while (rs.next()) {
				idCheck = true;
				dlgMsg("반납처리가능!정보확인!");

				dlgReturn(bookTitle, rs.getString("rent_member_hp"), rs.getString("rent_date"));
				break;

			}
			if (idCheck == false) {
				dlgMsg("반납가능한 책이 아닙니다.");
			}

		} catch (SQLException ee) {
			System.err.println("실행결과 획득실패!!");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCheck) {
			if (tfTitle.getText().equals("")) {
				dlgMsg("책 제목을 입력하세요");
				return;
			}
			nameCheck(tfTitle.getText());
		}

	}

	// 책 렌탈 상태 변경
	void updateBook(String title) {
		System.out.println(title);
		String query = "update book set book_rent = ? where title = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "yes");
			pstmt.setString(2, title);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("책 대여상태로 변경!");
		} catch (SQLException ee) {
			System.err.println("책 대여상태로 실패!!");

		}

	}

	// 책대여리스트 반납일 업데이트..
	void updateRentalList(String title) {
		String query = "update book_rental set return_date = now() where book_title = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("반납완료!");
		} catch (SQLException ee) {
			System.err.println("책 반납 실패!!");

		}

	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "책 반납화면", true);
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

	void dlgReturn(String title, String hp, String date) {
		Dialog dlg = new Dialog(this, "책 반납화면", true);

		Label lbTitle = new Label("반납책이름:");
		Label lbTitle2 = new Label(title);
//		Label lbMember = new Label("대여자 이름:");
		Label lbHp = new Label("연락처:");
		Label lbHp2 = new Label(hp);
		Label lbRentDate = new Label("대여일자:");
		Label lbRentDate2 = new Label(date);

		Button btnReturn = new Button("반납하기");

		dlg.setLayout(null);
//		dlg.add(lbMember);
		dlg.add(lbTitle);
		dlg.add(lbTitle2);
		dlg.add(lbHp);
		dlg.add(lbHp2);
		dlg.add(lbRentDate);
		dlg.add(lbRentDate2);
		dlg.add(btnReturn);

//		lbMember.setFont(font15);
		lbTitle.setFont(font15);
		lbTitle2.setFont(font15);
		lbHp.setFont(font15);
		lbHp2.setFont(font15);
		lbRentDate.setFont(font15);
		lbRentDate2.setFont(font15);
		btnReturn.setFont(font15);

//		lbMember.setBounds(20, 40, 200, 30);
		lbTitle.setBounds(50, 50, 100, 30);
		lbTitle2.setBounds(150, 50, 100, 30);
		lbHp.setBounds(50, 100, 100, 30);
		lbHp2.setBounds(150, 100, 100, 30);
		lbRentDate.setBounds(50, 150, 100, 30);
		lbRentDate2.setBounds(150, 150, 140, 30);

		btnReturn.setBounds(80, 180, 120, 30);

		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBook(title);// 책제목으로 호출해서 대여상태변환
				updateRentalList(title);
			}
		});
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setLocation(480, 250);
		dlg.setSize(300, 250);
		dlg.setVisible(true);
	}

}
