package com.cos.securityex01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {

	@GetMapping({"","/"})
	public String index() {
		return "인덱스 페이지입니다.";
	}
}
