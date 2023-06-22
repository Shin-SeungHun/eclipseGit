package ㄱ자바예제소스;

import java.awt.*;

public class Round18_Ex04 {
	public static void main(String[] ar) {
		Round18_Ex04_Sub round = new Round18_Ex04_Sub();
	}
}

class Round18_Ex04_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Label lb = new Label("Test");

	public Round18_Ex04_Sub() {
		super();
		this.init();
		this.start();
		this.setSize(250, 200);
		// this.pack();
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}

	public void init() {
		// 화면 구성 넣을 부분
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		Cursor cursor1 = new Cursor(Cursor.WAIT_CURSOR);
		this.setCursor(cursor);
		FlowLayout flow = new FlowLayout();
		this.setLayout(flow);
		lb.setCursor(cursor1);
		lb.setBackground(Color.yellow);
		this.add(lb);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
