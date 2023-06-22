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

public class Board extends Frame implements ActionListener {
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/book_db?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Font font10 = new Font("SansSerif", Font.BOLD, 10);

	Label lbTitle = new Label("문의글 남기기");
	
	Label lbSubject = new Label("제목:");
	Label lbContent = new Label("내용:");

	TextField tfSubject = new TextField();

	TextArea content = new TextArea();

	Button btnRegist = new Button("등록");

	Board() {
		super("문의창");
		this.setSize(450, 550);
		this.init();// 화면레이아웃구성메서드
		this.dbCon(); // db접속
		this.start();
		this.setLocation(500, 150);
		this.setVisible(true);
	}

	void init() {
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);
		this.add(lbSubject);
		this.add(lbContent);

		this.add(tfSubject);
		this.add(content);
		this.add(btnRegist);

		lbTitle.setFont(font25);
		lbSubject.setFont(font15);
		lbContent.setFont(font15);

		tfSubject.setFont(font15);
		content.setFont(font15);
		btnRegist.setFont(font15);

		lbTitle.setBounds(120, 30, 200, 30);
		lbSubject.setBounds(40, 70, 40, 30);
		lbContent.setBounds(40, 120, 40, 30);

		tfSubject.setBounds(100, 70, 250, 30);
		content.setBounds(50, 150, 350, 300);
		btnRegist.setBounds(140, 460, 70, 30);

	}

	void start() {
		btnRegist.addActionListener(this);
		
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
	
	void regist() {

		String pquery = "insert into board values (null, ?, ?, now())"; // 시간 함수 now()
		try {
			conn = DriverManager.getConnection(url, id, pass);
			pstmt = conn.prepareStatement(pquery);
			pstmt.setString(1, tfSubject.getText());
			pstmt.setString(2, content.getText());
			pstmt.executeUpdate();
			System.out.println("등록완료");
		} catch (SQLException ee) {
			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
		}
		dbClose();// 디비작업끝나서 닫기

		tfSubject.setEnabled(true);
		content.setEnabled(true);
		tfSubject.setText("");
		content.setText("");

		dlgMsg("문의글이 등록되었습니다.");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegist) {
			if (tfSubject.getText().equals("")) {
				dlgMsg("제목을 입력하세요");
				tfSubject.requestFocus();
				return;
			} else if (content.getText().equals("")) {
				dlgMsg("글을 작성해주세요");
				content.requestFocus();
				return;
			}
			regist();
			BoardList.mList.removeAll();// 리시트항목 모두제거
			BoardList.dataLoad();// 삭제후 디비 새로읽기
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
