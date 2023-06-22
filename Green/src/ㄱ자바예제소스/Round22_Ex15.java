import java.awt.*;
import javax.swing.*;

class Round22_Ex15_Sub extends JFrame {
	private Container con;

	private JLabel lb = new JLabel();

	private ImageIcon im = new ImageIcon("ff.gif");

	private JLabel lb1 = new JLabel(im);

	private JLabel lb2 = new JLabel(new ImageIcon("ff.gif"), JLabel.LEFT);

	private JLabel lb3 = new JLabel("Test");

	private JLabel lb4 = new JLabel("Test1", JLabel.CENTER);

	private JLabel lb5 = new JLabel("Test2", new ImageIcon("ff.gif"),
			JLabel.CENTER);

	public Round22_Ex15_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(600, 400);
		this.setVisible(true);
		System.out.println(lb5.getDisabledIcon());
		System.out.println(lb5.getIcon());
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new GridLayout(3, 2));
		con.add(lb);
		con.add(lb1);
		con.add(lb2);
		con.add(lb3);
		con.add(lb4);
		lb5.setHorizontalTextPosition(SwingConstants.LEFT);
		lb5.setVerticalTextPosition(SwingConstants.BOTTOM);
		con.add(lb5);
	}

	public void start() {

	}
}

public class Round22_Ex15 {
	public static void main(String[] ar) {
		Round22_Ex15_Sub es = new Round22_Ex15_Sub();
	}
}
