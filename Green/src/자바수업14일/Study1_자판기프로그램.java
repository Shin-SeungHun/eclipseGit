package 자바수업14일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1_자판기프로그램 {
	/*
	 * 다이얼로그 적용 - 결제시, 결제취소시 각 제어시 띄우기
	 * 
	 * 제어조건 1.잔액이 없을때 주문불가 2.잔액보다 큰 현재주문상품 선택시 진행x 3.돈이 없을때 결제취소 불가 4.상품 선택시 대기중칸에
	 * 해당 이미지가 떠야함 5.선택취소시 해당이미지가 다시 돌아와야함
	 */
	public static void main(String[] args) {
		new VM();

	}

}

class VM extends Frame implements ActionListener {
	int input1 = 1000, input2 = 5000, input3 = 10000; // 투입금액
	int goods1 = 1070, goods2 = 1500, goods3 = 1200; // 상품가격
	
	int payMoney = 0; // 결제금액
	int changes = 0; //현재 잔액
	
	// 상품 선택 여부 체크변수...
	boolean goods1Sel = false;
	boolean goods2Sel = false;
	boolean goods3Sel = false;
	
	//이미지
	Image imgSel1, imgSel2, imgSel3, imgCan1, imgCan2, imgCan3;

	Label lbTitle = new Label("자판기프로그램", Label.CENTER);
	Label lbGoods1 = new Label("포카리");
	Label lbGoods2 = new Label("사이다");
	Label lbGoods3 = new Label("게토레이");

	Button btnGoods1 = new Button(goods1 + "원");
	Button btnGoods2 = new Button(goods2 + "원");
	Button btnGoods3 = new Button(goods3 + "원");

	Label lbPayMoney1 = new Label("현재주문상품");
	Label lbPayMoney2 = new Label("결제금액");
	Label lbPayMoney3 = new Label(payMoney + "원");

	Button btnCancel1 = new Button("선택취소");
	Button btnCancel2 = new Button("선택취소");
	Button btnCancel3 = new Button("선택취소");

	Label lbInputMoney = new Label("투입금액");
	Button btnMoney1 = new Button(input1 + "원");
	Button btnMoney2 = new Button(input2 + "원");
	Button btnMoney3 = new Button(input3 + "원");

	Button btnPay = new Button("결제하기");
	Button btnPayCancel = new Button("결제취소(반환)");

	Label lbMoney1 = new Label("현재 잔액: ");
	Label lbMoney2 = new Label(changes + "원");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	VM() {
		super("자판기 프로그램"); // 제목
		this.setSize(450, 700);
		this.setLocation(600, 200);
		this.init();
		this.start();
		this.setVisible(true); // 마지막에 화면 띄움

	}

	void init() {
		this.setLayout(null);

		// 클래스에 추가
		this.add(lbTitle);
		this.add(lbGoods1);
		this.add(lbGoods2);
		this.add(lbGoods3);

		this.add(btnGoods1);
		this.add(btnGoods2);
		this.add(btnGoods3);

		this.add(lbPayMoney1);
		this.add(lbPayMoney2);
		this.add(lbPayMoney3);

		this.add(btnCancel1);
		this.add(btnCancel2);
		this.add(btnCancel3);

		this.add(lbInputMoney);

		this.add(btnMoney1);
		this.add(btnMoney2);
		this.add(btnMoney3);
		this.add(btnPay);
		this.add(btnPayCancel);

		this.add(lbMoney1);
		this.add(lbMoney2);

		// 배치
		lbTitle.setBounds(140, 40, 180, 30);
		lbGoods1.setBounds(55, 250, 80, 30);
		lbGoods2.setBounds(205, 250, 50, 30);
		lbGoods3.setBounds(335, 250, 90, 30);

		btnGoods1.setBounds(45, 280, 70, 30);
		btnGoods2.setBounds(195, 280, 70, 30);
		btnGoods3.setBounds(335, 280, 70, 30);

		lbPayMoney1.setBounds(20, 360, 120, 30);
		lbPayMoney2.setBounds(20, 390, 100, 30);
		lbPayMoney3.setBounds(60, 415, 100, 30);

		btnCancel1.setBounds(150, 450, 80, 25);
		btnCancel2.setBounds(240, 450, 80, 25);
		btnCancel3.setBounds(330, 450, 80, 25);

		lbInputMoney.setBounds(20, 500, 100, 30);
		btnMoney1.setBounds(25, 530, 80, 30);
		btnMoney2.setBounds(115, 530, 80, 30);
		btnMoney3.setBounds(205, 530, 80, 30);
		btnPay.setBounds(320, 510, 80, 30);
		btnPayCancel.setBounds(320, 550, 115, 30);

		lbMoney1.setBounds(20, 600, 100, 30);
		lbMoney2.setBounds(250, 600, 100, 30);

		// 폰트적용
		lbTitle.setFont(font25);
		lbGoods1.setFont(font15);
		lbGoods2.setFont(font15);
		lbGoods3.setFont(font15);

		btnGoods1.setFont(font15);
		btnGoods2.setFont(font15);
		btnGoods3.setFont(font15);

		lbPayMoney1.setFont(font15);
		lbPayMoney2.setFont(font15);
		lbPayMoney3.setFont(font15);

		btnCancel1.setFont(font15);
		btnCancel2.setFont(font15);
		btnCancel3.setFont(font15);

		lbInputMoney.setFont(font15);

		btnMoney1.setFont(font15);
		btnMoney2.setFont(font15);
		btnMoney3.setFont(font15);

		btnPay.setFont(font15);
		btnPayCancel.setFont(font15);

		lbMoney1.setFont(font15);
		lbMoney2.setFont(font15);

		imgSel1 = Toolkit.getDefaultToolkit().getImage("img/포카리.jpg");
		imgSel2 = Toolkit.getDefaultToolkit().getImage("img/사이다.jpg");
		imgSel3 = Toolkit.getDefaultToolkit().getImage("img/게토레이.jpg");

		imgCan1 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
		imgCan2 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
		imgCan3 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");

	}

	public void paint(Graphics g) {
		g.drawImage(imgSel1, 10, 100, 150, 150, this);
		g.drawImage(imgSel2, 140, 100, 180, 150, this);
		g.drawImage(imgSel3, 290, 100, 160, 150, this);
		g.drawImage(imgCan1, 140, 350, 100, 100, this);
		g.drawImage(imgCan2, 230, 350, 100, 100, this);
		g.drawImage(imgCan3, 320, 350, 100, 100, this);

	}

	void start() {
		this.btnGoods1.addActionListener(this);
		this.btnGoods2.addActionListener(this);
		this.btnGoods3.addActionListener(this);

		this.btnCancel1.addActionListener(this);
		this.btnCancel2.addActionListener(this);
		this.btnCancel3.addActionListener(this);

		this.btnMoney1.addActionListener(this);
		this.btnMoney2.addActionListener(this);
		this.btnMoney3.addActionListener(this);

		this.btnPay.addActionListener(this);

		this.btnPayCancel.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGoods1) {

			if(changes == 0) {
				dlgMsg("잔액이 없습니다.");
				return;
			}
			if(goods1Sel == false) {
				// 선택상품 결제 금액에 누적
				payMoney += 1070;
				// 선택 상품 결제금액 표시
				lbPayMoney3.setText(payMoney +"원");
				// 선택상품 이미지 변경
				imgCan1 = imgSel1;
				this.repaint();
				
				//상품선택 유지변수
				goods1Sel = true;
			}


		} else if (e.getSource() == btnGoods2) {
			if (changes == 0) {
				dlgMsg("잔액이 없습니다.선택X");
				return;
			}
			
			if(goods2Sel == false) {
				// 선택상품 결제 금액에 누적
				payMoney += 1500;
				// 선택 상품 결제금액 표시
				lbPayMoney3.setText(payMoney+"원");
				// 선택상품 이미지 변경
				imgCan2 = imgSel2;
				this.repaint();
				
				//상품선택 유지변수
				goods2Sel = true;
			}
			
		} else if (e.getSource() == btnGoods3) {

			if (changes == 0) {
				dlgMsg("잔액이 없습니다.선택X");
				return;
			}
			
			if(goods3Sel == false) {
				// 선택상품 결제 금액에 누적
				payMoney += 1200;
				// 선택 상품 결제금액 표시
				lbPayMoney3.setText(payMoney+"원");
				//선택상품 이미지 변경
				imgCan3 = imgSel3;
				this.repaint();
				
				//상품선택 유지변수
				goods3Sel = true;
			}
		} else if (e.getSource() == btnCancel1) {
			//선택상품 이미지 변경
			imgCan1 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
			this.repaint();
			
			//상품선택 유지변수
			goods1Sel = false;
			payMoney -= 1070; // 금액다시차감
			lbPayMoney3.setText(payMoney+"원");
			
		} else if (e.getSource() == btnCancel2) {
			//선택상품 이미지 변경
			imgCan2 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
			this.repaint();
			
			//상품선택 유지변수
			goods2Sel = false;
			payMoney -= 1500; //금액 다시차감
			lbPayMoney3.setText(payMoney+"원");
			
		} else if (e.getSource() == btnCancel3) {
			//선택상품 이미지 변경
			imgCan3 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg");
			this.repaint();
			
			//상품선택 유지변수
			goods3Sel = false;
			payMoney -= 1200; //금액 다시차감
			lbPayMoney3.setText(payMoney+"원");
			
		} else if (e.getSource() == btnMoney1) {
			changes+=1000;
			lbMoney2.setText(changes+"원");
		} else if (e.getSource() == btnMoney2) {
			changes+=5000;
			lbMoney2.setText(changes+"원");
			
		} else if (e.getSource() == btnMoney3) {
			changes+=10000;
			lbMoney2.setText(changes+"원");
			
		} else if (e.getSource() == btnPay) {
			if(changes<=0 || payMoney>changes) {
				dlgMsg("잔액이 "+(payMoney-changes)+"원 부족합니다.");
				return;
			}
			
			changes -= payMoney; // 결제
			
			lbPayMoney3.setText(payMoney+"원");
			lbMoney2.setText(changes+"원");
			
			imgCan1 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg"); 
			imgCan2 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg"); 
			imgCan3 = Toolkit.getDefaultToolkit().getImage("img/모래시계.jpg"); 
			
			//상품선택 유지변수
			goods1Sel = false;
			goods2Sel = false;
			goods3Sel = false;
			
		} else if (e.getSource() == btnPayCancel) {
			if(changes == 0) {
				dlgMsg("반환할 금액이 없습니다.");
				return;
			}
			
			//잔액 반환 알림
			dlgMsg(changes+"원이 반환되었습니다.");
			
			//선택상품초기화
			payMoney =0;
			lbPayMoney3.setText(payMoney+"원");
			
			changes =0;
			lbMoney2.setText(changes+"원");
			
			//상품선택유지변수
			goods1Sel = false;
			goods2Sel = false;
			goods3Sel = false;
		}

	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "자판기 알림", true);
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
		dlg.setSize(300, 200);
		dlg.setVisible(true);
	}
}