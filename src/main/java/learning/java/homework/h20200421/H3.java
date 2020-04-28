package learning.java.homework.h20200421;

public class H3 {

	public static void main(String[] args) {
		String ch = null;
		String str = "123 abc 编程";
		char[] cha = str(str);
		for (int i = 0; i < cha.length; i++) {
			System.out.println(cha[i]);
		}
	}

	public static char[] str(String str) {
		char[] ch = null;
		ch = str.toCharArray();
		return ch;
	}
}