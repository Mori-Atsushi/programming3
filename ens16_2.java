import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ens16_2 extends JPanel implements ActionListener {
	JTextField h1, h2;
	JLabel l1, l2, l3, l4, l5;
	double d1, d2;
	public ens16_2() {
		setBackground(Color.white);
		h1 = new JTextField(10);
		h2 = new JTextField(10);
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		l4 = new JLabel();
		l5 = new JLabel();
		h1.addActionListener(this);
		h2.addActionListener(this);
		setLayout(new GridLayout(7, 2));
		add(new JLabel("データ1(a)"));	add(h1);
		add(new JLabel("データ2(b)"));	add(h2);
		add(new JLabel("a + b = "));	add(l1);
		add(new JLabel("a - b = "));	add(l2);
		add(new JLabel("a * b = "));	add(l3);
		add(new JLabel("a / b = "));	add(l4);
		add(new JLabel("a % b = "));	add(l5);
	}

	public void actionPerformed(ActionEvent e) {
		try{
			d1 = Double.parseDouble(h1.getText());
			d2 = Double.parseDouble(h2.getText());
		} catch (NumberFormatException error){ d1 = 0.0; d2 = 0.0;}
		doCalc();
	}

	void doCalc() {
		if(d1 > 0 && d2 > 0) {
			double a1 = d1 + d2;
			double a2 = d1 - d2;
			double a3 = d1 * d2;
			double a4 = d1 / d2;
			double a5 = d1 % d2;
			l1.setText(String.valueOf(a1));
			l2.setText(String.valueOf(a2));
			l3.setText(String.valueOf(a3));
			l4.setText(String.valueOf(a4));
			l5.setText(String.valueOf(a5));
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calc");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ens16_2 h = new ens16_2();
		frame.add(h, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}