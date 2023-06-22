package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

class Round19_Ex07_Sub extends Frame implements MouseMotionListener,
		KeyListener, FocusListener, ActionListener {
	private Label lb = new Label("x = 000, y = 000", Label.RIGHT);

	private Label lb1 = new Label("x = 000, y = 000");

	private Label jumin_lb = new Label("Jumin = ", Label.RIGHT);

	private TextField jumin_tf1 = new TextField(6);

	private Label jumin_dasi = new Label("-", Label.CENTER);

	private TextField jumin_tf2 = new TextField(7);

	private Button jumin_bt = new Button("중첩");

	private Panel p = null;

	public Round19_Ex07_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(new BorderLayout());
		this.add("North", lb);
		p = new Panel(new GridBagLayout());
		p.add(jumin_lb);
		p.add(jumin_tf1);
		p.add(jumin_dasi);
		p.add(jumin_tf2);
		p.add(jumin_bt);
		this.add("Center", p);
		this.add("South", lb1);
	}

	public void start() {
		this.addMouseMotionListener(this);
		p.addMouseMotionListener(this);
		lb.addMouseMotionListener(this);
		lb1.addMouseMotionListener(this);
		jumin_tf1.addKeyListener(this);
		jumin_tf1.addFocusListener(this);
		jumin_bt.addActionListener(this);
	}

	public void mouseMoved(MouseEvent e) {
		int xpos = e.getX();
		int ypos = e.getY();
		lb1.setText("x = " + xpos + ", y = " + ypos);
	}

	public void mouseDragged(MouseEvent e) {
		int xpos = e.getX();
		int ypos = e.getY();
		lb.setText("x = " + xpos + ", y = " + ypos);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == jumin_tf1) {
			String str = jumin_tf1.getText().trim();
			if (str.length() == 5) {
				jumin_tf2.requestFocus();
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == jumin_tf1) {
			String str = jumin_tf1.getText().trim();
			if (str.length() == 6) {
				jumin_tf2.requestFocus();
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void focusGained(FocusEvent e) {
		if (e.getSource() == jumin_tf1) {
			String str = jumin_tf1.getText().trim();
			if (str.length() != 6) {
				jumin_tf1.setText("");
				jumin_tf1.requestFocus();
			}
		}
	}

	public void focusLost(FocusEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jumin_bt) {
			String first = jumin_tf1.getText().trim();
			String second = jumin_tf2.getText().trim();
			if (first.length() != 6 || second.length() != 7) {
				jumin_tf1.setText("");
				jumin_tf2.setText("");
				jumin_tf1.requestFocus();
				return;
			}
			final Dialog dlg = new Dialog(this, "OK", true);
			dlg.setLayout(new BorderLayout());
			String sss = "주민번호 : " + first + "-" + second + "는 사용할 수 있다.";
			dlg.add("Center", new Label(sss, Label.CENTER));
			Button bt = new Button("확인");
			Panel pp = new Panel(new FlowLayout());
			pp.add(bt);
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dlg.setVisible(false);
				}
			});
			dlg.add("South", pp);
			dlg.setSize(300, 100);
			dlg.setVisible(true);
		}
	}
}

public class Round19_Ex07 {
	public static void main(String[] args) {
		Round19_Ex07_Sub ms = new Round19_Ex07_Sub();
	}
}
