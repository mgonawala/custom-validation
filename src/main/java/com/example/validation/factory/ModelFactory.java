package com.example.validation.factory;

import com.example.validation.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * Factory design pattern for mapping BaseModel to channel.
 *
 * It returns a subtype of BaseModel based on channel provided.
 *
 */
@Component
public class ModelFactory {

    /**
     * All beans of type BaseModel will be injected , with id as the key
     */
    @Autowired
    private Map<String, BaseModel> modelMap;

    /**
     * Returns bean of given type.
     *
     * @param type
     * @return
     */
    public  BaseModel getModel(String type){
        return modelMap.get(type);

    }

    public Map<String, BaseModel> getModelMap() {
        return modelMap;
    }

    public void setModelMap(Map<String, BaseModel> modelMap) {
        this.modelMap = modelMap;
    }
}
