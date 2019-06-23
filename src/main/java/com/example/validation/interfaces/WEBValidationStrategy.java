package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;

/**
 *
 * Implements validation strategy for WEB channel.
 */
// TODO - pluggable set of rules to execute.

public class WEBValidationStrategy implements IValidationStrategy {

    @Override
    public boolean isValid(BaseModel baseModel) {
        System.out.println("Calling WEB validation strategy");
        return false;
    }
}
