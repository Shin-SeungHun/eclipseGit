package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

public class Round19_Ex01 {
	public static void main(String[] ar) {
		Round19_Ex01_Sub round = new Round19_Ex01_Sub();
	}
}

class Round19_Ex01_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Button bt = new Button("닫기");

	public Round19_Ex01_Sub() {
		super("이벤트!");
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
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();

		this.setLayout(gridbag);

		gridbag.setConstraints(bt, gc);
		this.add(bt);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
