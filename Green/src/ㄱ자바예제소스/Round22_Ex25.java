import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

class Round22_Ex25_Sub extends JFrame implements MouseListener, ActionListener {
	private JRootPane jrp;

	private Container con;

	private BorderLayout bl = new BorderLayout();

	private JButton bt = new JButton("A");

	private JButton bt1 = new JButton("B");

	private JButton bt2 = new JButton("C");

	private JPanel jp = new JPanel(null);

	private ImageIcon ii = new ImageIcon("aaa.gif");

	private JLabel lb = new JLabel(ii);

	private JButton bt3 = new JButton("닫기");

	public Round22_Ex25_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(bl);
		con.add("North", bt);
		con.add("Center", bt1);
		con.add("South", bt2);
		lb.setBounds(0, 0, 200, 100);
		jp.add(lb);
		bt3.setBounds(200, 100, 80, 60);
		jp.add(bt3);
		jp.setOpaque(false);// 투명하게...
		jrp.setGlassPane(jp);
		jp.setVisible(true);
	}

	public void start() {
		bt.addMouseListener(this);
		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
		bt3.addActionListener(this);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == bt || e.getSource() == bt1 || e.getSource() == bt2) {
			if (e.getSource() == bt) {
				lb.setBounds(e.getX(), e.getY(), 50, 50);
			} else if (e.getSource() == bt1) {
				lb.setBounds(e.getX(), e.getY() + bt.getHeight(), 50, 50);
			} else if (e.getSource() == bt2) {
				lb.setBounds(e.getX(), e.getY() + bt.getHeight()
						+ bt1.getHeight(), 50, 50);
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt3) {
			jp.setVisible(false);
		}
	}
}

public class Round22_Ex25 {
	public static void main(String[] ar) {
		Round22_Ex25_Sub es = new Round22_Ex25_Sub();
	}
}
