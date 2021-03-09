package design_patterns.singleton;

/**
 * 反例示范 —— 不带DCL的线程不安全懒汉式单例
 *
 * @Author yuc
 */
public class LazyManWithoutDCL {

    private static LazyManWithoutDCL instance = null;

    private LazyManWithoutDCL(){};

    /**
     * 仅做简单检测，线程不安全
     *
     * @return
     */
    public static LazyManWithoutDCL getInstance(){
        if(instance == null){
            instance = new LazyManWithoutDCL();
        }
        return instance;
    }
}
