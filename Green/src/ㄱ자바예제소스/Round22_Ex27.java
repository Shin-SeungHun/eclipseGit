import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;

class Round22_Ex27_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	private JSpinner js = new JSpinner();

	private SpinnerDateModel sdm = new SpinnerDateModel();

	private JTextField tf = new JTextField();

	private JSpinner js1 = new JSpinner();

	private SpinnerNumberModel snm = new SpinnerNumberModel(50, 0, 100, 2);

	public Round22_Ex27_Sub() {
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
		sdm.setCalendarField(Calendar.MONTH);
		js.setModel(sdm);
		tf = ((JSpinner.DateEditor) js.getEditor()).getTextField();
		tf.setEnabled(false);
		con.add("North", js);
		js1.setModel(snm);
		con.add("South", js1);
	}

	public void start() {

	}
}

public class Round22_Ex27 {
	public static void main(String[] ar) {
		Round22_Ex27_Sub es = new Round22_Ex27_Sub();
	}
}
