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

public class BookDel extends Frame implements ActionListener {
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

	Label lbSubject = new Label("책 삭제화면");

	Label lbName = new Label("책 이름:");

	Label lbTitle = new Label("책 제목:");
	Label lbWriter = new Label("책 저자:");
	Label lbPublishing = new Label("출판사:");
//		Label lbDate = new Label("등록일:");

	TextField tfName = new TextField();

	Label lbTitle2 = new Label("대기중...");
	Label lbWriter2 = new Label("대기중...");
	Label lbPublishing2 = new Label("대기중...");

	Button btnTitleCheck = new Button("찾기");
	Button btnDel = new Button("삭제하기");
	Button btnCancel = new Button("닫기");

	BookDel() {
		super("책삭제");
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
		this.add(lbName);
		this.add(tfName);
		this.add(lbTitle);
		this.add(lbTitle2);
		this.add(lbWriter);
		this.add(lbWriter2);
		this.add(lbPublishing);
		this.add(lbPublishing2);
		this.add(btnDel);
		this.add(btnTitleCheck);
		this.add(btnCancel);

		lbSubject.setFont(font25);
		lbName.setFont(font15);
		tfName.setFont(font15);
		lbTitle.setFont(font15);
		lbTitle2.setFont(font15);
		lbWriter.setFont(font15);
		lbWriter2.setFont(font15);
		lbPublishing.setFont(font15);
		lbPublishing2.setFont(font15);

		btnTitleCheck.setFont(font15);
		btnDel.setFont(font15);
		btnCancel.setFont(font15);

		lbSubject.setBounds(70, 30, 200, 30);
		lbName.setBounds(30, 100, 80, 30);
		tfName.setBounds(110, 100, 80, 30);

		lbTitle.setBounds(30, 150, 80, 30);
		lbTitle2.setBounds(110, 150, 120, 30);
		lbWriter.setBounds(30, 200, 80, 30);
		lbWriter2.setBounds(110, 200, 120, 30);
		lbPublishing.setBounds(30, 250, 80, 30);
		lbPublishing2.setBounds(110, 250, 120, 30);

		btnTitleCheck.setBounds(200, 100, 80, 30);
		btnDel.setBounds(110, 300, 80, 30);
		btnCancel.setBounds(110, 340, 80, 30);
	}

	void start() {
		btnTitleCheck.addActionListener(this);
		btnDel.addActionListener(this);
		btnCancel.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	void viewClose() {
		
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

	void detail() {
		// 수정idx 찾기
		String query = "select * from book";
		try {
			rs = stmt.executeQuery(query);
			boolean titleCheck = false;
			while (rs.next()) {

				if (tfName.getText().equals(rs.getString(2))) {
					dlgMsg("삭제할 책을 찾았습니다.");
					titleCheck = true;

					lbTitle2.setText(rs.getString(2));
					lbWriter2.setText(rs.getString(3));
					lbPublishing2.setText(rs.getString(4));
					break;
				}

			}
			if (titleCheck == false) {
				dlgMsg("삭제대상이 없습니다.");
			}
//				rs.close();
//				stmt.close();
//				conn.close();

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	public void deleteBook(String title) {
		String query = "delete from book where title = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("책 삭제");
			lbTitle.setText("");
			lbWriter.setText("");
			lbPublishing.setText("");
			lbPublishing2.setText("");
			viewClose();

//			BoardList.mList.removeAll();// 리시트 항목 모두 제거
//			BoardList.dataLoad(); // 삭제후 db 새로읽기

		} catch (SQLException ee) {
			System.err.println("책 삭제 실패");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTitleCheck) {
			if (tfName.getText().equals("")) {
				dlgMsg("책제목을 입력하세요.");
				return;
			}
			detail();
		} else if (e.getSource() == btnDel) {
			if (tfName.getText().equals("")) {
				dlgMsg("책 제목을 입력하세요");
				tfName.requestFocus();
				return;
			}
			deleteBook(tfName.getText());
		} else if (e.getSource() == btnCancel) {
			viewClose();
		}
	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "책삭제", true);
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
