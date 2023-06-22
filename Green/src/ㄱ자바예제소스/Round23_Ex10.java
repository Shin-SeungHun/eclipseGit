import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import javax.swing.table.*;

class Round23_Ex10_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	private String[][] str = { { "1_1", "1_2", "1_3", "1_4" },
			{ "2_1", "2_2", "2_3", "2_4" }, { "3_1", "3_2", "3_3", "3_4" } };

	private String[] str1 = { "1번", "2번", "3번", "4번" };

	private DefaultTableModel dtm = new DefaultTableModel(str, str1);

	private DefaultTableColumnModel dtcm = new DefaultTableColumnModel();

	private JTable jt = new JTable(dtm, dtcm);

	private JScrollPane jsp = new JScrollPane(jt);

	private TableColumn tc, tc1, tc2, tc3;

	private DefaultTableCellRenderer dtcr;

	private DefaultCellEditor dce;

	public Round23_Ex10_Sub() {
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
		con.add("North", new JLabel("JTable !!!", JLabel.CENTER));
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(new JButton("확인"));
		jp.add(new JButton("취소"));
		con.add("South", jp);

		tc = new TableColumn();// 0, 75
		tc.setHeaderValue("1번");
		tc1 = new TableColumn(1);// 1, 75
		tc1.setHeaderValue("2번");
		tc2 = new TableColumn(2, 125);// 2, 125
		tc2.setHeaderValue("3번");
		dtcr = new DefaultTableCellRenderer();
		dtcr.setBackground(Color.red);
		dtcr.setForeground(Color.blue);
		dce = new DefaultCellEditor(new JCheckBox());
		tc3 = new TableColumn(3, 30, dtcr, dce);// 3, 30
		tc3.setHeaderValue("4번");

		dtcm.addColumn(tc);
		dtcm.addColumn(tc1);
		dtcm.addColumn(tc2);
		dtcm.addColumn(tc3);

		con.add("Center", jsp);
	}

	public void start() {

	}
}

public class Round23_Ex10 {
	public static void main(String[] ar) {
		Round23_Ex10_Sub es = new Round23_Ex10_Sub();
	}
}
