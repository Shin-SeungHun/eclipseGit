import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Created on 2005. 10. 25.
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author kimsh
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
class Hourse extends Canvas implements Runnable {
	private Round21_Ex08 parent;

	private int number;

	private Image stop_hourse;

	private int xpos;

	public Hourse(Round21_Ex08 p, int num) {
		parent = p;
		number = num;
		stop_hourse = p.getImage(p.getCodeBase(), "ho_stop.gif");
	}

	public void paint(Graphics g) {
		Dimension di = this.getSize();
		g.drawLine(0, (int) (di.getHeight() / 2), (int) di.getWidth(),
				(int) (di.getHeight() / 2));
		g
				.drawImage(stop_hourse, xpos, 5, 30,
						(int) (di.getHeight() - 10), this);
	}

	public void run() {
		stop_hourse = parent.getImage(parent.getCodeBase(),
				"animal2011500[1].gif");
		Dimension di = this.getSize();
		for (int i = 0; i < di.getWidth() - 30; i++) {
			i += (int) (Math.random() * 3) + 1;
			xpos = i;
			this.repaint();
			try {
				Thread.sleep(30 + (int) (Math.random() * 10));
			} catch (InterruptedException ee) {
			}
		}
		stop_hourse = parent.getImage(parent.getCodeBase(), "ho_stop.gif");
		parent.setMyData(number);

	}
}

public class Round21_Ex08 extends Applet implements ActionListener {
	private Label num_lb = new Label("말의 수 = ", Label.RIGHT);

	private TextField num_tf = new TextField(5);

	private Button set_bt = new Button("설정");

	private Button clear_bt = new Button("초기화");

	private Panel center_pane = new Panel();

	private Label rank_lb = new Label("☆ 등 수 ☆");

	private Button start_bt = new Button("출발");

	private List rank_li = new List(5, false);

	private Hourse[] hourse;

	private static int rank = 1;

	public void init() {
		this.setLayout(new BorderLayout(5, 5));
		this.setBackground(Color.white);
		Panel p = new Panel(new GridBagLayout());
		p.add(num_lb);
		p.add(num_tf);
		p.add(set_bt);
		p.add(clear_bt);
		this.add("North", p);
		this.add("Center", center_pane);
		Panel p1 = new Panel(new BorderLayout());
		Panel p2 = new Panel(new GridLayout(1, 2));
		Panel p3 = new Panel(new FlowLayout(FlowLayout.LEFT));
		p3.add(rank_lb);
		p2.add(p3);
		Panel p4 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p4.add(start_bt);
		p2.add(p4);
		p1.add("North", p2);
		p1.add("Center", rank_li);
		this.add("South", p1);
	}

	public void start() {
		num_tf.addActionListener(this);
		set_bt.addActionListener(this);
		clear_bt.addActionListener(this);
		start_bt.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == num_tf || e.getSource() == set_bt) {
			String num_str = num_tf.getText();
			if (num_str == null || num_str.trim().length() == 0)
				return;
			int number = 0;
			try {
				number = Integer.parseInt(num_str);
			} catch (NumberFormatException ee) {
				num_tf.setText("");
				return;
			}
			this.remove(center_pane);
			center_pane = new Panel(new GridLayout(number, 1));
			hourse = new Hourse[number];
			for (int i = 0; i < number; i++) {
				hourse[i] = new Hourse(this, i);
				center_pane.add(hourse[i]);
			}
			this.add("Center", center_pane);
			set_bt.setEnabled(false);
			this.validate();
		} else if (e.getSource() == clear_bt) {
			num_tf.setText("");
			set_bt.setEnabled(true);
			this.remove(center_pane);
			center_pane = new Panel();
			this.add("Center", center_pane);
			this.validate();
			rank_li.clear();
			num_tf.requestFocus();
		} else if (e.getSource() == start_bt) {
			for (int i = 0; i < hourse.length; i++) {
				Thread imsi = new Thread(hourse[i]);
				imsi.start();
			}
		}
	}

	public void setMyData(int num) {
		rank_li.add(rank++ + "등==>" + (num + 1) + "번말");
		if (rank == hourse.length + 1) {
			start_bt.setEnabled(true);
			rank = 1;

		}
	}

	// public void update(Graphics g) { paint(g); }
	public void paint(Graphics g) {
	}

	public void stop() {
	}

	public void destroy() {
	}
}
