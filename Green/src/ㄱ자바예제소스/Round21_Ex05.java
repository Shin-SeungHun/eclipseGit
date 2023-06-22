import java.applet.*;
import java.awt.*;

public class Round21_Ex05 extends Applet implements Runnable {
	private String data = "";

	private String data1 = "";

	private int xpos = 0;

	private Thread curThread = null;

	private boolean bool = false;

	public void init() {
		data = this.getParameter("text");
		data1 = this.getParameter("text1");
	}

	public void start() {
		if (curThread == null) {
			curThread = new Thread(this);
			curThread.start();
		}
	}

	// public void update(Graphics g) {}
	public void paint(Graphics g) {
		g.setFont(new Font("Sans-Serif", Font.BOLD, 20));
		if (bool = !bool) {
			g.drawString(data, xpos, 30);
		} else {
			g.drawString(data1, xpos, 30);
		}
	}

	public void run() {
		Dimension di = this.getSize();
		for (int i = 0; i < di.getWidth(); i += 5) {
			xpos = i;
			this.repaint();
			try {
				Thread.sleep(80);
			} catch (InterruptedException ee) {
			}
		}
	}
	// public void stop() {}
	// public void destroy() {}
}
