public class ens13_4 extends Thread {
	int n, s;
	HTurtle mh;
	ens13_4(int n, int s, HTurtle m) {
		this.n = n;
		this.s = s;
		this.mh = m;
	}
	public void run() {
		mh.polygon(n, s);
		mh.house(s);
	}
	public static void main(String[] args) {
		TurtleFrame f = new TurtleFrame();
		HTurtle m = new HTurtle();
		f.add(m);
		ens13_4 t1 = new ens13_4(3, 50, m);
		ens13_4 t2 = new ens13_4(5, 40, m);
		t1.start();
		t2.start();
		System.out.println("Main method finished.");
	}
}