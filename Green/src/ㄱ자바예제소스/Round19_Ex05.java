package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

class Round19_Ex05_Sub extends Frame implements KeyListener {
	private FlowLayout fl = new FlowLayout();

	private TextField tf = new TextField(10);

	private Label lb = new Label("-", Label.CENTER);

	private TextField tf1 = new TextField(10);

	public Round19_Ex05_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(fl);
		this.add(tf);
		this.add(lb);
		this.add(tf1);
	}

	public void start() {
		tf.addKeyListener(this);
	}

	public void paint(Graphics g) {

	}

	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed");
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased");
		String str = tf.getText().trim();
		if (str.length() == 6) {
			tf1.requestFocus();
		}
	}

	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped");
	}
}

public class Round19_Ex05 {
	public static void main(String[] ar) {
		Round19_Ex05_Sub es = new Round19_Ex05_Sub();
	}
}
