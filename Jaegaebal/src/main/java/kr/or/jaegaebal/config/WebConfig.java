package kr.or.jaegaebal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.or.jaegaebal.interceptor.CommonInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private CommonInterceptor commInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commInterceptor).addPathPatterns("/**").excludePathPatterns("/css/**");
	}
}
