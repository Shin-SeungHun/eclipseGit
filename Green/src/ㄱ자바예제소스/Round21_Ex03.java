import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Round21_Ex03 extends Applet {
	String ccc = "";

	String ddd = "";

	public void init() {
		ccc = this.getParameter("aaa");
		ddd = this.getParameter("bbb");
	}

	// public void start() {}
	public void paint(Graphics g) {
		g.setFont(new Font("Sans-Serif", Font.BOLD, 20));
		g.drawString(ccc, 30, 100);
		g.drawString(ddd, 30, 150);
	}
	// public void stop() {}
	// public void destroy() {}
}
