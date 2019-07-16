package com.chryl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 重写增加自定义拦截器的注册，某一个拦截器需要先注册进来，才能工作
 * <p>
 * Created By Chr on 2019/7/16.
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    // 注册拦截器,注册才生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截的请求，并排除几个不拦截的请求
        registry.addInterceptor(new LoginInterceptor())//实例化
                .addPathPatterns("/**")//拦截哪些路径("/**":代表拦截所有路径)
                .excludePathPatterns(
                        //登陆页
                        "/index.html", "/", "/user/login/**",
                        //swagger
                        "/swagger-ui.html**", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**"
                );//不拦截哪些路径;
    }
}
