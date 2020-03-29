package com.taetaetae.hystrix.target;

import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TargetContoller {

	@GetMapping("/target")
	public String target(String key) {
		log.info("input key : {}", key);
		if (!StringUtils.equals("taetaetae", key)) {
			throw new RuntimeException("Invalid key");
		}
		return "ok";
	}
}
