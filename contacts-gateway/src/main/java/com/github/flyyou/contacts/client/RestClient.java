package com.github.flyyou.contacts.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	
	@Autowired
	private RestTemplate restTemplate;
	
	private Map<String, String> params;
	private String url;
	private String result;
	
	/**
	 * @param params
	 * @param url
	 */
	public RestClient(String url, Map<String, String> params) {
		super();
		this.url = url;
		this.params = params;
	}
	
	/**
	 * 
	 */
	public RestClient() {
		super();
	}

	public String call(){
		System.out.println(url);
		System.out.println(params.size());
		
		try{
			result = restTemplate.getForObject(url, String.class, params);
		} catch (Exception e){
			e.printStackTrace();
		}
		return result;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		
		String url = "http://openapi.naver.com/search?key={key}&query={query}&target={target}";
		
		Map<String, String> reqParams = new HashMap<String, String>();
		reqParams.put("key", "23e45d3e89384fk0484j8k84k484k48kldf9");
		reqParams.put("query", "액션");
		reqParams.put("target", "movie");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		RestTemplate client = (RestTemplate) context.getBean("restTemplate"); 
		//RestClient client = (RestClient) context.getBean("restClient");
		//RestClient client = new RestClient(url, reqParams);
		
		//String result = client.call();
		String result = client.getForObject(url, String.class, reqParams);
		
		System.out.println(result);

	}

}
