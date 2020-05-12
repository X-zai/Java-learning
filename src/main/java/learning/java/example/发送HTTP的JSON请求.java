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
        String data = "{\n" + 
        		"     \"msgtype\": \"markdown\",\n" + 
        		"     \"markdown\": {\n" + 
        		"         \"title\":\"💬\",\n" + 
        		"         \"text\": \"# 来自黑客帝国的短信 ![哈哈哈](https://images.cnblogs.com/cnblogs_com/Frank99/1215494/o_%e8%83%8c%e6%99%af5.gif)"
        		+ "@所有人 《黑客帝国》\n" + 
        		"在矩阵中生活的一名年轻的网络黑客尼奥（基努·里维斯饰）发现，看似正常的现实世界实际上似乎被某种力量控制着，尼奥便在网络上调查此事。而在现实中生活的人类反抗组织的船长墨菲斯（劳伦斯·菲什伯恩饰）， 也一直在矩阵中寻找传说的救世主，就这样在人类反抗组织成员崔妮蒂（凯莉·安·摩丝饰）的指引下，两人见面了，尼奥也在墨菲斯的指引下，回到了真正的现实中，逃离了矩阵，这才了解到，原来他一直活在虚拟世界当中 [5]  。\n" + 
        		"《黑客帝国2：重装上阵》\n" + 
        		"实际上，整个《重装上阵》是尼奥探寻自己使命背后真相的过程，他要为自\n" + 
        		"黑客帝国\n" + 
        		"黑客帝国(2张)\n" + 
        		" 己的行动寻找一个可以接受的理由。在上集打败史密斯（雨果·维文饰）、救出墨菲斯之后，尼奥随同亲密爱人崔妮蒂和其他战友一起，乘坐Nebuchadnezzar号飞船返回地球上最后一个人类据点——锡安基地。在那里，他们和其他自由战士们聚集到了一起。就在这时，母体系统决定“先下手为强”，派遣了为数250000的电子乌贼大军，开始进攻锡安基地，微弱的基地防守力量根本不足以对抗如此强大的机甲兵团，看来人类最后的香火也岌岌可危。可是，“母体取经”的道路注定是凶险多端的：在寻找母体系统内唯一知道系统弱点的“制钥者”的过程中，尼奥、墨菲斯和崔妮蒂遇到了前所未有的困难 [5]  。\n" + 
        		"《黑客帝国3：矩阵革命》\n" + 
        		"在《黑客帝国》系列电影最后一集中，延续上集《黑客帝国2：重装上阵》的故事，并揭晓机器与人类的最终命运。面对如潮的电子乌贼，人类城市危在旦夕，墨菲斯和崔妮蒂等欲与入侵者决一死战。此时，“救世主”尼奥的身体和思想却意外分离，后者再度陷入到“母体”中。墨菲斯和崔妮蒂也不得不回到“母体”和守护天使一起寻找他。\n" + 
        		"最后，在和机器的谈判中，机器答应为了人类和机器的共同利益，尼奥去消灭史密斯，而机器不再摧毁锡安。人类迎来新的和平 [5]  。\n```" + 
        		"\n" + 
        		"\\n\"\n" + 
        		"     },\n" + 
        		"      \"at\": {\n" + 
        		"          \"atMobiles\": [\n" + 
        		"              \"150XXXXXXXX\"\n" + 
        		"          ],\n" + 
        		"          \"isAtAll\": false\n" + 
        		"      }\n" + 
        		" }";
        //构建URL
        String uri = "https://oapi.dingtalk.com/robot/send?access_token=f5896bed709418fcaa5da249b63de95db4c1a7c8c7bdee9750e668791b7308e4"
                     + "&timestamp=" + timestamp + "&sign=" + sign;
        //发送给机器人
        String content = Request.Post(uri).useExpectContinue().version(HttpVersion.HTTP_1_1)
            .bodyString(data, ContentType.APPLICATION_JSON).execute().returnContent().asString();
        System.out.println(content);
    }
}
