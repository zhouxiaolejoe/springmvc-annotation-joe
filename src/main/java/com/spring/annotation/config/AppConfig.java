package com.spring.annotation.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilterable;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * @Description  Web只扫描Controller 子容器 禁用默认扫描规则useDefaultFilters = false
 * @Author ZhouXiaoLe
 * @Date  2019/6/4  14:07
 * @Param
 * @return
 **/
/**
* @Description  Web只扫描Controller 子容器 禁用默认扫描规则useDefaultFilters = false
* @Author ZhouXiaoLe
* @Date  2019/6/4  14:07
* @Param
* @return 
**/
@EnableWebMvc
@Configuration
@ComponentScan(value = {"com.spring.annotation"},includeFilters = {
		@Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)
public class AppConfig implements WebMvcConfigurer {
	@Autowired
	MyInterceptor interceptor;

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {

	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/**");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig jsonConfig = new FastJsonConfig();
		jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		//4.在convert中添加配置信息.
		converter.setSupportedMediaTypes(fastMediaTypes);
		converter.setFastJsonConfig(jsonConfig);
		//5.将convert添加到converters当中.
		converters.add(converter);
	}
}
