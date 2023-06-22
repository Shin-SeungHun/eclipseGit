package ㄱ자바예제소스;

import java.awt.*;

public class Round18_Ex17 {
	public static void main(String[] ar) {
		Round18_Ex17_Sub round = new Round18_Ex17_Sub();
	}
}

class Round18_Ex17_Sub extends Frame {
	private Dimension dimen, dimen1;

	private int xpos, ypos;

	private TextArea ta = new TextArea("5초후 나타난다.");

	private PopupMenu pm = new PopupMenu("My Popup");

	private MenuItem copy = new MenuItem("복사");

	private MenuItem cut = new MenuItem("잘라내기");

	private MenuItem paste = new MenuItem("붙여넣기");

	private Menu align = new Menu("정렬");

	private CheckboxMenuItem asize = new CheckboxMenuItem("크기순", false);

	private CheckboxMenuItem aname = new CheckboxMenuItem("이름순", false);

	private CheckboxMenuItem aauto = new CheckboxMenuItem("자동정렬", true);

	public Round18_Ex17_Sub() {
		super("팝업 메뉴");
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

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ee) {
		}
		pm.show(ta, 50, 0);
	}

	public void init() {
		// 화면 구성 넣을 부분
		BorderLayout border = new BorderLayout();
		this.setLayout(border);

		this.add("Center", ta);

		pm.add(copy);
		pm.add(cut);
		pm.add(paste);
		pm.addSeparator();
		align.add(asize);
		align.add(aname);
		align.addSeparator();
		align.add(aauto);
		pm.add(align);

		ta.add(pm);
	}

	public void start() {
		// 이벤트나 쓰레드 처리할 부분
	}
}
