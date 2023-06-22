package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Round20_Ex03_Sub extends Frame {
	private Image img;

	public Round20_Ex03_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(500, 500);
		this.setVisible(true);
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ee) {
			}
			this.repaint();
		}
	}

	public void init() {
		img = Toolkit.getDefaultToolkit().getImage("img/aaa.gif");
	}

	public void start() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// public void update(Graphics g) { paint(g); }
	public void paint(Graphics g) {
		String date = new Date().toString();
		g.drawString(date, 50, 50);
		g.drawImage(img, 50, 100, 300, 300, this);
	}
}

public class Round20_Ex03 {
	public static void main(String[] args) {
		Round20_Ex03_Sub gs = new Round20_Ex03_Sub();
	}
}
