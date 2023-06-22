import java.awt.*;
import javax.swing.*;

class Round22_Ex16_Sub extends JFrame {
	private Container con;

	private String[] str = { "AAA", "BBB", "CCC", "DDD", "EEE" };

	private JList li = new JList(str);

	// private JScrollPane jsp = new JScrollPane(li);
	public Round22_Ex16_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
		System.out.println(li.getCellBounds(1, 3));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		li.clearSelection();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		String str1[] = { "aaa", "bbb", "ccc", "ddd", "eee" };
		li.setListData(str1);
		// li.updateUI();
		li.setSelectionBackground(Color.red);
		li.setSelectionForeground(Color.yellow);
		li.setSelectedIndex(3);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new FlowLayout());
		// li.setVisibleRowCount(3);
		li.addSelectionInterval(1, 3);
		con.add(li);
	}

	public void start() {

	}
}

public class Round22_Ex16 {
	public static void main(String[] ar) {
		Round22_Ex16_Sub es = new Round22_Ex16_Sub();
	}
}
