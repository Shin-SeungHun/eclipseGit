import java.awt.*;

public class Round17_Ex03 {
	public static void main(String[] ar) {
		Round17_Ex03_Sub round = new Round17_Ex03_Sub();
	}
}

class Round17_Ex03_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	public Round17_Ex03_Sub() {
		super();
		this.init();
		this.start();
		this.setSize(300, 200);
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}

	public void init() {
		// 화면 구성 넣을 부분
	}

	public void start() {
		// 이벤트나 Thread 처리할 부분
	}
}
