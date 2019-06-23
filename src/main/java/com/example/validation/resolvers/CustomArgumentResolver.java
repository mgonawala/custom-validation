package com.example.validation.resolvers;

import com.example.validation.factory.ModelFactory;
import com.example.validation.model.BaseModel;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 *
 * Used to resolve BaseModel parameter of DemoController Class.
 * Whole purpose is to inject hierarchy of BaseModel objects based on channel used.
 *
 * EX. if Channel is WEB, appropriate sub class used for WEB channel should be instantiated
 * & mapping of request body should be done accordingly.
 *
 * This is non-spring managed bean.
 * Hence to make use of ModelFactory spring-managed bean, it implements ApplicationContextAware
 *
 */
@Component
public class CustomArgumentResolver implements HandlerMethodArgumentResolver , ApplicationContextAware {

    ModelFactory modelFactory;

   static  ApplicationContext applicationContext;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getGenericParameterType().equals(BaseModel.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String channel = ((ServletWebRequest) webRequest).getRequest().getRequestURI().toString();
        String[] split = channel.split("/");
        ModelFactory modelFactory = (ModelFactory) applicationContext.getBean("modelFactory");
        if( split.length == 3){
            channel = split[2];
            return modelFactory.getModel(channel);
        }
        return null;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
