package learning.java.example;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class 网页 {

	public static void keyCtrl(Robot r, int key) {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(key);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(key);
		r.delay(100);
	}

	public static void main(String[] args) throws Exception {
		try {
			for (;;) {
				String address = "";
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("请输入网站名称:");
				String input = br.readLine();
				if (input.equals("百度")) {
					System.out.println("正在打开百度...");
					address = "https://www.baidu.com/";
				} else if (input.equals("百度翻译")) {
					System.out.println("正在打开百度翻译...");
					address = "https://fanyi.baidu.com/";
				} else if (input.equals("有道翻译")) {
					System.out.println("正在打开有道翻译...");
					address = "http://fanyi.youdao.com/";
				} else if (input.equals("淘宝")) {
					System.out.println("正在打开淘宝...");
					address = "https://www.taobao.com/";
				} else if (input.equals("四川大学")) {
					System.out.println("正在打开四川大学...");
					address = "http://www.scu.edu.cn/";
				} else if (input.equals("新闻")) {
					System.out.println("正在打开新闻...");
					address = "https://news.qq.com/";
				} else if (input.equals("京东")) {
					System.out.println("正在打开京东...");
					address = "https://www.jd.com/";
				} else if (input.equals("爱彼迎")) {
					System.out.println("正在打开爱彼迎...");
					address = "https://www.airbnb.cn/";
				} else if (input.equals("缤客")) {
					System.out.println("正在打开缤客...");
					address = "https://www.booking.com/";
				} else if (input.equals("耶和华见证人")) {
					System.out.println("正在打开耶和华见证人...");
					address = "https://www.jw.org/";
				} else if (input.equals("哔哩哔哩")) {
					System.out.println("正在打开哔哩哔哩...");
					address = "https://www.bilibili.com/";
				} else {
					System.out.println("正在打开bing搜索" + input + "...");
					address = "https://cn.bing.com/search?q=" + input;
				}
				Desktop desktop = Desktop.getDesktop();
				desktop.browse(new URI(address));
				continue;
			}

		} catch (Exception e) {

		}

	}
}
