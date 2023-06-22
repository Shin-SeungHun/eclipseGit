import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

class Round23_Ex04_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	// private JTree jt = new JTree();
	private String[] str = { "AAA", "BBB", "CCC" };

	private JTree jt = new JTree(str);

	private JScrollPane jsp = new JScrollPane(jt);

	public Round23_Ex04_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", new JLabel("JTree !!!", JLabel.CENTER));
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(new JButton("확인"));
		jp.add(new JButton("취소"));
		con.add("South", jp);
		// jt.addSelectionInterval(0, 2);
		jt.addSelectionRow(1); // 기본 선택 Node
		jt.expandRow(1); // 하위 내용을 가질 때 확장될 Node
		jt.setDragEnabled(true); // Drag 활성 여부
		jt.setEditable(true); // Node 수정 여부
		jt.setToggleClickCount(2); // Toggle 지정 시 클릭 수
		con.add("Center", jsp);
	}

	public void start() {

	}
}

public class Round23_Ex04 {
	public static void main(String[] ar) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		} catch (Exception ee) {
		}
		Round23_Ex04_Sub es = new Round23_Ex04_Sub();
	}
}
