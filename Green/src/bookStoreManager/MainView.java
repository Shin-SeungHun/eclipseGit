package bookStoreManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainView extends Frame implements ActionListener {
	Image imgBook1, imgBook2, imgBook3, imgBook4, imgBook5, imgBook6, imgBook7, imgBook8, imgBook9, imgBook10,
			imgBook11, imgBook12, imgBook13, imgBook14, imgBook15, imgBook16, imgBook17, imgBook18, imgBook19,
			imgBook20;

	Scrollbar bar1, bar2, bar3, bar4, bar5;

	Label lbTitle = new Label("");

	Button btnImage1 = new Button();
	Button btnImage2 = new Button();
	Button btnImage3 = new Button();
	Button btnImage4 = new Button();
	Button btnImage5 = new Button();
	Button btnImage6 = new Button();
	Button btnImage7 = new Button();
	Button btnImage8 = new Button();
	Button btnImage9 = new Button();
	Button btnImage10 = new Button();
	Button btnImage11 = new Button();
	Button btnImage12 = new Button();
	Button btnImage13 = new Button();
	Button btnImage14 = new Button();
	Button btnImage15 = new Button();
	Button btnImage16 = new Button();
	Button btnImage17 = new Button();
	Button btnImage18 = new Button();
	Button btnImage19 = new Button();
	Button btnImage20 = new Button();

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	public MainView() {
		super("메인화면");
		this.setSize(300, 400);
		this.init();
		this.start();
		this.setLocation(500, 300);
		this.setVisible(true);

	}

	void init() {
		this.setLayout(null);
		this.add(lbTitle);
		this.add(btnImage1);
		this.add(btnImage2);
		this.add(btnImage3);
		this.add(btnImage4);
		this.add(btnImage5);

		lbTitle.setFont(font25);
		btnImage1.setFont(font15);
		btnImage2.setFont(font15);
		btnImage3.setFont(font15);
		btnImage4.setFont(font15);
		btnImage5.setFont(font15);

		lbTitle.setBounds(20, 20, 200, 30);
//		btnImage1.setBounds(50, 30, 100, 100);

//		Frame f = new Frame("Scrollbar");
//
//		f.setSize(300, 200);
//
//		f.setLayout(null);

		Scrollbar hor = new Scrollbar(Scrollbar.HORIZONTAL, 0, 50, 30, 100);

		hor.setSize(100, 15);

		hor.setLocation(80, 100);

		Scrollbar ver = new Scrollbar(Scrollbar.VERTICAL, 50, 20, 30, 100);

		ver.setSize(15, 100);

		ver.setLocation(50, 50);

		this.add(hor);

		this.add(ver);

		this.setVisible(true);

		imgBook1 = Toolkit.getDefaultToolkit().getImage("");
	}

	public void paint(Graphics g) {
		g.drawImage(imgBook1, 10, 100, 150, 150, this);
		g.drawImage(imgBook2, 140, 100, 180, 150, this);
		g.drawImage(imgBook3, 290, 100, 160, 150, this);
		g.drawImage(imgBook4, 140, 350, 100, 100, this);
		g.drawImage(imgBook5, 230, 350, 100, 100, this);
		g.drawImage(imgBook6, 320, 350, 100, 100, this);
		g.drawImage(imgBook7, 320, 350, 100, 100, this);
		g.drawImage(imgBook8, 320, 350, 100, 100, this);
		g.drawImage(imgBook9, 320, 350, 100, 100, this);
		g.drawImage(imgBook10, 320, 350, 100, 100, this);
		g.drawImage(imgBook11, 320, 350, 100, 100, this);
		g.drawImage(imgBook12, 320, 350, 100, 100, this);
		g.drawImage(imgBook13, 320, 350, 100, 100, this);
		g.drawImage(imgBook14, 320, 350, 100, 100, this);
		g.drawImage(imgBook15, 320, 350, 100, 100, this);
		g.drawImage(imgBook16, 320, 350, 100, 100, this);
		g.drawImage(imgBook17, 320, 350, 100, 100, this);
		g.drawImage(imgBook18, 320, 350, 100, 100, this);
		g.drawImage(imgBook19, 320, 350, 100, 100, this);
		g.drawImage(imgBook20, 320, 350, 100, 100, this);

	}

	void start() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

	}

	class ScrollbarT {
		private Frame f;
		Scrollbar bar1, bar2, bar3, bar4, bar5;

	}
}
