class Data1 {
	public int x;
	public void disp_x() {
		System.out.println("x=" + x);
	}
}

class Data2 extends Data1 {
	public int y;
	public void disp_y() {
		System.out.println("y=" + y);
	}
	public void disp_xy() {
		System.out.println("x=" + x + " y=" + y);
	}
}

public class ens10_1 {
	public static void main(String args[]) {
		Data2 dt = new Data2();
		dt.x = 100;
		dt.y = 200;
		dt.disp_x();
		dt.disp_y();
		dt.disp_xy();
	}
}