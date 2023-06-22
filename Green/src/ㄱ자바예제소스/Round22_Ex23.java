import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Round22_Ex23_Sub extends JFrame implements KeyListener, ActionListener {
	private Container con;

	private JTextArea ta = new JTextArea();

	private JScrollPane jsp = new JScrollPane(ta);

	private JMenuBar mb = new JMenuBar();

	private JMenu file = new JMenu("File");

	private JMenuItem fexit = new JMenuItem("Exit");

	public Round22_Ex23_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setJMenuBar(mb);
		file.setMnemonic('F');
		mb.add(file);
		KeyStroke ks = KeyStroke.getKeyStroke('E', InputEvent.CTRL_MASK
				^ InputEvent.ALT_MASK);
		fexit.setAccelerator(ks);
		file.add(fexit);
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("Center", jsp);
	}

	public void start() {
		ta.addKeyListener(this);
		fexit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fexit) {
			System.exit(0);
		}
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == ta) {
			// System.out.println("key = " + e.getKeyChar());
			// System.out.println("mod = " + e.getModifiers());
			KeyStroke ks = KeyStroke.getKeyStroke(e.getKeyChar(), e
					.getModifiers());
			KeyStroke ks1 = KeyStroke.getKeyStroke('r', InputEvent.ALT_MASK);
			// CTRL_MASK, SHIFT_MASK
			if (ks.equals(ks1)) {
				System.out.println("alt + r 을 눌렀습니다.");
			} else {
				System.out.println(ks);
			}
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}

public class Round22_Ex23 {
	public static void main(String[] ar) {
		Round22_Ex23_Sub es = new Round22_Ex23_Sub();
	}
}
