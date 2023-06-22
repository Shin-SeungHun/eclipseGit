import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Round22_Ex04_Sub extends JFrame implements MouseListener {
	private Container con;

	private FlowLayout fl = new FlowLayout();

	private JButton jb = new JButton("String");

	private ImageIcon im = new ImageIcon("aa.gif");

	private JButton jb1 = new JButton(im);

	private JButton jb2 = new JButton("Str & Icon", im);

	private ImageIcon im1 = new ImageIcon("bb.gif");

	private ImageIcon im2 = new ImageIcon("cc.gif");

	public Round22_Ex04_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(fl);
		//jb.setEnabled(false); // ��ư ��� ���� Method
		con.add(jb);
		jb1.setMnemonic('a');// alt + a (����Ű ���� Method)
		con.add(jb1);
		jb2.setHorizontalTextPosition(SwingConstants.RIGHT); // Text ��ġ����
																// Method
		jb2.setVerticalTextPosition(SwingConstants.TOP); // Text ��ġ���� Method
		jb2.setMnemonic('b');// alt + b (����Ű ���� Method)
		jb2.setPressedIcon(im1); // ���콺�� ������ ���� �̹��� ��ȭ Method
		jb2.setRolloverIcon(im2); // ���콺�� �÷��� ���� �̹��� ��ȭ Method
		con.add(jb2);
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == jb) {
			jb.doClick(5000); // ���콺 Ŭ�� ���� Method
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}

public class Round22_Ex04 {
	public static void main(String[] ar) {
		Round22_Ex04_Sub es = new Round22_Ex04_Sub();
	}
}
