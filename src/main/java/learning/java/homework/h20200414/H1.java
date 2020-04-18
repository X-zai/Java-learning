package learning.java.homework.h20200414;

import java.util.ArrayList;
import java.util.List;

public class H1 {
 
	public static void main(String[] args) {
		ArrayList<Integer> h001 = new ArrayList<Integer>();
		int i01 = 28;
		int i02 = 28;
		int i03 = 55;
		int i04 = 67;
		int i05 = 18;
		int i06 = 14;
		int i07 = 78;
		int i08 = 55;
		int i09 = 25;
		h001.add(i01);
		h001.add(i02);
		h001.add(i03);
		h001.add(i04);
		h001.add(i05);
		h001.add(i06);
		h001.add(i07);
		h001.add(i08);
		h001.add(i09);
		int i = pjz(h001);
		System.out.println(i);
	}

	public static int pjz(List<Integer> h001) {
		int pjz = 0;
		for (Integer i : h001) {
			pjz = pjz + i;
		}
		return pjz / h001.size();
	}
}
