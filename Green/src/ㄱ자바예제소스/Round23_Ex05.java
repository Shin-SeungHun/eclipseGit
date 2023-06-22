import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import javax.swing.tree.*;

class Round23_Ex05_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	private DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode("TOP");

	private DefaultMutableTreeNode dmtn1 = new DefaultMutableTreeNode("RED");

	private DefaultMutableTreeNode dmtn2 = new DefaultMutableTreeNode("GREEN");

	private DefaultMutableTreeNode dmtn3 = new DefaultMutableTreeNode("BLUE");

	private DefaultMutableTreeNode dmtn11 = new DefaultMutableTreeNode("11");

	private DefaultMutableTreeNode dmtn22 = new DefaultMutableTreeNode("22");

	private DefaultMutableTreeNode dmtn33 = new DefaultMutableTreeNode("33");

	private DefaultTreeModel dtm = new DefaultTreeModel(dmtn);

	private JTree jt = new JTree(dtm);

	private JScrollPane jsp = new JScrollPane(jt);

	public Round23_Ex05_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout(5, 5));
		con.add("North", new JLabel("JTree !!!", JLabel.CENTER));
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(new JButton("확인"));
		jp.add(new JButton("취소"));
		con.add("South", jp);
		dmtn.add(dmtn1);
		dmtn.add(dmtn2);
		dmtn.add(dmtn3);
		dmtn1.add(dmtn11);
		dmtn1.add(dmtn22);
		dmtn1.add(dmtn33);
		con.add("Center", jsp);
	}

	public void start() {

	}
}

public class Round23_Ex05 {
	public static void main(String[] ar) {
		Round23_Ex05_Sub es = new Round23_Ex05_Sub();
	}
}
