import java.applet.*;
import java.awt.*;
import java.util.*;

public class Round21_Ex04 extends Applet implements Runnable {
	private Thread currentTh;

	// public void init() {}
	public void start() {
		if (currentTh == null) {
			currentTh = new Thread(this);
			currentTh.start();
		}
	}

	// public void update(Graphics g) {}
	public void paint(Graphics g) {
		Date d = new Date();
		g.setFont(new Font("TimesRoman", Font.BOLD, 25));
		g.drawString(d.toString(), 30, 50);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ee) {
			}
			this.repaint();
		}
	}
	// public void stop() {}
	// public void destroy() {}
}
