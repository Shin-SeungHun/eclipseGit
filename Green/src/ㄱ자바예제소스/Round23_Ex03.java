import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

class Round23_Ex03_Sub extends Canvas implements Runnable {
	private Thread timeThread;

	private int h, m, s;// 시, 분, 초의 값을 기억

	private int xh, yh, xm, ym, xs, ys;// 현재의 시, 분, 초의 좌표를 기억

	private int xh1, yh1, xm1, ym1, xs1, ys1;// 바로 이전의 시, 분, 초의 좌표를 기억

	private int xcenter = 100;// 중심점의 x좌표

	private int ycenter = 100;// 중심점의 y좌표

	public Round23_Ex03_Sub() {
		timeThread = new Thread(this);
		timeThread.start();
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		Calendar ca = Calendar.getInstance();
		h = (int) ca.get(Calendar.HOUR_OF_DAY);// Date d = new Date();
												// d.getHours();
		m = (int) ca.get(Calendar.MINUTE);// d.getMinutes();
		s = (int) ca.get(Calendar.SECOND);// d.getSeconds();
		// 시간에 대한 좌표를 얻어내는 공식...
		xh = (int) (Math.cos((h * 30 + m / 2) * 3.14f / 180 - 3.14f / 2) * 60 + xcenter);
		yh = (int) (Math.sin((h * 30 + m / 2) * 3.14f / 180 - 3.14f / 2) * 60 + ycenter);
		xm = (int) (Math.cos(m * 3.14f / 30 - 3.14f / 2) * 90 + xcenter);
		ym = (int) (Math.sin(m * 3.14f / 30 - 3.14f / 2) * 90 + ycenter);
		xs = (int) (Math.cos(s * 3.14f / 30 - 3.14f / 2) * 90 + xcenter);
		ys = (int) (Math.sin(s * 3.14f / 30 - 3.14f / 2) * 90 + ycenter);
		// 여기까지...
		g.drawOval(0, 0, 200, 200);// 원
		g.fillOval(98, 98, 4, 4);// 중심원
		g.drawString("9", xcenter - 90, ycenter + 3);
		g.drawString("3", xcenter + 80, ycenter + 3);
		g.drawString("12", xcenter - 5, ycenter - 83);
		g.drawString("6", xcenter - 3, ycenter + 90);
		// 과거의 선들 지우는 작업...
		g.setColor(this.getBackground());
		if (xh != xh1 || yh != yh1) {
			g.drawLine(xcenter, ycenter - 2, xh1, yh1);
			g.drawLine(xcenter - 2, ycenter, xh1, yh1);
		}
		if (xm != xm1 || ym != ym1) {
			g.drawLine(xcenter, ycenter - 1, xm1, ym1);
			g.drawLine(xcenter - 1, ycenter, xm1, ym1);
		}
		if (xs != xs1 || ys != ys1) {
			g.drawLine(xcenter, ycenter, xs1, ys1);
		}
		// 여기까지...
		g.setColor(Color.black);
		g.drawLine(xcenter, ycenter, xs, ys);
		g.setColor(Color.red);
		g.drawLine(xcenter, ycenter - 1, xm, ym);
		g.drawLine(xcenter - 1, ycenter, xm, ym);
		g.setColor(Color.blue);
		g.drawLine(xcenter, ycenter - 2, xh, yh);
		g.drawLine(xcenter - 2, ycenter, xh, yh);
		xh1 = xh;
		yh1 = yh;
		xm1 = xm;
		ym1 = ym;
		xs1 = xs;
		ys1 = ys;
	}

	public void run() {
		while (timeThread != null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ee) {
			}
			repaint();
		}
	}

	public void stop() {
		timeThread = null;
	}
}

public class Round23_Ex03 extends JApplet implements Runnable {
	private Container con;

	private BorderLayout bl = new BorderLayout();

	private JTextField jtf = new JTextField();

	private Thread TimeThread;

	private Round23_Ex03_Sub es = new Round23_Ex03_Sub();

	public void init() {
		con = this.getContentPane();
		con.setLayout(bl);
		jtf.setEnabled(false);
		jtf.setDisabledTextColor(Color.magenta);
		jtf.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jtf.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		jtf.setHorizontalAlignment(SwingConstants.CENTER);
		con.add("Center", es);
		con.add("South", jtf);
	}

	public void start() {
		TimeThread = new Thread(this);
		TimeThread.start();
	}

	public void stop() {
		TimeThread = null;
		es.stop();
	}

	public void run() {
		while (TimeThread != null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ee) {
			}
			timeChange();
		}
	}

	private void timeChange() {
		Calendar ca = Calendar.getInstance();
		Date dd = ca.getTime();
		jtf.setText(dd.toString());
	}
}
