package com.example.validation.aspects;

import com.example.validation.factory.ModelFactory;
import com.example.validation.interfaces.IMappingInterface;
import com.example.validation.model.BaseModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * This aspect implements main validation of Model bean before it can continue
 * controller method execution.
 *
 * If validation fails, it will not execute Controller method.
 *
 */
@Aspect
@Component
public class ControllerAspect {

    @Autowired
    ModelFactory modelFactory;

    @Autowired
    IMappingInterface iMappingInterface;

    @Around("execution(* com.example.validation.controller.DemoController.*(..))")
    public void beforeController(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        Map<String, String> parameters = (Map<String, String>) args[1];
        String channel = (String) args[0];
        args[2] = modelFactory.getModel(channel);
        BaseModel baseModel = iMappingInterface.mapModel((BaseModel)args[2], parameters);
        baseModel.setChannel(channel);
        if(baseModel.getValidation().isValid(baseModel)){
            joinPoint.proceed();
        }
        else{
            System.out.println("Can't proceed . Errors in validation.");
            return;
        }

    }
}
