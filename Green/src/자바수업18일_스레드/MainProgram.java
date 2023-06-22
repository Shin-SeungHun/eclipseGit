package 자바수업18일_스레드;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MainProgram extends Frame implements ActionListener, Runnable {

	private Dimension dimen;
	int fullSizeWidth, fullSizeHeight;
	Label lbTitle = new Label("공장 가동 체크 프로그램");
	static Button btnCom1 = new Button(ServerData.productName[0]);
	static Button btnCom2 = new Button(ServerData.productName[1]);
	static Button btnCom3 = new Button(ServerData.productName[2]);
	static Button btnCom4 = new Button(ServerData.productName[3]);
	static Button btnCom5 = new Button(ServerData.productName[4]);
	static Button btnCom6 = new Button(ServerData.productName[5]);
	static Button btnAdmin = new Button("관리자");

	static Label lbCom1 = new Label("정지중", Label.CENTER);
	static Label lbCom2 = new Label("정지중", Label.CENTER);
	static Label lbCom3 = new Label("정지중", Label.CENTER);
	static Label lbCom4 = new Label("정지중", Label.CENTER);
	static Label lbCom5 = new Label("정지중", Label.CENTER);
	static Label lbCom6 = new Label("정지중", Label.CENTER);

	static Label lbCom1Time = new Label("생산시간간격(초):2초", Label.CENTER);
	static Label lbCom2Time = new Label("생산시간간격(초):2초", Label.CENTER);
	static Label lbCom3Time = new Label("생산시간간격(초):2초", Label.CENTER);
	static Label lbCom4Time = new Label("생산시간간격(초):2초", Label.CENTER);
	static Label lbCom5Time = new Label("생산시간간격(초):2초", Label.CENTER);
	static Label lbCom6Time = new Label("생산시간간격(초):2초", Label.CENTER);

	static Label lbCom1Target = new Label("목표량:1000개", Label.CENTER);
	static Label lbCom2Target = new Label("목표량:1000개", Label.CENTER);
	static Label lbCom3Target = new Label("목표량:1000개", Label.CENTER);
	static Label lbCom4Target = new Label("목표량:1000개", Label.CENTER);
	static Label lbCom5Target = new Label("목표량:1000개", Label.CENTER);
	static Label lbCom6Target = new Label("목표량:1000개", Label.CENTER);

	static Label lbCom1Cnt = new Label("기계1출하량:0개", Label.LEFT);
	static Label lbCom2Cnt = new Label("기계2출하량:0개", Label.LEFT);
	static Label lbCom3Cnt = new Label("기계3출하량:0개", Label.LEFT);
	static Label lbCom4Cnt = new Label("기계4출하량:0개", Label.LEFT);
	static Label lbCom5Cnt = new Label("기계5출하량:0개", Label.LEFT);
	static Label lbCom6Cnt = new Label("기계6출하량:0개", Label.LEFT);
	Label lbComTotCnt = new Label("총출하량:0개", Label.LEFT);

	Font font35 = new Font("TimesRoman", Font.PLAIN, 35);
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	int tot;// 총출하량

	MainProgram() {
		super("공장 가동 체크 프로그램");
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		fullSizeWidth = (int) (dimen.getWidth() / 2);// 모든해상도 화면가로의반
		fullSizeHeight = (int) (dimen.getHeight());// 모든해상도 화면세로꽉
		this.setSize(fullSizeWidth, fullSizeHeight);
		this.init();
		this.control();// 직급별 및 파트별 분류
		this.start();
		this.setLocation(0, 0);
		this.setVisible(true);

	}

	void start() {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(210, 40, 1000, 50);
		lbTitle.setFont(font35);

		this.add(btnCom1);
		btnCom1.setFont(font25);
		this.add(btnCom2);
		btnCom2.setFont(font25);
		this.add(btnCom3);
		btnCom3.setFont(font25);
		this.add(btnCom4);
		btnCom4.setFont(font25);
		this.add(btnCom5);
		btnCom5.setFont(font25);
		this.add(btnCom6);
		btnCom6.setFont(font25);
		this.add(btnAdmin);
		btnAdmin.setFont(font25);

		this.add(lbCom1);
		lbCom1.setFont(font25);
		this.add(lbCom2);
		lbCom2.setFont(font25);
		this.add(lbCom3);
		lbCom3.setFont(font25);
		this.add(lbCom4);
		lbCom4.setFont(font25);
		this.add(lbCom5);
		lbCom5.setFont(font25);
		this.add(lbCom6);
		lbCom6.setFont(font25);

		this.add(lbCom1Time);
		lbCom1Time.setFont(font15);
		this.add(lbCom2Time);
		lbCom2Time.setFont(font15);
		this.add(lbCom3Time);
		lbCom3Time.setFont(font15);
		this.add(lbCom4Time);
		lbCom4Time.setFont(font15);
		this.add(lbCom5Time);
		lbCom5Time.setFont(font15);
		this.add(lbCom6Time);
		lbCom6Time.setFont(font15);

		this.add(lbCom1Target);
		lbCom1Target.setFont(font15);
		this.add(lbCom2Target);
		lbCom2Target.setFont(font15);
		this.add(lbCom3Target);
		lbCom3Target.setFont(font15);
		this.add(lbCom4Target);
		lbCom4Target.setFont(font15);
		this.add(lbCom5Target);
		lbCom5Target.setFont(font15);
		this.add(lbCom6Target);
		lbCom6Target.setFont(font15);

		this.add(lbCom1Cnt);
		lbCom1Cnt.setFont(font25);
		this.add(lbCom2Cnt);
		lbCom2Cnt.setFont(font25);
		this.add(lbCom3Cnt);
		lbCom3Cnt.setFont(font25);
		this.add(lbCom4Cnt);
		lbCom4Cnt.setFont(font25);
		this.add(lbCom5Cnt);
		lbCom5Cnt.setFont(font25);
		this.add(lbCom6Cnt);
		lbCom6Cnt.setFont(font25);
		this.add(lbComTotCnt);
		lbComTotCnt.setFont(font25);

		btnCom3.setBounds(50, 100, 200, 200);
		btnCom4.setBounds(300, 100, 200, 200);
		btnCom5.setBounds(550, 100, 200, 200);
		btnCom2.setBounds(50, 400, 200, 200);
		btnCom6.setBounds(550, 400, 200, 200);
		btnCom1.setBounds(50, 700, 200, 200);
		btnAdmin.setBounds(550, 700, 200, 200);

		lbCom3.setBounds(50, 300, 200, 30);
		lbCom4.setBounds(300, 300, 200, 30);
		lbCom5.setBounds(550, 300, 200, 30);
		lbCom2.setBounds(50, 600, 200, 30);
		lbCom6.setBounds(550, 600, 200, 30);
		lbCom1.setBounds(50, 900, 200, 30);

		lbCom3Time.setBounds(50, 330, 200, 30);
		lbCom4Time.setBounds(300, 330, 200, 30);
		lbCom5Time.setBounds(550, 330, 200, 30);
		lbCom2Time.setBounds(50, 630, 200, 30);
		lbCom6Time.setBounds(550, 630, 200, 30);
		lbCom1Time.setBounds(50, 930, 200, 30);

		lbCom3Target.setBounds(50, 360, 200, 30);
		lbCom4Target.setBounds(300, 360, 200, 30);
		lbCom5Target.setBounds(550, 360, 200, 30);
		lbCom2Target.setBounds(50, 660, 200, 30);
		lbCom6Target.setBounds(550, 660, 200, 30);
		lbCom1Target.setBounds(50, 960, 200, 30);

		lbCom1Cnt.setBounds(300, 400, 250, 40);
		lbCom2Cnt.setBounds(300, 450, 250, 40);
		lbCom3Cnt.setBounds(300, 500, 250, 40);
		lbCom4Cnt.setBounds(300, 550, 250, 40);
		lbCom5Cnt.setBounds(300, 600, 250, 40);
		lbCom6Cnt.setBounds(300, 650, 250, 40);
		lbComTotCnt.setBounds(300, 700, 250, 40);

		// 디비값으로 변경하기...
		lbCom1Time.setText("생산시간간격(초):" + ServerData.productSecond[0] + "초");
		lbCom2Time.setText("생산시간간격(초):" + ServerData.productSecond[1] + "초");
		lbCom3Time.setText("생산시간간격(초):" + ServerData.productSecond[2] + "초");
		lbCom4Time.setText("생산시간간격(초):" + ServerData.productSecond[3] + "초");
		lbCom5Time.setText("생산시간간격(초):" + ServerData.productSecond[4] + "초");
		lbCom6Time.setText("생산시간간격(초):" + ServerData.productSecond[5] + "초");

		lbCom1Target.setText("목표량:" + ServerData.productCnt[0] + "개");
		lbCom2Target.setText("목표량:" + ServerData.productCnt[1] + "개");
		lbCom3Target.setText("목표량:" + ServerData.productCnt[2] + "개");
		lbCom4Target.setText("목표량:" + ServerData.productCnt[3] + "개");
		lbCom5Target.setText("목표량:" + ServerData.productCnt[4] + "개");
		lbCom6Target.setText("목표량:" + ServerData.productCnt[5] + "개");

	}

	void control() {
		// 관리자일경우에만 보임
		btnAdmin.setVisible(false);
		if (ServerData.grade.equals("사원")) {

			btnCom1.setEnabled(false);
			btnCom2.setEnabled(false);
			btnCom3.setEnabled(false);
			btnCom4.setEnabled(false);
			btnCom5.setEnabled(false);
			btnCom6.setEnabled(false);
			if (ServerData.part.equals("기계1")) {
				btnCom1.addActionListener(this);
				btnCom1.setEnabled(true);
			} else if (ServerData.part.equals("기계2")) {
				btnCom2.addActionListener(this);
				btnCom2.setEnabled(true);
			} else if (ServerData.part.equals("기계3")) {
				btnCom3.addActionListener(this);
				btnCom3.setEnabled(true);
			} else if (ServerData.part.equals("기계4")) {
				btnCom4.addActionListener(this);
				btnCom4.setEnabled(true);
			} else if (ServerData.part.equals("기계5")) {
				btnCom5.addActionListener(this);
				btnCom5.setEnabled(true);
			} else if (ServerData.part.equals("기계6")) {
				btnCom6.addActionListener(this);
				btnCom6.setEnabled(true);
			}

			// 관리자일경우 관리자모드 보임
			if (ServerData.part.equals("관리자")) {
				btnAdmin.setVisible(true);
				btnCom1.setEnabled(true);
				btnCom2.setEnabled(true);
				btnCom3.setEnabled(true);
				btnCom4.setEnabled(true);
				btnCom5.setEnabled(true);
				btnCom6.setEnabled(true);
				btnCom1.addActionListener(this);
				btnCom2.addActionListener(this);
				btnCom3.addActionListener(this);
				btnCom4.addActionListener(this);
				btnCom5.addActionListener(this);
				btnCom6.addActionListener(this);
			}
		} else {
			// 관리자일경우 관리자모드 보임
			if (ServerData.part.equals("관리자")) {
				btnAdmin.setVisible(true);
			}

			btnCom1.addActionListener(this);
			btnCom2.addActionListener(this);
			btnCom3.addActionListener(this);
			btnCom4.addActionListener(this);
			btnCom5.addActionListener(this);
			btnCom6.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnCom1 == e.getSource()) {
			// dlgMsg("기계1제어가능");
			SettingCom sc1 = new SettingCom("기계1");
		} else if (btnCom2 == e.getSource()) {
			SettingCom sc2 = new SettingCom("기계2");
		} else if (btnCom3 == e.getSource()) {
			SettingCom sc3 = new SettingCom("기계3");
		} else if (btnCom4 == e.getSource()) {
			SettingCom sc4 = new SettingCom("기계4");
		} else if (btnCom5 == e.getSource()) {
			SettingCom sc5 = new SettingCom("기계5");
		} else if (btnCom6 == e.getSource()) {
			SettingCom sc6 = new SettingCom("기계6");
		}

	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "대여하기정보", true);
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

	@Override
	public void run() {
		while (true) {
			// 바로 인식이 안되서 살짝 딜레이주기...
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}

			tot = SubCom1.com1Cnt + SubCom2.com2Cnt + SubCom3.com3Cnt + SubCom4.com4Cnt + SubCom5.com5Cnt
					+ SubCom6.com6Cnt;
			lbComTotCnt.setText("총 출하량:" + tot + "개");

		}

	}

}
