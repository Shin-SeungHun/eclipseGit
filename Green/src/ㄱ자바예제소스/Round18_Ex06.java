package ㄱ자바예제소스;

import java.awt.*;

public class Round18_Ex06 {
	public static void main(String[] ar) {
		Round18_Ex06_Sub round = new Round18_Ex06_Sub();
	}
}

class Round18_Ex06_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Label lb = new Label("최초문자(좌측정렬) -> ", Label.LEFT); // 기본정렬

	public Round18_Ex06_Sub() {
		super();
		this.init();
		this.start();
		this.setSize(500, 200);
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
		String str = lb.getText().trim();
		lb.setAlignment(Label.CENTER);
		lb.setText(str + "다음정렬(중앙정렬) -> ");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ee) {
		}
		str = lb.getText().trim();
		lb.setAlignment(Label.RIGHT);
		lb.setText(str + "마지막정렬(우측정렬)");
	}

	public void init() {
		// 화면 구성 넣을 부분
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		this.setLayout(gridbag);
		lb.setBackground(Color.yellow);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1;
		gridbag.setConstraints(lb, gc);
		this.add(lb);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
