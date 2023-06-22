package ㄱ자바예제소스;

import java.awt.*;

public class Round18_Ex07 {
	public static void main(String[] ar) {
		Round18_Ex07_Sub round = new Round18_Ex07_Sub();
	}
}

class Round18_Ex07_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Button[] bt = new Button[12];

	public Round18_Ex07_Sub() {
		super("전화기 자판"); // Frame의 제목
		this.init();
		this.start();
		this.setSize(300, 400);
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
		CardLayout card = new CardLayout(5, 5);
		this.setLayout(card); // 주변 둘레(가장자리) 여백 때문에 설정

		GridLayout grid = new GridLayout(4, 3, 5, 5);
		Panel p = new Panel(grid);

		Font font = new Font("TimesRoman", Font.BOLD, 20);
		Font font1 = new Font("SansSerif", Font.BOLD, 20);

		String[] str = { "*", "0", "#" };
		for (int i = 0; i < bt.length; i++) {
			if (i < 9) {
				bt[i] = new Button(String.valueOf(i + 1));
				bt[i].setFont(font);
			} else {
				bt[i] = new Button(str[i - 9]);
				bt[i].setFont(font1);
			}
			p.add(bt[i]);
		}

		this.add("view", p);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
