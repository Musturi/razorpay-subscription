package com.lybl.razorpay.subscription.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class BasicAuthProvider {

	@Autowired
	private Environment env;

	public HttpEntity<String> enableBasicAuth() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBasicAuth(env.getProperty("razorpay.keyid"), env.getProperty("razorpay.keysecret"));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}
	
	public HttpEntity<String> enableBasicAuth(String body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBasicAuth(env.getProperty("razorpay.keyid"), env.getProperty("razorpay.keysecret"));
		HttpEntity<String> entity = new HttpEntity<String>(body, headers);
		return entity;
	}

}
