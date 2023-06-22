import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

class Round22_Ex28_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	private JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
			new JButton("좌측버튼"), new JButton("우측버튼"));

	public Round22_Ex28_Sub() {
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
		jsp.setRightComponent(new JButton("우측1버튼"));
		jsp.setContinuousLayout(false);
		// jsp.setDividerLocation(50);
		// jsp.setDividerSize(5);
		jsp.setOneTouchExpandable(true);
		jsp.setResizeWeight(0.3);
		con.add("Center", jsp);
		con.add("North", new JLabel("Test"));
		con.add("South", new JButton("Yes"));
	}

	public void start() {

	}
}

public class Round22_Ex28 {
	public static void main(String[] ar) {
		Round22_Ex28_Sub es = new Round22_Ex28_Sub();
	}
}
