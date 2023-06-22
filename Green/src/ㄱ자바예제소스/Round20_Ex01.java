package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

class Round20_Ex01_Sub extends Frame {
	private Button bt = new Button("확인");

	private Button bt1 = new Button("취소");

	public Round20_Ex01_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(new BorderLayout());
		Panel p = new Panel(new FlowLayout());
		p.add(bt);
		p.add(bt1);
		this.add("North", p);
	}

	public void start() {
	}

	// public void update(Graphics g) {
	// paint(g);
	// }
	public void paint(Graphics g) {
		System.out.println("리줌");
		g.drawLine(100, 100, 200, 200); // 점(100, 100) 에서 점(200, 200) 까지 직선을
										// 출력한다.
		g.drawRoundRect(100, 100, 200, 300, 90, 90); // 점(100, 100), 폭 100,
														// 높이 100, round_x 30,
														// round_y 30 픽셀의 모서리가
														// 둥근 사각형을 출력한다.
		int[] x = { 250, 300, 200 }; // x축의 좌표들을 꼭지점 순서대로 모은다.
		int[] y = { 200, 300, 300 }; // y축의 좌표들을 x축과 동일한 순서대로 꼭지점 좌표를 모은다.
		g.drawPolygon(x, y, x.length); // 삼각형을 출력한다.
		g.setColor(Color.red); // 색상을 빨간색으로 바꾼다.
		g.fillOval(200, 100, 100, 100); // 점(200, 100), 폭 100, 높이 100 픽셀의 속이 채워진
										// 타원을 출력한다.
	}
}

public class Round20_Ex01 {
	public static void main(String[] args) {
		Round20_Ex01_Sub gs = new Round20_Ex01_Sub();
	}
}
