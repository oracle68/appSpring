package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String sayHello(){
        return helloService.sayHello();
    }
}