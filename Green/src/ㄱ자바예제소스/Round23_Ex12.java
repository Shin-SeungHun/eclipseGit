import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;

/*
 * Created on 2005. 11. 1.
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
class Round23_Ex12_Sub extends JFrame implements ActionListener {
	private Container con;

	private JLabel title_lb = new JLabel("파일 검색", JLabel.CENTER);

	private JTextField search_tf = new JTextField(15);

	private Vector condition_vc = new Vector();

	private JComboBox condition_jcb = new JComboBox(condition_vc);

	private JScrollPane condition_jsp = new JScrollPane(condition_jcb);

	private JButton search_bt = new JButton("검색 시작");

	private JLabel result_lb = new JLabel("RESULTS");

	private JLabel view_lb = new JLabel();

	private Vector data_vc = new Vector();

	private Vector field_vc = new Vector();

	private JTable view_jt;

	private JScrollPane view_jsp;

	private JButton clear_bt = new JButton("CLEAR");

	private JButton end_bt = new JButton("END");

	private JPanel jpjp;

	public Round23_Ex12_Sub() {
		super("My Search!");
		this.init();
		this.start();
		this.setSize(700, 500);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = this.getSize();
		int xpos = (int) (screen.getWidth() / 2 - frm.getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - frm.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout(10, 10));
		JPanel jp = new JPanel(new BorderLayout());
		title_lb.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		jp.add("North", title_lb);
		JPanel jp1 = new JPanel(new GridLayout(3, 1));
		jp1.setBorder(new BevelBorder(BevelBorder.RAISED));
		jp1.setBackground(Color.WHITE);
		JPanel jp2 = new JPanel(new BorderLayout());
		jp2.setBorder(new TitledBorder("파일검색"));
		JPanel jp3 = new JPanel(new GridLayout(2, 1));
		search_tf.setBorder(new TitledBorder("검색조건"));
		jp3.add(search_tf);
		condition_jsp.setBorder(new TitledBorder("검색범위"));
		jp3.add(condition_jsp);
		jp2.add("Center", jp3);
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp4.add(search_bt);
		jp2.add("South", jp4);
		jp1.add(jp2);
		jp1.add(new JLabel());
		jp1.add(new JLabel());
		jp.add("Center", jp1);
		jp.setPreferredSize(new Dimension(150, 500));
		con.add("West", jp);

		jpjp = new JPanel(new BorderLayout(10, 10));
		JPanel jpjp1 = new JPanel(new BorderLayout(5, 5));
		result_lb.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		jpjp1.add("West", result_lb);
		view_lb.setBorder(new BevelBorder(BevelBorder.LOWERED));
		jpjp1.setPreferredSize(new Dimension(550, 50));
		JPanel jpjpjp = new JPanel(new BorderLayout());
		jpjpjp.setBackground(Color.white);
		// view_lb.setBackground(Color.white);
		// view_lb.setForeground(Color.BLACK);
		jpjpjp.add("Center", view_lb);
		jpjp1.add("Center", jpjpjp);
		jpjp.add("North", jpjp1);
		field_vc.add("파일명");
		field_vc.add("파일경로");
		field_vc.add("파일크기");
		field_vc.add("최종수정일");
		field_vc.add("파일종류");
		view_jt = new JTable(data_vc, field_vc);
		view_jsp = new JScrollPane(view_jt);
		jpjp.add("Center", view_jsp);
		JPanel jpjp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jpjp2.add(clear_bt);
		jpjp2.add(end_bt);
		jpjp.add("South", jpjp2);
		con.add("Center", jpjp);

		File[] root = File.listRoots();
		condition_vc.add("전체범위");
		for (int i = 0; i < root.length; i++) {
			condition_vc.add(root[i].toString());
		}
		condition_jcb.updateUI();

	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		search_bt.addActionListener(this);
		search_tf.addActionListener(this);
		clear_bt.addActionListener(this);
		end_bt.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search_tf || e.getSource() == search_bt) {
			String data = search_tf.getText();
			if (data == null || data.trim().length() == 0) {
				return;
			}
			data = data.trim();
			int condition = 0;
			char ch = data.charAt(0);
			if (ch == '*') {
				condition = 1;
			}
			char ch1 = data.charAt(data.length() - 1);
			if (ch1 == '*') {
				condition = 2;
			}
			if (ch == '*' && ch1 == '*') {
				condition = 3;
			}

			String str = (String) condition_jcb.getSelectedItem();
			if (str.trim().equals("전체범위")) {
				File[] root = File.listRoots();
				for (int i = 1; i < root.length; i++) {
					// this.searchDirectory(
					new MyThread(root[i].toString(), data, condition);
				}
			} else {
				new MyThread(str.trim(), data, condition);
			}
		} else if (e.getSource() == clear_bt) {
			// data_vc.add(imsi);
			// view_jt.updateUI();
			data_vc.clear();
			jpjp.remove(view_jsp);
			view_jt = new JTable(data_vc, field_vc);
			view_jsp = new JScrollPane(view_jt);
			jpjp.add("Center", view_jsp);
			jpjp.validate();
		} else if (e.getSource() == end_bt) {
			System.exit(0);
		}
	}

	private void updateTable(Vector imsi) {
		data_vc.add(imsi);
		// view_jt.updateUI();
		jpjp.remove(view_jsp);
		view_jt = new JTable(data_vc, field_vc);
		view_jsp = new JScrollPane(view_jt);
		jpjp.add("Center", view_jsp);
		jpjp.validate();

	}

	class MyThread1 extends Thread {
		private String path;

		public MyThread1(String path) {
			this.path = path;
			this.start();
		}

		public void run() {
			view_lb.setText(path);
		}
	}

	class MyThread extends Thread {
		private String path;

		private String data;

		private int condition;

		public MyThread(String path, String data, int condition) {
			this.path = path;
			this.data = data;
			this.condition = condition;
			this.start();
		}

		public void run() {
			this.searchDirectory();
		}

		private void searchDirectory() {
			File[] files = new File(path).listFiles();
			if (files == null)
				return;
			for (int i = 0; i < files.length; i++) {
				// view_lb.setText(files[i].getPath());
				new MyThread1(files[i].getPath());
				if (condition == 0) {
					if (files[i].getName().equals(data)) { // 0
						Vector imsi = new Vector();
						imsi.add(files[i].getName());
						imsi.add(files[i].getParent());
						imsi.add(String.valueOf(files[i].length()));
						imsi.add(new Date(files[i].lastModified()).toString());
						imsi.add(files[i].isDirectory() ? "폴더" : "파일");
						// data_vc.add(imsi);
						// view_jt.updateUI();
						updateTable(imsi);
					}
				} else if (condition == 1) {
					if (files[i].getName().endsWith(data.substring(1))) { // 1
						Vector imsi = new Vector();
						imsi.add(files[i].getName());
						imsi.add(files[i].getParent());
						imsi.add(String.valueOf(files[i].length()));
						imsi.add(new Date(files[i].lastModified()).toString());
						imsi.add(files[i].isDirectory() ? "폴더" : "파일");
						// data_vc.add(imsi);
						// view_jt.updateUI();
						updateTable(imsi);
					}
				} else if (condition == 2) {
					if (files[i].getName().startsWith(
							data.substring(0, data.trim().length() - 1))) { // 2
						Vector imsi = new Vector();
						imsi.add(files[i].getName());
						imsi.add(files[i].getParent());
						imsi.add(String.valueOf(files[i].length()));
						imsi.add(new Date(files[i].lastModified()).toString());
						imsi.add(files[i].isDirectory() ? "폴더" : "파일");
						// data_vc.add(imsi);
						// view_jt.updateUI();
						updateTable(imsi);
					}
				} else if (condition == 3) {
					if (files[i].getName().indexOf(
							data.substring(1, data.trim().length() - 1)) != -1) { // 3
						Vector imsi = new Vector();
						imsi.add(files[i].getName());
						imsi.add(files[i].getParent());
						imsi.add(String.valueOf(files[i].length()));
						imsi.add(new Date(files[i].lastModified()).toString());
						imsi.add(files[i].isDirectory() ? "폴더" : "파일");
						// data_vc.add(imsi);
						// view_jt.updateUI();
						updateTable(imsi);
					}
				}
			}
			// view_lb.setText("");
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					new MyThread(path + File.separator + files[i].getName(),
							data, condition);
				}
			}
		}
	}
}

public class Round23_Ex12 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ee) {
		}
		Round23_Ex12_Sub ss = new Round23_Ex12_Sub();
	}
}
