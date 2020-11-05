package design_patterns.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 单例模式 - 测试类
 */
public class Tester {

    private static int testCount = 20;

    private static CountDownLatch cdl = new CountDownLatch(testCount);

    public static void LazyManWithoutDCLTester() throws InterruptedException {
        System.out.println("懒汉式不带DCL测试开始");
        // 开启20个线程，获取懒汉式不带DCL的实例并打印其地址
        for(int i=0;i<20;++i){
            new Thread(()->{
                System.out.println(LazyManWithoutDCL.getInstance());
                cdl.countDown();
            }).start();
        }
        cdl.await();
        System.out.println("懒汉式不带DCL测试结束");
    }

    public static void main(String[] args) throws InterruptedException {
        LazyManWithoutDCLTester();
    }
}
