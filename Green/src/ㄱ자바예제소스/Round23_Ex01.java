import java.awt.*;
import javax.swing.*;

class Round23_Ex01_Sub extends Canvas {
	public void paint(Graphics g) {
		g.drawLine(50, 50, 100, 100);
		g.setColor(Color.red);
		g.fillRect(100, 100, 50, 50);
	}
}

public class Round23_Ex01 extends JApplet {
	private Container con;

	private JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	private JButton bt = new JButton("확인");

	private JButton bt1 = new JButton("취소");

	private Round23_Ex01_Sub es = new Round23_Ex01_Sub();

	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		jp.add(bt);
		jp.add(bt1);
		con.add("South", jp);
		con.add("Center", es);
	}

	public void start() {

	}

	public void stop() {

	}

	public void destroy() {

	}
}
