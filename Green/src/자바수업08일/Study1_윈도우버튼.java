package 자바수업08일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1_윈도우버튼 {

	public static void main(String[] args) {
		Btn btn = new Btn();

	}

}

class Btn extends Frame implements ActionListener {
	Label result1 = new Label("값대기중...");
	Label result2 = new Label("값대기중...");

	Button btn1 = new Button("버튼1");

	Button btn2 = new Button("버튼2");
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Btn() {
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

		this.add(result1);
		result1.setBounds(150, 105, 300, 30);
		result1.setFont(font15);

		this.add(btn2);
		btn2.setBounds(30, 230, 100, 40);
		btn2.setFont(font15);

		this.add(result2);
		result2.setBounds(150, 235, 300, 30);
		result2.setFont(font15);

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
			result1.setText("홍길동");
			System.out.println("Button1 clicked");
		} else if (e.getSource() == btn2) {
			result2.setText("대전");
			System.out.println("Button2 clicked");
		}
	}

}