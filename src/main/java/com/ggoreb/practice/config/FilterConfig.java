package com.ggoreb.practice.config;

import com.ggoreb.practice.filter.SignInCheckFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean<Filter> getFilterRegistrationBean() {
//        FilterRegistrationBean<Filter> bean =
//                new FilterRegistrationBean<>(new SignInCheckFilter());
//        bean.addUrlPatterns("/question/create");
//        return bean;
//    }
}
