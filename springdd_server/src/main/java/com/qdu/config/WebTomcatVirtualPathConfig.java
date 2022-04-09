package com.qdu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebTomcatVirtualPathConfig implements WebMvcConfigurer {
    @Value("${tomcat.virtual.path}")
    private String resourceHandler;

    @Value("${basePath}")
    private String resourceLocations;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourceHandler).addResourceLocations("file:///" + resourceLocations + "/");
    }

}
