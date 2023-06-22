package 자바수업08일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1_윈도우버튼2 {

	public static void main(String[] args) {
		new Btn2();

	}

}

class Btn2 extends Frame implements ActionListener {
	TextField tfResult1 = new TextField();
	Label lbResult2 = new Label("결과대기중...");

	Button btn1 = new Button("초기화");

	Button btn2 = new Button("가져오기");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Btn2() {
		super("버튼 테스트");
		this.setSize(300, 400);
		this.init(); // 레이아웃
		this.start(); // 이벤트
		this.setLocation(600, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(null);

		this.add(btn1);
		btn1.setBounds(30, 100, 100, 40);
		btn1.setFont(font15);

		this.add(tfResult1);
		tfResult1.setBounds(150, 105, 130, 30);
		tfResult1.setFont(font15);

		this.add(btn2);
		btn2.setBounds(30, 230, 100, 40);
		btn2.setFont(font15);

		this.add(lbResult2);
		lbResult2.setBounds(150, 235, 300, 30);
		lbResult2.setFont(font15);

	}

	public void start() {

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