package com.Sl.Funcctions;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
public class Random {
	/**
	 * url1 随机剧情开篇
	 * url2 一个段落
	 * url3 人物性格
	 *
	 */
	final String url1 = "https://story-shack-cdn-v2.glitch.me/generators/plot-generator";
	final String url2 = "https://story-shack-cdn-v2.glitch.me/generators/random-paragraph-generator";
	final String url3 = "https://story-shack-cdn-v2.glitch.me/generators/character-personality-generator";
	public void doGet(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = null;
		get.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.62");
		try {
			response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			System.out.println(EntityUtils.toString(entity));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
