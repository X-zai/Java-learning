package learning.java.homework.h20200421;

public class H3 {

	public static void main(String[] args) {
		char[] ch = null;
		char[] cha = str(ch);
		for (int i = 0; i < cha.length; i++) {
			System.out.println(cha[i]);
		}
	}

	public static char[] str(char[] ch) {
		String str = "123";
		for (int i = 0; i < str.length(); i++) {
			ch = str.toCharArray();
		}
		return ch;
	}
}