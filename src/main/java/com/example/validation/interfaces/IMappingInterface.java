package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;

import java.util.Map;

public interface IMappingInterface {

    BaseModel mapModel(BaseModel baseModel, Map<String, String> parameters);
}
