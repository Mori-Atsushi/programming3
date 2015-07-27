interface Communication {
	void communicate();
}

class Tiger implements Communication {
	public void communicate() {
		System.out.println("トラと触れ合うのは危険です。");
	}
}

class Mustang implements Communication {
	public void communicate() {
		System.out.println("馬は警戒心が強いです。エサを置いたら遠くから見守りましょう。");
	}
}

class Dolphin implements Communication {
	public void communicate() {
		System.out.println("イルカはひとなつっこいです。頭を撫でることができます。");
	}
}

class JavaSafari {
	public void challenge(Communication animal) {
		animal.communicate();
	}
}

public class ens10_7 {
	public static void main(String[] args) {
		JavaSafari javaSafari = new JavaSafari();
		Tiger tiger = new Tiger();
		Mustang mustang = new Mustang();
		Dolphin dolphin = new Dolphin();
		javaSafari.challenge(tiger);
		javaSafari.challenge(mustang);
		javaSafari.challenge(dolphin);
	}
}