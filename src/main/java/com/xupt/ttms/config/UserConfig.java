package com.xupt.ttms.config;

import com.xupt.ttms.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")      //拦截请求
                .excludePathPatterns("/","/user/login","/register","/forget-pw","/user/checkUserName/{username}","/user/register","/user/forgetPassword","/main/**","/captcha","/captchaCommon"); //放行请求
    }
}
