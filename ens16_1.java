import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class ens16_1 extends JPanel implements ActionListener {
	JLabel label;
	JButton b1, b2, b3;
	public ens16_1() {
		b1 = new JButton("グー");
		b2 = new JButton("チョキ");
		b3 = new JButton("パー");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		label = new JLabel("ボタンを押してね！");

		add(b1, BorderLayout.WEST);
		add(b2, BorderLayout.CENTER);
		add(b3, BorderLayout.EAST);
		add(label, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Random rnd = new Random();
		int ran = rnd.nextInt(3);
		int ans = 0;

		if(e.getSource() == b1) {
			ans = 0;
		} else if(e.getSource() == b2) {
			ans = 1;
		} else if(e.getSource() == b3) {
			ans = 2;
		}

		int result = (ran + ans + 3) % 3;
		switch(result) {
			case 0:
				label.setText("あいこです。");
				break;
			case 1:
				label.setText("あなたの勝ちです。");
				break;
			case 2:
				label.setText("あなたの負けです。");
				break;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens16_1 h = new ens16_1();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}