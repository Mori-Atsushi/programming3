import java.awt.*;
import javax.swing.*;

public class ens14_7 extends JPanel{
	JLabel label;
	JButton b1, b2;

	public ens14_7() {
		label = new JLabel("こんにちは");
		b1 = new JButton("ボタン1");
		b2 = new JButton("ボタン2");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(label);
		add(b1);
		add(b2);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens14_7 h = new ens14_7();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}