package com.taetaetae.hystrix.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	private final MainService mainService;

	@GetMapping("index")
	public String index(String key){
		return mainService.getResult(key);
	}

	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
}
