/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.example;

import java.net.URLEncoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpVersion;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

/**
 * 带签名的发送钉钉机器人
 * 
 * @author Rayliu40k
 * @version $Id: Test.java, v 0.1 May 1, 2020 11:19:27 AM Rayliu40k Exp $
 */
public class 发送HTTP的JSON请求 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //生产签名字符串
        Long timestamp = System.currentTimeMillis();
        String secret = "SECd692da1c61058b5a715cc0e8f3681f01efdd75c3b78275a7e78af637a5f23466";
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        //得到签名字符串
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        //要发送的数据
        String data = "{\n" + "  \"msgtype\": \"text\",\n" + "  \"text\": {\n"
                      + "    \"content\": \"签名成功，哈哈哈111   \"\n" + "  },\n" + "  \"at\": {\n"
                      + "    \"atMobiles\": [\n" + "      \"156xxxx8827\",\n"
                      + "      \"189xxxx8325\"\n" + "    ],\n" + "    \"isAtAll\": false\n"
                      + "  }\n" + "}";
        //构建URL
        String uri = "https://oapi.dingtalk.com/robot/send?access_token=f5896bed709418fcaa5da249b63de95db4c1a7c8c7bdee9750e668791b7308e4"
                     + "&timestamp=" + timestamp + "&sign=" + sign;
        //发送给机器人
        String content = Request.Post(uri).useExpectContinue().version(HttpVersion.HTTP_1_1)
            .bodyString(data, ContentType.APPLICATION_JSON).execute().returnContent().asString();
        System.out.println(content);
    }
}
