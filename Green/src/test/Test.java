package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) {
		Cal cal = new Cal();
	}
}

class Cal extends Frame implements ActionListener {
	String num1 = "", num2 = "";
	boolean num1Check = true; // 첫번째수일경우를 체크
	String cal = "";
	int su1, su2;
	char flag = 0;
	Label lbTitle = new Label("계산기");
	Button btn1 = new Button("1");
	Button btn2 = new Button("2");
	Button btn3 = new Button("3");
	Button btn4 = new Button("4");
	Button btn5 = new Button("5");
	Button btn6 = new Button("6");
	Button btn7 = new Button("7");
	Button btn8 = new Button("8");
	Button btn9 = new Button("9");
	Button btn0 = new Button("0");
	Button btnC = new Button("C"); // 클리어
	Button btnEqual = new Button("=");
	Button btnAdd = new Button("+");
	Button btnMin = new Button("-");
	Button btnMul = new Button("*");
	Button btnDiv = new Button("/");
	TextField tfText = new TextField();
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Cal() {
		super("계산기");
		this.setSize(300, 400);
		this.init();// 화면레이아웃구성메서드
		start();
		this.setLocation(500, 300);
		this.setVisible(true);
	}

	void start() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn0.addActionListener(this);
		btnC.addActionListener(this);
		btnEqual.addActionListener(this);
		btnAdd.addActionListener(this);
		btnMin.addActionListener(this);
		btnMul.addActionListener(this);
		btnDiv.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void init() {
		this.setLayout(null);
		this.add(lbTitle);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(btn8);
		this.add(btn9);
		this.add(btn0);
		this.add(btnC);
		this.add(btnEqual);
		this.add(btnAdd);
		this.add(btnMin);
		this.add(btnMul);
		this.add(btnDiv);
		this.add(tfText);
		lbTitle.setFont(font25);
		btn1.setFont(font15);
		btn2.setFont(font15);
		btn3.setFont(font15);
		btn4.setFont(font15);
		btn5.setFont(font15);
		btn6.setFont(font15);
		btn7.setFont(font15);
		btn8.setFont(font15);
		btn9.setFont(font15);
		btn0.setFont(font15);
		btnC.setFont(font15);
		btnEqual.setFont(font15);
		btnAdd.setFont(font15);
		btnMin.setFont(font15);
		btnMul.setFont(font15);
		btnDiv.setFont(font15);
		tfText.setFont(font15);
		lbTitle.setBounds(110, 40, 80, 30);
		btn1.setBounds(20, 100, 50, 50);
		btn2.setBounds(90, 100, 50, 50);
		btn3.setBounds(160, 100, 50, 50);
		btn4.setBounds(20, 160, 50, 50);
		btn5.setBounds(90, 160, 50, 50);
		btn6.setBounds(160, 160, 50, 50);
		btn7.setBounds(20, 220, 50, 50);
		btn8.setBounds(90, 220, 50, 50);
		btn9.setBounds(160, 220, 50, 50);
		btnC.setBounds(20, 290, 50, 50);
		btn0.setBounds(90, 290, 50, 50);
		btnEqual.setBounds(160, 290, 50, 50);
		btnAdd.setBounds(230, 100, 50, 50);
		btnMin.setBounds(230, 160, 50, 50);
		btnMul.setBounds(230, 220, 50, 50);
		btnDiv.setBounds(230, 290, 50, 50);

		tfText.setBounds(20, 350, 260, 30);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		flag = 0;
//		try {
//			System.out.print("SU1");
//			su1 = Integer.parseInt(num1);
//			su2 = Integer.parseInt(num2);
//		} catch (NumberFormatException nfe) {
//			
//		
//		}	
		if (e.getSource() == btn1) {

			if (num1Check == true) {
				num1 += 1;
				tfText.setText(num1);
			} else {
				num2 += 1;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btn2) {
			if (num1Check == true) {
				num1 += 2;
				tfText.setText(num1);
			} else {
				num2 += 2;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btn3) {
			if (num1Check == true) {
				num1 += 3;
				tfText.setText(num1);
			} else {
				num2 += 3;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btn4) {
			if (num1Check == true) {
				num1 += 4;
				tfText.setText(num1);
			} else {
				num2 += 4;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btn5) {
			if (num1Check == true) {
				num1 += 5;
				tfText.setText(num1);
			} else {
				num2 += 5;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btn6) {
			if (num1Check == true) {
				num1 += 6;
				tfText.setText(num1);
			} else {
				num2 += 6;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btn7) {
			if (num1Check == true) {
				num1 += 7;
				tfText.setText(num1);
			} else {
				num2 += 7;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btn8) {
			if (num1Check == true) {
				num1 += 8;
				tfText.setText(num1);
			} else {
				num2 += 8;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btn9) {
			if (num1Check == true) {
				num1 += 9;
				tfText.setText(num1);
			} else {
				num2 += 9;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btn0) {
			if (num1Check == true) {
				num1 += 0;
				tfText.setText(num1);
			} else {
				num2 += 0;
				tfText.setText(num2);
			}
		} else if (e.getSource() == btnC) {
			tfText.setText("");
			num1Check = true;
			num1 = "";
			num2 = "";
		} else if (e.getSource() == btnEqual) {
			su2 = Integer.parseInt(num2);
			if (cal.equals("+")) {
				tfText.setText(su1 + su2 + "");
			} else if (cal.equals("-")) {
				tfText.setText(su1 - su2 + "");
			} else if (cal.equals("*")) {
				tfText.setText(su1 * su2 + "");
			} else if (cal.equals("/")) {
				tfText.setText(su1 / su2 + "");
			}
			if (cal.equals("+")) {
				su1 = Integer.parseInt(num1);
				cal = "+";
			}
		} else if (e.getSource() == btnAdd) {
			num1Check = false;
			tfText.setText("");
			su1 = Integer.parseInt(num1);
			cal = "+";
		} else if (e.getSource() == btnMin) {
			num1Check = false;
			tfText.setText("");
			su1 = Integer.parseInt(num1);
			cal = "-";
		} else if (e.getSource() == btnMul) {
			num1Check = false;
			tfText.setText("");
			su1 = Integer.parseInt(num1);
			cal = "*";
		} else if (e.getSource() == btnDiv) {
			num1Check = false;
			tfText.setText("");
			su1 = Integer.parseInt(num1);
			cal = "/";
		}
	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "오류", true);
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