package com.example.jvm.jvmexceptionexample.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StackController {

    public static long count = 0;

    public static void add(long i) {
        count ++ ;
        add(i);
    }

    @GetMapping(value = {"stack"})
    public void stack() {
        add(1);
    }

}
