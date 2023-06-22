package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

class Round19_Ex03_Sub extends Frame implements FocusListener {
	private BorderLayout bl = new BorderLayout();

	private Label lb = new Label("이름 = ", Label.RIGHT);

	private Label lb1 = new Label("주민번호 = ", Label.RIGHT);

	private TextField tfName = new TextField();

	private TextField tfNum1 = new TextField();

	private TextField tfNum2 = new TextField();

	private Button bt = new Button("확인");

	private Button bt1 = new Button("취소");

	public Round19_Ex03_Sub() {
		super("Focus Event!");
		this.init();
		this.start();
		this.setSize(200, 100);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(bl);
		Panel p = new Panel(new GridLayout(2, 1));
		p.add(tfName);
		Panel p1 = new Panel(new GridLayout(1, 2, 5, 5));
		p1.add(tfNum1);
		p1.add(tfNum2);
		p.add(p1);
		this.add("Center", p);
		Panel p2 = new Panel(new GridLayout(2, 1));
		p2.add(lb);
		p2.add(lb1);
		this.add("West", p2);
		Panel p3 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(bt);
		p3.add(bt1);
		this.add("South", p3);
	}

	public void start() {
		tfName.addFocusListener(this);
		tfNum1.addFocusListener(this);
		tfNum2.addFocusListener(this);
	}

	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfNum1) {
			int x = tfName.getText().trim().length();
			if (x == 0) {
				tfName.requestFocus();
			}
		} else if (e.getSource() == tfNum2) {
			int x = tfNum1.getText().trim().length();
			if (x != 6) {
				tfNum1.setText("");
				tfNum1.requestFocus();
			}
		}
	}

	public void focusLost(FocusEvent e) {
		if(e.getSource()==tfNum1) {
			System.out.println("name input complete");
		}
	}
}

public class Round19_Ex03 {
	public static void main(String[] ar) {
		Round19_Ex03_Sub es = new Round19_Ex03_Sub();
	}
}
