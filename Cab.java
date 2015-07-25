public class Cab {
	static int calc(int m) {
		int basic = 600; //初乗り料金
		int normal = 80; //単位距離あたりの料金
		int basicDistance = 2000; //初乗りの距離
		int normalDistance = 459; //単位距離

		int ans = basic;
		m -= basicDistance;
		if(m > 0)
			ans += (m / normalDistance + 1) * normal;
		return ans;
	}
}