import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Round21_Ex07 extends Applet implements ActionListener {
	private Image img1 = null;

	private Image img2 = null;

	private AudioClip ac = null;

	private Button start_bt = new Button("����");

	private Button end_bt = new Button("����");

	private boolean bool = false;

	public void init() {
		String img1_str = this.getParameter("img1");
		String img2_str = this.getParameter("img2");
		String sound_str = this.getParameter("sound");
		img1 = this.getImage(this.getDocumentBase(), img1_str);
		img2 = this.getImage(this.getCodeBase(), img2_str);
		ac = this.getAudioClip(this.getDocumentBase(), sound_str);
		this.setLayout(new BorderLayout());
		Panel p = new Panel(new FlowLayout());
		p.add(start_bt);
		p.add(end_bt);
		this.add("South", p);
	}

	public void start() {
		start_bt.addActionListener(this);
		end_bt.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start_bt) {
			ac.loop(); // sound�� ���� �ݺ� �����Ѵ�.
			bool = true; // �Ҹ��� ���� �׸� ������� �����Ѵ�.
			this.repaint();
		} else if (e.getSource() == end_bt) {
			ac.stop(); // sound�� �����.
			bool = false; // �Ҹ��� ���� �ʴ� �׸� ������� �����Ѵ�.
			this.repaint();
		}
	}

	// public void update(Graphics g) {}
	public void paint(Graphics g) {
		if (bool) {
			g.drawImage(img1, 20, 20, 260, 140, this);
		} else {
			g.drawImage(img2, 20, 20, 260, 140, this);
		}
	}

	public void stop() {
	}
	// public void destroy() {}
}
