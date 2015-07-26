public class MyTurtle extends HTurtle{
	public MyTurtle() {
		super();
	}

	public MyTurtle(int x, int y, int angle) {
		super(x, y, angle);
	}

	public int houses(int n, int s, int w) {
		for(int i = 0; i < n; i++) {
			house(s);
			up(); rt(90); fd(w + s); lt(90); down();
		}

		return s * 9 * n;
	}

	public int houses(int x, int y, int n, int s, int w) {
		up(); moveTo(x, y, 0); down();
		return houses(n, s, w);
	}

	public int ppolygon(int n, int m, int s) {
		for(int i = 0; i < n; i++) {
			polygon(m, s);
			fd(s);
			lt(360 / n);
		}

		return s * (m + 1) * n;
	}
}