package 윈도우프로그램;

import java.awt.*;

public class MyAWTFrame {
	private Frame fr;

	public MyAWTFrame(String str) {
		initialize(str);

	}

	public static void main(String[] args) {
		MyAWTFrame myfr = new MyAWTFrame("MyAWTFrameTitle");
		myfr.fr.setVisible(true);

	}

	private void initialize(String str) {
		fr = new Frame(str);
		Button bt1 = new Button("North");
		bt1.setLocation(30,30);
		bt1.setSize(50, 50);
		Button bt2 = new Button("South");
		bt2.setBounds(80, 80, 70, 70);
		Button bt3 = new Button("East");
		bt3.setBounds(55, 55, 50, 50);
		Button bt4 = new Button("West");
		bt4.setBounds(100, 100, 80, 120);
		Button bt5 = new Button("Center");
		bt5.setBounds(200, 200, 100, 80);

		fr.setLayout(null);
		// hgap 세로갭 west cneter east 간격조절 vgap 가로갭 수평 간격 조절
		fr.add(bt1);
		fr.add(bt2);
		fr.add(bt3);
		fr.add(bt4);
		fr.add(bt5);
//		bt1.setSize(100, 200);

		fr.setSize(300, 300);
	}

}