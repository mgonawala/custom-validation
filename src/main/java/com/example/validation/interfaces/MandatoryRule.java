package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;
import com.example.validation.model.ChildClass;
import com.example.validation.model.FBModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aop.framework.Advised;
import org.springframework.util.ReflectionUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MandatoryRule implements  IRule<BaseModel>{


    String rulePath = "mandatory_rule.json";

    ObjectMapper objectMapper = new ObjectMapper();

    Map<String,List<String>> mandatoryMap = new HashMap<>();

    List<String> mandatoryFields = new ArrayList<>();

    boolean result = true;

    public List<String> getMandatoryFields() {
        return mandatoryFields;
    }

    public void setMandatoryFields(List<String> mandatoryFields) {
        this.mandatoryFields = mandatoryFields;
    }

    public MandatoryRule(){
        try {
           this.mandatoryMap =  objectMapper.readValue(new URL("classpath:"+rulePath),Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean isMatching(BaseModel baseModel) {
        if(mandatoryMap.containsKey(baseModel.getChannel()))
            return true;
        return false;
    }

    @Override
    public  boolean execute(BaseModel baseModel) {
        this.result = true;
        mandatoryMap.get(baseModel.getChannel()).forEach(field -> {
            Field field1 = ReflectionUtils.findField(baseModel.getClass(), field);
            field1.setAccessible(true);
            try {
                if( field1 == null || field1.get(baseModel) == null){
                    this.result = false;
                    System.out.println(field1 + " is a mandatory field.");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });
        return this.result;
    }

    public Map<String, List<String>> getMandatoryMap() {
        return mandatoryMap;
    }

    public void setMandatoryMap(Map<String, List<String>> mandatoryMap) {
        this.mandatoryMap = mandatoryMap;
    }


}
