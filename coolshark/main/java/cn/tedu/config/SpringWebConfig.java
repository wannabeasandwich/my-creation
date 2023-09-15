package cn.tedu.config;

import cn.tedu.interceptor.TimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebConfig implements WebMvcConfigurer { //web.xml

    //配置MVC拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截路径
        registry.addInterceptor(new TimeInterceptor()).addPathPatterns("/user/login");
    }
}
