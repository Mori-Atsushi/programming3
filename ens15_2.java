import java.awt.*;
import javax.swing.*;
public class ens15_2 extends JPanel {
	public ens15_2() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(880, 700));
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(40, 50, 800, 600);
		g.drawLine(440, 50, 440, 650);
		g.drawLine(40, 350, 840, 350);
		int x1, x2, y1, y2;
		for(int i = -360; i < 360; i++) {
			x1 = (int)((i + 360) * 800 / 720) + 40;
			x2 = (int)((i + 360) * 800 / 720) + 41;
			y1 = (int)(-Math.sin(Math.toRadians(i)) * 300) + 350;
			y2 = (int)(-Math.sin(Math.toRadians(i+1)) * 300) + 350;
			g.drawLine(x1, y1, x2, y2);
		}
		g.setFont(new Font("YuGothic", Font.PLAIN, 20));
		g.drawString("O", 445, 370);
		g.drawString("1", 445, 70);
		g.drawString("-1", 445, 640);
		g.drawString("-2π", 45, 370);
		g.drawString("-π", 245, 370);
		g.drawString("π", 645, 370);
		g.drawString("2π", 845, 370);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens15_2 h = new ens15_2();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}