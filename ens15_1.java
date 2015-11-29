import java.awt.*;
import javax.swing.*;
public class ens15_1 extends JPanel {
	public ens15_1() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(250, 250));
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawLine(g);
		drawRect(g);
		drawOval(g);
		drawPolygon(g);
	}
	void drawLine(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("YuMincho", Font.BOLD, 14));
		g.drawLine(50, 50, 150, 150);
		g.drawLine(150, 50, 50, 150);
		g.drawString("直線", 90, 140);	
	}
	void drawRect(Graphics g) {
		g.setColor(Color.green);
		g.setFont(new Font("Hiragino Kaku Gothic ProN", Font.PLAIN, 18));
		g.drawRect(20, 70, 30, 50);
		g.drawString("長方形", 10, 140);
	}
	void drawOval(Graphics g) {
		g.setColor(Color.blue);
		g.setFont(new Font("Hiragino Maru Gothic ProN", Font.PLAIN, 16));
		g.drawOval(80, 150, 50, 80);
		g.drawString("楕円", 140, 220);			
	}
	void drawPolygon(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("Hiragino Mincho ProN", Font.ITALIC, 20));
		int x[] = {200, 230, 230, 200, 170, 170};
		int y[] = {100, 120, 150, 170, 150, 120};
		g.drawPolygon(x, y, 6);
		g.drawString("六角形", 180, 200);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw Line");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens15_1 h = new ens15_1();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}