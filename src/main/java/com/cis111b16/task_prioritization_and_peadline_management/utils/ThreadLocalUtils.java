package com.cis111b16.task_prioritization_and_peadline_management.utils;

/**
 * The type Thread local utils.
 */
public class ThreadLocalUtils {
    private static  final ThreadLocal THREAD_LOCAL=new ThreadLocal();

    /**
     * Get t.
     *
     * @param <T> the type parameter
     * @return the t
     */
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }

    /**
     * Set.
     *
     * @param value the value
     */
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }

    /**
     * Remove.
     */
    public static void remove(){
        THREAD_LOCAL.remove();
    }

}
