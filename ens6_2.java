public class ens6_2 {
	public static void main(String[] args) {
		TurtleFrame f = new TurtleFrame();
		MyTurtle m = new MyTurtle();
		f.add(m);
		m.ppolygon(6, 5, 30);
	}
}