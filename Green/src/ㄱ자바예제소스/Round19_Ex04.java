package ㄱ자바예제소스;

import java.awt.*;
import java.awt.event.*;

class Round19_Ex04_Sub extends Frame implements ItemListener {
	private FlowLayout fl = new FlowLayout();

	private Choice ch = new Choice();

	private List li = new List(3, false);

	public Round19_Ex04_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(fl);
		ch.add("AAA");
		ch.add("BBB");
		ch.add("CCC");
		this.add(ch);
		li.add("AAA");
		li.add("BBB");
		li.add("CCC");
		this.add(li);
	}

	public void start() {
		ch.addItemListener(this);
		li.addItemListener(this);
	}

	public void paint(Graphics g) {

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == ch) {
			String str = ch.getSelectedItem();
			System.out.println("얻어온 문자열 = " + str);
		} else if (e.getSource() == li) {
			String str = li.getSelectedItem();
			System.out.println("리스트에서 얻어온 문자 = " + str);
		}
	}
}

public class Round19_Ex04 {
	public static void main(String[] ar) {
		Round19_Ex04_Sub es = new Round19_Ex04_Sub();
	}
}
