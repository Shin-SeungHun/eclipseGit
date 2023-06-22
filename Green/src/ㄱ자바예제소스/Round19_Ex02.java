package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

public class Round19_Ex02 {
	public static void main(String[] ar) {
		Round19_Ex02_Sub round = new Round19_Ex02_Sub();
	}
}

class Round19_Ex02_Sub extends Frame implements ActionListener {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Label lb = new Label("결과표시 : 현재 누른 버튼이 없습니다.", Label.CENTER);

	private Button bt = new Button("버튼 1");

	private Button bt1 = new Button("버튼 2");

	public Round19_Ex02_Sub() {
		super();
		this.init(); // 화면 레이아웃
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
		BorderLayout border = new BorderLayout();
		this.setLayout(border);

		Panel p = new Panel();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		p.setLayout(gridbag);

		gc.insets = new Insets(0, 0, 0, 10);
		gridbag.setConstraints(bt, gc);
		p.add(bt);

		gc.insets = new Insets(0, 10, 0, 0);
		gridbag.setConstraints(bt1, gc);
		p.add(bt1);
//		bt1.setFont(font15);

		this.add("North", lb);
//		lb.setFont(font15);
		this.add("Center", p);
	}

	public void start() {
		// Event나 쓰레드 처리할 부분
		bt.addActionListener(this);
		bt1.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
//		System.out.println("11111111111");
//		lb.setText("클릭됨");
		if (e.getSource() == bt) {
			lb.setText("버튼1클릭!");
			System.out.println("Button1 clicked");
		} else if (e.getSource() == bt1) {
			lb.setText("버튼2클릭!");
			System.out.println("Button2 clicked");
		}
	}
}
