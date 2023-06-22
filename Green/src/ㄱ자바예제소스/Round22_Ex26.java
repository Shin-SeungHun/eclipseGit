import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.text.*;

class Round22_Ex26_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	private JSpinner js = new JSpinner();

	// private String[] str = {"AAA", "BBB", "CCC"};
	private DateFormatSymbols dfs = new DateFormatSymbols();

	private String[] str = dfs.getMonths();

	private SpinnerListModel slm = new SpinnerListModel(str);

	public Round22_Ex26_Sub() {
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
		js.setModel(slm);
		con.add("North", js);
	}

	public void start() {

	}
}

public class Round22_Ex26 {
	public static void main(String[] ar) {
		Round22_Ex26_Sub es = new Round22_Ex26_Sub();
	}
}
