package ㄱ자바예제소스;

/*
 * Created on 2005. 10. 20.
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * @author kimsh
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
class DrawInfo implements Serializable {
	private int x, y, x1, y1;

	private int type;

	private Color color;

	private boolean fill;

	public DrawInfo(int x, int y, int x1, int y1, int type, Color color,
			boolean fill) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.type = type;
		this.color = color;
		this.fill = fill;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getType() {
		return type;
	}

	public Color getColor() {
		return color;
	}

	public boolean getFill() {
		return fill;
	}
}

class Round20_Ex05_Sub extends Frame implements MouseListener,
		MouseMotionListener, ItemListener, ActionListener {
	private MenuBar mb = new MenuBar();

	private Menu file = new Menu("FILE");

	private MenuItem fnew = new MenuItem("NEW");

	private MenuItem fopen = new MenuItem("OPEN");

	private MenuItem fsave = new MenuItem("SAVE");

	private MenuItem fexit = new MenuItem("EXIT");

	private Menu option = new Menu("OPTION");

	private Menu odraw = new Menu("DRAW");

	private CheckboxMenuItem odpen = new CheckboxMenuItem("PEN", true);

	private CheckboxMenuItem odline = new CheckboxMenuItem("LINE");

	private CheckboxMenuItem odrect = new CheckboxMenuItem("RECT");

	private CheckboxMenuItem odcircle = new CheckboxMenuItem("CIRCLE");

	private Menu ocolor = new Menu("COLOR");

	private CheckboxMenuItem ocred = new CheckboxMenuItem("RED");

	private CheckboxMenuItem ocblue = new CheckboxMenuItem("BLUE");

	private CheckboxMenuItem ocgreen = new CheckboxMenuItem("GREEN");

	private Menu oprop = new Menu("PROPERTY");

	private CheckboxMenuItem opdraw = new CheckboxMenuItem("DRAW", true);

	private CheckboxMenuItem opfill = new CheckboxMenuItem("FILL");

	private int x, y, x1, y1, dist;

	private Color color;

	private boolean fill;

	private Vector vc = new Vector();

	public Round20_Ex05_Sub() {
		super("그림판!");
		this.init();
		this.start();
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public void init() {
		this.setMenuBar(mb);
		mb.add(file);
		file.add(fnew);
		file.addSeparator();
		file.add(fopen);
		file.add(fsave);
		file.addSeparator();
		file.add(fexit);
		mb.add(option);
		option.add(odraw);
		odraw.add(odpen);
		odraw.add(odline);
		odraw.add(odrect);
		odraw.add(odcircle);
		option.addSeparator();
		option.add(ocolor);
		ocolor.add(ocred);
		ocolor.add(ocgreen);
		ocolor.add(ocblue);
		option.addSeparator();
		option.add(oprop);
		oprop.add(opdraw);
		oprop.add(opfill);
	}

	public void start() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		odpen.addItemListener(this);
		odline.addItemListener(this);
		odrect.addItemListener(this);
		odcircle.addItemListener(this);
		fnew.addActionListener(this);
		fopen.addActionListener(this);
		fsave.addActionListener(this);
		fexit.addActionListener(this);
		opdraw.addItemListener(this);
		opfill.addItemListener(this);
	}

	// public void update(Graphics g) { paint(g); }
	public void paint(Graphics g) {
		Color c = new Color(ocred.getState() ? 255 : 0,
				ocgreen.getState() ? 255 : 0, ocblue.getState() ? 255 : 0);
		g.setColor(c);
		if (dist == 1 || dist == 0) {
			g.drawLine(x, y, x1, y1);
		} else if (dist == 2) {
			if (fill) {
				g.fillRect(x, y, x1 - x, y1 - y);
			} else {
				g.drawRect(x, y, x1 - x, y1 - y);
			}
		} else if (dist == 3) {
			if (fill) {
				g.fillOval(x, y, x1 - x, y1 - y);
			} else {
				g.drawOval(x, y, x1 - x, y1 - y);
			}
		}
		for (int i = 0; i < vc.size(); i++) {
			DrawInfo imsi = (DrawInfo) vc.elementAt(i);
			g.setColor(imsi.getColor());
			if (imsi.getType() == 1 || imsi.getType() == 0) {
				g
						.drawLine(imsi.getX(), imsi.getY(), imsi.getX1(), imsi
								.getY1());
			} else if (imsi.getType() == 2) {
				if (imsi.getFill()) {
					g.fillRect(imsi.getX(), imsi.getY(), imsi.getX1()
							- imsi.getX(), imsi.getY1() - imsi.getY());
				} else {
					g.drawRect(imsi.getX(), imsi.getY(), imsi.getX1()
							- imsi.getX(), imsi.getY1() - imsi.getY());
				}
			} else if (imsi.getType() == 3) {
				if (imsi.getFill()) {
					g.fillOval(imsi.getX(), imsi.getY(), imsi.getX1()
							- imsi.getX(), imsi.getY1() - imsi.getY());
				} else {
					g.drawOval(imsi.getX(), imsi.getY(), imsi.getX1()
							- imsi.getX(), imsi.getY1() - imsi.getY());
				}
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		Color c = new Color(ocred.getState() ? 255 : 0,
				ocgreen.getState() ? 255 : 0, ocblue.getState() ? 255 : 0);
		DrawInfo di = new DrawInfo(x, y, x1, y1, dist, c, opfill.getState());
		vc.add(di);
		this.repaint();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		if (dist == 0) {
			Color c = new Color(ocred.getState() ? 255 : 0,
					ocgreen.getState() ? 255 : 0, ocblue.getState() ? 255 : 0);
			DrawInfo di = new DrawInfo(x, y, x1, y1, dist, c, opfill.getState());
			vc.add(di);
			x = x1;
			y = y1;
		}
		this.repaint();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == odpen) {
			dist = 0;
			odpen.setState(true);
			odline.setState(false);
			odrect.setState(false);
			odcircle.setState(false);
		} else if (e.getSource() == odline) {
			dist = 1;
			odpen.setState(false);
			odline.setState(true);
			odrect.setState(false);
			odcircle.setState(false);
		} else if (e.getSource() == odrect) {
			dist = 2;
			odpen.setState(false);
			odline.setState(false);
			odrect.setState(true);
			odcircle.setState(false);
		} else if (e.getSource() == odcircle) {
			dist = 3;
			odpen.setState(false);
			odline.setState(false);
			odrect.setState(false);
			odcircle.setState(true);
		} else if (e.getSource() == opdraw) {
			opdraw.setState(true);
			opfill.setState(false);
		} else if (e.getSource() == opfill) {
			opdraw.setState(false);
			opfill.setState(true);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fnew) {
			vc.clear();
			x = y = x1 = y1 = dist = 0;
			this.repaint();
		} else if (e.getSource() == fopen) {
			FileDialog fdlg = new FileDialog(this, "열기", FileDialog.LOAD);
			fdlg.setVisible(true);
			String dir = fdlg.getDirectory();
			String file = fdlg.getFile();
			if (dir == null || file == null)
				return;
			try {
				ObjectInputStream oos = new ObjectInputStream(
						new BufferedInputStream(new FileInputStream(new File(
								dir, file))));
				vc = (Vector) oos.readObject();
				oos.close();
			} catch (IOException ee) {
			} catch (ClassNotFoundException ee) {
			}

		} else if (e.getSource() == fsave) {
			FileDialog fdlg = new FileDialog(this, "저장", FileDialog.SAVE);
			fdlg.setVisible(true);
			String dir = fdlg.getDirectory();
			String file = fdlg.getFile();
			if (dir == null || file == null)
				return;
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream(new File(
								dir, file))));
				oos.writeObject(vc);
				oos.close();
			} catch (IOException ee) {
			}
		} else if (e.getSource() == fexit) {
			System.exit(0);
		}
	}
}

public class Round20_Ex05 {
	public static void main(String[] args) {
		Round20_Ex05_Sub ds = new Round20_Ex05_Sub();
	}
}
