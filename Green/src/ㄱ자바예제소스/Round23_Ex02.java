import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Round23_Ex02 extends JApplet implements ActionListener {
	private JMenuBar jmb = new JMenuBar();

	private JMenu file = new JMenu("File");

	private JMenu help = new JMenu("Help");

	private JMenuItem fnew = new JMenuItem("New File");

	private JMenuItem fstop = new JMenuItem("Stop");

	public void init() {
		this.setJMenuBar(jmb);
		jmb.add(file);
		jmb.add(help);
		fnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK)); // control + n
		fstop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK)); // control + s
		file.add(fnew);
		file.addSeparator();
		file.add(fstop);
	}

	public void start() {
		fnew.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fnew) {
			this.showStatus("New File 키를 눌렀습니다."); // 상태바에 문자열 띄우기
		}
	}
}
