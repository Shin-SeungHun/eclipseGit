import java.awt.*;
import javax.swing.*;

class Round22_Ex22_Sub extends JFrame {
	private Container con;

	private JToolBar jtb = new JToolBar(JToolBar.HORIZONTAL);

	private JButton bt = new JButton(new ImageIcon("bbb.gif"));

	private JButton bt1 = new JButton(new ImageIcon("ccc.gif"));

	public Round22_Ex22_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		jtb.setRollover(true);
		jtb.add(bt);
		jtb.addSeparator(new Dimension(20, 30));
		jtb.add(bt1);
		con.add("North", jtb);
	}

	public void start() {

	}
}

public class Round22_Ex22 {
	public static void main(String[] ar) {
		Round22_Ex22_Sub es = new Round22_Ex22_Sub();
	}
}
