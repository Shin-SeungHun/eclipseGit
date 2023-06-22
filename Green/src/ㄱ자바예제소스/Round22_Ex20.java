import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Round22_Ex20_Sub extends JFrame implements MouseListener {
	private Container con;

	private JLabel lb = new JLabel("¸Þ¸ðÀå", JLabel.CENTER);

	private JButton bt = new JButton("È®ÀÎ");

	private JTextArea ta = new JTextArea();

	private JScrollPane jsp = new JScrollPane(ta);

	public Round22_Ex20_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", lb);
		con.add("South", bt);
		ta.setDragEnabled(true);
		ta.setFocusAccelerator('r');
		ta.setSelectedTextColor(Color.red);
		ta.setSelectionColor(Color.yellow);
		con.add("Center", jsp);
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ta.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == ta) {
			if (e.getClickCount() == 2) {
				// ta.paste();
				// System.out.println(ta.getCaretPosition());
				// ta.moveCaretPosition(0);
				ta.setEditable(false);
			}
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == ta) {
			if (e.isPopupTrigger()) {
				// ta.copy();
				// ta.setCaretPosition(ta.getText().length());
				// ta.setEditable(true);
				// ta.setSelectionStart(3);
				// ta.setSelectionEnd(7);
				ta.setText("±è½ÂÇö");
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}

public class Round22_Ex20 {
	public static void main(String[] ar) {
		Round22_Ex20_Sub es = new Round22_Ex20_Sub();
	}
}
