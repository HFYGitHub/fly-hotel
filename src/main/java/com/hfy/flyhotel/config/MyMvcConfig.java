package com.hfy.flyhotel.config;

import com.hfy.flyhotel.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index.html").setViewName("dashboard");
                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/register.html").setViewName("register");


            }
        };

        return configurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/**").addResourceLocations("file:D:\\IDEAwork\\fly-hotel\\src\\main\\resources\\static\\images\\");
        registry.addResourceHandler("/static/images/**").addResourceLocations("file:D:\\IDEAwork\\fly-hotel\\src\\main\\resources\\static\\images\\");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }







}
