package com.trabajo_dirigido.dirigido;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DirigidoConfig implements WebMvcConfigurer {
    public void addViewControllers ( ViewControllerRegistry registry ) {
        //Define routes to simple views
        registry.addViewController("/").setViewName("redirect:/index.jsp");
    }

}
