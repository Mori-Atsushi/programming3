public class ens7_5 {
	public static void main(String[] args) {
		int[] s1 = {1, 2, 3, 4};
		int[][] s2 = {{10, 20, 30}, {40, 50, 60}};
		Cal x = new Cal();
		int ans1[] = x.cal(s1);
		int ans2[][] = x.cal(s2);

		for(int i = 0; i < ans1.length; i++)
			System.out.print("s1[" + i + "]=" + ans1[i] + " ");
		System.out.println();

		for(int i = 0; i < ans2.length; i++)
			for(int j = 0; j < ans2[i].length; j++)
				System.out.print("s2[" + i + "][" + j + "]=" + ans2[i][j] + " ");
		System.out.println();
	}
}