package cn.shalee.utils;

import org.springframework.objenesis.ObjenesisHelper;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 14:07
 * @注释
 */
public class ThreadLocalUtil {

    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();


    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    public static void set(Object value) {
        THREAD_LOCAL.set(value);
    }

    //clear the ThreadLocal 防止内存泄漏
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
