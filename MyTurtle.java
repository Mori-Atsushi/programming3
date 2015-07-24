public class MyTurtle extends HTurtle {
	public void houses(int n, int s, int w) {
		for(int i = 0; i < n; i++) {
			house(s);
			up(); rt(90); fd(w + s); lt(90); down();
		}
	}

	public void ppolygon(int n, int m, int s) {
		for(int i = 0; i < n; i++) {
			polygon(m, s);
			fd(s);
			lt(360 / n);
		}
	}
}