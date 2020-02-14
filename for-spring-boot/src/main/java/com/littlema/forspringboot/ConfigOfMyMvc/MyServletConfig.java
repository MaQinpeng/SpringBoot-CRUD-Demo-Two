package com.littlema.forspringboot.ConfigOfMyMvc;


import com.littlema.forspringboot.filter.MyFilter;
import com.littlema.forspringboot.listener.MyListener;
import com.littlema.forspringboot.servlet.MyServlet;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyServletConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean<>(new MyServlet(),"/helloServlet");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<MyFilter> myFilter = new FilterRegistrationBean<>(new MyFilter());
        myFilter.setUrlPatterns(Arrays.asList("/helloServlet","/login"));
        return myFilter;
    }

    @Bean
    public FilterRegistrationBean encodingFilter(){
        FilterRegistrationBean<CharacterEncodingFilter> bean = new FilterRegistrationBean<>(new CharacterEncodingFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("encoding","UTF-8");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<EventListener> myListener = new ServletListenerRegistrationBean<>(new MyListener());
        return myListener;
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> myServletWebServerFactoryCustomizer(ServerProperties serverProperties) {
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>(){
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8888);
            }
        };
    }
}

















