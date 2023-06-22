package 자바수업08일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1_윈도우친구목록리스트 {

	public static void main(String[] args) {
		new FriendList();
	}
}

class FriendList extends Frame implements ActionListener {
	Label lbTitle = new Label("친구목록리스트만들기", Label.CENTER);
	Label lbList = new Label("친구리스트");

	Label lbName = new Label("이름:");
	Label lbHp = new Label("연락처:");

	TextField tfName = new TextField();
	TextField tfHp = new TextField();

	Button btnAdd = new Button("추가하기");

	TextArea ta = new TextArea();
	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	int cnt = 0; // 친구수
	String result = ""; // 문자열초기화

	FriendList() {
		super("친구목록리스트");
		this.setSize(300, 400);
		this.init(); // 레이아웃
		this.start(); // 이벤트
		this.setLocation(600, 200);
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(null);
		this.add(lbTitle);
		lbTitle.setBounds(65, 40, 170, 30);
		lbTitle.setFont(font15);

		this.add(lbList);
		lbList.setBounds(45, 170, 100, 30);
		lbList.setFont(font15);

		this.add(lbName);
		lbName.setBounds(20, 100, 60, 30);
		lbName.setFont(font15);

		this.add(lbHp);
		lbHp.setBounds(20, 135, 60, 30);
		lbHp.setFont(font15);

		this.add(tfName);
		tfName.setBounds(80, 100, 100, 30);
		tfName.setFont(font15);

		this.add(tfHp);
		tfHp.setBounds(80, 135, 100, 30);
		tfHp.setFont(font15);

		this.add(btnAdd);
		btnAdd.setBounds(190, 100, 80, 30);
		btnAdd.setFont(font15);

		this.add(ta);
		ta.setBounds(45, 200, 220, 150);
		ta.setFont(font15);

	}

	public void start() {

		btnAdd.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 초반에 입력하지 않은 상태에서 처리 막기 공백체크
		if (tfName.getText().equals("")) {
			return;
		}
		if (tfHp.getText().equals("")) {
			return;
		}

		String name = tfName.getText();
		String Hp = tfHp.getText();

		cnt++; // 친구 추가시 카운트

		result += cnt + " / " + name + " / " + Hp + "\n";
		// 텍스트에리어에 줄바꿈포함 한번에 찍기위함

		if (e.getSource() == btnAdd) {
			ta.setText(result);

			// 한명추가후 보기좋게 공백처리
			tfName.setText("");
			tfHp.setText("");
		}
	}

}