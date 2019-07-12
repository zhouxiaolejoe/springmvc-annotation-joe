package com.spring.annotation.controller;

import com.spring.annotation.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@Autowired
	HelloService helloService;
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		String hello = helloService.hello("nginx");
		return hello;
	}
	@RequestMapping("/suc")
	public String success(){
		return "index";
	}
}
