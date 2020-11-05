package design_patterns.singleton;

/**
 * 单例模式 - 懒汉式 - 双重检验锁
 * DCL(Double-Checked Locking)
 * 优点：
 * 1. 懒加载，不会浪费内存
 * 2. 线程安全
 * 3. 高效
 * 缺点：
 * 1. 实现较复杂
 *
 * @Author Yuc
 */
public class LazyManWithDCL {

    /**
     * 类加载时，先不加载实例
     * 使用 volatile 修饰，这样第二个线程才能立刻知道静态变量是否还是 null
     */
    private volatile static LazyManWithDCL instance = null;

    /**
     * 构造方法私有，禁止别人访问
     */
    private LazyManWithDCL() {};

    public static LazyManWithDCL getInstance(){
        // 第一重校验
        if(instance == null){
            synchronized (LazyManWithDCL.class){
                // 拿到锁后，进行第二重校验，避免第二个进来的线程再次生成实例
                if(instance == null){
                    instance = new LazyManWithDCL();
                }
            }
        }
        return instance;
    }

}
