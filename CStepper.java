public class CStepper extends Turtle {
	private int n;
	private int size;
	private int j = 0;

	public CStepper(int n, int size, int x, int y, int angle) {
		super(x, y, angle);
		this.n = n;
		this.size = size;
	}

	public CStepper(int n, int size) {
		this(n, size, 200, 200, 0);
	}

	public void step() {
		if(j >= n)
			return;

		fd(size);
		rt(360 / n);
		j++;
	}
}