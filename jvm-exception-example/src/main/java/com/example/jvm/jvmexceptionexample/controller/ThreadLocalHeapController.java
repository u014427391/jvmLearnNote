package com.example.jvm.jvmexceptionexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *      ThreadLocal 内存溢出例子
 * </pre>
 *
 * <pre>
 * @author nicky.ma
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/07/07 16:40  修改内容:
 * </pre>
 */
@RestController
@RequestMapping(value = {"/api"})
public class ThreadLocalHeapController {

    @GetMapping(value = "/testHeap")
    public ResponseEntity<?> testHeap() {
        ThreadLocal<Byte[]> threadLocal = new ThreadLocal<Byte[]>();
        try {
            threadLocal.set(new Byte[1024 * 1024]);
            return ResponseEntity.ok("success");
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        } finally {
            // 不进行ThreadLocal remove会出现内存溢出
            threadLocal.remove();
        }
    }

}
