package ㄱ자바예제소스;

import java.awt.*;

public class Round18_Ex02 {
	public static void main(String[] ar) {
		Round18_Ex02_Sub round = new Round18_Ex02_Sub();
	}
}

class Round18_Ex02_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Label lb = new Label("Test");

	private Label lb1 = new Label("Test1");

	public Round18_Ex02_Sub() {
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
		BorderLayout border = new BorderLayout();
		this.setLayout(border);
		lb.setBackground(Color.yellow);
		lb1.setBackground(Color.magenta);
		GridLayout grid = new GridLayout(1, 2, 5, 5);
		Panel p = new Panel();
		p.setLayout(grid);
		// 34번과 35번 줄을 통합하여 Panel p = new Panel(grid); 라고 하여도 됨
		p.add(lb);
		p.add(lb1);
		this.add("South", p);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
