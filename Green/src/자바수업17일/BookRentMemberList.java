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

public class BookRentMemberList extends Frame implements ActionListener, ItemListener {

	Label lbTitle = new Label("대여자 리스트");

	static List mList = new List();

	Button btnOk = new Button("확인");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.PLAIN, 15);

	static int boardIdx[] = new int[20];

	BookRentMemberList() {
		super("미반납 회원 목록");
		this.setSize(450, 350);
		this.init();// 화면레이아웃구성메서드
		this.start();
		rentMemberList("no");
		this.setLocation(300, 100);
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

		lbTitle.setBounds(130, 30, 200, 30);
		mList.setBounds(25, 80, 400, 200);
		btnOk.setBounds(180, 300, 80, 30);

	}

	void start() {
		btnOk.addActionListener(this);
		mList.addItemListener(this);
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
		if (e.getSource() == btnOk) {
			viewClose();
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		dlgMemberDetail(boardIdx[mList.getSelectedIndex()]);
	}

	static void rentMemberList(String gubun) {
////////////////////////////////////////
///데이타베이스접속..

		String query = "select * from book_rental";

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}

		Connection conn = null;
//접속 주소 : 3306/디비명
		String url = "jdbc:mysql://localhost:3306/book_db?useUnicode=true&characterEncoding=utf8";
//String url = "jdbc:mysql://127.0.0.1:3306/java";
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result = "";
			int cnt = 0;
			mList.removeAll();
			while (rs.next()) {
				if (rs.getString("return_date") == null) {
					result = "idx:" + rs.getString("idx") + " / 이름: " + rs.getString("rent_member_name") + " / 연락처: "
							+ rs.getString("rent_member_hp") + " / 책제목: " + rs.getString("book_title") + " / 대여일자: "
							+ rs.getString("rent_date");

					mList.add(result);

					// 상세보기 처리를 위해서 싱크를 맞춰서 idx값을 저장
					// 리스트에서 아이템 선택시 인덱스값하고 맞춰서 제어를 위해
					boardIdx[cnt] = Integer.parseInt(rs.getString("idx"));
					cnt++;
				}
			}

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
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

	void dlgMemberDetail(int idx) {
		String bookTitle = "", name = "", hp = "", date = "";

		String query = "select * from book_rental where idx='" + idx + "'";

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

		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result = "";
			while (rs.next()) {
				// 상세정보 변수에 담기.
				bookTitle = rs.getString("book_title");
				name = rs.getString("rent_member_name");
				hp = rs.getString("rent_member_hp");
				date = rs.getString("rent_date");
			}

		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

		Dialog dlg = new Dialog(this, "대여자 정보", true);

		Label lbTitle = new Label("대여책 이름:");
		Label lbTitle2 = new Label(bookTitle);
		Label lbName = new Label("대여자 이름:");
		Label lbName2 = new Label(name);
		Label lbHp = new Label("대여자 연락처:");
		Label lbHp2 = new Label(hp);
		Label lbRentDate = new Label("대여일자:");
		Label lbRentDate2 = new Label(date);

		Button bt = new Button("확인");

		dlg.setLayout(null);
		dlg.add(lbTitle);
		dlg.add(lbTitle2);
		dlg.add(lbName);
		dlg.add(lbName2);
		dlg.add(lbHp);
		dlg.add(lbHp2);
		dlg.add(lbRentDate);
		dlg.add(lbRentDate2);
		dlg.add(bt);

		lbTitle.setFont(font15);
		lbTitle2.setFont(font15);
		lbName.setFont(font15);
		lbName2.setFont(font15);
		lbHp.setFont(font15);
		lbHp2.setFont(font15);
		lbRentDate.setFont(font15);
		lbRentDate2.setFont(font15);
		bt.setFont(font15);

		lbTitle.setBounds(20, 50, 100, 30);
		lbTitle2.setBounds(120, 50, 170, 30);
		lbName.setBounds(20, 100, 100, 30);
		lbName2.setBounds(120, 100, 100, 30);
		lbHp.setBounds(20, 150, 100, 30);
		lbHp2.setBounds(120, 150, 100, 30);
		lbRentDate.setBounds(20, 200, 100, 30);
		lbRentDate2.setBounds(120, 200, 140, 30);

		bt.setBounds(100, 250, 120, 30);

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
		dlg.setSize(320, 350);
		dlg.setVisible(true);
	}

}
