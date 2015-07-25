class ClockAccessMain {
	public static void main(String[] args) {
		ClockAccess c = new ClockAccess();
		c.setTime("1234");
		String tod = c.getTime();
		System.out.println("time: " + tod);
	}
}