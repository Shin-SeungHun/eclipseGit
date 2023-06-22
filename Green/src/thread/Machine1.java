package thread;

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

public class Machine1 extends Frame implements ActionListener, Runnable {

	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/factory?useUnicode=true&characterEncoding=utf8";
	String id = "root";
	String pass = "qwer";
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	Label lbTitle = new Label("기계 1 조작반");
	Button btnOn = new Button("전원ON");
	Button btnOff = new Button("전원OFF");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	boolean onOff = false;

	static int machine1Cnt;

	static boolean machine1Start = false;

	public Machine1() {
		super("machine1 operation");
//		dbCon();
		this.setSize(320, 200);
		this.init();
		this.start();
		this.setLocation(900, 300);
		this.setVisible(true);
	}

	void viewClose() {
		this.setVisible(false);
	}

	public void start() {
		btnOn.addActionListener(this);
		btnOff.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	public void init() {
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(70, 40, 200, 30);
		lbTitle.setFont(font25);

		this.add(btnOn);
		btnOn.setBounds(40, 100, 100, 40);
		btnOn.setFont(font15);

		this.add(btnOff);
		btnOff.setBounds(170, 100, 100, 40);
		btnOff.setFont(font15);
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
			e.printStackTrace(); // printStackTrace는 리턴값이 없다 호출하면 메소드가 내부적으로 예외 결과를 화면에 출력, 가장 자세한 예외 정보를 제공, 에러의
									// 발생근원지를 찾아서 단계별로 에러를 출력
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOn) {
			FactoryCheck.btnMachine1.enable(false);
			FactoryCheck.lbMachineText1.setForeground(Color.RED);
			FactoryCheck.lbMachineText1.setText("가동중");
			machine1Start = true;
		} else if (e.getSource() == btnOff) {
			FactoryCheck.btnMachine1.enable(true);
			FactoryCheck.lbMachineText1.setForeground(Color.BLACK);
			FactoryCheck.lbMachineText1.setText("대기중");
			machine1Start = false;
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}

			if (machine1Start == true) {
				machine1Cnt++;
				try {
					Thread.sleep(2000);
					FactoryCheck.lbMachine1.setText("기계 1출하량:" + machine1Cnt + "개");
					System.out.println("동작중..");
				} catch (InterruptedException e) {

				}
			}
		}

	}

//	void machine1() {
//		String pquery = "insert into product values (null, ?, ?, ?, ?, ?, ?)";
//		try {
//			conn = DriverManager.getConnection(url, id, pass);
//			pstmt = conn.prepareStatement(pquery);
//			pstmt.setString(1, FactoryCheck.lbMachine1.getText());
//			pstmt.setString(2, Integer.toString(FactoryCheck.machine1Cnt));
//			pstmt.setString(3, FactoryCheck.lbMachineTotal.getText());
////			pstmt.setInt(4, );
////			pstmt.setString(5, );
////			pstmt.setString(6, );
//			pstmt.executeUpdate();
//			System.out.println("실행성공");
//		} catch (SQLException ee) {
//			System.err.println("Query 실행 클래스 생성 에러~!! : " + ee.toString());
//		}
//	}
}
