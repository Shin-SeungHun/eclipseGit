import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Round21_Ex07 extends Applet implements ActionListener {
	private Image img1 = null;

	private Image img2 = null;

	private AudioClip ac = null;

	private Button start_bt = new Button("시작");

	private Button end_bt = new Button("멈춤");

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
			ac.loop(); // sound를 무한 반복 실행한다.
			bool = true; // 소리가 나는 그림 모양으로 변경한다.
			this.repaint();
		} else if (e.getSource() == end_bt) {
			ac.stop(); // sound를 멈춘다.
			bool = false; // 소리가 나지 않는 그림 모양으로 변경한다.
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
