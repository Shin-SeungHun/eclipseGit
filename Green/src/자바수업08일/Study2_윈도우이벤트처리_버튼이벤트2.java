package 자바수업08일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study2_윈도우이벤트처리_버튼이벤트2 {
	public static void main(String[] args) {
		BtnTest2 log = new BtnTest2();
	}
}

class BtnTest2 extends Frame implements ActionListener {
	TextField tfResult1 = new TextField();
	Label lbResult2 = new Label("결과대기중...");
	Button btn1 = new Button("초기화");
	Button btn2 = new Button("가져오기");
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	BtnTest2() {
		super("버튼테스트");
		this.setSize(300, 400);
		this.init();// 레이아웃
		this.start();// 이벤트
		this.setLocation(600, 200);
		this.setVisible(true);
	}

	void init() {
		this.setLayout(null);
		this.add(tfResult1);
		this.add(lbResult2);
		this.add(btn1);
		this.add(btn2);
		tfResult1.setFont(font15);
		lbResult2.setFont(font15);
		btn1.setFont(font15);
		btn2.setFont(font15);

		btn1.setBounds(50, 150, 80, 30);
		tfResult1.setBounds(150, 150, 120, 30);
		btn2.setBounds(50, 220, 80, 30);
		lbResult2.setBounds(150, 220, 120, 30);
	}

	void start() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			tfResult1.setText("");
		} else if (e.getSource() == btn2) {
//			String temp = tfResult1.getText();
//			lbResult2.setText(temp);

			lbResult2.setText(tfResult1.getText());
		}

	}
}
