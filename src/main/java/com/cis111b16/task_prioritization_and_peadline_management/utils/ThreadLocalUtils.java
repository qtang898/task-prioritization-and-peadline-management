package com.cis111b16.task_prioritization_and_peadline_management.utils;

public class ThreadLocalUtils {
    private static  final ThreadLocal THREAD_LOCAL=new ThreadLocal();

    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }

    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }

    public static void remove(){
        THREAD_LOCAL.remove();
    }

}
