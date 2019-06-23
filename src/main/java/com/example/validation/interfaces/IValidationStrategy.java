package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;

/**
 *
 * Interface to use for strategy pattern.
 *
 * This will be composite in BaseModel class.
 */
public interface IValidationStrategy {

    public boolean isValid(BaseModel baseModel);
}
