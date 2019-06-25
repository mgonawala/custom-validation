package com.example.validation.model;

import com.example.validation.interfaces.IValidationStrategy;

public class ChildClass extends BaseModel {

    private IValidationStrategy validation;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IValidationStrategy getValidation() {
        return validation;
    }

    @Override
    public void setValidation(IValidationStrategy validationStrategy) {
        this.validation = validationStrategy;
    }

}
