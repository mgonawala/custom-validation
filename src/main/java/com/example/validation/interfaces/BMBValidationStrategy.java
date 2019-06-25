package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implements validation strategy for BMB channel.
 */
public class BMBValidationStrategy implements IValidationStrategy {

    private List<IRule> ruleList = new ArrayList<>();

    @Override
    public boolean isValid(BaseModel baseModel) {
        System.out.println("Calling BMB Validation Strategy.");
        ruleList.forEach(rule -> {
            if( rule.isMatching(baseModel))
                rule.execute(baseModel);
        });
        return true;
    }

    @Override
    public void setRules(List<IRule> rules) {
        this.ruleList = rules;
    }

    @Override
    public List<IRule> getRules() {
        return ruleList;
    }
}
