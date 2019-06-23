package com.example.validation;

import com.example.validation.interfaces.BMBValidationStrategy;
import com.example.validation.interfaces.IValidationStrategy;
import com.example.validation.interfaces.WEBValidationStrategy;
import com.example.validation.model.BaseModel;
import com.example.validation.model.ChildClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;


/**
 *
 * Contains centralized configurations.
 *
 * At any point , to add new channel support,
 * Register Model bean (T extends BaseModel) that is going to be used for the channel.
 *
 * Register new validation strategy if required.(or use any existing)
 */
@Configuration
public class Configurations {

    @Bean("webStrategy")
    public IValidationStrategy getWEBValidationStrategy(){
        return new WEBValidationStrategy();
    }

    @Bean("bmbStrategy")
    public IValidationStrategy getBMBValidationStrategy(){
        return new BMBValidationStrategy();
    }

    @Bean("WEB")
    @RequestScope
    public BaseModel getWEBModel(){
        ChildClass childClass = new ChildClass();
        childClass.setValidation(getWEBValidationStrategy());
        return childClass;
    }


    @Bean("BMB")
    @RequestScope
    public BaseModel getBMBModel(){
        ChildClass childClass = new ChildClass();
        childClass.setValidation(getBMBValidationStrategy());
        return childClass;
    }

}
