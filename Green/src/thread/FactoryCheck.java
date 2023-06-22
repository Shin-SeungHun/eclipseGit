package thread;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*제어조건
 * 1. 동시에 모든 화면을 다 띄우고 테스트 진행
 * 2. 각 기계 조작반에서 전원 on 버튼을 누르면 메인화면에 해당되는 버튼이 눌리지 않게 변경되면서 버튼하단에 "가동중"이라고 표시 전원 off버튼 눌릴시 사라짐
 * 3. 전원 on버튼 눌릴시 메인화면 중앙에 해당되는 기계의 출하량 갯수가 2초에 한번씩 증가함 증가시 실시간으로 표시되며 총 출하량도 같이 합산되서 계산됨
 * 4. 전원 off버튼 눌릴시 메인화면에서 보이는 해당 기계의 버튼이 다시 활성화
 * */

public class FactoryCheck extends Frame implements ActionListener, Runnable {

//	public static Machine1 machine1 = null;
//	public static Machine2 machine2 = null;
//	public static Machine3 machine3 = null;
//	public static Machine4 machine4 = null;
//	public static Machine5 machine5 = null;
//	public static Machine6 machine6 = null;

	Label lbTitle = new Label("공장 가동률 체크 프로그램");
	static Label lbMachine1 = new Label("기계 1 출하량: 0개");
	static Label lbMachine2 = new Label("기계 2 출하량: 0개");
	static Label lbMachine3 = new Label("기계 3 출하량: 0개");
	static Label lbMachine4 = new Label("기계 4 출하량: 0개");
	static Label lbMachine5 = new Label("기계 5 출하량: 0개");
	static Label lbMachine6 = new Label("기계 6 출하량: 0개");
	Label lbMachineTotal = new Label("총 출하량: 0개");

	static Label lbMachineText1 = new Label("...");
	static Label lbMachineText2 = new Label("...");
	static Label lbMachineText3 = new Label("...");
	static Label lbMachineText4 = new Label("...");
	static Label lbMachineText5 = new Label("...");
	static Label lbMachineText6 = new Label("...");

	static Label lbMachineTime1 = new Label("생산간격(초):2초");
	static Label lbMachineTime2 = new Label("생산간격(초):2초");
	static Label lbMachineTime3 = new Label("생산간격(초):2초");
	static Label lbMachineTime4 = new Label("생산간격(초):2초");
	static Label lbMachineTime5 = new Label("생산간격(초):2초");
	static Label lbMachineTime6 = new Label("생산간격(초):2초");
	
	static Label lbMachineTarget1 = new Label("목표량");
	static Label lbMachineTarget2 = new Label("목표량");
	static Label lbMachineTarget3 = new Label("목표량");
	static Label lbMachineTarget4 = new Label("목표량");
	static Label lbMachineTarget5 = new Label("목표량");
	static Label lbMachineTarget6 = new Label("목표량");
	
	static Button btnMachine1 = new Button("기계1");
	static Button btnMachine2 = new Button("기계2");
	static Button btnMachine3 = new Button("기계3");
	static Button btnMachine4 = new Button("기계4");
	static Button btnMachine5 = new Button("기계5");
	static Button btnMachine6 = new Button("기계6");
	static Button btnAdmin = new Button("관리자");

	int tot;

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	public FactoryCheck() {
		super("fatoryCheck");
		this.setSize(600, 600);
		this.init();
		this.control(); // 직급별 및 파트별 분류
		this.start();
		this.setLocation(300, 300);
		this.setVisible(true);

	}

	public void control() {
		// 관리자일 경우에만 보임
		btnAdmin.setVisible(false);

		if (ServerData.grade.equals("사원")) {

			btnMachine1.setEnabled(false);
			btnMachine2.setEnabled(false);
			btnMachine3.setEnabled(false);
			btnMachine4.setEnabled(false);
			btnMachine5.setEnabled(false);
			btnMachine6.setEnabled(false);

			if (ServerData.part.equals("기계1")) {
				btnMachine1.addActionListener(this);
				btnMachine1.setEnabled(true);
			} else if (ServerData.part.equals("기계2")) {
				btnMachine2.addActionListener(this);
				btnMachine2.setEnabled(true);
			} else if (ServerData.part.equals("기계3")) {
				btnMachine3.addActionListener(this);
				btnMachine3.setEnabled(true);
			} else if (ServerData.part.equals("기계4")) {
				btnMachine4.addActionListener(this);
				btnMachine4.setEnabled(true);
			} else if (ServerData.part.equals("기계5")) {
				btnMachine5.addActionListener(this);
				btnMachine5.setEnabled(true);
			} else if (ServerData.part.equals("기계6")) {
				btnMachine6.addActionListener(this);
				btnMachine6.setEnabled(true);
			}
		} else {
			// 관리자일 경우 관리자모드 보임
			if (ServerData.part.equals("관리자")) {
				btnAdmin.setVisible(true);

				btnMachine1.setEnabled(true);
				btnMachine2.setEnabled(true);
				btnMachine3.setEnabled(true);
				btnMachine4.setEnabled(true);
				btnMachine5.setEnabled(true);
				btnMachine6.setEnabled(true);

			}
			btnMachine1.addActionListener(this);
			btnMachine2.addActionListener(this);
			btnMachine3.addActionListener(this);
			btnMachine4.addActionListener(this);
			btnMachine5.addActionListener(this);
			btnMachine6.addActionListener(this);
		}

	}

	void viewClose() {
		this.setVisible(false);
	}

	public void start() {

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	public void init() {
		this.setLayout(null);

		this.add(lbTitle);
		this.add(lbMachine1);
		this.add(lbMachine2);
		this.add(lbMachine3);
		this.add(lbMachine4);
		this.add(lbMachine5);
		this.add(lbMachine6);

		this.add(lbMachineText1);
		this.add(lbMachineText2);
		this.add(lbMachineText3);
		this.add(lbMachineText4);
		this.add(lbMachineText5);
		this.add(lbMachineText6);

		this.add(lbMachineTime1);
		this.add(lbMachineTime2);
		this.add(lbMachineTime3);
		this.add(lbMachineTime4);
		this.add(lbMachineTime5);
		this.add(lbMachineTime6);
		
		this.add(lbMachineTarget1);
		this.add(lbMachineTarget2);
		this.add(lbMachineTarget3);
		this.add(lbMachineTarget4);
		this.add(lbMachineTarget5);
		this.add(lbMachineTarget6);
		
		
		
		this.add(lbMachineTotal);

		this.add(btnMachine1);
		this.add(btnMachine2);
		this.add(btnMachine3);
		this.add(btnMachine4);
		this.add(btnMachine5);
		this.add(btnMachine6);
		this.add(btnAdmin);

		lbTitle.setFont(font25);
		lbMachine1.setFont(font15);
		lbMachine2.setFont(font15);
		lbMachine3.setFont(font15);
		lbMachine4.setFont(font15);
		lbMachine5.setFont(font15);
		lbMachine6.setFont(font15);

		lbMachineText1.setFont(font15);
		lbMachineText2.setFont(font15);
		lbMachineText3.setFont(font15);
		lbMachineText4.setFont(font15);
		lbMachineText5.setFont(font15);
		lbMachineText6.setFont(font15);

		lbMachineTotal.setFont(font15);

		btnMachine1.setFont(font15);
		btnMachine2.setFont(font15);
		btnMachine3.setFont(font15);
		btnMachine4.setFont(font15);
		btnMachine5.setFont(font15);
		btnMachine6.setFont(font15);
		btnAdmin.setFont(font15);

		lbTitle.setBounds(150, 40, 300, 30);
		lbMachine1.setBounds(240, 270, 150, 30);
		lbMachine2.setBounds(240, 300, 150, 30);
		lbMachine3.setBounds(240, 330, 150, 30);
		lbMachine4.setBounds(240, 360, 150, 30);
		lbMachine5.setBounds(240, 390, 150, 30);
		lbMachine6.setBounds(240, 420, 150, 30);

		lbMachineText1.setBounds(80, 540, 100, 30);
		lbMachineText2.setBounds(80, 380, 100, 30);
		lbMachineText3.setBounds(80, 210, 100, 30);
		lbMachineText4.setBounds(260, 210, 100, 30);
		lbMachineText5.setBounds(430, 210, 100, 30);
		lbMachineText6.setBounds(430, 380, 100, 30);

		lbMachineTotal.setBounds(240, 450, 150, 30);

		btnMachine1.setBounds(80, 430, 100, 100);
		btnMachine2.setBounds(80, 270, 100, 100);
		btnMachine3.setBounds(80, 100, 100, 100);
		btnMachine4.setBounds(260, 100, 100, 100);
		btnMachine5.setBounds(430, 100, 100, 100);
		btnMachine6.setBounds(430, 270, 100, 100);

		btnAdmin.setBounds(430, 430, 100, 100);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMachine1) {
			dlgMsg("기계1 제어가능");
		} else if (e.getSource() == btnMachine2) {
			dlgMsg("기계2 제어가능");
		} else if (e.getSource() == btnMachine3) {
			dlgMsg("기계3 제어가능");
		} else if (e.getSource() == btnMachine4) {
			dlgMsg("기계4 제어가능");
		} else if (e.getSource() == btnMachine5) {
			dlgMsg("기계5 제어가능");
		} else if (e.getSource() == btnMachine6) {
			dlgMsg("기계6 제어가능");
		} else if (e.getSource() == btnAdmin) {

		}

	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}

			tot = Machine1.machine1Cnt + Machine2.machine2Cnt + Machine3.machine3Cnt + Machine4.machine4Cnt
					+ Machine5.machine5Cnt + Machine6.machine6Cnt;
			lbMachineTotal.setText("총 출하량: " + tot + "개");

		}

	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "회원정보", true);
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
