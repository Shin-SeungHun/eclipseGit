package 자바수업18일_스레드;

import java.awt.Button;
import java.awt.Color;
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

class SettingCom extends Frame implements ActionListener {
	private Dimension dimen;
	int fullSizeWidth, fullSizeHeight;
	int x, y;
	Label lbTitle = new Label("기계 관리자 모드");

	Label lbTime = new Label("생산시간조정(1~3초):");
	Label lbCnt = new Label("목표 생산량 입력:");
	TextField tfTime = new TextField();
	TextField tfCnt = new TextField();

	Button btnSave = new Button("적용하기");

	Font font35 = new Font("TimesRoman", Font.PLAIN, 35);
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	SettingCom(String part) {
		super(part + " 관리자모드");
		lbTitle.setText(part + " 관리자모드");
		this.setSize(400, 350);
		this.init();
		this.start();
		this.setLocation(600, 200);
		this.setVisible(true);

	}

	void start() {
		btnSave.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeView();
			}
		});
	}

	void closeView() {
		this.setVisible(false);
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);// 현재 클래스 내부에 생성해서 넣음...
		lbTitle.setBounds(100, 50, 300, 50);
		lbTitle.setFont(font25);

		this.add(lbTime);
		lbTime.setFont(font15);
		this.add(lbCnt);
		lbCnt.setFont(font15);
		this.add(tfTime);
		tfTime.setFont(font15);
		this.add(tfCnt);
		tfCnt.setFont(font15);
		this.add(btnSave);
		btnSave.setFont(font15);

		lbTime.setBounds(50, 130, 200, 30);
		tfTime.setBounds(250, 130, 100, 30);

		lbCnt.setBounds(50, 200, 200, 30);
		tfCnt.setBounds(250, 200, 100, 30);

		btnSave.setBounds(150, 270, 100, 50);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {

		}

	}

}
