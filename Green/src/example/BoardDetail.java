package example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class BoardDetail extends Frame implements ActionListener {
	// 디비관련 클래스변수들...
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
///////////////////////
	Label lbTitle = new Label("[[ 게시글 상세화면 ]]");
	Label lbSubject = new Label("제목:");
	Label lbContent = new Label("내용:");

	TextField tfSubject = new TextField();
	TextArea ta = new TextArea();

	Button btnEdit = new Button("글수정");
	Button btnDel = new Button("글삭제");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	int idx;// 수정이나 삭제를 위한 idx변수

	BoardDetail(int idx) {
		super("게시판");
		this.idx = idx;
		this.setSize(350, 450);
		this.init();// 화면레이아웃구성메서드
		dbCon(); // 디비접속
		detail(idx);// 상세화면 디비 조회
		start();
		this.setLocation(300, 100);
		this.setVisible(true);

	}

	void start() {
		btnEdit.addActionListener(this);
		btnDel.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	void viewClose() {
		this.setVisible(false);
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);
		lbTitle.setFont(font25);
		lbTitle.setBounds(70, 50, 240, 30);

		this.add(lbSubject);
		lbSubject.setFont(font15);
		lbSubject.setBounds(30, 100, 50, 30);
		this.add(tfSubject);
		tfSubject.setFont(font15);
		tfSubject.setBounds(90, 100, 200, 30);
		this.add(lbContent);
		lbContent.setFont(font15);
		lbContent.setBounds(30, 150, 80, 30);
		this.add(ta);
		ta.setFont(font15);
		ta.setBounds(30, 180, 300, 170);
		this.add(btnEdit);
		btnEdit.setFont(font15);
		btnEdit.setBounds(70, 360, 100, 40);
		this.add(btnDel);
		btnDel.setFont(font15);
		btnDel.setBounds(200, 360, 100, 40);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEdit) {
			if (tfSubject.getText().equals("")) {
				dlgMsg("제목을 입력하시오.");
				return;
			} else if (ta.getText().equals("")) {
				dlgMsg("내용을 입력하시오.");
				return;
			}

			updateBoard(idx, tfSubject.getText(), ta.getText());
		} else if (e.getSource() == btnDel) {
			deleteMember(idx);
		}
//		dlgMsg("정상적으로 글 등록 완료!");
	}

	void updateBoard(int idx, String subject, String content) {
		String query = "update board set title = ?, content = ? where idx = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, idx);

			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("수정완료!");

			BoardList.mList.removeAll();// 리시트항목 모두제거
			BoardList.dataLoad();// 삭제후 디비 새로읽기
			this.setVisible(false);

		} catch (SQLException ee) {
			System.err.println("게시글 수정 실패!!");

		}

	}

	public void deleteMember(int idx) {
		String query = "delete from board where idx = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			pstmt.close();
			dlgMsg("게시글 삭제완료!!");

			tfSubject.setText("");
			ta.setText("");
			this.setVisible(false);

			BoardList.mList.removeAll();// 리시트항목 모두제거
			BoardList.dataLoad();// 삭제후 디비 새로읽기
		} catch (SQLException ee) {
			System.err.println("게시글 삭제완료!!");
		}
	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "상세화면알림", true);
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

	void detail(int idx) {

		String query = "select * from board where idx='" + idx + "'";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result = "";
			int count = 0;
			while (rs.next()) {
				tfSubject.setText(rs.getString("title"));
				ta.setText(rs.getString("content"));
			}

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

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
}
