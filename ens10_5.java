class Bird {
	public void showName() {
		System.out.println("鳥の名前を表示します。");
	}
	public void behavior() {
		System.out.println("特徴や習性を表示します。");
	}
}

class Kestrel extends Bird{
	public void showName() {
		System.out.println("タカ目ハヤブサ科チョウゲンボウ");
	}
	public void behavior() {
		System.out.println("素早く羽ばたいて牡馬リングを行なった後、急降下して獲物のを捉える。");
	}
}

class Merlin extends Bird{
	public void showName() {
		System.out.println("タカ目ハヤブサ科コチョウゲンボウ");
	}
	public void behavior() {
		System.out.println("日本でも田園などで見ることができる冬鳥。ハトくらいの大きさ。");
	}
}

class Dictionary {
	public void showBird(Bird bird) {
		bird.showName();
		bird.behavior();
		System.out.println();
	}
}

public class ens10_5 {
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		Kestrel kestrel = new Kestrel();
		Merlin merlin = new Merlin();
		dictionary.showBird(kestrel);
		dictionary.showBird(merlin);
	}
}