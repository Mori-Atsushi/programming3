public class HTurtle extends Turtle {
	public HTurtle(int x, int y, int angle) {
		super(x, y, angle);
	}
	public int polygon(int n, int s) {
		int a = 360 / n;
		for(int j = 0; j < n; j++) {
			fd(s);
			rt(a);
		}
		return s * n;
	}

	public int house(int s) {
		int x = 0;
		x += polygon(4, s);
		fd(s); rt(30);
		x += polygon(3,s);
		lt(30); bk(s);
		x += s * 2;
		return x;
	}

	public int house(int x, int y, int s) {
		up(); moveTo(x, y, 0); down();
		return house(s);
	}
}