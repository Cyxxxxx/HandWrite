package design_patterns.singleton;

/**
 * 借助枚举实现线程安全的单例懒加载
 * 优点：
 *   1. 是线程安全的懒汉式
 *   2. 实现超简单
 *   3. 不会被反射 / 反序列化破坏
 *
 * @Author yuc
 */
public enum LazyManWithEnum {
    INSTANCE;

    public void doSomething(){
        System.out.println("借助枚举实现线程安全的单例懒加载 - 被调用啦~");
    }
}
