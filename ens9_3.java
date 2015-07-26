public class ens9_3 {
	public static void main(String[] args) {
		TurtleFrame f = new TurtleFrame();
		MyHTurtle m = new MyHTurtle();
		f.add(m);
		m.up(); m.moveTo(100, 200, 0); m.down();
		m.houses(4, 30, 10);
		m.up(); m.moveTo(100, 300, 0); m.down();
		m.ppolygon(6, 5, 30);
	}
}