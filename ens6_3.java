public class ens6_3 {
	public static void main(String[] args) {
		TurtleFrame f = new TurtleFrame();
		HTurtle m1 = new HTurtle();
		f.add(m1);
		m1.house(100, 200, 30);

		MyTurtle m2 = new MyTurtle();
		f.add(m2);
		m2.houses(100, 300, 4, 30, 10);
	}
}