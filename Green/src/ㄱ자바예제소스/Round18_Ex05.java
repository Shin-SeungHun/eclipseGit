package ㄱ자바예제소스;

import java.awt.*;

public class Round18_Ex05 {
	public static void main(String[] ar) {
		Round18_Ex05_Sub round = new Round18_Ex05_Sub();
	}
}

class Round18_Ex05_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Label lb = new Label("Test");

	public Round18_Ex05_Sub() {
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
		Font font = new Font("SansSerif", Font.BOLD, 20);
		FlowLayout flow = new FlowLayout();
		this.setLayout(flow);
		lb.setFont(font);
		lb.setBackground(Color.yellow);
		this.add(lb);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
