package com.example.validation.controller;

import com.example.validation.model.BaseModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {

    /**
     *
     *
     *
     * @param channel - channel , this API is called from.
     * @param params - Map of parameters sent as part of request body
     * @param request - BaseModel reference which will be injected by CustomerArgumentResolver.
     *                Appropriate subtype object will be instantiated based on channel.
     *                And will be assigned to super class reference variable.
     * @return
     */
    @PostMapping(path = "/hello/{channel}")
    public String get(@PathVariable String channel, @RequestBody Map<String, String> params, BaseModel request){

        System.out.println(request.getClass());
        System.out.println(request);
        System.out.println(request.getValidation());
        return null;
    }
}
