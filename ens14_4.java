import java.awt.*;
import javax.swing.*;

public class ens14_4 extends JPanel{
	JLabel label;
	JButton b1, b2;

	public ens14_4() {
		label = new JLabel("こんにちは");
		b1 = new JButton("ボタン1");
		b2 = new JButton("ボタン2");
		setLayout(new FlowLayout());
		add(label, FlowLayout.LEFT);
		add(b1, FlowLayout.CENTER);
		add(b2, FlowLayout.RIGHT);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens14_4 h = new ens14_4();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}