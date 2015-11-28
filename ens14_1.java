import java.awt.*;
import javax.swing.*;

public class ens14_1 extends JPanel{
	JLabel label;
	JButton b1, b2;

	public ens14_1() {
		label = new JLabel("こんにちは");
		b1 = new JButton("ボタン1");
		b2 = new JButton("ボタン2");
		setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		add(b1, BorderLayout.CENTER);
		add(b2, BorderLayout.EAST);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens14_1 h = new ens14_1();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}