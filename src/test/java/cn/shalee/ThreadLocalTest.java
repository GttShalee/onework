package cn.shalee;

import org.junit.jupiter.api.Test;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 13:29
 * @注释
 */

public class ThreadLocalTest {
    @Test
    public void testTheadLocalSetAndGet() {

        ThreadLocal tl = new ThreadLocal<>();

        //开两个线程    //线程分离
        new Thread(() ->{
            tl.set("萧炎");
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
        },"蓝色").start();

        new Thread(() ->{
            tl.set("唐三");
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
        },"红色").start();
    }
}
