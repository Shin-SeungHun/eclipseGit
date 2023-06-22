import java.applet.*;
import java.awt.*;

public class Round21_Ex06 extends Applet {
	private int num = 0;

	public void init() {
		num = Integer.parseInt(this.getParameter("number"));
	}

	public void paint(Graphics g) {
		Dimension di = this.getSize();
		for (int i = 0; i < num; i++) {
			g.setColor(new Color((int) (Math.random() * 256), (int) (Math
					.random() * 256), (int) (Math.random() * 256)));
			int xpos = (int) (di.getWidth() * Math.random());
			int ypos = (int) (di.getHeight() * Math.random());
			g.setFont(new Font("TimesRoman", Font.BOLD, 15));
			g.drawString("¡Ú", xpos, ypos);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ee) {
			}
		}
	}
}
