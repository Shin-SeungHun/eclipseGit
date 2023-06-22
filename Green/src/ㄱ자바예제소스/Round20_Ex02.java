package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

class Round20_Ex02_Sub extends Frame {
	public Round20_Ex02_Sub() {
		super("원 그리기!");
		this.init();
		this.start();
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public void init() {
	}

	public void start() {
	}

	// public void update(Graphics g) { paint(g);}
	public void paint(Graphics g) {
		for (int i = 0; i < 1000; i++) {
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			Color cc = new Color(red, green, blue);
			g.setColor(cc);
			Dimension di = this.getSize();
			int x = (int) (Math.random() * di.getWidth());
			int y = (int) (Math.random() * di.getHeight());
			int w = (int) (Math.random() * 50) + 50;
			int h = (int) (Math.random() * 50) + 50;
			int dist = (int) (Math.random() * 4);
			// 도형선택
			if (dist == 0)
				g.drawRect(x, y, w, h);
			else if (dist == 1)
				g.fillRect(x, y, w, h);
			else if (dist == 2)
				g.drawOval(x, y, w, h);
			else
				g.fillOval(x, y, w, h);
			// 도형선택
			try {
				Thread.sleep(100); // 0.1초 시간지연
			} catch (InterruptedException ee) {
			}
		}
	}
}

public class Round20_Ex02 {
	public static void main(String[] args) {
		Round20_Ex02_Sub gs = new Round20_Ex02_Sub();
	}
}
