import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class Round22_Ex10_Sub extends JFrame implements ActionListener {
	private Container con;

	private FlowLayout fl = new FlowLayout();

	private JLabel lb = new JLabel("ID : ", JLabel.RIGHT);

	private JTextField tf = new JTextField(10);

	private JDialog dlg = new JDialog(this, "확인");

	private Container dlgcon;

	private JLabel dlglb = new JLabel("사용할 수 있는 ID입니다.", JLabel.CENTER);

	private BorderLayout dlgbl = new BorderLayout();

	public Round22_Ex10_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(fl);
		con.add(lb);
		con.add(tf);
		dlgcon = dlg.getContentPane();
		dlgcon.setLayout(dlgbl);
		dlglb.setBorder(new BevelBorder(BevelBorder.RAISED));
		dlgcon.add("Center", dlglb);
		dlg.setSize(200, 150);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = dlg.getSize();
		dlg.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
				(int) (di.getHeight() / 2 - di1.getHeight() / 2));
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tf.addActionListener(this);
		dlg.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf) {
			dlg.setVisible(true);
		}
	}
}

public class Round22_Ex10 {
	public static void main(String[] ar) {
		Round22_Ex10_Sub es = new Round22_Ex10_Sub();
	}
}
