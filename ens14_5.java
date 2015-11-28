import java.awt.*;
import javax.swing.*;

public class ens14_5 extends JPanel{
	JLabel label;
	JButton b1, b2;

	public ens14_5() {
		label = new JLabel("こんにちは");
		b1 = new JButton("ボタン1");
		b2 = new JButton("ボタン2");
		setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		JPanel flowPanel = new JPanel();
		flowPanel.add(b1);
		flowPanel.add(b2);
		add(flowPanel, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens14_5 h = new ens14_5();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}