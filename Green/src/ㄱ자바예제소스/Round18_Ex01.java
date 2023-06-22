import java.awt.*;

public class Round18_Ex01 {
	public static void main(String[] ar) {
		Round18_Ex01_Sub round = new Round18_Ex01_Sub();
	}
}

class Round18_Ex01_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private Label lb = new Label("Test");

	public Round18_Ex01_Sub() {
		super();
		this.init();
		this.start();
		this.setSize(250, 200);
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
		lb.setBackground(Color.yellow);
		this.add("South", lb);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
