package com.gmail.rybachko.anna.taskfourth.mvc;

import com.gmail.rybachko.anna.taskfourth.service.EngineService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class MVCConfiguration implements WebMvcConfigurer {
    @Bean
    public Map<String, EngineService> stringEngineServiceMap(List<EngineService> engineServices) {
        return engineServices.stream()
                .collect(Collectors.toMap(EngineService::currentType, Function.identity()));
    }

    @Bean
    public ViewResolver viewResolver(ApplicationContext applicationContext) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setApplicationContext(applicationContext);
        springResourceTemplateResolver.setPrefix("classpath:/templates/");
        springResourceTemplateResolver.setSuffix(".html");

        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springResourceTemplateResolver);

        viewResolver.setTemplateEngine(springTemplateEngine);
        return viewResolver;
    }

}
