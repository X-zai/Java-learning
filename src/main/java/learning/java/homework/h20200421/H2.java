package learning.java.homework.h20200421;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class H2 {

	public static void main(String[] args) {
		int i = 0;
		List<Integer> li = new ArrayList<Integer>();
		li.add(88);
		li.add(18);
		li.add(25);
		li.add(39);
		li.add(77);
		li.add(89);
		int j = li(li);
		System.out.println(j);
	}

	public static int li(List<Integer> li) {
		int i = 0;
		li.sort(Comparator.reverseOrder());
		i=li.get(0);
		return i;
	}
}