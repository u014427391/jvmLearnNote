package com.example.jvmgcexample.gc;

public class TestGc {

    static class A{
        public B b;
    }

    static class B {
        public A a;
    }

    public static void testGc() {
        A a = new A();
        B b = new B();
        a.b = b;
        b.a = a;
        a = null;
        b = null;
        // 强制进行gc回收
        System.gc();
    }

    public static void main(String[] args) {
        testGc();
    }
}
