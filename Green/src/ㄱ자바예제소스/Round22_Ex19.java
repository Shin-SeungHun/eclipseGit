import java.awt.*;
import javax.swing.*;

class Round22_Ex19_Sub extends JFrame {
	private Container con;

	private JLabel lb = new JLabel("�̰��� �� ���Դϴ�.");

	private JButton bt = new JButton("Ȯ��");

	private JButton bt1 = new JButton("���");

	private JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	private JPanel jp1 = new JPanel(new BorderLayout());

	private JTabbedPane jtp = new JTabbedPane(JTabbedPane.BOTTOM,
			JTabbedPane.SCROLL_TAB_LAYOUT);

	private JButton bt2 = new JButton("ù��° Tab");

	private JButton bt3 = new JButton("�ι�° Tab");

	private JButton bt4 = new JButton("����° Tab");

	private JButton bt5 = new JButton("�׹�° Tab");

	private JButton bt6 = new JButton("�ټ���° Tab");

	public Round22_Ex19_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout(5, 5));
		con.add("North", lb);
		jp.add(bt);
		jp.add(bt1);
		con.add("South", jp);
		jtp.add(bt2);
		jtp.add(bt3);
		jtp.add(bt4, 1);
		jtp.add("Title", bt5);
		jtp.addTab("Title1", new ImageIcon("bbb.gif"), bt6, "���� �������� �ֽ��ϴ�.");
		jp1.add("Center", jtp);
		jtp.setBackgroundAt(2, Color.red);
		jtp.setDisplayedMnemonicIndexAt(3, 0);
		jtp.setEnabledAt(2, false);
		jtp.setForegroundAt(4, Color.yellow);
		jtp.setMnemonicAt(3, 65);
		jtp.setTitleAt(0, "Test");
		con.add("Center", jp1);
	}

	public void start() {

	}
}

public class Round22_Ex19 {
	public static void main(String[] ar) {
		Round22_Ex19_Sub es = new Round22_Ex19_Sub();
	}
}
