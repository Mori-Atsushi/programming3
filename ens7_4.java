public class ens7_4 {
	public static void main(String[] args) {
		int[] s1 = {1, 2, 3, 4};
		Cal x = new Cal();
		int[] y = x.cal(s1);

		for(int i = 0; i < y.length; i++)
			System.out.print("s1[" + i + "]=" + y[i] + " ");
		System.out.println(); 
	}
}