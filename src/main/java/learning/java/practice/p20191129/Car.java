package learning.java.practice.p20191129;

import org.apache.commons.io.FileUtils;

import javazoom.jl.player.Player;

public class Car {
	private int km;

	public Car(int km) throws Exception {
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
		this.km = km;
	}

	public void carOpen() throws Exception {
		Thread.sleep(4095);
		String filePath = "c:/Users/小仔/eclipse-workspace/java-learning/src/main/java/learning/java/example/汽车启动的声音_爱给网_aigei_com.mp3";
		Player player = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath)));
		System.out.println(this.km + "km/h");
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
		for (;;) {
			if (this.km == 20 || this.km <= 115) {
				for (int i = 0; i <= 19; i++) {
					this.km = this.km + 5;
					System.out.println(this.km + "km/h");
					Thread.sleep(500);
					continue;
				}

			} else if (this.km == 115 || this.km >= 20) {
				for (int i = 19; i >= 0; i--) {
					this.km = this.km - 5;
					System.out.println(this.km + "km/h");
					Thread.sleep(500);
					continue;
				}
			}
			if (this.km == 20) {
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
			} else if (this.km == 120) {
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

	public static void main(String[] args) throws Exception {
		Car car = new Car(20);
		car.carOpen();
		car.carDriveing();
	}
}