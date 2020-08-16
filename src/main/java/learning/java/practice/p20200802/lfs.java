package learning.java.practice.p20200802;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class lfs {

	public static void main(String[] args) throws Exception {
		ArrayList<lfs_> lfs = new ArrayList<lfs_>();
		lfs_ m1 = new lfs_("张明", 35, "男");
		lfs_ m2 = new lfs_("王芳", 28, "女");
		lfs_ m3 = new lfs_("东东", 7, "男");
		lfs_ m4 = new lfs_("刘强", 56, "女");
		lfs_ m5 = new lfs_("陈帅", 47, "男");
		lfs.add(m1);
		lfs.add(m2);
		lfs.add(m3);
		lfs.add(m4);
		lfs.add(m5);
		int sj = 0;
		int q = 0;
		for (lfs_ lfs__ : lfs) {
			if (lfs__.nl >= 18 && lfs__.xb.equals("男")) {
				sj = sj + 30;
				q = q + 20;
			} else if (lfs__.nl >= 18 && lfs__.xb.equals("女")) {
				sj = sj + 65;
				q = q + 45;
			} else if (lfs__.nl < 18) {
				sj = sj + 30;
				q = q + 20;
			}
		}
		
		System.out.println("理发师已经工作了" + sj + "分钟 , 挣了" + q + "元 , 他在" + getTime(sj) + "下班 .");
	}

	public static String getTime(int mins) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = sdf.parse("09:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, mins);
		Date d = calendar.getTime();
		String textDate = sdf.format(d);
		return textDate;
	}
}
