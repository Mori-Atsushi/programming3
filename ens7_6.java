import java.io.*;
public class ens7_6 {
	public static void main(String[] args) {
		int num;
		ens7_6 x = new ens7_6();

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("何の階乗？");
			num = Integer.parseInt(br.readLine());
			System.out.println(num + "! = " + x.factorial(num));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public int factorial(int x) {
		if(x > 1)
			return x * factorial(x - 1);
		else
			return 1;
	}
}