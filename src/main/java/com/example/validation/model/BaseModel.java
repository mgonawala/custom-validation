package com.example.validation.model;

import com.example.validation.interfaces.IValidationStrategy;

/**
 *
 * Base class used to represent common attributes of Request.
 *
 * It enforces concrete classes to implement setValidation method.
 * which will inject appropriate ValidationStrategy used for given concrete class.
 *
 */
public abstract class BaseModel {
    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public abstract void setValidation(IValidationStrategy validationStrategy);

    public abstract IValidationStrategy getValidation();
}
