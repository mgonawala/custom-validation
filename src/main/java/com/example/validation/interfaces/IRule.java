package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;
import com.fasterxml.jackson.databind.ser.Serializers;
import sun.tools.jconsole.Tab;

public interface IRule<T> {

     boolean isMatching(T baseModel);

     boolean execute(T baseModel);
}
