package com.taetaetae.hystrix.main;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MainService {

	private RestTemplate restTemplate;

	@HystrixCommand(
		fallbackMethod = "fallbackMethod",
		commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "100")
		})
	public String getResult(String key) {
		return restTemplate.getForObject("http://localhost:8080/target?key=" + key, String.class);
	}

	public String fallbackMethod(String key) {
		log.info("fallbackMethod, param : {}", key);
		return "defaultResult";
	}

	public MainService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
