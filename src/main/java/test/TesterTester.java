package test;

public class TesterTester {

	static {
		System.loadLibrary("tester");
	}
	
	
	public static void main(String[] args) {
		Tester t = new Tester();
		int value = t.rng();
		System.out.println("got value: " + value);
		t.printer();
	}

}
