public class ens7_2 {
	public static void main(String[] args) {
		TurtleFrame f = new TurtleFrame();
		CStepper m1 = new CStepper(5, 50, 100, 100, 0);
		CStepper m2 = new CStepper(4, 50, 300, 100, 0);
		f.add(m1); f.add(m2);

		for(int i = 0; i < 5; i++) {
			m1.step(); m2.step();
		}

		MyTurtle m3 = new MyTurtle(100, 300, 0);
		f.add(m3);
		m3.houses(5, 30, 10);
	}
}