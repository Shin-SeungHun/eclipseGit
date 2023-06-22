import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Round22_Ex21_Sub extends JFrame implements ActionListener {
	private Container con;

	private JTextArea ta = new JTextArea("abcdefghijklmnopqrstuvwxyz");

	private JScrollPane jsp = new JScrollPane(ta);

	private JLabel lb = new JLabel("ID : ", JLabel.RIGHT);

	private JTextField tf = new JTextField();

	private JLabel lb1 = new JLabel("Pass : ", JLabel.RIGHT);

	private JPasswordField jpf = new JPasswordField();

	public Round22_Ex21_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		ta.replaceRange("ABCD", 0, 4);
	}

	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel jp = new JPanel(new BorderLayout());
		jp.add("West", lb);
		tf.setHorizontalAlignment(JTextField.CENTER);
		jp.add("Center", tf);
		JPanel jp1 = new JPanel(new BorderLayout());
		jp1.add("West", lb1);
		jpf.setEchoChar('%');
		jp1.add("Center", jpf);
		con.add("South", jp1);
		con.add("North", jp);
		con.add("Center", jsp);
	}

	public void start() {
		jpf.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jpf) {
			String str = new String(jpf.getPassword());
			System.out.println("얻어온 비밀번호 = " + str);
		}
	}
}

public class Round22_Ex21 {
	public static void main(String[] ar) {
		Round22_Ex21_Sub es = new Round22_Ex21_Sub();
	}
}
