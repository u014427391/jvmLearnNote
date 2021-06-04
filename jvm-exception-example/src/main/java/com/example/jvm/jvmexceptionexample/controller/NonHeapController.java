package com.example.jvm.jvmexceptionexample.controller;

import com.example.jvm.jvmexceptionexample.asm.MyMetaspace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NonHeapController {

    List<Class<?>> list = new ArrayList<Class<?>>();

    @GetMapping(value = {"/noheap"})
    public String noheap() {
        while (true) {
            list.addAll(MyMetaspace.createClasses());
        }
    }

}