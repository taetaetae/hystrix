package com.taetaetae.hystrix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplate retryableRestTemplate() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		clientHttpRequestFactory.setReadTimeout(500);
		clientHttpRequestFactory.setConnectTimeout(500);

		return new RestTemplate(clientHttpRequestFactory);
	}
}
