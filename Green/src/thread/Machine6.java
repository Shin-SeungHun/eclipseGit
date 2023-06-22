package thread;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Machine6 extends Frame implements ActionListener, Runnable {
	Label lbTitle = new Label("기계 6 조작반");
	Button btnOn = new Button("전원ON");
	Button btnOff = new Button("전원OFF");

	Font font25 = new Font("TimesRoman", Font.PLAIN, 25);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);

	static int machine6Cnt;

	static boolean machine6Start = false;

	public Machine6() {
		super("machine6 operation");
		this.setSize(320, 200);
		this.init();
		this.start();
		this.setLocation(1220, 700);
		this.setVisible(true);
	}

	void viewClose() {
		this.setVisible(false);
	}

	public void start() {
		btnOn.addActionListener(this);
		btnOff.addActionListener(this);

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

		this.add(btnOn);
		btnOn.setBounds(40, 100, 100, 40);
		btnOn.setFont(font15);

		this.add(btnOff);
		btnOff.setBounds(170, 100, 100, 40);
		btnOff.setFont(font15);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOn) {
			FactoryCheck.btnMachine6.enable(false);
			FactoryCheck.lbMachineText6.setForeground(Color.RED);
			FactoryCheck.lbMachineText6.setText("가동중");
			machine6Start = true;
		} else if (e.getSource() == btnOff) {
			FactoryCheck.btnMachine6.enable(true);
			FactoryCheck.lbMachineText6.setForeground(Color.BLACK);
			FactoryCheck.lbMachineText6.setText("대기중");
			machine6Start = false;
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}

			if (machine6Start == true) {
				machine6Cnt++;
				try {
					Thread.sleep(2000);
					FactoryCheck.lbMachine6.setText("기계 6출하량:" + machine6Cnt + "개");
//				System.out.println("동작중..");
				} catch (InterruptedException e) {

				}
			}
		}

	}
}
