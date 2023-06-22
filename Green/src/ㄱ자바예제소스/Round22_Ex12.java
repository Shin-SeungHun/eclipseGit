import java.awt.*;
import javax.swing.*;

class Round22_Ex12_Sub extends JFrame {
	private Container con;

	private BorderLayout bl = new BorderLayout();

	private JButton bt = new JButton("1");

	private JButton bt1 = new JButton("2");

	private JTextArea ta = new JTextArea();

	private JScrollPane jsp = new JScrollPane(ta);

	public Round22_Ex12_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(bl);
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(bt);
		jp.add(bt1);
		con.add("North", jp);
		jsp.setWheelScrollingEnabled(true);
		con.add("Center", jsp);
	}

	public void start() {

	}
}

public class Round22_Ex12 {
	public static void main(String[] ar) {
		Round22_Ex12_Sub es = new Round22_Ex12_Sub();
	}
}
