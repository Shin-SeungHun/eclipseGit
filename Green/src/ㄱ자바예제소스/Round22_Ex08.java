package ㄱ자바예제소스;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class Round22_Ex08_Sub extends JFrame {
	private JMenuBar jmb = new JMenuBar();

	private JMenu file = new JMenu("파일");

	private JMenuItem fnew = new JMenuItem("새파일");

	private ImageIcon im = new ImageIcon("bbb.gif");

	private JMenuItem fopen = new JMenuItem(im);

	private ImageIcon im1 = new ImageIcon("ccc.gif");

	private JMenuItem fexit = new JMenuItem("종료", im1);

	private JMenu edit = new JMenu("수정");

	private JMenu esize = new JMenu("크기");

	private JRadioButtonMenuItem es10 = new JRadioButtonMenuItem("10");

	private JRadioButtonMenuItem es20 = new JRadioButtonMenuItem("20");

	private JRadioButtonMenuItem es30 = new JRadioButtonMenuItem("30");

	private ButtonGroup bg = new ButtonGroup();

	private JMenu ecolor = new JMenu("색상");

	private JCheckBoxMenuItem ecred = new JCheckBoxMenuItem("RED");

	private JCheckBoxMenuItem ecgreen = new JCheckBoxMenuItem("GREEN");

	private JCheckBoxMenuItem ecblue = new JCheckBoxMenuItem("BLUE");

	private JMenu help = new JMenu("도움말");

	public Round22_Ex08_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setJMenuBar(jmb);
		fexit.setArmed(true);
		file.add(fnew);
		file.addSeparator();
		file.add(fopen);
		file.addSeparator();
		file.add(fexit);
		jmb.add(file);
		edit.setBorder(new LineBorder(Color.red, 3));
		esize.setBorder(new BevelBorder(BevelBorder.RAISED));
		ecolor.setBorder(new BevelBorder(BevelBorder.RAISED));
		bg.add(es10);
		bg.add(es20);
		bg.add(es30);
		esize.add(es10);
		esize.add(es20);
		esize.add(es30);
		edit.add(esize);
		edit.addSeparator();
		ecolor.add(ecred);
		ecolor.add(ecgreen);
		ecolor.add(ecblue);
		edit.add(ecolor);
		jmb.add(edit);
		jmb.add(help);
	}

	public void start() {

	}
}

public class Round22_Ex08 {
	public static void main(String[] ar) {
		Round22_Ex08_Sub es = new Round22_Ex08_Sub();
	}
}
