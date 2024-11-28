package com.cis111b16.task_prioritization_and_peadline_management;

import org.junit.jupiter.api.Test;


public class ThreadLocalTest {

    @Test
    public void testThreadLocaSetAndGet(){
        ThreadLocal tl=new ThreadLocal();

        new Thread(()->{
            tl.set("a");
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
        },"A").start();

        new Thread(()->{
            tl.set("b");
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
        },"B").start();
    }
}
