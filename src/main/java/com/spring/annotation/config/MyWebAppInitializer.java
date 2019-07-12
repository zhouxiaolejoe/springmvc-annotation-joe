package com.spring.annotation.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * Web容器启动的时候创建对象：调用方法来初始化容器以及前端控制器
 *
 *
 *
 *
 *
 *
 *
 *
**/
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	* @Description  获取跟容器的配置类：(Spring的配置文件)：父容器
	* @Author ZhouXiaoLe
	* @Date  2019/6/4  13:58
	* @Param []
	* @return java.lang.Class<?>[]
	**/
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{RootConfig.class};
	}
	/**
	* @Description  获取Web容器的配置类（Spring MVC的配置文件）
	* @Author ZhouXiaoLe
	* @Date  2019/6/4  13:59
	* @Param []
	* @return java.lang.Class<?>[]
	**/
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{AppConfig.class};
	}
	/**
	* @Description  获取DispatcherServlet "/"拦截所有请求  包括静态资源
	* @Author ZhouXiaoLe
	* @Date  2019/6/4  13:59
	* @Param []
	* @return java.lang.String[]
	**/
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
