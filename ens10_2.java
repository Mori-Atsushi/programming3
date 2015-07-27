class A{
	public void m1() {
		System.out.print("A's m1, ");
	}
	public void m2() {
		System.out.print("A's m2, ");
	}
	public void m3() {
		System.out.print("A's m3, ");
	}
}

class B extends A {
	public void m1() {
		System.out.print("B's m1, ");
	}
}

class C extends A{
	public void m3() {
		System.out.print("C's m3, ");
	}
}

public class ens10_2 {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		A a2 = new C();

		b.m1();
		c.m2();
		a.m3();

		System.out.println();
	}
}