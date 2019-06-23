package com.example.validation;

import com.example.validation.resolvers.CustomArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class ValidationApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ValidationApplication.class, args);
    }


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CustomArgumentResolver());
    }


}
