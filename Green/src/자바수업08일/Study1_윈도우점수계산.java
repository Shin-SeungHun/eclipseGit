package 자바수업08일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1_윈도우점수계산 {

	public static void main(String[] args) {
		new Cal();

	}

}

class Cal extends Frame implements ActionListener {
	Label lbN = new Label("이름없음", Label.CENTER);
	Label lbScore = new Label("점수대기중...", Label.CENTER);

	Label lbName = new Label("이름:");
	Label lbKor = new Label("국어:");
	Label lbEng = new Label("영어:");
	Label lbMat = new Label("수학:");

	TextField tfName = new TextField();
	TextField tfKor = new TextField();
	TextField tfEng = new TextField();
	TextField tfMat = new TextField();

	Button btnCal = new Button("계산하기");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	int tot, avg;

	Cal() {
		super("점수계산기");
		this.setSize(300, 400);
		this.init(); // 레이아웃
		this.start(); // 이벤트
		this.setLocation(600, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(null);

		this.add(lbName);
		lbName.setBounds(25, 40, 70, 30);
		lbName.setFont(font25);

		this.add(lbKor);
		lbKor.setBounds(25, 90, 70, 30);
		lbKor.setFont(font25);

		this.add(lbEng);
		lbEng.setBounds(25, 130, 70, 30);
		lbEng.setFont(font25);

		this.add(lbMat);
		lbMat.setBounds(25, 170, 70, 30);
		lbMat.setFont(font25);

		this.add(tfName);
		tfName.setBounds(105, 40, 100, 30);
		tfName.setFont(font15);

		this.add(tfKor);
		tfKor.setBounds(105, 90, 100, 30);
		tfKor.setFont(font15);

		this.add(tfEng);
		tfEng.setBounds(105, 130, 100, 30);
		tfEng.setFont(font15);

		this.add(tfMat);
		tfMat.setBounds(105, 170, 100, 30);
		tfMat.setFont(font15);

		this.add(btnCal);
		btnCal.setBounds(105, 230, 90, 30);
		btnCal.setFont(font15);

		this.add(lbN);
		lbN.setBounds(100, 270, 90, 20);
		lbN.setFont(font15);

		this.add(lbScore);
		lbScore.setBounds(70, 300, 150, 20);
		lbScore.setFont(font15);
	}

	public void start() {

		btnCal.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 공백체크
		if (tfName.getText().equals("")) {
			return;
		}
		if (tfKor.getText().equals("")) {
			return;
		}
		if (tfEng.getText().equals("")) {
			return;
		}
		if (tfMat.getText().equals("")) {
			return;
		}

		String name = tfName.getText();
		int kor = Integer.parseInt(tfKor.getText());
		int eng = Integer.parseInt(tfEng.getText());
		int mat = Integer.parseInt(tfMat.getText());
		tot = kor + eng + mat;
		avg = tot / 3;

		if (e.getSource() == btnCal) {
			lbN.setText(tfName.getText());
			lbScore.setText("총점: " + tot + " / 평균: " + avg);
		}
	}

}