package 자바수업17일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardList extends Frame implements ItemListener, ActionListener {
	Label lbTitle = new Label("[[  문의글 목록  ]]");

	static List mList = new List();
	Button btnOk = new Button("확인");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	static int boardIdx[] = new int[20];

	static BoardList boardList;

	BoardList() {
		super("문의글 목록");
		boardList = this;
		this.setSize(450, 400);
		this.init();// 화면레이아웃구성메서드
		start();
		this.setLocation(500, 200);
		dataLoad();
		this.setVisible(true);
	}

	void init() {
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);
		this.add(mList);
		this.add(btnOk);

		lbTitle.setFont(font25);
		mList.setFont(font15);
		btnOk.setFont(font15);

		lbTitle.setBounds(120, 50, 200, 30);
		mList.setBounds(20, 100, 400, 220);
		btnOk.setBounds(180, 340, 80, 30);

	}

	void start() {
		btnOk.addActionListener(this);

		mList.addItemListener(this);

//		mList.addItemListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	void viewClose() {
//		this.setVisible(false);
//		dispose();
	}

	static void dataLoad() {
////////////////////////////////////////
///데이타베이스접속..

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;
// 접속 주소 : 3306/디비명
		String url = "jdbc:mysql://localhost:3306/book_db?useUnicode=true&characterEncoding=utf8";
// String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from board";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result = "";
			int cnt = 0;
			while (rs.next()) {
				if (cnt == 20) {
					break;
				}
				result = rs.getString(1) + " / " + rs.getString(2) + " / " + rs.getString(3) + " / " + rs.getString(4);
				System.out.println("result:" + result);
				mList.add(result);

				// 상세보기 처리를 위해서 싱크를 맞춰서 idx값을 저장
				// 리스트에서 아이템 선택시 인덱스값하고 맞춰서 제어를 위해
				boardIdx[cnt] = Integer.parseInt(rs.getString("idx"));
				cnt++;

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			viewClose();
//			BoardList.boardList = null; //클래스 초기화
//			BoardList.boardList.dispose();
		}
//		new BoardDetail(boardIdx[mList.getSelectedIndex()]);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

//		System.out.println("mList.getSelectedIndex():" + mList.getSelectedIndex());
//		System.out.println("boardIdx[mList]:" + mList.getSelectedIndex());
		BoardDetail boardDetail = new BoardDetail(boardIdx[mList.getSelectedIndex()]);
		System.out.println("");

	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "문의글 목록", true);
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
