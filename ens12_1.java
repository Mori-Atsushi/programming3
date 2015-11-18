import java.io.*;
public class ens12_1 {
	public static void main(String[] args) {
		int x, y;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("割られる数 : ");
			x = Integer.parseInt(br.readLine());
			System.out.print("割る数 : ");
			y = Integer.parseInt(br.readLine());
			System.out.println(x + " / " + y + " = " + divison(x, y));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	static int divison(int x, int y) {
		int a = 0;
		try {
			a = x / y;
		} catch(ArithmeticException e) {
			System.out.println("0で割ることはできません。");
			System.exit(-1);
		}

		return a;
	}
}