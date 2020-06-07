package learning.java.practice.p20200512;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class Student3 {
	/**
	 * @param args
	 * @throws Exception
	 * @notes null
	 */
	public static void main(String[] args) throws Exception {
		// 添加List(class调用类型)
		List<Stu> allStudents = new ArrayList<Stu>();
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
		int stu1 = 0;
		int stu2 = 0;
		int stu3 = 0;
		List<Stu> stu001 = new ArrayList<Stu>();
		List<Stu> stu002 = new ArrayList<Stu>();
		List<Stu> stu003 = new ArrayList<Stu>();
		for (Stu stu : allStudents) {
			stu1 = stu1 + stu.getCh();
			stu2 = stu2 + stu.getMa();
			stu3 = stu3 + stu.getEn();
		}
		stu1 = stu1 / 7;
		stu2 = stu2 / 7;
		stu3 = stu3 / 7;
		Map<String, List<Stu>> kv = new HashMap<String, List<Stu>>();
		Map<String, Integer> kv2 = new HashMap<String, Integer>();
		for (Stu stu : allStudents) {
			if (stu.getCh() < stu1) {
				stu001.add(stu);
			}
		}
		kv.put("语文", stu001);
		kv2.put("语文", stu1);
		for (Stu stu : allStudents) {
			if (stu.getMa() < stu2) {
				stu002.add(stu);
			}
		}
		kv.put("数学", stu002);
		kv2.put("数学", stu2);
		for (Stu stu : allStudents) {
			if (stu.getEn() < stu3) {
				stu003.add(stu);
			}
		}
		kv.put("英语", stu002);
		kv2.put("英语", stu3);
		List<String> send = new ArrayList<String>();
		Set<String> keys = kv.keySet();
		for (String km : keys) {
			List<Stu> students = kv.get(km);
			for (Stu student : students) {
				send.add("家长【" + student.getPa() + "】您好，您的孩子【" + student.getNa() + "】在本次期末考试中，【" + km + "】获得"
						+ student.getCh() + "分，低于全班平均分" + kv2.get(km) + "分，希望您和学校一起加强对孩子学习的管理，提升他的学习成绩，谢谢。");
			}
		}

//		for (Stu student : stu001) {
//			// 获取语文成绩前3的学生
//			send.add("家长【" + student.getPa() + "】您好，您的孩子【" + student.getNa() + "】在本次期末考试中，【语文】获得" + student.getCh()
//					+ "分，低于全班平均分" + stu1 + "分，希望您和学校一起加强对孩子学习的管理，提升他的学习成绩，谢谢。");
//		}

		main(send);
	}

	public static void main(List<String> send) throws Exception {
		// 生产签名字符串
		for (int i = 0; i < send.size(); i++) {
			Long timestamp = System.currentTimeMillis();
			String secret = "SECcadf655ee189d182b619dce83a525dbef3449b9a1ff3dc44c1b01e8e0323918a";
			String stringToSign = timestamp + "\n" + secret;
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
			byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
			// 得到签名字符串
			String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
			// 要发送的数据
			String data = "{\r\n" + "     \"msgtype\": \"markdown\",\r\n" + "     \"markdown\": {\r\n"
					+ "         \"title\":\"💬\",\r\n" + "         \"text\": \"# " + send.get(i) + "\\n\"\r\n"
					+ "     },\r\n" + "      \"at\": {\r\n" + "          \"atMobiles\": [\r\n"
					+ "              \"150XXXXXXXX\"\r\n" + "          ],\r\n" + "          \"isAtAll\": false\r\n"
					+ "      }\r\n" + " }";
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
