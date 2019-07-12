package com.spring.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
public class AsyncController {
	@ResponseBody
	@RequestMapping("/async")
	public Callable<String> async(){

		System.err.println("主线程开始"+Thread.currentThread()+"时间:"+System.currentTimeMillis());


		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.err.println("副线程开始"+Thread.currentThread()+"时间:"+System.currentTimeMillis());
				Thread.sleep(2000);
				System.err.println(1/0);
				System.err.println("副线程结束"+Thread.currentThread()+"时间:"+System.currentTimeMillis());
				return " Callable<String> async";
			}
		};
		System.err.println("主线程结束"+Thread.currentThread()+"时间:"+System.currentTimeMillis());

		return callable;
	}
}
