package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

class Round19_Ex06_Sub extends Frame implements MouseListener {
	private Button bt = new Button("나를 눌러봐요");

	public Round19_Ex06_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(null);
		bt.setBounds(50, 50, 80, 30);
		this.add(bt);
	}

	public void start() {
		bt.addMouseListener(this);
	}

	public void paint(Graphics g) {

	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked.");
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered.");
		bt.setLocation((int) (Math.random() * 300) - 80,
				(int) (Math.random() * 200) - 30);
	}

	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited.");
	}
}

public class Round19_Ex06 {
	public static void main(String[] ar) {
		Round19_Ex06_Sub es = new Round19_Ex06_Sub();
	}
}
