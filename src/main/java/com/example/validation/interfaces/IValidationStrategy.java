package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;

import java.util.List;

/**
 *
 * Interface to use for strategy pattern.
 *
 * This will be composite in BaseModel class.
 */
public interface IValidationStrategy {

    boolean isValid(BaseModel baseModel);

    void setRules(List<IRule> rules);

    List<IRule> getRules();

}
