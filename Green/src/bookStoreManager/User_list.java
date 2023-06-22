package bookStoreManager;

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

public class User_list extends Frame implements ItemListener, ActionListener {

	Label lbTitle = new Label("[[  회원 리스트  ]]");
	List mList = new List();
	Button btnOk = new Button("확인");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	User_list() {
		super("회원목록");
		this.setSize(300, 400);
		this.init();// 화면레이아웃구성메서드
		start();
		this.setLocation(500, 200);
		dataLoad();
		this.setVisible(true);

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

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);
		this.add(mList);
		this.add(btnOk);
		
		lbTitle.setFont(font25);
		mList.setFont(font15);
		btnOk.setFont(font15);
		
		lbTitle.setBounds(50, 50, 200, 30);
		mList.setBounds(10, 100, 280, 220);
		btnOk.setBounds(110, 340, 80, 30);

	}

	void dataLoad() {


		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		Connection conn = null;
	
		String url = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8";
	
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from user";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result = "";
			while (rs.next()) {
				result = "idx: " + rs.getString("idx") + " / id: " + rs.getString("id") + " / pw: " + rs.getString("pw")
						+ " / 이름: " + rs.getString("name") + " / 닉네임: " + rs.getString("nickName")+" / 나이: "+rs.getString("age")+" / 연락처: " + rs.getString("hp") + " / 성별: "
						+ rs.getString("gender");
				System.out.println("result:" + result);
				mList.add(result);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		dlgMsg(mList.getSelectedItem());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewClose();

	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "alert", true);
		Label lbContent = new Label(msg);
		Button bt = new Button("닫기");
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
