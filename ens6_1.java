public class ens6_1 {
	public static void main(String[] args) {
		TurtleFrame f = new TurtleFrame();
		MyTurtle m = new MyTurtle();
		f.add(m);
		m.houses(4, 30, 10);
	}
}