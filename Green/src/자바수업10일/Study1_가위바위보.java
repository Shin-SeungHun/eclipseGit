package 자바수업10일;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Study1_가위바위보 {

	public static void main(String[] args) {
		Game game = new Game();
	}
}

class Game extends Frame implements ActionListener, ItemListener {
	// 게임전적용변수
	int winCnt, drawCnt, lossCnt, totCnt;// 승리,무승부,패배,총전적변수
	String my = "가위";
	String com = "";
	Label lbTitle = new Label("가위바위보게임");
	Label lbMy = new Label("내선택:");
	Label lbCom = new Label("컴퓨터:");
	Label lbCom2 = new Label("대기중...");
	Label lbResult = new Label("결과:");
	Label lbResult2 = new Label("대기중........");
	Button btnStart = new Button("게임시작");
	Button btnHistory = new Button("통계");
	Choice ch = new Choice();

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	Game() {
		super("가위바위보게임");
		this.setSize(300, 400);
		this.setLocation(600, 200);
		this.init();
		this.start();
		this.setVisible(true);
	}

	void init() {
		// 레이아웃 디폴트..
		this.setLayout(null);
		// 클래스에 추가
		this.add(lbTitle);
		this.add(lbMy);
		this.add(lbCom);
		this.add(lbCom2);
		this.add(lbResult);
		this.add(lbResult2);
		this.add(btnStart);
		this.add(btnHistory);
		this.add(ch);
		// 폰트적용
		lbTitle.setFont(font25);
		lbMy.setFont(font15);
		lbCom.setFont(font15);
		lbCom2.setFont(font15);
		lbResult.setFont(font15);
		lbResult2.setFont(font15);
		btnStart.setFont(font15);
		btnHistory.setFont(font15);
		ch.setFont(font15);
		ch.add("가위");
		ch.add("바위");
		ch.add("보");
		// 배치..

		lbTitle.setBounds(50, 50, 200, 30);
		lbMy.setBounds(30, 100, 50, 30);
		ch.setBounds(100, 100, 70, 30);
		btnStart.setBounds(180, 100, 100, 50);

		lbCom.setBounds(30, 170, 60, 30);
		lbCom2.setBounds(100, 170, 200, 30);

		lbResult.setBounds(30, 220, 60, 30);
		lbResult2.setBounds(100, 220, 200, 30);

		btnHistory.setBounds(100, 280, 100, 40);

	}

	void start() {
		ch.addItemListener(this);
		btnStart.addActionListener(this);
		btnHistory.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void dlgMsg(String msg) {
		Dialog dlg = new Dialog(this, "승부결과", true);
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

	void dlgHistory() {
		Dialog dlg = new Dialog(this, "통계", true);
		Label lbTitle = new Label("게임 기록");
		Label lbTot = new Label("총전적 :");
		Label lbTot2 = new Label(totCnt + "회");
		Label lbWin = new Label("승리 :");
		Label lbWin2 = new Label(winCnt + "회");
		Label lbDraw = new Label("무승부 :");
		Label lbDraw2 = new Label(drawCnt + "회");
		Label lbLoss = new Label("패배 :");
		Label lbLoss2 = new Label(lossCnt + "회");

		Button bt = new Button("확인");
		dlg.setLayout(null);
		dlg.add(lbTitle);
		lbTitle.setFont(font15);
		dlg.add(lbTot);
		lbTot.setFont(font15);
		dlg.add(lbTot2);
		lbTot2.setFont(font15);
		dlg.add(lbWin);
		lbWin.setFont(font15);
		dlg.add(lbWin2);
		lbWin2.setFont(font15);
		dlg.add(lbDraw);
		lbDraw.setFont(font15);
		dlg.add(lbDraw2);
		lbDraw2.setFont(font15);
		dlg.add(lbLoss);
		lbLoss.setFont(font15);
		dlg.add(lbLoss2);
		lbLoss2.setFont(font15);
		lbTitle.setBounds(110, 50, 200, 30);
		lbTot.setBounds(70, 100, 70, 30);
		lbTot2.setBounds(170, 100, 100, 30);
		lbWin.setBounds(70, 150, 70, 30);
		lbWin2.setBounds(170, 150, 100, 30);
		lbDraw.setBounds(70, 200, 70, 30);
		lbDraw2.setBounds(170, 200, 100, 30);
		lbLoss.setBounds(70, 250, 70, 30);
		lbLoss2.setBounds(170, 250, 100, 30);

		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setLocation(480, 250);
		dlg.setSize(300, 330);
		dlg.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {

			try {
				lbCom2.setText("검퓨터가 생각중입니다.");
				Thread.sleep(1000);
				lbCom2.setText("3...");
				Thread.sleep(1000);
				lbCom2.setText("2..");
				Thread.sleep(1000);
				lbCom2.setText("1.");
				Thread.sleep(1000);

				int comRand = (int) (Math.random() * 3);
				if (comRand == 0) {
					com = "가위";
				} else if (comRand == 1) {
					com = "바위";
				} else if (comRand == 2) {
					com = "보";
				}

				lbResult2.setText("나=" + my + "vs컴퓨터=" + com);

				String msg = "오류발생!다시하세요!";
				if (com.equals("가위")) {
					if (my.equals("가위")) {
						msg = "무승부입니다.";
						drawCnt++;
					} else if (my.equals("바위")) {
						msg = "승리했습니다.";
						winCnt++;
					} else if (my.equals("보")) {
						msg = "패배했습니다.";
						lossCnt++;
					}

				} else if (com.equals("바위")) {
					if (my.equals("가위")) {
						msg = "패배했습니다.";
						lossCnt++;
					} else if (my.equals("바위")) {
						msg = "무승부입니다.";
						drawCnt++;
					} else if (my.equals("보")) {
						msg = "승리했습니다.";
						winCnt++;
					}

				} else if (com.equals("보")) {
					if (my.equals("가위")) {
						msg = "승리했습니다.";
						winCnt++;
					} else if (my.equals("바위")) {
						msg = "패배했습니다.";
						lossCnt++;
					} else if (my.equals("보")) {
						msg = "무승부입니다.";
						drawCnt++;
					}
				}
				dlgMsg(msg);// 결과멘트 다이얼로그처리
				lbCom2.setText("게임 재대결 대기중.");
				totCnt++;// 총전적은 항상증가..
			} catch (InterruptedException e1) {
			}

			// dlgMsg("승리");
		} else if (e.getSource() == btnHistory) {
			dlgHistory();
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		my = e.getItem().toString();
		System.out.println(my);
	}

}
