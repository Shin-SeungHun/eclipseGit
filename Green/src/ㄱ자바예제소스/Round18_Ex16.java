package ㄱ자바예제소스;

import java.awt.*;

public class Round18_Ex16 {
	public static void main(String[] ar) {
		Round18_Ex16_Sub round = new Round18_Ex16_Sub();
	}
}

class Round18_Ex16_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Label lb = new Label("많은 버튼들 추가...");

	private Button[] bt = new Button[50];

	private Button bt1 = new Button("확인");

	private Button bt2 = new Button("취소");

	public Round18_Ex16_Sub() {
		super("Scroll Pane!");
		this.init();
		this.start();
		this.setSize(300, 200);
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
		BorderLayout border = new BorderLayout(5, 5);
		this.setLayout(border);
		this.add("North", lb);

		GridLayout grid = new GridLayout(10, 5, 2, 2);
		Panel p = new Panel(grid);
		for (int i = 0; i < bt.length; i++) {
			bt[i] = new Button("TEST " + i);
			p.add(bt[i]);
		}

		this.add("Center", p);

		FlowLayout flow1 = new FlowLayout(FlowLayout.RIGHT);
		Panel p1 = new Panel(flow1);
		p1.add(bt1);
		p1.add(bt2);
		this.add("South", p1);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
