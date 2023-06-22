package thread;

/*로그인할때 정보로  제어하기
 * 1.사원은 해당파트의 기계만 제어가능
 * 2.직급이 반장, 공장장이면 전 라인 제어가능
 * 3.담당파트는 직급무시하고 관리자일경우 전 라인 제어가능
 * */
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Admin extends Frame implements ActionListener {
	Label lbTitle = new Label("기계 1 관리자 모드");
//	Button btnOn = new Button("전원ON");
//	Button btnOff = new Button("전원OFF");

	Label lbFactory = new Label("생산시간조정(1~3초");
	Label lbPoint = new Label("목표 생산량 입력:");

	TextField tfFactory = new TextField();
	TextField tfPoint = new TextField();

	Button btnRegist = new Button("적용하기");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Admin() {
		super("Admin");
		this.setSize(320, 200);
		this.init();
		this.start();
		this.setLocation(500, 300);
		this.setVisible(true);
	}

	void viewClose() {
		this.setVisible(false);
	}

	public void start() {
//		btnOn.addActionListener(this);
//		btnOff.addActionListener(this);
		btnRegist.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				viewClose();
			}
		});
	}

	public void init() {
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(70, 40, 200, 30);
		lbTitle.setFont(font25);

		this.add(lbFactory);
		lbFactory.setFont(font15);
		lbFactory.setBounds(40, 100, 100, 40);

		this.add(lbPoint);
		lbPoint.setFont(font15);
		lbPoint.setBounds(170, 100, 100, 40);

		this.add(tfFactory);
		tfFactory.setFont(font15);
		tfFactory.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);

		this.add(tfPoint);
		tfPoint.setFont(font15);
		tfPoint.setBounds(MAXIMIZED_BOTH, ABORT, WIDTH, HEIGHT);

//		this.add(btnOn);
//		btnOn.setBounds(40, 100, 100, 40);
//		btnOn.setFont(font15);
//
//		this.add(btnOff);
//		btnOff.setBounds(170, 100, 100, 40);
//		btnOff.setFont(font15);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == btnOn) {
//			
//		}else if(e.getSource() == btnOff) {
//			
//		}
		if (e.getSource() == btnRegist) {

		}
	}
}
