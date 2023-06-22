import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.io.*;

class Round22_Ex29_Sub extends JFrame {
	private JRootPane jrp;

	private Container con;

	private JEditorPane jep;

	private JScrollPane jsp;

	private JToolTip jtt = new JToolTip();

	public Round22_Ex29_Sub() {
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public void init() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout(5, 5));
		con.add("North", new JLabel("Editor Pane!!!", JLabel.CENTER));
		con.add("South", new JButton("확인"));
		// try{
		// jep = new JEditorPane("http://www.empas.com");
		jep = new JEditorPane("text/html",
				"<html><body><h1>Hello</h1><p><h2>hello<h2><a href=\"\">소스보기</a></body></html>");
		// }catch(IOException ee){}
		jep.setToolTipText("Test");
		jtt.setTipText(jep.getToolTipText());
		jsp = new JScrollPane(jep);
		con.add("Center", jsp);
	}

	public void start() {

	}
}

public class Round22_Ex29 {
	public static void main(String[] ar) {
		Round22_Ex29_Sub es = new Round22_Ex29_Sub();
	}
}
