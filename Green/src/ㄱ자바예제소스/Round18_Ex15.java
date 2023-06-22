package ㄱ자바예제소스;

import java.awt.*;

public class Round18_Ex15 {
	public static void main(String[] ar) {
		Round18_Ex15_Sub round = new Round18_Ex15_Sub();
	}
}

class Round18_Ex15_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private MenuBar mb = new MenuBar();

	private Menu file = new Menu("파일");

	private Menu edit = new Menu("편집");

	private Menu view = new Menu("보기");

	private Menu help = new Menu("도움말");

	public Round18_Ex15_Sub() {
		super("메뉴 만들기");
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
		this.setMenuBar(mb);

		mb.add(file);
		mb.add(edit);
		mb.add(view);
		mb.add(help);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
