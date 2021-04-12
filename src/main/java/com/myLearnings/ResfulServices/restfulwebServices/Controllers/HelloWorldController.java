package com.myLearnings.ResfulServices.restfulwebServices.Controllers;

import com.myLearnings.ResfulServices.restfulwebServices.Service.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String hello_world_method(){
        return "Hello World!!!!";
    }
    @GetMapping("/hellow-wordBean")
    public HelloWorldBean hellow_word_bean(){
        return new HelloWorldBean("I m your Bean!!!!!!");
    }
    @GetMapping("/hellow-wordBean/{name}")
    public HelloWorldBean hellow_word_pathVariable(@PathVariable String name){
        return new HelloWorldBean("I m your Bean!!!!!!"+name);
    }



}
