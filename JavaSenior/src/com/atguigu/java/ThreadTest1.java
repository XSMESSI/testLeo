package com.atguigu.java;

/**
 * @Author: Leo messi
 * @Date: 2022/05/29/2:25
 * @Description:
 */

/**
 * 创建多线程的方式二：实现Runable()接口
 *
 * 1.创建一个实现了Runable()接口的类
 * 2.实现类趋势线Runable()中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数，传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 *
 * 比较创建线程的两种方式：
 *开发中，优先选择：实现Runable接口的方式
 * 原因：1.实现的方式没有列的单继承性的局限性
 *      2.实现的方式更适合来处理多个线程共享数据的情况
 *
 * 联系：class Thread implements Runnable
 * 相同点：两种方式都要重写run(),将线程的要执行的逻辑声明在run()中，
 *
 *
 */
//1.创建一个实现了Runable()接口的类
class MThread implements Runnable{
//2.实现类趋势线Runable()中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ ":" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //3.创建实现类的对象
            MThread mThread = new MThread();
            //4.将此对象作为参数，传递到Thread类的构造器中，创建Thread类的对象
            Thread t1 = new Thread(mThread);
            t1.setName("线程" + i);
            //5.通过Thread类的对象调用start() 1.启动线程 2.调用当前线程的run()-->调用了Runable类型的target
            t1.start();
        }

        //3.创建实现类的对象
//        MThread mThread = new MThread();
//        //4.将此对象作为参数，传递到Thread类的构造器中，创建Thread类的对象
//        Thread t1 = new Thread(mThread);
//        t1.setName("线程1");
//        //5.通过Thread类的对象调用start() 1.启动线程 2.调用当前线程的run()-->调用了Runable类型的target
//        t1.start();

        //再启动一个线程，遍历100以内的偶数
//        Thread t2 = new Thread(mThread);
//        t2.setName("线程2");
//        t2.start();
    }
}
