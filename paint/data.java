import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;

class Data  implements Cloneable {
	int object, x1, y1, x2, y2, fontSize, lineWeight;
	Color lineColor = null, sideColor = null;
	String value = null;

	public Data() {}

	public Data(String s) {
		String[] tmp = s.split(",", -1);
		this.object = Integer.parseInt(tmp[0]);
		this.x1 = Integer.parseInt(tmp[1]);
		this.y1 = Integer.parseInt(tmp[2]);
		if(object < 3) {
			this.x2 = Integer.parseInt(tmp[3]);
			this.y2 = Integer.parseInt(tmp[4]);	
			if(!"".equals(tmp[5]))
				this.lineColor = new Color(Integer.parseInt(tmp[5]), true);
			if(!"".equals(tmp[6]))
				this.sideColor = new Color(Integer.parseInt(tmp[6]), true);
			this.lineWeight = Integer.parseInt(tmp[7]);
		} else {
			value = tmp[3];
			if(!"".equals(tmp[4]))
				this.lineColor = new Color(Integer.parseInt(tmp[4]), true);
			this.fontSize = Integer.parseInt(tmp[5]);
		}
	}

	public Data clone() {
		Data r = null;
		try {
			r = (Data)super.clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void setData(int tool, int x1, int y1, int x2, int y2, Color lineColor, Color sideColor, int lineWeight) {
		int[] lineWeightList = {1, 2, 3, 4, 5, 6, 8, 10, 12};
		this.object = tool;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.lineColor = lineColor;
		this.sideColor = sideColor;
		this.lineWeight = lineWeightList[lineWeight];

		if(this.object > 0) {
			int tmp;

			if(this.x1 > this.x2) {
				tmp = this.x2;
				this.x2 = this.x1;
				this.x1 = tmp;
			}

			if(this.y1 > this.y2) {
				tmp = this.y2;
				this.y2 = this.y1;
				this.y1 = tmp;
			}	
		}
	}

	public void setData(int tool, int x, int y, String value, Color lineColor, int fontSize) {
		int[] fontSizeList = {10, 12, 14, 18, 24, 36, 48, 72, 96};
		this.object = tool;
		this.x1 = x;
		this.y1 = y;
		this.value = value;
		this.lineColor = lineColor;
		this.fontSize = fontSizeList[fontSize];
	}

	public void move(int x, int y) {
		x1 += x;
		y1 += y;
		x2 += x;
		y2 += y;
	}

	public void draw(Graphics2D g) {
		if(object != 3) {
			BasicStroke wideStroke = new BasicStroke(lineWeight);
			g.setStroke(wideStroke);
		}

		switch(object) {
			case 0:
				if(lineColor != null) {
					g.setColor(lineColor);
					g.drawLine(this.x1, this.y1, this.x2, this.y2);
				}
				break;
			case 1:
				if(sideColor != null) {
					g.setColor(sideColor);
					g.fillRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);			
				}
				if(lineColor != null) {
					g.setColor(lineColor);
					g.drawRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
				}
				break;
			case 2:
				if(sideColor != null) {
					g.setColor(sideColor);
					g.fillOval(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
				}
				if(lineColor != null) {
					g.setColor(lineColor);
					g.drawOval(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
				}
				break;
			case 3:
				if(lineColor != null) {
					g.setColor(lineColor);
					g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
					g.drawString(value, x1, y1);
				}
				break;
		}
	}

	public void selectDraw(Graphics2D g) {
		BasicStroke wideStroke = new BasicStroke(1.0f);
		g.setStroke(wideStroke);
		g.setColor(Color.blue);
		switch(object) {
			case 0:
				g.drawLine(x1, y1, x2, y2);
				g.drawOval(x1 - 5, y1 - 5, 10, 10);
				g.drawOval(x2 - 5, y2 - 5, 10, 10);
				g.drawOval((x1 + x2) / 2 - 5, (y1 + y2) / 2 - 5, 10, 10);
				break;
			case 1:
				g.drawRect(x1, y1, x2 - x1, y2 - y1);
				g.drawOval(x1 - 5, y1 - 5, 10, 10);
				g.drawOval(x1 - 5, y2 - 5, 10, 10);
				g.drawOval(x2 - 5, y1 - 5, 10, 10);
				g.drawOval(x2 - 5, y2 - 5, 10, 10);
				g.drawOval((x1 + x2) / 2 - 5, y1 - 5, 10, 10);
				g.drawOval((x1 + x2) / 2 - 5, y2 - 5, 10, 10);
				g.drawOval(x1 - 5, (y1 + y2) / 2 - 5, 10, 10);
				g.drawOval(x2 - 5, (y1 + y2) / 2 - 5, 10, 10);
				break;
			case 2:
				g.drawOval(x1, y1, x2 - x1, y2 - y1);
				g.drawRect(x1, y1, x2 - x1, y2 - y1);
				g.drawOval(x1 - 5, y1 - 5, 10, 10);
				g.drawOval(x1 - 5, y2 - 5, 10, 10);
				g.drawOval(x2 - 5, y1 - 5, 10, 10);
				g.drawOval(x2 - 5, y2 - 5, 10, 10);
				g.drawOval((x1 + x2) / 2 - 5, y1 - 5, 10, 10);
				g.drawOval((x1 + x2) / 2 - 5, y2 - 5, 10, 10);
				g.drawOval(x1 - 5, (y1 + y2) / 2 - 5, 10, 10);
				g.drawOval(x2 - 5, (y1 + y2) / 2 - 5, 10, 10);
				break;
			case 3:
				BufferedImage bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = bi.createGraphics();
				g2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
				FontMetrics fm = g2.getFontMetrics();
				Rectangle2D r = fm.getStringBounds(value,g2);
				int rx = (int)r.getX(), ry = (int)r.getY(), a = (int)r.getWidth(), b = (int)r.getHeight();
				g.drawRect(rx + x1, ry + y1, a, b);
				g.drawLine(x1, y1, a + x1, y1);
				g.drawOval(rx + x1 - 5, ry + y1 - 5, 10, 10);
				g.drawOval(rx + x1 - 5, ry + y1 + b - 5 , 10, 10);
				g.drawOval(rx + x1 + a - 5, ry + y1 - 5, 10, 10);
				g.drawOval(rx + x1 + a - 5, ry + y1 + b - 5, 10, 10);
				break;
		}
	}

	public int check(int x, int y) {
		double a, b, c, x3, y3;
		int margin = 5 + lineWeight;
		switch(object) {
			case 0:
				a = x2 - x1;
				b = y2 - y1;
				c = Math.sqrt(a * a + b * b);

				x3 = (x - x1) * - (a / c) + (y - y1) * - (b / c);
				y3 = (x - x1) *   (b / c) + (y - y1) * - (a / c);

				if(-margin < y3 && y3 < margin && - (c + margin) < x3 && x3 < margin)
					return 1;
				break;
			case 1:
				if((x1 - margin) <= x && x <= (x2 + margin) && (y1 - margin) <= y && y <= (y2 + margin)) {
					if(sideColor != null)
						return 1;
					else if((x1 + margin) >= x || x >= (x2 - margin) || (y1 + margin) >= y || y >= (y2 - margin))
						return 1;
				}
				break;
			case 2:
				a = (x2 - x1) / 2.0;
				b = (y2 - y1) / 2.0;
				x3 = x - (x1 + a);
				y3 = y - (y1 + b);

				if((x3 * x3) / ((a + margin) * (a + margin)) + (y3 * y3) / ((b + margin) * (b + margin)) <= 1.0) {
					if(sideColor != null)
						return 1;
					else if((x3 * x3) / ((a - margin) * (a - margin)) + (y3 * y3) / ((b - margin) * (b - margin)) > 1.0)
						return 1;
				}
				break;
			case 3:
				BufferedImage bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = bi.createGraphics();
				g2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
				FontMetrics fm = g2.getFontMetrics();
				Rectangle2D r = fm.getStringBounds(value,g2);
				int rx = (int)r.getX(), ry = (int)r.getY();
				a = (int)r.getWidth();
				b = (int)r.getHeight();
				if((rx + x1 - margin) < x && x < (rx + x1 + a + margin) && (ry + y1 + margin + b) > y && y > (ry + y1 - margin))
					return 1;
				break;			
		}
		return 0;
	}

	public String export() {
		String line = "", side = "";

		if(lineColor != null)
			line = String.valueOf(lineColor.getRGB());
		if(sideColor != null)
			side = String.valueOf(sideColor.getRGB());

		String exportText = String.valueOf(object) + ',' + String.valueOf(x1) + ',' + String.valueOf(y1);
		if(object < 3)
			exportText += ',' + String.valueOf(x2) + ',' + String.valueOf(y2) + ',' + line + ',' + side + ',' + String.valueOf(lineWeight) + "\n";
		else
			exportText += ',' + value + ',' + line + ',' + String.valueOf(fontSize) + "\n";
		return exportText;
	}
}