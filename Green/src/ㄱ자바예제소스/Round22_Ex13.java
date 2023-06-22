import java.awt.*;
import java.util.*;
import javax.swing.*;

class Round22_Ex13_Sub extends JFrame {
	private Container con;

	private String[] str = { "AAA", "BBB", "CCC", "DDD", "EEE" };

	private JComboBox jcb = new JComboBox(str);

	public Round22_Ex13_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
		System.out.println("얻어온 객체 = " + (String) jcb.getItemAt(3));
		System.out.println("포함된 객체 개수 = " + jcb.getItemCount());
		System.out.println("현재 선택된 객체 = " + (String) jcb.getSelectedItem());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		jcb.setSelectedIndex(2);
		jcb.setSelectedItem("BBB");
		jcb.showPopup();
		con.repaint();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		jcb.hidePopup();
		con.repaint();
	}

	public void init() {
		Vector vc = new Vector();
		vc.add("AAA");
		vc.add("BBB");
		jcb = new JComboBox(vc);
		con = this.getContentPane();
		con.setLayout(new FlowLayout());
		jcb.addItem("FFF");
		jcb.setEditable(true);
		jcb.setMaximumRowCount(3);
		con.add(jcb);
	}

	public void start() {

	}
}

public class Round22_Ex13 {
	public static void main(String[] ar) {
		Round22_Ex13_Sub es = new Round22_Ex13_Sub();
	}
}
