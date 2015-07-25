public class Cal {
	public int[] cal(int[] x) {
		for(int i = 0; i < x.length; i++)
			x[i] *= 2;

		return x;
	}

	public int[][] cal(int[][] x) {
		for(int i = 0; i < x.length; i++)
			for(int j = 0; j < x[i].length; j++)
				x[i][j] *= 3;

		return x;
	}
}