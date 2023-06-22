import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Round22_Ex18_Sub extends JFrame implements MouseListener {
	private Container con;

	private JLabel lb = new JLabel("메모를 하십시오");

	private JTextArea ta = new JTextArea();

	private JScrollPane jsp = new JScrollPane(ta);

	private JPopupMenu jpm = new JPopupMenu();

	private JMenuItem jmi = new JMenuItem("복사");

	private JMenuItem jmi1 = new JMenuItem("붙여넣기");

	private JMenuItem jmi2 = new JMenuItem("잘라내기");

	public Round22_Ex18_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		jpm.add(jmi);
		jpm.addSeparator();
		jpm.add(jmi1);
		jpm.addSeparator();
		jpm.add(jmi2);
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", lb);
		con.add("Center", jsp);
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ta.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == ta) {
			// 팝업 띄우기...
			if (e.isPopupTrigger()) {
				jpm.show(ta, e.getX(), e.getY());
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}

public class Round22_Ex18 {
	public static void main(String[] ar) {
		Round22_Ex18_Sub es = new Round22_Ex18_Sub();
	}
}
