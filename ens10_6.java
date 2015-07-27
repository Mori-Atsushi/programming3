class Denwa {
	public String no = "080-1234-5678";
	public void tell() {
		System.out.println("電話ができます。");
	}
}

class Keitai extends Denwa implements Ongaku{
	public String address = "abc@akashi.ac.jp";
	public void mail() {
		System.out.println("メールが出来ます。");
	}
	public void listen() {
		System.out.println("音楽が聴けます。");
	}
}

interface Ongaku {
	void listen();
}

public class ens10_6 {
	public static void main(String[] args) {
		Keitai keitai = new Keitai();
		keitai.tell();
		keitai.mail();
		keitai.listen();
	}
}