package 자바수업09일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study6_윈도우_회원정보_삭제 {
	public static void main(String[] args) {
		Delelte wt = new Delelte();
	}
}

class Delelte extends Frame implements ItemListener, ActionListener {
	Label lbTitle = new Label("    회원 정보 삭제    ");
	Label lbId = new Label("아 이 디:");
	
	Label lbName = new Label("이   름:");
	Label lbNameD = new Label("대기중..");
	Label lbHp = new Label("연 락 처:");
	Label lbHpD = new Label("대기중..");
	Label lbSex = new Label("성   별:");
	Label lbSexD = new Label("대기중..");
	
	TextField tfId = new TextField();

	TextField tfName = new TextField();
	TextField tfHp = new TextField();
	
	Button btnIdCheck = new Button("찾기");
	Button btnModify = new Button("삭제완료");
	Button btnCancle = new Button("취소");

	
	private Choice chSex = new Choice();

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Delelte() {
		super("회원정보삭제");
		this.setSize(300, 400);
		this.init();// 화면레이아웃구성메서드
		start();
		this.setLocation(500, 200);
		this.setVisible(true);

	}

	void start() {
		btnIdCheck.addActionListener(this);
		
		chSex.addItemListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void init() // 레이아웃 구성하기...
	{
		this.setLayout(null);// 레이아웃을 직접좌표처리하는방식으로하기위해서...
		this.add(lbTitle);
		lbTitle.setFont(font15);
		lbTitle.setBounds(80, 30, 200, 30);

		this.add(lbId);
		lbId.setFont(font15);
		lbId.setBounds(30, 70, 80, 30);
		this.add(tfId);
		tfId.setFont(font15);
		tfId.setBounds(110, 70, 80, 30);
		this.add(btnIdCheck);
		btnIdCheck.setFont(font15);
		btnIdCheck.setBounds(220, 67, 50, 30);

		this.add(lbName);
		lbName.setFont(font15);
		lbName.setBounds(30, 130, 80, 30);
		this.add(lbNameD);
		lbNameD.setFont(font15);
		lbNameD.setBounds(110, 130, 120, 30);

		this.add(lbHp);
		lbHp.setFont(font15);
		lbHp.setBounds(30, 160, 80, 30);
		this.add(lbHpD);
		lbHpD.setFont(font15);
		lbHpD.setBounds(110, 160, 120, 30);

		this.add(lbSex);
		lbSex.setFont(font15);
		lbSex.setBounds(30, 190, 80, 30);
		this.add(lbSexD);
		lbSexD.setFont(font15);
		lbSexD.setBounds(110, 190, 120, 30);
	

		this.add(btnModify);
		btnModify.setFont(font15);
		btnModify.setBounds(110, 250, 80, 30);
		
		this.add(btnCancle);
		btnCancle.setFont(font15);
		btnCancle.setBounds(110, 280, 80, 30);

		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialog("대상이 없습니다.");

			
			

		}
	
	public void dialog(String msg) {
		Dialog dlg = new Dialog(this, "삭제", true);
		Label lbContent = new Label(msg);
		Button bt = new Button("확인");
		dlg.setLayout(null);

		dlg.add(lbContent);
		lbContent.setFont(font15);
		dlg.add(bt);
		bt.setFont(font15);
		lbContent.setBounds(50, 50, 200, 30);
		bt.setBounds(80, 120, 120, 30);

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		
		dlg.setLocation(480, 250);
		dlg.setSize(300, 100);
		dlg.setVisible(true);

//		chSex.addItemListener(this);
	}
	}

