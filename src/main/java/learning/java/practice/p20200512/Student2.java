package learning.java.practice.p20200512;

import java.io.ObjectInputStream.GetField;
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

import learning.java.practice.p20200512.ray.Student;

/**
 * 
 * @author Xzai
 *
 */
public class Student2 {
	/**
	 * @param args
	 * @throws Exception
	 * @notes null
	 */
	public static void main(String[] args) throws Exception {
		// 准备数据
		List<Student> students = new ArrayList<Student>();
		Student student01 = new Student("小王", "王芳", 89, 90, 91);
		Student student02 = new Student("小李", "李海", 65, 88, 83);
		Student student03 = new Student("小宋", "宋阳", 78, 65, 89);
		Student student04 = new Student("小明", "张大明", 93, 88, 92);
		Student student05 = new Student("小芳", "夏芳", 67, 87, 76);
		Student student06 = new Student("小秦", "秦岚", 85, 95, 80);
		Student student07 = new Student("小刘", "刘东", 90, 90, 86);
		students.add(student01);
		students.add(student02);
		students.add(student03);
		students.add(student04);
		students.add(student05);
		students.add(student06);
		students.add(student07);

		top3InCourses(students);
	}

	/**
	 * 找出单科成绩最高的前3名，并发送钉钉消息给他的家长
	 * 
	 * @param students 所有学生
	 * @throws Exception
	 */
	public static void top3InCourses(List<Student> students) throws Exception {
		List<Integer> allChineseScore = new ArrayList<>();
		for (Student student : students) {
			allChineseScore.add(student.getChineseScore());
		}
		allChineseScore.sort(Comparator.reverseOrder());
		List<Integer> top3ChineseScore = allChineseScore.subList(0, 3);
		System.out.println(top3ChineseScore);

		List<Student> top3ChineseScoreStudents = new ArrayList<Student>();
		for (Student student : students) {
			if (top3ChineseScore.contains(student.getChineseScore())) {
				top3ChineseScoreStudents.add(student);
			}
		}
		top3ChineseScoreStudents.sort(Comparator.comparing(Student::getChineseScore).reversed());

		top3ChineseScoreStudents.forEach(student -> {
			System.out.println("-----");
			System.out.println(student.getName());
			System.out.println(student.getChineseScore());
			System.out.println(student.getParent());
		});

		int rank = 0;
		for (Student student : top3ChineseScoreStudents) {
			rank++;
			// 生产签名字符串
			String xxx = "家长【" + student.getParent() + "】您好，您的孩子【" + student.getName() + "】在本次期末考试中，【语文】获得"
					+ student.getChineseScore() + "分，排名全班第【" + rank + "】，恭喜您。";
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
					+ "         \"title\":\"💬\",\r\n" + "         \"text\": \"" + xxx + "\\n\"\r\n" + "     },\r\n"
					+ "      \"at\": {\r\n" + "          \"atMobiles\": [\r\n" + "              \"150XXXXXXXX\"\r\n"
					+ "          ],\r\n" + "          \"isAtAll\": false\r\n" + "      }\r\n" + " }";
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
