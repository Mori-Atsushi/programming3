import java.awt.*;
import javax.swing.*;

public class ens14_3 extends JPanel{
	JLabel label;
	JButton b1, b2;
	ImageIcon sun = new ImageIcon("sun.png");
	ImageIcon snow = new ImageIcon("snow.png");

	public ens14_3() {
		label = new JLabel("こんにちは");
		b1 = new JButton("あいさつ", sun);
		b2 = new JButton("消える", snow);
		setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		add(b1, BorderLayout.CENTER);
		add(b2, BorderLayout.EAST);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens14_3 h = new ens14_3();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}