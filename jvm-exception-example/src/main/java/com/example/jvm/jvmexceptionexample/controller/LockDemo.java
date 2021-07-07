package com.example.jvm.jvmexceptionexample.controller;

public class LockDemo
{
    public static void main(String[] args)
    {
        LockThread d1=new LockThread(true);
        LockThread d2=new LockThread(false);
        Thread t1=new Thread(d1);
        Thread t2=new Thread(d2);
        t1.start();
        t2.start();
    }
}
//定义锁对象
class MyLock{
    public static Object obj1=new Object();
    public static Object obj2=new Object();
}
// 案例，thread1持有u1的锁，thread2持有u2的锁，thread1等待获取u2的锁，thread2等待获取u1的锁
class LockThread implements Runnable{
    private boolean flag;
    LockThread(boolean flag){
        this.flag=flag;
    }
    public void run() {
        if(flag) {
            while(true) {
                synchronized(MyLock.obj1) {
                    System.out.println(Thread.currentThread().getName()+"获得obj1锁");
                    synchronized(MyLock.obj2) {
                        System.out.println(Thread.currentThread().getName()+"获得obj2锁");
                    }
                }
            }
        } else {
            while(true){
                synchronized(MyLock.obj2) {
                    System.out.println(Thread.currentThread().getName()+"获得obj2锁");
                    synchronized(MyLock.obj1) {
                        System.out.println(Thread.currentThread().getName()+"获得obj1锁");
                    }
                }
            }
        }
    }

}