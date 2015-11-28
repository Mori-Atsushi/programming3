
public class HTurtle extends Turtle {
	public HTurtle() {
		super();
	}

	public HTurtle(int x, int y, int angle) {
		super(x, y, angle);
	}

	synchronized public void polygon(int n, int s) {
		int a = 360 / n;
		for(int j = 0; j < n; j++) {
			fd(s);
			rt(a);
		}
	}

	synchronized public void house(int s) {
		polygon(4, s);
		fd(s); rt(30);
		polygon(3, s);
		lt(30); bk(s);
	}

	public void house(int x, int y, int s) {
		up(); moveTo(x, y, 0); down();
		house(s);
	}
}