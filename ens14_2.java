import java.awt.*;
import javax.swing.*;

public class ens14_2 extends JPanel{
	JButton b1, b2, b3, b4, b5;

	public ens14_2() {
		b1 = new JButton("北");
		b2 = new JButton("中央");
		b3 = new JButton("東");
		b4 = new JButton("西");
		b5 = new JButton("南");
		setLayout(new BorderLayout());
		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.CENTER);
		add(b3, BorderLayout.EAST);
		add(b4, BorderLayout.WEST);
		add(b5, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens14_2 h = new ens14_2();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}