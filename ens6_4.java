public class ens6_4 {
	public static void main(String[] args) {
		TurtleFrame f = new TurtleFrame();
		MyTurtle m = new MyTurtle();
		f.add(m);
		m.up(); m.moveTo(100, 200, 0); m.down();
		System.out.println("線の長さ: " + m.houses(4, 30, 10));
		m.up(); m.moveTo(100, 300, 0); m.down();
		System.out.println("線の長さ: " + m.ppolygon(6, 5, 30));
	}
}