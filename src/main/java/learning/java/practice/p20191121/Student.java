package learning.java.practice.p20191121;

public class Student {
	private String xingming;
	private String xingbie;
	private int nianling;
	private double shengao;
	private double tizhong;

	public Student(String xingming, String xingbie, int nianling, double shengao, double tizhong) {
		this.xingming = xingming;
		this.xingbie = xingbie;
		this.nianling = nianling;
		this.shengao = shengao;
		this.tizhong = tizhong;
	}

	public void eat() throws Exception {
		if (this.nianling < 10) {
			System.out.println("准备吃1碗饭...");
			Thread.sleep(3000);
			for (int i = 1; i <= 1; i++) {
				System.out.println("正在吃第" + i + "碗饭");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		} else if (this.nianling >= 10 && this.nianling < 20) {
			System.out.println("准备吃2碗饭...");
			Thread.sleep(3000);
			for (int i = 1; i <= 2; i++) {
				System.out.println("正在吃第" + i + "碗饭");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else if (this.nianling >= 20) {
			System.out.println("准备吃3碗饭...");
			Thread.sleep(3000);
			for (int i = 1; i <= 3; i++) {
				System.out.println("正在吃第" + i + "碗饭");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		System.out.println("吃饭完成!!!");
		Thread.sleep(3000);
	}

	public void sleep() throws Exception {
		System.out.println("姓名:" + this.xingming);
		System.out.println("性别:" + this.xingbie);
		System.out.println("年龄:" + this.nianling + "岁");
		System.out.println("身高:" + this.shengao + "米");
		System.out.println("体重:" + this.tizhong + "公斤");
		Thread.sleep(3000);
		System.out.println("准备睡觉...");
		Thread.sleep(3000);
		if (this.nianling < 10) {
			for (int i = 1; i <= 12; i++) {
				System.out.println("正在睡觉...");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("起床了...");
			System.out.println("一共睡了12个小时");
			Thread.sleep(3000);
		} else if (this.nianling >= 10 && this.nianling < 20) {
			for (int i = 1; i <= 10; i++) {
				System.out.println("正在睡觉...");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("起床了...");
			System.out.println("一共睡了10个小时");
			Thread.sleep(3000);
		} else if (this.nianling >= 20) {
			for (int i = 1; i <= 8; i++) {
				System.out.println("正在睡觉...");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("起床了...");
			System.out.println("一共睡了8个小时");
			Thread.sleep(3000);
		}
	}

	public void going() throws Exception {
		System.out.println("准备上学...");
		Thread.sleep(3000);
		if (this.nianling < 12) {
			for (int i = 5; i <= 25; i = i + 5) {
				System.out.println("大概走了" + i + "公里");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("到小学了");
			System.out.println("一共走了25个公里");
			Thread.sleep(3000);
		} else if (this.nianling >= 12 && this.nianling < 15) {
			for (int i = 5; i <= 30; i = i + 5) {
				System.out.println("大概走了" + i + "公里");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("到初中了");
			System.out.println("一共走了30个公里");
			Thread.sleep(3000);
		} else if (this.nianling >= 15 && this.nianling < 18) {
			for (int i = 5; i <= 35; i = i + 5) {
				System.out.println("大概走了" + i + "公里");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("到高中了");
			System.out.println("一共走了35个公里");
			Thread.sleep(3000);
		} else {
			for (int i = 5; i <= 40; i = i + 5) {
				System.out.println("大概走了" + i + "公里");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("到大学了");
			System.out.println("一共走了40个公里");
			Thread.sleep(3000);
		}
	}

	public static void main(String[] args) throws Exception {
		Student r1 = new Student("小仔", "♂", 10, 1.32, 24.7);
		r1.sleep();
		r1.eat();
		r1.going();
		Student r2 = new Student("A老婆", "♀", 33, 1.58, 51.3);
		r2.sleep();
		r2.eat();
		r2.going();
	}
}
