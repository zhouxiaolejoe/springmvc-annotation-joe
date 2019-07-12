package com.spring.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
/**
* @Description  Spring 不扫描Controller 父容器
* @Author ZhouXiaoLe
* @Date  2019/6/4  14:05
* @Param
* @return
**/
@Configuration
@ComponentScan(value = {"com.spring.annotation"},excludeFilters = {
		@Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class RootConfig {

}
