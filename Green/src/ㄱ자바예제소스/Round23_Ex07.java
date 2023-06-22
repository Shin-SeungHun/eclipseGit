import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;

/*
 * Created on 2005. 10. 31.
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
class Round23_Ex07_Sub extends JFrame implements TreeWillExpandListener,
		ActionListener {
	private Container con;

	private JSplitPane sp = new JSplitPane();

	private JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("My 탐색기");

	private JTree tree_jt = new JTree(root);

	private JScrollPane tree_jsp = new JScrollPane(tree_jt);

	private Vector view_vc = new Vector();

	private JList view_li = new JList(view_vc);

	private JScrollPane view_jsp = new JScrollPane(view_li);

	private JButton view_bt = new JButton("VIEW");

	private JButton edit_bt = new JButton("EDIT");

	private JButton del_bt = new JButton("DELETE");

	private JButton end_bt = new JButton("EXIT");

	private JTextArea data_ta = new JTextArea();

	private JScrollPane data_jsp = new JScrollPane(data_ta);

	private Dimension screen;

	public Round23_Ex07_Sub() {
		super("My 탐색기");
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.init();
		this.start();
		this.setSize((int) screen.getWidth(), (int) screen.getHeight());
		this.setLocation(0, 0);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("Center", sp);
		tree_jsp.setPreferredSize(new Dimension(200, (int) screen.getHeight()));
		sp.setLeftComponent(tree_jsp);
		JPanel jp = new JPanel(new BorderLayout());
		view_jsp.setPreferredSize(new Dimension((int) screen.getWidth() - 220,
				300));
		jp.add("Center", view_jsp);
		JPanel jp1 = new JPanel(new GridLayout(1, 4, 5, 5));
		jp1.add(view_bt);
		jp1.add(edit_bt);
		jp1.add(del_bt);
		jp1.add(end_bt);
		jp.add("South", jp1);
		sp1.setTopComponent(jp);
		sp1.setBottomComponent(data_jsp);
		sp.setRightComponent(sp1);

		File[] file = File.listRoots();
		for (int i = 0; i < file.length; i++) {
			DefaultMutableTreeNode dmt = new DefaultMutableTreeNode(file[i]);
			dmt.add(new DefaultMutableTreeNode("EMPTY"));
			root.add(dmt);
		}

	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tree_jt.addTreeWillExpandListener(this);
		view_bt.addActionListener(this);
		edit_bt.addActionListener(this);
		del_bt.addActionListener(this);
		end_bt.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view_bt) {
			TreePath tp = tree_jt.getSelectionPath();
			// System.out.println("tp = " + tp);
			StringTokenizer stk = new StringTokenizer(tp.toString(), "[,]");
			stk.nextToken();
			if (stk.hasMoreTokens()) {
				String filepath = stk.nextToken().trim();
				while (stk.hasMoreTokens()) {
					filepath += stk.nextToken().trim() + "/";
				}
				String filename = (String) view_li.getSelectedValue();
				filename = filename.substring(0, filename.indexOf("(")).trim();
				File f = new File(filepath, filename);
				try {
					BufferedReader in = new BufferedReader(new FileReader(f));
					data_ta.setText("");
					while (true) {
						String str = in.readLine();
						if (str == null)
							break;
						data_ta.append(str + "\n");
					}
					in.close();
				} catch (IOException ee) {
				}
			}
		} else if (e.getSource() == edit_bt) {
			TreePath tp = tree_jt.getSelectionPath();
			// System.out.println("tp = " + tp);
			StringTokenizer stk = new StringTokenizer(tp.toString(), "[,]");
			stk.nextToken();
			if (stk.hasMoreTokens()) {
				String filepath = stk.nextToken().trim();
				while (stk.hasMoreTokens()) {
					filepath += stk.nextToken().trim() + "/";
				}
				String filename = (String) view_li.getSelectedValue();
				filename = filename.substring(0, filename.indexOf("(")).trim();
				File f = new File(filepath, filename);
				int xx = JOptionPane.showConfirmDialog(this, "정말 수정하시겠습니까?",
						"수정", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (xx == 0) {
					try {
						DataOutputStream dos = new DataOutputStream(
								new BufferedOutputStream(
										new FileOutputStream(f)));
						byte[] data = data_ta.getText().trim().getBytes();
						dos.write(data);
						dos.close();
					} catch (IOException ee) {
					}
				}
			}
		} else if (e.getSource() == del_bt) {
			TreePath tp = tree_jt.getSelectionPath();
			// System.out.println("tp = " + tp);
			StringTokenizer stk = new StringTokenizer(tp.toString(), "[,]");
			stk.nextToken();
			if (stk.hasMoreTokens()) {
				String filepath = stk.nextToken().trim();
				while (stk.hasMoreTokens()) {
					filepath += stk.nextToken().trim() + "/";
				}
				String filename = (String) view_li.getSelectedValue();
				filename = filename.substring(0, filename.indexOf("(")).trim();
				File f = new File(filepath, filename);
				int xx = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?",
						"삭제", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (xx == 0) {
					f.delete();
					view_vc.clear();
					view_li.setListData(view_vc);
					data_ta.setText("");
				}
			}
		} else if (e.getSource() == end_bt) {
			System.exit(0);
		}
	}

	public void treeWillExpand(TreeExpansionEvent e) {
		if (e.getSource() == tree_jt) {
			tree_jt.setSelectionPath(e.getPath());
			TreePath tp = tree_jt.getSelectionPath();
			// System.out.println("tp = " + tp);
			StringTokenizer stk = new StringTokenizer(tp.toString(), "[,]");
			stk.nextToken();
			if (stk.hasMoreTokens()) {
				String filepath = stk.nextToken().trim();
				while (stk.hasMoreTokens()) {
					filepath += stk.nextToken().trim() + "/";
				}
				// System.out.println("file = " + filepath);
				File dir = new File(filepath);
				File[] data = dir.listFiles();
				if (data == null) {
					return;
				}
				DefaultMutableTreeNode imsi = (DefaultMutableTreeNode) e
						.getPath().getLastPathComponent();
				imsi.removeAllChildren();
				view_vc.clear();
				if (data.length == 0) {
					imsi.add(new DefaultMutableTreeNode("EMPTY"));
				} else {
					int count = -1;
					for (int i = 0; i < data.length; i++) {
						if (data[i].isDirectory()) {
							DefaultMutableTreeNode dtm = new DefaultMutableTreeNode(
									data[i].getName());
							dtm.add(new DefaultMutableTreeNode("EMPTY"));
							imsi.add(dtm);
							count++;
						} else {
							view_vc.add(data[i].getName() + " ("
									+ data[i].length() + "byte, "
									+ new Date(data[i].lastModified()) + ")");
						}
					}
					if (count == -1) {
						imsi.add(new DefaultMutableTreeNode("EMPTY"));
					}
				}
				view_li.setListData(view_vc);
			}
		}
	}

	public void treeWillCollapse(TreeExpansionEvent e) {
	}
}

public class Round23_Ex07 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ee) {
		}
		Round23_Ex07_Sub ws = new Round23_Ex07_Sub();
	}
}
