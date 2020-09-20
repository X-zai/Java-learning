package learning.java.practice.p20200920;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

public class Microsoft_Defender {

	public static void main(String[] args) {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File[] fs = File.listRoots();
		for (int i = 0; i < fs.length; i++) {
			System.out.print(fsv.getSystemDisplayName(fs[i]) + " ");
		}
	}
}
