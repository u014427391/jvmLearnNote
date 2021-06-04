package com.example.jvm.jvmexceptionexample.controller;


import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeapController {

    List<Foo> list = new ArrayList<Foo>();
    @GetMapping(value = {"heap"})
    public String heapTest() {
        while (true) {
            list.add(new Foo());
        }
    }


    @Data
    class Foo {
        String str;
    }
}
