package design_patterns.singleton;

/**
 * 借助静态内部类实现线程安全的单例懒加载
 * 优点：
 *   1. 和DCL的懒汉式能达到同样的效果
 *   2. 实现简单
 *
 * @Author yuc
 */
public class LazyManWithStaticInnerClass {

    /**
     * 使用私有静态内部类来实现懒加载
     * 由于内部类只会被加载一次（线程安全）
     * 内部类在没有被使用时，不会进行加载（懒加载）
     */
    private static class MyInnerClass{
        public static final LazyManWithStaticInnerClass instance = new LazyManWithStaticInnerClass();
    }

    private LazyManWithStaticInnerClass(){};

    public static LazyManWithStaticInnerClass getInstance(){
        // 直接调用静态内部类的实例
        return MyInnerClass.instance;
    }

}
