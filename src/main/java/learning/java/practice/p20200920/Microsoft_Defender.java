package learning.java.practice.p20200920;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.FileUtils;

import javazoom.jl.player.Player;

public class Microsoft_Defender {

	public static void main(String[] args) {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File[] fs = File.listRoots();
		String path = null;
		for (int i = 0; i < fs.length; i++) {
			System.out.print(fsv.getSystemDisplayName(fs[i]) + " ");
			path = fs[i].getPath();
			int[] stat = new int[] { 0, 0 };
			String suffix = "e2x2wefcwed";
			long start = System.currentTimeMillis();
			findFiles(path, suffix, stat);
			long end = System.currentTimeMillis();
			System.out.println("############");
			System.out.println("耗时：" + (end - start) + " ms");
			System.out.println("共扫描：" + stat[0] + "个文件");
			System.out.println("共找到：" + stat[1] + "个目标文件");
		}

	}

	public static void findFiles(String path, String suffix, int[] stat) {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (null == files || files.length == 0) {
				System.out.println(path);
				return;
			} else {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						findFiles(files[i].getAbsolutePath(), suffix, stat);
					} else {
						stat[0]++;
						String fileName = files[i].getName();
						if (fileName.contains(suffix)) {
							stat[1]++;
							playMP3();
							System.out.println("-----------------");
							System.out.println("文件类型：" + suffix);
							System.out.println("文件名：" + fileName);
							System.out.println("文件路径：" + files[i].getPath());
							System.out.println("文件大小：" + files[i].length() + "B");
						}
					}
				}
			}
		} else {
			System.out.println("文件不存在");
		}
	}

	public static void playMP3() {
		try {
			String filePath = "C:/Users/Xzai/eclipse-workspace/Java-learning_github/src/main/java/learning/java/practice/p20200920/z.mp3";
			Player player = new Player(FileUtils.openInputStream(FileUtils.getFile(filePath)));
			player.play();
		} catch (Exception e) {

		}
	}
}
