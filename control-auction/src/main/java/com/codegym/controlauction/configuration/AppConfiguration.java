package com.codegym.controlauction.configuration;

import com.codegym.controlauction.formatter.ProductTypeFormatter;
import com.codegym.controlauction.service.IProductTypeService;
import com.codegym.controlauction.service.impl.ProductTypeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.codegym")
public class AppConfiguration implements WebMvcConfigurer {

    @Bean
    public IProductTypeService productTypeService() {
        return new ProductTypeService();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new ProductTypeFormatter(productTypeService()));
    }

    // *** THÊM ViewResolver cho JSP ***
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(1);
        return resolver;
    }

    // (Tùy chọn) Nếu có static file (css/js/img)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
