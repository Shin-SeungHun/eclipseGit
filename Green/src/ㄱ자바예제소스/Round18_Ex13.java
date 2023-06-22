package ㄱ자바예제소스;

import java.awt.*;

public class Round18_Ex13 {
	public static void main(String[] ar) {
		Round18_Ex13_Sub round = new Round18_Ex13_Sub();
	}
}

class Round18_Ex13_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Dialog dlg = new Dialog(this, "종속된 Dlg1", false);

	private Label dlglb = new Label("종속된 Dlg1 이다.", Label.CENTER);

	private Dialog dlg1 = new Dialog(this, "종속된 Dlg2", false);

	private Label dlg1lb = new Label("종속된 Dlg2 이다.", Label.CENTER);

	public Round18_Ex13_Sub() {
		super("최상위 Frame!!!");
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

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ee) {
		}
		dlg.setVisible(true);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ee) {
		}
		dlg.setVisible(false);
		dlg1.setVisible(true);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ee) {
		}
		dlg1.setVisible(false);
	}

	public void init() {
		// 화면 구성 넣을 부분
		Dimension dimen0 = Toolkit.getDefaultToolkit().getScreenSize();

		BorderLayout border = new BorderLayout();
		dlg.setLayout(border);
		dlg.add("Center", dlglb);
		dlg.setSize(150, 120);
		Dimension dimen2 = dlg.getSize();
		int xpos1 = (int) (dimen0.getWidth() / 2 - dimen2.getWidth() / 2);
		int ypos1 = (int) (dimen0.getHeight() / 2 - dimen2.getHeight() / 2);
		dlg.setLocation(xpos1, ypos1);

		BorderLayout border1 = new BorderLayout();
		dlg1.setLayout(border1);
		dlg1.add("Center", dlg1lb);
		dlg1.setSize(150, 120);
		Dimension dimen3 = dlg1.getSize();
		int xpos2 = (int) (dimen0.getWidth() / 2 - dimen3.getWidth() / 2);
		int ypos2 = (int) (dimen0.getHeight() / 2 - dimen3.getHeight() / 2);
		dlg1.setLocation(xpos2, ypos2);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
