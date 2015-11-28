import java.awt.*;
import javax.swing.*;

public class ens14_6 extends JPanel{
	JLabel label;
	JButton b1, b2;

	public ens14_6() {
		label = new JLabel("こんにちは");
		b1 = new JButton("ボタン1");
		b2 = new JButton("ボタン2");
		setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		JPanel flowPanel = new JPanel();
		flowPanel.setLayout(new GridLayout(1, 2));
		flowPanel.add(b1);
		flowPanel.add(b2);
		add(flowPanel, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens14_6 h = new ens14_6();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}