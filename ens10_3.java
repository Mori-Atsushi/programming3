class Bird {
	public void move() {
		System.out.println("飛んで移動します。");
	}
	public void eat() {
		System.out.println("エサを食べます。");
	}
}

class Suzume extends Bird {
	public void eat() {
		System.out.println("昆虫などを食べます。");
	}
}

class Penguin extends Bird {
	public void move() {
		System.out.println("泳いで移動します。");
	}
	public void eat() {
		System.out.println("魚を食べます。");
	}
}

public class ens10_3 {
	public static void main(String[] args) {
		Suzume suzume = new Suzume();
		Penguin penguin = new Penguin();
		System.out.println("スズメは");
		suzume.move();
		suzume.eat();

		System.out.println();
		System.out.println("ペンギンは");
		penguin.move();
		penguin.eat();
	}
}