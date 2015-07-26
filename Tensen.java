public class Tensen extends HTurtle {
	int psize = 10;
	boolean up = false;

	public void fd(int s) {
		if(up == false) {
			int k, len;
			for(k = 0, len = 0; len + psize <= s; k++, len += psize) {
				if(k % 2 == 0)
					super.down();
				else
					super.up();
				super.fd(psize);
			}

			down();
			super.fd(s - len);
		} else {
			super.fd(s);
		}
	}

	public void up() {
		up = true;
	}

	public void down() {
		up = false;
	}
}