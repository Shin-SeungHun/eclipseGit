import java.awt.*;
import javax.swing.*;

class Round22_Ex06_Sub extends JFrame {
	private Container con;

	private GridLayout gl = new GridLayout(2, 2, 5, 5);

	private JRadioButton cb1 = new JRadioButton("1", true);

	private JRadioButton cb2 = new JRadioButton("2");

	private JRadioButton cb3 = new JRadioButton("3");

	private JRadioButton cb4 = new JRadioButton("4", true);

	private ButtonGroup bg = new ButtonGroup();

	private ButtonGroup bg1 = new ButtonGroup();

	public Round22_Ex06_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(gl);
		bg.add(cb1);
		bg.add(cb2);
		bg1.add(cb3);
		bg1.add(cb4);
		con.add(cb1);
		con.add(cb2);
		con.add(cb3);
		con.add(cb4);
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Round22_Ex06 {
	public static void main(String[] ar) {
		Round22_Ex06_Sub es = new Round22_Ex06_Sub();
	}
}
