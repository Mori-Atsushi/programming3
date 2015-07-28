class SuperClass {
	String field = "superField";

	String method() {
		return "superMethod";
	}
	String getField() {
		return field;
	}
}

class SubClass extends SuperClass {
	String field = "subField";

	String method() {
		return "subMethod";
	}
}

class ens11_2 {
	public static void main(String[] args) {
		SuperClass clz1 = new SuperClass();
		System.out.println(clz1.field);
		System.out.println(clz1.method());
		System.out.println(clz1.getField());
		System.out.println();

		SubClass clz2 = new SubClass();
		System.out.println(clz2.field);
		System.out.println(clz2.method());
		System.out.println(clz2.getField());
		System.out.println();

		SuperClass clz3 = new SubClass();
		System.out.println(((SubClass)clz3).field);
		System.out.println(clz3.method());
		System.out.println(clz3.getField());
	}
}