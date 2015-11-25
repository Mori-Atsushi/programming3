import java.awt.Color;
public class ens13_3 extends HTurtle implements Runnable {
	int n, s;
	ens13_3(int x, int y, int a, int n, int s) {
		super(x, y, a);
		this.n = n; this.s = s;
	}
	public void run() {
		polygon(n, s);
	}
	public static void main(String[] args) {
		TurtleFrame f = new TurtleFrame();
		ens13_3 m = new ens13_3(200, 200, 0, 10, 50); f.add(m);
		ens13_3 m1 = new ens13_3(100, 200, 0, 5, 50); f.add(m1);
		m1.setColor(new Color(255, 0, 0));
		m1.speed(5);
		Thread t = new Thread(m);
		Thread t1 = new Thread(m1);
		t.start();
		t1.start();
		try {
			t.join();
			t1.join();
		} catch(InterruptedException e) {}
		f.clear();
	}
}