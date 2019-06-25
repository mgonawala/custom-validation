package com.example.validation.interfaces;

import com.example.validation.model.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implements validation strategy for WEB channel.
 */
// TODO - pluggable set of rules to execute.

public class WEBValidationStrategy implements IValidationStrategy {

    private List<IRule> ruleList = new ArrayList<>();

    @Override
    public boolean isValid(BaseModel baseModel) {
        System.out.println("Calling WEB validation strategy");

        for (IRule rule :
                ruleList) {
            if(rule.isMatching(baseModel))
                if(rule.execute(baseModel)== false)
                    return false;
        }
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
