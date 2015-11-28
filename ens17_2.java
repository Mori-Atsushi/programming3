import java.io.*;
import java.util.Scanner;
public class ens17_2 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new BufferedReader(new FileReader("data1.txt")));
			PrintWriter fileout = new PrintWriter(args[0]);
			while(sc.hasNext()) {
				fileout.printf("%s,\n", sc.next());
			}
			fileout.close();
			sc.close();
		} catch(IOException e) {
			System.out.println(e);
		}
	}
}