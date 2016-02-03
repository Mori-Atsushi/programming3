import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ens16_3 extends JPanel implements MouseListener, ActionListener{
	JComboBox <String> c1, c2;
	JButton b1, b2, b3;
	int x1, y1, x2, y2;
	int form = 0;
	Color[] color = {Color.black, Color.red, Color.yellow, Color.green, Color.blue};

	public ens16_3() {
		b1 = new JButton("四角");
		b2 = new JButton("円");
		b3 = new JButton("直線");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		JPanel button = new JPanel();
		button.setLayout(new BorderLayout());
		button.setOpaque(false);
		button.add(b1, BorderLayout.WEST);
		button.add(b2, BorderLayout.CENTER);
		button.add(b3, BorderLayout.EAST);

		JPanel select = new JPanel();
		select.setLayout(new GridLayout(2, 2));	
		String[] list = {"なし", "黒", "赤", "黄", "緑", "青"};
		c1 = new JComboBox <String> (list);
		c2 = new JComboBox <String> (list);
		c1.setSelectedIndex(1);
		c2.setSelectedIndex(0);
		select.add(new JLabel("線の色"));	select.add(c1);
		select.add(new JLabel("塗りつぶしの色"));	select.add(c2);


		JPanel pa = new JPanel();
		pa.setLayout(new BorderLayout());
		pa.setOpaque(false);
		pa.add(button, BorderLayout.NORTH);
		pa.add(select, BorderLayout.SOUTH);

		setPreferredSize(new Dimension(250, 400));
		setLayout(new BorderLayout());
		setBackground(Color.white);
		add(pa, BorderLayout.SOUTH);
		addMouseListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			form = 0;
		} else if(e.getSource() == b2) {
			form = 1;
		} else if(e.getSource() == b3) {
			form = 2;
		}
	}

	protected void paintComponent(Graphics g) {
		int ans;

		super.paintComponent(g);
		switch(form) {
			case 0:
				check();
				if((ans = c2.getSelectedIndex()) != 0) {
					g.setColor(color[ans - 1]);
					g.fillRect(x1, y1, x2 - x1, y2 - y1);
				}
				if((ans = c1.getSelectedIndex()) != 0) {
					g.setColor(color[ans - 1]);
					g.drawRect(x1, y1, x2 - x1, y2 - y1);
				}
				break;
			case 1:
				check();
				if((ans = c2.getSelectedIndex()) != 0) {
					g.setColor(color[ans - 1]);
					g.fillOval(x1, y1, x2 - x1, y2 - y1);
				}
				if((ans = c1.getSelectedIndex()) != 0) {
					g.setColor(color[ans - 1]);
					g.drawOval(x1, y1, x2 - x1, y2 - y1);
				}
				break;
			case 2:
				if((ans = c1.getSelectedIndex()) != 0) {
					g.setColor(color[ans - 1]);
					g.drawLine(x1, y1, x2, y2);
				}
				break;
		}
	}

	protected void check() {
		int tmp;

		if(x1 > x2) {
			tmp = x2;
			x2 = x1;
			x1 = tmp;
		}

		if(y1 > y2) {
			tmp = y2;
			y2 = y1;
			y1 = tmp;
		}
	}

	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();

		repaint();	
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calc");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens16_3 e = new ens16_3();
		frame.add(e, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}