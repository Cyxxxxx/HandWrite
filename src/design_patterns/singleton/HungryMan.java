package design_patterns.singleton;

/**
 * 单例模式 - 饿汉式
 * 优点：
 *   1. 线程安全
 *   2. 执行效率高
 *   3. 实现简单
 * 缺点：
 *   1. 类加载时就初始化，浪费内存
 *   2. 可能被反射 / 反序列化破坏
 *
 * @Author yuc
 */
public class HungryMan {

    /**
     * 定义静态常量指向唯一实例
     */
    private static final HungryMan instance = new HungryMan();

    /**
     * 构造方法私有，禁止别人访问
     */
    private HungryMan() {};

    /**
     * 通过静态方法来获取唯一实例
     *
     * @return
     */
    public static HungryMan getInstance() {
        return instance;
    }
}
