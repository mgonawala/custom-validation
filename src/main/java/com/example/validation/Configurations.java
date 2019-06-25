package com.example.validation;

import com.example.validation.interfaces.*;
import com.example.validation.model.BaseModel;
import com.example.validation.model.ChildClass;
import com.example.validation.model.FBModel;
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
        IValidationStrategy strategy = new WEBValidationStrategy();
        strategy.getRules().add(mandatoryRule());
        return  strategy;
    }

    @Bean("bmbStrategy")
    public IValidationStrategy getBMBValidationStrategy(){
        IValidationStrategy strategy = new WEBValidationStrategy();
        strategy.getRules().add(mandatoryRule());
        return  strategy;
    }

    @Bean("fbStrategy")
    public IValidationStrategy getFBValidationStrategy(){
        IValidationStrategy strategy = new WEBValidationStrategy();
        strategy.getRules().add(mandatoryRule());
        return  strategy;
    }

    @Bean("WEB")
    public BaseModel getWEBModel(){
        ChildClass childClass = new ChildClass();
        childClass.setValidation(getWEBValidationStrategy());
        return childClass;
    }


    @Bean("BMB")
    public BaseModel getBMBModel(){
        ChildClass childClass = new ChildClass();
        childClass.setValidation(getBMBValidationStrategy());
        return childClass;
    }

    @Bean("FB")
    public BaseModel getFbModel(){
        BaseModel fbModel = new FBModel();
        fbModel.setValidation(getBMBValidationStrategy());
        return fbModel;
    }

    @Bean("WA")
    public BaseModel getWModel(){
        BaseModel fbModel = new FBModel();
        fbModel.setValidation(getBMBValidationStrategy());
        return fbModel;
    }
    /*@Bean
    public IRule web_mandatory(){
        MandatoryRule rule = new MandatoryRule();
        rule.getMandatoryFields().add("firstName");
        rule.getMandatoryFields().add("lastName");
        rule.getMandatoryFields().add("email");
        return  rule;
    }

    @Bean
    public IRule bmb_mandatory(){
        MandatoryRule rule = new MandatoryRule();
        rule.getMandatoryFields().add("firstName");
        rule.getMandatoryFields().add("lastName");
        return  rule;
    }

    @Bean
    public IRule fb_mandatory(){
        MandatoryRule rule = new MandatoryRule();
        rule.getMandatoryFields().add("firstName");
        rule.getMandatoryFields().add("lastName");
        rule.getMandatoryFields().add("fbAppVesion");
        return  rule;
    }*/
    @Bean
    public IRule mandatoryRule(){
        return new MandatoryRule();
    }
}
