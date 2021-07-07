package com.example.jvm.jvmexceptionexample;

/**
 * <pre>
 *      通知JVM GC
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/06/07 13:52  修改内容:
 * </pre>
 */
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
        System.gc();
    }

    public static void main(String[] args) {
        testGc();
    }
}
