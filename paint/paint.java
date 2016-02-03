import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.File;

public class paint extends JPanel implements MouseListener, MouseMotionListener,ActionListener{
	static JMenuBar menubar;
	static JMenu file, edit;
	static JMenuItem menuNew, menuSave, menuNewSave, menuOpen;
	static JMenuItem menuCopy, menuCut, menuPaste, menuDelete; 

	boolean writeFlag = false, moveFlag = false;

	JButton select, line_b, rect_b, oval_b, text_b, lineColor_c, sideColor_c;
	JComboBox <String> c1, c2, fontSize_c, lineWeight_c;
	JPanel opera, tool, surface, lineColor_p, sideColor_p, main;
	int x1, y1, x2, y2;
	int nowTool = -1, nowSelect = -1;
	java.util.List<Data> data = new ArrayList<Data>();
	SaveFile saveFile = new SaveFile();
	Data tmp = new Data(), copyData = null;

	Color lineColor = Color.black, sideColor = Color.white;

	public paint() {
		ImageIcon select_i = new ImageIcon("image/select.png");
		ImageIcon line_i = new ImageIcon("image/line.png");
		ImageIcon rect_i = new ImageIcon("image/rect.png");
		ImageIcon oval_i = new ImageIcon("image/oval.png");
		ImageIcon text_i = new ImageIcon("image/text.png");
		select = new JButton("選択", select_i);
		line_b = new JButton("直線", line_i);
		rect_b = new JButton("四角", rect_i);
		oval_b = new JButton("楕円", oval_i);
		text_b = new JButton("文字", text_i);
		select.addActionListener(this);
		line_b.addActionListener(this);
		rect_b.addActionListener(this);
		oval_b.addActionListener(this);
		text_b.addActionListener(this);

		tool = new JPanel();
		tool.setLayout(new BoxLayout(tool, BoxLayout.Y_AXIS));
		tool.add(select);
		tool.add(line_b);
		tool.add(rect_b);
		tool.add(oval_b);
		tool.add(text_b);

		String[] list = {"なし", "あり"};
		c1 = new JComboBox <String> (list);
		c2 = new JComboBox <String> (list);
		String[] fontSizeList = {"10pt", "12pt", "14pt", "18pt", "24pt", "36pt", "48pt", "72pt", "96pt"};
		fontSize_c = new JComboBox <String> (fontSizeList);
		String[] lineWeightList = {"1pt", "2pt", "3pt", "4pt", "5pt", "6pt", "8pt", "10pt", "12pt"};
		lineWeight_c = new JComboBox <String> (lineWeightList);
		c1.setSelectedIndex(1);
		c2.setSelectedIndex(0);
		fontSize_c.setSelectedIndex(2);
		lineWeight_c.setSelectedIndex(2);

		lineColor_p = new JPanel();
		sideColor_p = new JPanel();
		lineColor_p.setPreferredSize(new Dimension(20, 20));
		lineColor_p.setBackground(Color.black);
		sideColor_p.setPreferredSize(new Dimension(20, 20));
		sideColor_p.setBackground(Color.white);

		lineColor_c = new JButton("色選択");
		sideColor_c = new JButton("色選択");
		lineColor_c.addActionListener(this);
		sideColor_c.addActionListener(this);

		opera = new JPanel();
		opera.setLayout(new BoxLayout(opera, BoxLayout.X_AXIS));
		opera.add(new JLabel("線/フォントの色"));
		opera.add(c1);
		opera.add(lineColor_p);
		opera.add(lineColor_c);
		opera.add(new JLabel("塗りつぶしの色"));
		opera.add(c2);
		opera.add(sideColor_p);
		opera.add(sideColor_c);
		opera.add(new JLabel("線の太さ"));
		opera.add(lineWeight_c);
		opera.add(new JLabel("フォントサイズ"));
		opera.add(fontSize_c);

		surface = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D)g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				for(int i = 0; i < data.size(); i++)
					data.get(i).draw(g2);
				if(writeFlag)
					tmp.draw(g2);
				if(nowTool == -1 && nowSelect != -1) {
					data.get(nowSelect).selectDraw(g2);
				}
			}
		};
		surface.setPreferredSize(new Dimension(1280, 720));
		surface.setBackground(Color.white);
		surface.addMouseListener(this);
		surface.addMouseMotionListener(this);

		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(opera);
		main.add(surface);

		setLayout(new BorderLayout());
		add(main, BorderLayout.CENTER);
		add(tool, BorderLayout.WEST);
	}

	void paste() {
		Data tmp2 = copyData.clone();
		data.add(tmp2);
		nowSelect = data.size() - 1;
		surface.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuNew) {
			data.clear();
			saveFile = new SaveFile();
			nowSelect = -1;
		} else if(e.getSource() == menuSave) {
			saveFile.menuSave(this, data);
		} else if(e.getSource() == menuNewSave) {
			saveFile.menuNewSave(this, data);
		} else if(e.getSource() == menuOpen) {
			data = saveFile.menuOpen(this);
		} else if(e.getSource() == menuCopy && nowSelect >= 0) {
			copyData = data.get(nowSelect).clone();
			copyData.move(20, 20);
		} else if(e.getSource() == menuCut && nowSelect >= 0) {
			copyData = data.get(nowSelect).clone();
			data.remove(nowSelect);
			nowSelect = -1;
		} else if(e.getSource() == menuPaste && copyData != null) {
			paste();
		} else if(e.getSource() == menuDelete && nowSelect >= 0) {
			data.remove(nowSelect);
			nowSelect = -1;
		} else if(e.getSource() == select) {
			nowSelect = -1;
			nowTool = -1;
		} else if(e.getSource() == line_b) {
			nowTool = 0;
		} else if(e.getSource() == rect_b) {
			nowTool = 1;
		} else if(e.getSource() == oval_b) {
			nowTool = 2;
		} else if(e.getSource() == text_b) {
			nowTool = 3;
		} else if(e.getSource() == lineColor_c) {
			JColorChooser colorchooser = new JColorChooser();
			Color color = colorchooser.showDialog(this, "色の選択", lineColor);
			if(color != null) {
				lineColor_p.setBackground(color);
				lineColor = color;
			}
		} else if(e.getSource() == sideColor_c) {
			JColorChooser colorchooser = new JColorChooser();
			Color color = colorchooser.showDialog(this, "色の選択", sideColor);
			if(color != null) {
				sideColor_p.setBackground(color);
				sideColor = color;
			}
		}
		surface.repaint();
	}

	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		if(nowTool >= 0 && nowTool < 3) {
			writeFlag = true;
		} else if(nowTool == -1) {
			int i;
			for(i = data.size() - 1; i >= 0; i--) {
				if(data.get(i).check(x1, y1) == 1) {
					moveFlag = true;
					nowSelect = i;
					break;
				}
			}
			if(i < 0)
				nowSelect = -1;
			surface.repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {
		if(nowTool < 3) {
			x2 = e.getX();
			y2 = e.getY();
			writeFlag = false;

			if(nowTool >= 0) {
				Data tmp2 = new Data();
				Color a, b;
				if(c1.getSelectedIndex() == 0)
					a = null;
				else
					a = lineColor;

				if(c2.getSelectedIndex() == 0)
					b = null;
				else
					b = sideColor;
				int lineWeight = lineWeight_c.getSelectedIndex();
				tmp2.setData(nowTool, x1, y1, x2, y2, a, b, lineWeight);
				data.add(tmp2);
				surface.repaint();
			}
		}

		if(nowTool == -1) {
			moveFlag = false;
		}
	}

	public void mouseClicked(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		if(nowTool == 3) {

			String value = JOptionPane.showInputDialog(this, "テキスト入力");
			if (value != null) {
				Data tm2 = new Data();
				Color a;
				if(c1.getSelectedIndex() == 0)
					a = null;
				else
					a = lineColor;
				int fontSize = fontSize_c.getSelectedIndex();
				tm2.setData(nowTool, x1, y1, value, lineColor, fontSize);
				data.add(tm2);
				surface.repaint();
			}
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		if(nowTool < 3 && nowTool >= 0) {
			Color a, b;
			if(c1.getSelectedIndex() == 0)
				a = null;
			else
				a = lineColor;

			if(c2.getSelectedIndex() == 0)
				b = null;
			else
				b = sideColor;
			int lineWeight = lineWeight_c.getSelectedIndex();
			tmp.setData(nowTool, x1, y1, x2, y2, a, b, lineWeight);
			surface.repaint();
		}

		if(moveFlag) {
			data.get(nowSelect).move(x2 - x1, y2 - y1);
			surface.repaint();
			x1 = e.getX();
			y1 = e.getY();
		}
	}

	public void mouseMoved(MouseEvent e) {}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paint e = new paint();
		menubar = new JMenuBar();
		file = new JMenu("ファイル");
		edit = new JMenu("編集");
		menubar.add(file);
		menubar.add(edit);

		menuNew = new JMenuItem("新規");
		menuSave = new JMenuItem("保存");
		menuNewSave = new JMenuItem("名前をつけて保存");
		menuOpen = new JMenuItem("開く");
		menuNew.addActionListener(e);
		menuSave.addActionListener(e);
		menuNewSave.addActionListener(e);
		menuOpen.addActionListener(e);

		file.add(menuNew);
		file.add(menuSave);
		file.add(menuNewSave);
		file.add(menuOpen);

		menuCopy = new JMenuItem("コピー");
		menuCut = new JMenuItem("切り取り");
		menuPaste = new JMenuItem("貼り付け");
		menuDelete = new JMenuItem("削除");
		menuCopy.addActionListener(e);
		menuCut.addActionListener(e);
		menuPaste.addActionListener(e);
		menuDelete.addActionListener(e);

		edit.add(menuCopy);
		edit.add(menuCut);
		edit.add(menuPaste);
		edit.add(menuDelete);

		frame.setJMenuBar(menubar);

		frame.add(e, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}