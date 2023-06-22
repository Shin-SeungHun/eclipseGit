package ㄱ자바예제소스;

import java.awt.*;
import java.applet.*;

public class Round21_Ex01 extends Applet {
	public void init() {
		this.setLayout(new BorderLayout());
		this.add("North", new Label("sample!"));
		Label lb = new Label("Hello Applet!", Label.CENTER);
		lb.setFont(new Font("Sans-Serif", Font.BOLD, 20));
		lb.setBackground(Color.blue);
		this.add("Center", lb);
		this.add("South", new Button("Ȯ��"));
	}
}
