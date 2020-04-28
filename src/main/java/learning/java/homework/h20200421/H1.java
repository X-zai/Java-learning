package learning.java.homework.h20200421;

public class H1 {

	public static void main(String[] args) {
		String str = "";
		String print = str(str);
		System.out.println(print);
	}

	public static String str(String str) {
		int i = 3;
		for (int j = 0; j < i; j++) {
			str += "Hello world\n";
		}
		return str;
	}
}
