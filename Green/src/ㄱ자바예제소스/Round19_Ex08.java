package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

class Round19_Ex08_Sub extends Frame {
	public Round19_Ex08_Sub() {
		super("제목");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {

	}

	public void start() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

public class Round19_Ex08 {
	public static void main(String[] ar) {
		Round19_Ex08_Sub rs = new Round19_Ex08_Sub();
	}
}
