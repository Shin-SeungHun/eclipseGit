package ㄱ자바예제소스;

import java.awt.*;

public class Round17_Ex01 {
	public static void main(String[] ar) {
		Frame f = new Frame();
		f.setSize(300, 200); // 윈도우 가로 세로 사이즈
//		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
//		Dimension dimen1 = f.getSize();
//		int xpos = (int)(dimen.getWidth() / 2 - dimen1.getWidth() / 2);
//		int ypos = (int)(dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		f.setLocation(500, 300);// 현재 프레임의 중앙 배치
		f.setVisible(true);// 현재 프레임을 화면상에 나타나게 함.
	}
}
