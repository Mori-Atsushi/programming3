import java.io.*;
public class ens17_1 {
	public static void main(String[] args) {
		try {
			BufferedReader buffin = new BufferedReader(new FileReader(args[0]));
			String s; int n = 0, sum = 0; int x[] = new int[5];
			while((s = buffin.readLine()) != null) {
				if(++n % 2 == 0) {
					x[n / 2 - 1] = Integer.parseInt(s);
					sum += x[n / 2 - 1];
					System.out.println(s);
				} else {
					System.out.print(s + " ");
				}
			}
			buffout.close();
			System.out.println("合計 " + sum);
			for(int i = 0; i < x.length; i++)
				System.out.print(x[i] + " ");
			System.out.println();
		} catch(IOException e) {
			System.out.println(e);
		} catch(NumberFormatException e) {
			System.out.println("数値が正しくありません。");
			System.exit(-1);
		}
	}
}