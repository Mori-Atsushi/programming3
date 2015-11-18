import java.io.*;
public class ens12_3 {
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
		} catch(NumberFormatException e) {
			System.out.println("数値を入力してください。");
			System.exit(-1);
		} catch(ArithmeticException e) {
			System.out.println("0で割ることはできません。");
			System.exit(-1);
		}
	}

	static int divison(int x, int y) throws ArithmeticException{
		return x / y;
	}
}