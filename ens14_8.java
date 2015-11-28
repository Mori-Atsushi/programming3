import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class ens14_8 extends JPanel {
	JButton b1, b2, b3, b4, b5, b6, b7, b8;
	JCheckBox c1, c2, c3, c4;
	Color[] color = {Color.blue, Color.cyan, Color.green, Color.magenta, Color.orange};
	Font[] font = {new Font("YuMincho", Font.PLAIN, 16), new Font("YuGothic", Font.PLAIN, 16), new Font("Hiragino Maru Gothic ProN", Font.PLAIN, 16), new Font("Hiragino Kaku Gothic ProN", Font.PLAIN, 16), new Font("Hiragino Mincho ProN", Font.PLAIN, 16)};
	public ens14_8() {
		b1 = new JButton("ボタン1");
		b2 = new JButton("ボタン2");
		b3 = new JButton("ボタン3");
		b4 = new JButton("ボタン");
		b5 = new JButton("ボタン");
		b6 = new JButton("ボタン");
		b7 = new JButton("ボタン");
		b8 = new JButton("ボタン");

		c1 = new JCheckBox("チェック1");
		c2 = new JCheckBox("チェック2");
		c3 = new JCheckBox("チェックA");
		c4 = new JCheckBox("チェックB");

		setLayout(new GridLayout(1, 2, 10, 10));
		JPanel right, left, up, down;
		Random n = new Random();
		int c;

		right = new JPanel();
		right.setLayout(new GridLayout(2, 1));
		up = new JPanel();
		c = n.nextInt(5);
		up.setBackground(color[c]);
		up.setLayout(new GridLayout(1, 3, 10, 10));
		c = n.nextInt(5);
		b1.setFont(font[c]); b1.setBackground(color[c]); b1.setOpaque(true); b1.setBorderPainted(false);
		b2.setFont(font[c]); b2.setBackground(color[c]); b2.setOpaque(true); b2.setBorderPainted(false);
		b3.setFont(font[c]); b3.setBackground(color[c]); b3.setOpaque(true); b3.setBorderPainted(false);
		up.add(b1); up.add(b2); up.add(b3);
		right.add(up);
		down = new JPanel();
		c = n.nextInt(5);
		down.setBackground(color[c]);
		down.setLayout(new GridLayout(2, 2, 10, 10));
		c = n.nextInt(5);
		c1.setFont(font[c]); c1.setBackground(color[c]); c1.setOpaque(true); c1.setBorderPainted(false);
		c2.setFont(font[c]); c2.setBackground(color[c]); c2.setOpaque(true); c2.setBorderPainted(false);
		c3.setFont(font[c]); c3.setBackground(color[c]); c3.setOpaque(true); c3.setBorderPainted(false);
		c4.setFont(font[c]); c4.setBackground(color[c]); c4.setOpaque(true); c4.setBorderPainted(false);
		down.add(c1); down.add(c2); down.add(c3); down.add(c4);
		right.add(down);
		add(right);
		left = new JPanel();
		left.setLayout(new GridLayout(2, 1));
		up = new JPanel();
		c = n.nextInt(5);
		up.setBackground(color[c]);
		up.setLayout(new GridLayout(2, 1, 10, 10));
		c = n.nextInt(5);
		b4.setFont(font[c]); b4.setBackground(color[c]); b4.setOpaque(true); b4.setBorderPainted(false);
		b5.setFont(font[c]); b5.setBackground(color[c]); b5.setOpaque(true); b5.setBorderPainted(false);
		up.add(b4);
		up.add(b5);
		left.add(up);
		down = new JPanel();
		c = n.nextInt(5);
		down.setBackground(color[c]);
		down.setLayout(new GridLayout(1, 3, 10, 10));
		c = n.nextInt(5);
		b6.setFont(font[c]); b6.setBackground(color[c]); b6.setOpaque(true); b6.setBorderPainted(false);
		b7.setFont(font[c]); b7.setBackground(color[c]); b7.setOpaque(true); b7.setBorderPainted(false);
		b8.setFont(font[c]); b8.setBackground(color[c]); b8.setOpaque(true); b8.setBorderPainted(false);
		down.add(b6);
		down.add(b7);
		down.add(b8);
		left.add(down);
		add(left);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens14_8 h = new ens14_8();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}