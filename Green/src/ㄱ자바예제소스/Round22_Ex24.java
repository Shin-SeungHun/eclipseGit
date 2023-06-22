import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

class Round22_Ex24_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	private BorderLayout bl = new BorderLayout();

	private JLayeredPane jlp = new JLayeredPane();

	private JPanel jp = new JPanel(new FlowLayout());

	private JPanel jp1 = new JPanel(new FlowLayout());

	private JPanel jp2 = new JPanel(new FlowLayout());

	private ImageIcon ii = new ImageIcon("aaa.gif");

	private JLabel lb = new JLabel(ii);

	private JButton bt = new JButton("1");

	private JButton bt1 = new JButton("2");

	private JButton bt2 = new JButton("3");

	public Round22_Ex24_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public void init() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(bl);
		jp.add(bt);
		jp1.add(bt1);
		jp2.add(bt2);
		jp.setBackground(Color.red);
		jp1.setBackground(Color.green);
		jp2.setBackground(Color.blue);
		jp.setBounds(50, 50, 100, 100);
		jp1.setBounds(75, 75, 100, 100);
		jp2.setBounds(100, 100, 100, 100);
		lb.setBounds(60, 60, 50, 50);
		jlp.add(jp, new Integer(0));
		jlp.add(jp1, new Integer(1));
		jlp.add(jp2, new Integer(2));
		jlp.add(lb, new Integer(0));
		jlp.moveToFront(lb);
		con.add("Center", jlp);
	}

	public void start() {

	}
}

public class Round22_Ex24 {
	public static void main(String[] ar) {
		Round22_Ex24_Sub es = new Round22_Ex24_Sub();
	}
}
