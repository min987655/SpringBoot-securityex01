package com.cos.securityex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

	@GetMapping({"","/"})
	public @ResponseBody String index() {
		return "인덱스 페이지입니다.";
	}
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "유저 페이지입니다.";
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "어드민 페이지입니다.";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
