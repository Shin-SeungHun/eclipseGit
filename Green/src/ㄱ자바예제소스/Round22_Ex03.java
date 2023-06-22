package ㄱ자바예제소스;

import java.awt.*;
import javax.swing.*;

class Round22_Ex03_Sub extends JFrame {
	private Container con;

	// private FlowLayout fl = new FlowLayout();
	private JButton jb = new JButton("Test");

	private JButton jb1 = new JButton("Test1");

	public Round22_Ex03_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
		// Dimension di = new Dimension();
		// System.out.println(jb.getSize(di));
		// System.out.println(di);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());// con.setLayout(new FlowLayout());
		jb.reshape(50, 50, 100, 100);// jb.setBounds(50, 50, 100, 100);
		jb.setBackground(Color.yellow);
		jb.setEnabled(true);
		jb.setForeground(Color.black);
		jb.setFont(new Font("굴림체", Font.BOLD, 20));
		jb.setOpaque(false);
		jb.setToolTipText("하하하"); // 툴팁 출력 Method
		con.add("Center", jb);
		jb1.reshape(60, 60, 100, 100);
		jb1.setToolTipText("호호호"); // 툴팁 출력 Method
		con.add("North", jb1);
		jb.updateUI();// combobox, list
	}

	public void start() {

	}
}

public class Round22_Ex03 {
	public static void main(String[] ar) {
		Round22_Ex03_Sub es = new Round22_Ex03_Sub();
	}
}
