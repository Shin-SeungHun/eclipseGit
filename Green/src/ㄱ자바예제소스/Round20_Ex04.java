package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

class Round20_Ex04_Sub extends Frame implements ActionListener {
	private Button bt = new Button("확대");

	private Button bt1 = new Button("축소");

	private Image img = null;

	private int w = 100, h = 100;

	public Round20_Ex04_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 300);
		this.setVisible(true);
	}

	public void init() {
		img = Toolkit.getDefaultToolkit().getImage("img/aaa.gif");
		this.setLayout(new BorderLayout());
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p.add(bt);
		bt1.setEnabled(false);
		p.add(bt1);
		this.add("North", p);
	}

	public void start() {
		bt.addActionListener(this);
		bt1.addActionListener(this);
	}

	// public void update(Graphics g) { paint(g); }
	public void paint(Graphics g) {
		g.drawImage(img, 50, 80, w, h, this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt) {
			bt.setEnabled(false);
			bt1.setEnabled(true);
			bt1.requestFocus();
			w = h = 200;
			this.repaint();
		} else if (e.getSource() == bt1) {
			bt1.setEnabled(false);
			bt.setEnabled(true);
			bt.requestFocus();
			w = h = 100;
			this.repaint();
		}
	}
}

public class Round20_Ex04 {
	public static void main(String[] args) {
		Round20_Ex04_Sub gs = new Round20_Ex04_Sub();
	}
}
