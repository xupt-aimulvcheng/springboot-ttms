package com.xupt.ttms.config;

import com.xupt.ttms.interceptor.LoginInterceptor;
import com.xupt.ttms.interceptor.RedisInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class UserConfig implements WebMvcConfigurer {
    @Resource
    private RedisInterceptor redisInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")      //拦截请求
                .excludePathPatterns("/","/user/login","/register","/forget-pw","/user/checkUserName/{username}","/user/register","/user/forgetPassword","/main/**","/captcha","/captchaCommon"); //放行请求
        registry.addInterceptor(redisInterceptor)
                .addPathPatterns("/**");
    }
}
