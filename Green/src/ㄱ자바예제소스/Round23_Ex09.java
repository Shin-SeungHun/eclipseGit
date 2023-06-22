import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import javax.swing.table.*;

class Round23_Ex09_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	// private DefaultTableModel dtm = new DefaultTableModel();
	// private DefaultTableModel dtm = new DefaultTableModel(3, 4);
	// private String[][] str = {{"1_1", "1_2", "1_3", "1_4"}, {"2_1", "2_2",
	// "2_3", "2_4"}, {"3_1", "3_2", "3_3", "3_4"}};
	// private String[] str1 = {"1번", "2번", "3번", "4번"};
	// private DefaultTableModel dtm = new DefaultTableModel(str, str1);
	private String[] str = { "1번", "2번", "3번", "4번" };

	private DefaultTableModel dtm = new DefaultTableModel(str, 5);

	private JTable jt = new JTable(dtm);

	private JScrollPane jsp = new JScrollPane(jt);

	public Round23_Ex09_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
		System.out.println("1 Column's Class Name = " + dtm.getColumnClass(0));
		System.out.println("Column Count = " + dtm.getColumnCount());
		System.out.println("3 Column's Name = " + dtm.getColumnName(2));
		System.out.println("Row Count = " + dtm.getRowCount());
		dtm.setValueAt("Test", 2, 2);
		System.out.println("2, 2 Editable = " + dtm.isCellEditable(2, 2));
		System.out.println("2번 Column's Pos = " + dtm.findColumn("2번"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		String[] s = { "1", "2", "3", "4", "5" };
		dtm.addColumn("5번", s);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		String[] a = { "true", "true", "true", "true", "true" };
		dtm.addRow(a);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		String[] b = { "false", "false", "false", "false", "false" };
		dtm.insertRow(2, b);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		dtm.moveRow(1, 3, 0);
		String[] sss = { "11", "22", "33", "44", "55" };
		dtm.setColumnIdentifiers(sss);
		dtm.setRowCount(14);// dtm.setNumRows(14);
	}

	public void init() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout(5, 5));
		con.add("North", new JLabel("JTable !!!", JLabel.CENTER));
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(new JButton("확인"));
		jp.add(new JButton("취소"));
		con.add("South", jp);
		con.add("Center", jsp);
	}

	public void start() {

	}
}

public class Round23_Ex09 {
	public static void main(String[] ar) {
		Round23_Ex09_Sub es = new Round23_Ex09_Sub();
	}
}
