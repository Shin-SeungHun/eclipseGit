import java.awt.*;
import javax.swing.*;

class Round22_Ex05_Sub extends JFrame {
	private Container con;

	private GridLayout gl = new GridLayout(2, 2, 5, 5);

	private JToggleButton tb = new JToggleButton("1", true);

	private JToggleButton tb1 = new JToggleButton("2", false);

	private JToggleButton tb2 = new JToggleButton("3", false);

	private JToggleButton tb3 = new JToggleButton("4", false);

	private ButtonGroup bg = new ButtonGroup();

	public Round22_Ex05_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(gl);
		bg.add(tb); // bg라는 그룹에 버튼을 추가한다.
		bg.add(tb1); // bg라는 그룹에 버튼을 추가한다.
		bg.add(tb2); // bg라는 그룹에 버튼을 추가한다.
		bg.add(tb3); // bg라는 그룹에 버튼을 추가한다.
		con.add(tb);
		con.add(tb1);
		con.add(tb2);
		con.add(tb3);
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Round22_Ex05 {
	public static void main(String[] ar) {
		Round22_Ex05_Sub es = new Round22_Ex05_Sub();
	}
}
