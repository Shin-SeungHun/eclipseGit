package 자바수업16일;

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



public class BoardDetail extends Frame implements ActionListener {
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

	Label lbTitle = new Label("게시글 상세화면");
//	static List mList = new List();
	Label lbSubject = new Label("제목:");
	Label lbContent = new Label("내용:");
	Label lbDate = new Label("등록일:");

	TextField tfSubject = new TextField();

	TextArea text = new TextArea();

	Button btnModify = new Button("수정");
	Button btnDelete = new Button("삭제");

	int idx; // 수정이나 삭제를 위한 idx변수

	BoardDetail(int idx) {
		super("게시판");
		this.idx = idx;
		this.setSize(450, 550);
		this.init();// 화면레이아웃구성메서드
		dbCon(); //db접속
		detail(idx);// 상세화면 db조회
		this.start();
		this.setLocation(500, 150);
		this.setVisible(true);
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);
		this.add(lbSubject);
		this.add(lbContent);
		this.add(lbDate);
		this.add(tfSubject);
		this.add(text);
		this.add(btnModify);
		this.add(btnDelete);

		lbTitle.setFont(font25);
		lbSubject.setFont(font15);
		lbContent.setFont(font15);
		lbDate.setFont(font15);
		tfSubject.setFont(font15);
		text.setFont(font15);
		btnModify.setFont(font15);
		btnDelete.setFont(font15);

		lbTitle.setBounds(120, 30, 200, 30);
		lbSubject.setBounds(40, 70, 40, 30);
		lbContent.setBounds(40, 120, 40, 30);
		lbDate.setBounds(180, 120, 100, 30);
		tfSubject.setBounds(100, 70, 250, 30);
		text.setBounds(50, 150, 350, 300);
		btnModify.setBounds(140, 460, 70, 30);
		btnDelete.setBounds(220, 460, 70, 30);
	}

	void start() {
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);

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
//			rs.close();
//			stmt.close();
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

	void detail(int idx) {
		// 수정idx 찾기
		String query = "select * from board where idx='" + idx + "'";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result = "";
			int cnt = 0;
			while (rs.next()) {
//				idxCheck = true;
//				dlgMsg("수정대상을 찾았습니다.");
				// 수정할 목록 가져옴
				tfSubject.setText(rs.getString(2));
				text.setText(rs.getString(3));
//				break;
			}
//			rs.close();
//			stmt.close();
//			conn.close();

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	//
	void updateBoard(int idx, String subject, String content) {
		String query = "update board set title = ?, content = ? where idx = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, idx);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("게시글 수정완료");
			
			BoardList.mList.removeAll();// 리시트항목 모두제거
			BoardList.dataLoad();// 삭제후 디비 새로읽기
			viewClose();
		} catch (SQLException ee) {
			System.err.println("게시글 수정 실패");

		}

	}

	public void deleteBoard(int idx) {
		String query = "delete from board where idx = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("게시글 삭제");
			tfSubject.setText("");
			text.setText("");
			viewClose();

//			BoardList.mList.removeAll();// 리시트 항목 모두 제거
//			BoardList.dataLoad(); // 삭제후 db 새로읽기

		} catch (SQLException ee) {
			System.err.println("게시글 삭제 실패");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// tfSubject.setText(mList);

		if (e.getSource() == btnModify) {

			if (tfSubject.getText().equals("")) {
				dlgMsg("제목을 입력하세요");
				tfSubject.requestFocus();
				return;
			} else if (text.getText().equals("")) {
				dlgMsg("글을 작성해주세요");
				text.requestFocus();
				return;
			}

			updateBoard(idx, tfSubject.getText(), text.getText());
//			new BoardList();
			viewClose();
		} else if (e.getSource() == btnDelete) {

			deleteBoard(idx);
//			new BoardList();
			viewClose();
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
