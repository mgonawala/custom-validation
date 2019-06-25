package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Map;

@Component
public class MappingImpl implements IMappingInterface {

    private BeanWrapper beanWrapper = null;

    @Override
    public BaseModel mapModel(BaseModel baseModel, Map<String, String> parameters) {

        beanWrapper = new BeanWrapperImpl(baseModel);
        ReflectionUtils.doWithFields(baseModel.getClass(),(field) ->{
            if(parameters.keySet().contains(field.getName())){
                beanWrapper.setPropertyValue(field.getName(),parameters.get(field.getName()));
                beanWrapper.getWrappedInstance();
            }
        });

        return baseModel;
    }
}
