package design_patterns.singleton;

/**
 * 借助枚举实现饿汉式单例
 * 优点：
 *   1. 实现超简单
 *   2. 不会被反射 / 反序列化破坏
 *
 * @Author yuc
 */
public enum HungryManWithEnum {
    INSTANCE;

    public void doSomething(){
        System.out.println("借助枚举实现饿汉式单例 - 被调用啦~");
    }
}
