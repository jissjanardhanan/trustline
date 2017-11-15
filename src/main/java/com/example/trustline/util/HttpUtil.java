package com.example.trustline.util;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {
	
	private static Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);
	
	public static int post(String user,int amount,String port) throws IOException {
		int statusCode = -1;
		CloseableHttpClient client = HttpClients.createDefault();
		String url = "http://localhost:"+port+"/trustapp/"+amount+"/receive?user="+user;
		LOGGER.info("Calling "+ url);
		HttpPost req = new HttpPost(url);
		CloseableHttpResponse response;
		try {
			response = client.execute(req);
			statusCode = response.getStatusLine().getStatusCode();
		} catch (IOException e) {
			LOGGER.error("Unable to connect to "+user);
		}finally{
			client.close();
		}
		return statusCode;
	}
	
}
