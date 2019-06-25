package com.example.validation.model;

import com.example.validation.interfaces.IValidationStrategy;

public class FBModel extends BaseModel {

    private IValidationStrategy strategy;

    private String fbAppVesion;

    public IValidationStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public String getFbAppVesion() {
        return fbAppVesion;
    }

    public void setFbAppVesion(String fbAppVesion) {
        this.fbAppVesion = fbAppVesion;
    }

    @Override
    public void setValidation(IValidationStrategy validationStrategy) {
        this.strategy = validationStrategy;
    }

    @Override
    public IValidationStrategy getValidation() {
        return strategy;
    }
}
