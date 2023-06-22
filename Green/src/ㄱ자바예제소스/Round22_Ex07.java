import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class Round22_Ex07_Sub extends JFrame {
	private Container con;

	private FlowLayout fl = new FlowLayout();

	private JButton bt = new JButton("TestTestTestTest");

	// private BevelBorder bb = new BevelBorder(BevelBorder.RAISED, Color.green,
	// Color.red, Color.blue, Color.darkGray);

	// private EmptyBorder bb = new EmptyBorder(3, 5, 7, 9);

	// private EtchedBorder bb = new EtchedBorder(EtchedBorder.LOWERED,
	// Color.green, Color.red);

	// private LineBorder bb = new LineBorder(Color.red, 5, true);

	// private ImageIcon im = new ImageIcon("bg.jpg");
	// private MatteBorder bb = new MatteBorder(5, 10, 15, 20, im);

	// private LineBorder lb = new LineBorder(Color.red, 3);
	// private TitledBorder bb = new TitledBorder(lb, "Title",
	// TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM);

	private LineBorder lb = new LineBorder(Color.red, 3);

	private SoftBevelBorder sbb = new SoftBevelBorder(SoftBevelBorder.RAISED);

	private CompoundBorder bb = new CompoundBorder(lb, sbb);

	public Round22_Ex07_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(400, 300);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(fl);
		// bt.setBackground(Color.yellow);
		bt.setBorder(bb); // ? Border를 표현하는 부분
		con.add(bt);
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Round22_Ex07 {
	public static void main(String[] ar) {
		Round22_Ex07_Sub es = new Round22_Ex07_Sub();
	}
}
