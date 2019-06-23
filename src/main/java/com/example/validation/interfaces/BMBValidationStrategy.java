package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;

/**
 *
 * Implements validation strategy for BMB channel.
 */
public class BMBValidationStrategy implements IValidationStrategy {

    @Override
    public boolean isValid(BaseModel baseModel) {
        System.out.println("Calling BMB Validation Strategy.");
        return true;
    }
}
