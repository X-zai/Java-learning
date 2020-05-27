package learning.java.practice.p20200512;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpVersion;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

/**
 *
 * @author Xzai
 *
 */
public class Student {
	/**
	 * @param args
	 * @throws Exception 
	 * @notes null
	 */
	public static void main(String[] args) throws Exception {
		// 添加List(class调用类型)
		List<Stu> allStudents = new ArrayList<Stu>();// TODO
		// 把参数传到Stu的文件里
		Stu student01 = new Stu("小王", 89, 90, 91, "王芳");
		Stu student02 = new Stu("小李", 65, 88, 83, "李海");
		Stu student03 = new Stu("小宋", 78, 65, 89, "宋阳");
		Stu student04 = new Stu("小明", 93, 88, 92, "张大明");
		Stu student05 = new Stu("小芳", 67, 87, 76, "夏芳");
		Stu student06 = new Stu("小秦", 85, 95, 80, "秦岚");
		Stu student07 = new Stu("小刘", 90, 90, 86, "刘东");
		// 把Stu文件里的参数添加到allStudents
		allStudents.add(student01);
		allStudents.add(student02);
		allStudents.add(student03);
		allStudents.add(student04);
		allStudents.add(student05);
		allStudents.add(student06);
		allStudents.add(student07);
		// 调用方法+传参数
		student(allStudents);
	}

	/**
	 * @param null
	 * @throws Exception 
	 * @notes null
	 */
	private static void student(List<Stu> allStudents) throws Exception {
		// 添加List(integer类型)
		List<Integer> chinese = new ArrayList<Integer>();
		// for循环
		for (Stu stu : allStudents) {
			// stu里的Ch循环添加到chinese里
			chinese.add(stu.getCh());
		}
		// 把chinese排成倒序以便找前3个人
		chinese.sort(Comparator.reverseOrder());
		String[] top = new String[3];
		for (Stu stu : allStudents) {
			if (stu.getCh() == chinese.get(0)) {
				top[0] = "# 家长【" + stu.getPa() + "】您好，您的孩子【" + stu.getNa() + "】在本次期末考试中，【语文】获得" + stu.getCh()
						+ "分，排名全班第【1】，恭喜您。";
			} else if (stu.getCh() == chinese.get(1)) {
				top[1] = "# 家长【" + stu.getPa() + "】您好，您的孩子【" + stu.getNa() + "】在本次期末考试中，【语文】获得" + stu.getCh()
						+ "分，排名全班第【2】，恭喜您。";
			} else if (stu.getCh() == chinese.get(2)) {
				top[2] = "# 家长【" + stu.getPa() + "】您好，您的孩子【" + stu.getNa() + "】在本次期末考试中，【语文】获得" + stu.getCh()
						+ "分，排名全班第【3】，恭喜您。";
			}
		}
		// 打印chinese
		System.out.println("[" + chinese.get(0) + ", " + chinese.get(1) + ", " + chinese.get(2) + "] | " + chinese);
		sendMsg(top);
	}

	private static void sendMsg(String[] top) throws Exception {
		for (int i = 0; i < top.length; i++) {
			// 生产签名字符串
			Long timestamp = System.currentTimeMillis();
			String secret = "SECcadf655ee189d182b619dce83a525dbef3449b9a1ff3dc44c1b01e8e0323918a";
			String stringToSign = timestamp + "\n" + secret;
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
			byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
			// 得到签名字符串
			String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
			// 要发送的数据
			String data = "{\r\n" + 
					"     \"msgtype\": \"markdown\",\r\n" + 
					"     \"markdown\": {\r\n" + 
					"         \"title\":\"💬\",\r\n" + 
					"         \"text\": \""+ top[i]+ "\\n\"\r\n" + 
					"     },\r\n" + 
					"      \"at\": {\r\n" + 
					"          \"atMobiles\": [\r\n" + 
					"              \"150XXXXXXXX\"\r\n" + 
					"          ],\r\n" + 
					"          \"isAtAll\": false\r\n" + 
					"      }\r\n" + 
					" }";
			// 构建URL
			String uri = "https://oapi.dingtalk.com/robot/send?access_token=f5896bed709418fcaa5da249b63de95db4c1a7c8c7bdee9750e668791b7308e4"
					+ "&timestamp=" + timestamp + "&sign=" + sign;
			// 发送给机器人
			String content = Request.Post(uri).useExpectContinue().version(HttpVersion.HTTP_1_1)
					.bodyString(data, ContentType.APPLICATION_JSON).execute().returnContent().asString();
			System.out.println(content);
		}
	}
}
