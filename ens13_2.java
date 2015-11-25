public class ens13_2 implements Runnable {
	int type, time;
	ens13_2(int type, int time) {
		this.type = type;
		this.time = time;
	}
	public void run() {
		String x[] = {"***", "==="};
		try{
			for(int i = 0; i < 10; i++) {
				Thread.sleep(time * 1000);
				System.out.println(x[type]);
			}
		} catch(InterruptedException e) {}
	}
	public static void main(String[] args) {
		ens13_2 a = new ens13_2(0, 3);
		ens13_2 b = new ens13_2(1, 5);
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}
}