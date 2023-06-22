import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

class Round22_Ex30_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	private JScrollPane jsp = new JScrollPane();

	private JLabel jl = new JLabel("Column Header !", JLabel.CENTER);

	private JViewport jv = new JViewport();

	private JLabel jl1 = new JLabel(" 1 ", JLabel.CENTER);

	private JViewport jv1 = new JViewport();

	private JLabel jl2 = new JLabel(new ImageIcon("image/kathyCosmo.gif"));

	private JViewport jv2 = new JViewport();

	private JScrollBar jsb = new JScrollBar(JScrollBar.VERTICAL);

	private JScrollBar jsb1 = new JScrollBar(JScrollBar.HORIZONTAL);

	public Round22_Ex30_Sub() {
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
		con.add("North", new JLabel("JViewport !!!", JLabel.CENTER));
		con.add("South", new JButton("»Æ¿Œ"));
		jv.setView(jl);
		jv1.setBackground(Color.red);
		jv1.setView(jl1);
		jv2.setView(jl2);
		jv2.setScrollMode(JViewport.BLIT_SCROLL_MODE);
		jsp.setColumnHeaderView(jv);// North
		jsp.setRowHeaderView(jv1);// West
		jsp.setViewportView(jv2);// Center
		jsp.setVerticalScrollBar(jsb);// East
		jsp.setHorizontalScrollBar(jsb1);// South
		jsp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, new JButton("1"));
		con.add("Center", jsp);
	}

	public void start() {

	}
}

public class Round22_Ex30 {
	public static void main(String[] ar) {
		Round22_Ex30_Sub es = new Round22_Ex30_Sub();
	}
}
