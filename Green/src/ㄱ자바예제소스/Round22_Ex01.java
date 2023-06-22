package ㄱ자바예제소스;

import java.awt.*;
import javax.swing.*;

class Round22_Ex01_Sub extends JFrame {
	private Container con; // 작업 영역을 위한 기본 Panel을 담을 객체

	private ImageIcon im; // 타이틀 바의 이미지를 가지는 객체

	public Round22_Ex01_Sub() {
		super("제목");
		this.init();
		this.start();
		im = new ImageIcon("title.gif"); // 특정 이미지 객체 생성
		this.setIconImage(im.getImage()); // 타이틀 바에 이미지 넣기
		this.setSize(300, 200);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
				(int) (di.getHeight() / 2 - di1.getHeight() / 2));
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane(); // 다중 Panel에서의 기본 작업 영역 획득
		// 폼 구성 영역
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame의 X버튼을 눌렀을 때의 Event (WindowEvent Closing)
	}
}

public class Round22_Ex01 {
	public static void main(String[] ar) {
		Round22_Ex01_Sub es = new Round22_Ex01_Sub();
	}
}
