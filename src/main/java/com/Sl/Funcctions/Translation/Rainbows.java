package com.Sl.Funcctions.Translation;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rainbows {
	final String url = "https://api.interpreter.caiyunai.com/v1/translator";

	public void doPost() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		HttpResponse response = null;
		Header[] header={

		};
		String Payload ="source: \""+""+"+\", trans_type: \"auto2zh\", request_id: \"web_fanyi\", media: \"text\"";
		//post.setHeaders(header);
		post.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.62");
		post.setHeader("X-Authorization","3975l6lr5pcbvidl6jl2 ");
		post.setHeader("content-type","application/json");
		post.setHeader("Referer","http://fanyi.caiyunapp.com/");
		StringEntity entity= null;
		entity = new StringEntity(Payload, ContentType.APPLICATION_JSON);
		post.setEntity(entity);
		try {
			response=httpClient.execute(post);
			HttpEntity Sentity= response.getEntity();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
