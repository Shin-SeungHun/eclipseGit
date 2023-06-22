package ㄱ자바예제소스;

import java.awt.*;
import javax.swing.*;

class Round22_Ex02_Sub extends JFrame {
	private Container con;

	private JButton jl = new JButton("Test");

	private ImageIcon im, im1;

	public Round22_Ex02_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setIconImage(im.getImage());
		this.setSize(400, 300);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
				(int) (di.getHeight() / 2 - di1.getHeight() / 2));
		this.setVisible(true);
	}

	public void init() {
		im = new ImageIcon("title.gif");
		im1 = new ImageIcon("title.gif");
		con = this.getContentPane(); // 작업 영역 획득
		con.setLayout(new BorderLayout()); // 작업 영역에 Layout 설정
		con.add("North", jl); // 작업 영역 상단에 일반 버튼 넣음
		con.add("Center", new JButton("Test1", im1)); // 작업 영역 중앙에 이미지와 함께 생성된
														// 버튼을 넣음
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 누를때 종료처리
	}

	public void paint(Graphics g) {

	}
}

public class Round22_Ex02 {
	public static void main(String[] ar) {
		Round22_Ex02_Sub es = new Round22_Ex02_Sub();
	}
}
