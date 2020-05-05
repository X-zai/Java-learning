/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.example;

import org.apache.http.HttpVersion;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

/**
 * 
 * @author Rayliu40k
 * @version $Id: Test.java, v 0.1 May 1, 2020 11:19:27 AM Rayliu40k Exp $
 */
public class 发送HTTP的JSON请求 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			try {
				String json = "{\n" + "  \"msgtype\": \"text\",\n" + "  \"text\": {\n" + "    \"content\": \"java\"\n"
						+ "  },\n" + "  \"at\": {\n" + "    \"atMobiles\": [\n" + "      \"156xxxx8827\",\n"
						+ "      \"189xxxx8325\"\n" + "    ],\n" + "    \"isAtAll\": false\n" + "  }\n" + "}";
				Request.Post(
						"https://oapi.dingtalk.com/robot/send?access_token=f5896bed709418fcaa5da249b63de95db4c1a7c8c7bdee9750e668791b7308e4")
						.useExpectContinue().version(HttpVersion.HTTP_1_1)
						.bodyString(json, ContentType.APPLICATION_JSON).execute().returnContent().asBytes();
				Thread.sleep(1 * 1000 * 60 * 10);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
