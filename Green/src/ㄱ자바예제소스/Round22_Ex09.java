import java.awt.*;
import javax.swing.*;

class Round22_Ex09_Sub extends JFrame {
	private Container con;

	private FlowLayout fl = new FlowLayout();

	private JButton[] bt = new JButton[6];

	private Box box, box1, box2;

	public Round22_Ex09_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(fl);
		for (int i = 0; i < 6; i++) {
			bt[i] = new JButton(String.valueOf(i + 1));
		}
		box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(10));
		for (int i = 0; i < 3; i++) {
			box.add(bt[i]);
			box.add(Box.createVerticalStrut(10));
		}
		// con.add(box);
		box1 = Box.createHorizontalBox();
		box1.add(Box.createVerticalStrut(170));
		for (int i = 3; i < 6; i++) {
			box1.add(bt[i]);
			box1.add(Box.createHorizontalStrut(10));
		}
		// con.add(box1);
		box2 = Box.createHorizontalBox();
		box2.add(box);
		box2.add(Box.createHorizontalStrut(30));
		box2.add(box1);
		con.add(box2);
	}

	public void start() {

	}
}

public class Round22_Ex09 {
	public static void main(String[] ar) {
		Round22_Ex09_Sub es = new Round22_Ex09_Sub();
	}
}
