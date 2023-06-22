import java.awt.*;
import javax.swing.*;

class Round22_Ex14_Sub extends JFrame {
	private Container con;

	private BorderLayout bl = new BorderLayout();

	private JButton bt = new JButton("1");

	private JButton bt1 = new JButton("2");

	private JPanel jp = new JPanel(null);

	private JInternalFrame jif = new JInternalFrame("Á¦¸ñ", true, true, true,
			true);

	public Round22_Ex14_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(bl);
		con.add("West", bt);
		con.add("South", bt1);
		Container cc = jif.getContentPane();
		cc.setLayout(new FlowLayout());
		cc.add(new JButton("1"));
		cc.add(new JButton("2"));
		// jif.setClosable(false);
		jif.setFrameIcon(new ImageIcon("bbb.gif"));
		// jif.setIconifiable(false);
		// jif.setMaximizable(false);
		try {
			jif.setMaximum(true);
		} catch (Exception ee) {
		}
		jif.setSize(100, 80);
		jif.setVisible(true);
		jp.add("Center", jif);
		con.add("Center", jp);
	}

	public void start() {

	}
}

public class Round22_Ex14 {
	public static void main(String[] ar) {
		Round22_Ex14_Sub es = new Round22_Ex14_Sub();
	}
}
