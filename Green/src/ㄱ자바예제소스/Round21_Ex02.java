package ㄱ자바예제소스;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Round21_Ex02 extends Applet {
	private static String data = "";

	public void init() {
		data += "init() -> ";
	}

	public void start() {
		data += "start() -> ";
	}

	public void paint(Graphics g) {
		// update(g);
		data += "paint() -> ";
		g.drawString(data, 30, 50);
	}

	public void stop() {
		data += "stop() -> ";
	}

	public void destroy() {
		data += "destroy() -> ";
	}
}
