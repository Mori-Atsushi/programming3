import java.awt.*;
public class MyHTurtle extends MyTurtle {
	Color color = new Color(0, 0, 0);
	int count = 0;

	public void house(int s) {
		super.house(s);
		up(); rt(90); fd(s / 4); lt(90); fd(s / 4); down();
		polygon(4, s / 2);
		up(); lt(90); fd(s / 4); rt(90); bk(s / 4); down();
	}

	public void polygon(int n, int s) {
		switch(count) {
			case 0: color = new Color(0, 0, 0); break;
			case 1: color = new Color(255, 0, 0); break;
			case 2: color = new Color(0, 0, 255); break;
			case 3: color = new Color(255, 255, 0); break;
		}
		count++;
		count %= 4;
		setColor(color);
		super.polygon(n, s);
	}
}