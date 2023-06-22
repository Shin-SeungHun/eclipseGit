import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

class Round23_Ex08_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	// private JTable jt = new JTable();
	// private JTable jt = new JTable(3, 4);
	private String[][] str = { { "1_1", "1_2", "1_3", "1_4" },
			{ "2_1", "2_2", "2_3", "2_4" }, { "3_1", "3_2", "3_3", "3_4" } };

	private String[] str1 = { "1번", "2번", "3번", "4번" };

	private JTable jt = new JTable(str, str1);

	private JScrollPane jsp = new JScrollPane(jt);

	public Round23_Ex08_Sub() {
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
		con.add("Center", jsp);
	}

	public void start() {

	}
}

public class Round23_Ex08 {
	public static void main(String[] ar) {
		Round23_Ex08_Sub es = new Round23_Ex08_Sub();
	}
}
