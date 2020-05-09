package learning.java.example;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.net.URLEncoder;

public class Test {
	public static void main(String[] args) throws Exception {
		Long timestamp = System.currentTimeMillis();
		String secret = "SECb3bd9abf9f7aeb19b68e5bd37ce8504ea6a62507e873ac8fbd5649e8e1adaf8c";

		String stringToSign = timestamp + "\n" + secret;
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
		byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
		String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
		System.out.println(sign);
	}

}