import java.awt.*;
import javax.swing.*;

class Round22_Ex17_Sub extends JFrame {
	private Container con;

	private JOptionPane jop = new JOptionPane();

	public Round22_Ex17_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
		// System.out.println(JOptionPane.showConfirmDialog(this,
		// "저장하시겠습니까?", "저장", JOptionPane.OK_CANCEL_OPTION,
		// JOptionPane.QUESTION_MESSAGE, new
		// ImageIcon("bb.gif")));
		// String[] str = {"AAA", "BBB", "CCC"};
		// System.out.println(jop.showInputDialog(this, "아이디 ? ", "ID",
		// JOptionPane.INFORMATION_MESSAGE, new ImageIcon("bbb.gif"), str,
		// "BBB"));
		// System.out.println(jop.showInternalConfirmDialog(con,
		// "저장하시겠습니까?"));
		// System.out.println(jop.showInternalInputDialog(con, "이름 = "));
		// jop.showMessageDialog(this, "오류가 발생했습니다", "오류",
		// JOptionPane.ERROR_MESSAGE);
		String[] str = { "a", "b", "c", "d", "e", "f" };
		System.out.println(jop.showOptionDialog(this, "선택하세요 ? ", "물건선택",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				new ImageIcon("bb.gif"), str, "a"));
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
	}

	public void start() {

	}
}

public class Round22_Ex17 {
	public static void main(String[] ar) {
		Round22_Ex17_Sub es = new Round22_Ex17_Sub();
	}
}
