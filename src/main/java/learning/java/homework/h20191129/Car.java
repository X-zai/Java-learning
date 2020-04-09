package learning.java.homework.h20191129;

import org.apache.commons.io.FileUtils;

import javazoom.jl.player.Player;

public class Car {
	private long startTime;
	private int kmh;
	private int km;

	public Car(int kmh) throws Exception {
		new Thread(() -> {
			for (;;) {
				try {
					String filePath = "c:/Users/小仔/eclipse-workspace/java-learning/src/main/java/learning/java/example/Ari Pulkkinen - Title Theme.mp3";
					Player player = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath)));
					player.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		this.kmh = kmh;
	}

	public void carOpen() throws Exception {
		this.startTime = System.currentTimeMillis();
		Thread.sleep(4095);
		String filePath = "c:/Users/小仔/eclipse-workspace/java-learning/src/main/java/learning/java/example/汽车启动的声音_爱给网_aigei_com.mp3";
		Player player = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath)));
		System.out.println(this.kmh + "km/h");
		player.play();
		new Thread(() -> {
			for (;;) {
				try {
					String filePath1 = "c:/Users/小仔/eclipse-workspace/java-learning/src/main/java/learning/java/example/100022_爱给网_aigei_com.mp3";
					Player player1 = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath1)));
					player1.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void carDriveing() throws Exception {
		this.carStop();
		for (;;) {
			if (this.kmh == 20 || this.kmh <= 115) {
				for (int i = 0; i <= 19; i++) {
					this.kmh = this.kmh + 1;
					System.out.println(this.kmh + "km/h");
					Thread.sleep(500);
					continue;
				}

			} else if (this.kmh == 115 || this.kmh >= 20) {
				for (int i = 19; i >= 0; i--) {
					this.kmh = this.kmh - 1;
					System.out.println(this.kmh + "km/h");
					Thread.sleep(500);
					continue;
				}

			}
			if (this.kmh == 20) {
				String filePath = "c:/Users/小仔/eclipse-workspace/java-learning/src/main/java/learning/java/example/20_爱给网_aigei_com.mp3";
				Player player = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath)));
				System.out.println("速度过慢!!!");
				new Thread(() -> {
					try {
						player.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}).start();
			} else if (this.kmh == 120) {
				String filePath = "c:/Users/小仔/eclipse-workspace/java-learning/src/main/java/learning/java/example/20_爱给网_aigei_com.mp3";
				Player player = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath)));
				System.out.println("速度过快!!!");
				new Thread(() -> {
					try {
						player.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}).start();
			}
		}
	}

	public void carStop() throws Exception {
		new Thread(() -> {
			long totalDistance = 0;
			while (true) {
				try {
					// 5s计算一次距离
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				long stopTime = System.currentTimeMillis();
				long time = stopTime - this.startTime;
				long currentDistance = (time / 1000) * this.kmh;
				totalDistance = totalDistance + currentDistance;
				System.out.println("当前行驶距离：" + totalDistance);
				if (totalDistance >= 10000) {
					System.out.println("终于到家了");
					System.exit(0);
				}
			}
		}).start();
	}

	public static void main(String[] args) throws Exception {
		Car car = new Car(20);
		car.carOpen();
		car.carDriveing();
	}
}