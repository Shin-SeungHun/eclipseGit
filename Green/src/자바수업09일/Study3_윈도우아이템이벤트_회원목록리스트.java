package 자바수업09일;


import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*회원목록 리스트를 만들고 안에 리스트로 값을 고정으로 넣어서 아이템리스너 이벤트를 적용하시오
 * 클릭하면 해당항목의 데이터가 콘솔에 출력되도록
 * */
public class Study3_윈도우아이템이벤트_회원목록리스트 {

	public static void main(String[] args) {
		List list = new List();
	}
}

class List extends Frame implements ItemListener {
	Label lbTitle = new Label("회원목록리스트", Label.CENTER);
	List mList = new List();
	Button btnOk = new Button("확인");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	List() {
		super("회원목록리스트");
		this.setSize(300, 400);
		this.init(); // 레이아웃
		this.start(); // 이벤트
		this.setLocation(600, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(null);
		this.add(lbTitle);
		start();
		lbTitle.setBounds(65, 40, 170, 30);
		lbTitle.setFont(font25);

		this.add(mList);
		mList.setFont(font15);
		mList.setBounds(30, 100, 240, 220);
		mList.add("1 / hong / 홍길동 / 1111111");
		mList.add("2 / cms / 아무개 / 2222222");
		mList.add("3 / abc / 둘리 / 3333333");

		this.add(btnOk);
		btnOk.setFont(font15);
		btnOk.setBounds(110, 340, 80, 30);

	}

	public void start() {
		mList.addItemListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("select list item index = " + mList.getSelectedIndex());
		System.out.println("select lits item value = " + mList.getSelectedItem());

	}
}
