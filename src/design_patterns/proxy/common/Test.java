package design_patterns.proxy.common;

/**
 * @author yuc
 * @description 普通代理模式测试类
 * @Date 2020/12/17 18:06
 */
public class Test {

    public static void main(String[] args) throws Exception {
        IStudent zs = new StudentProxy("张三");
        zs.study();
        zs.exam();

        IStudent ls = new StudentVirtualProxy("李四");
        ls.study();
        ls.exam();
    }
}
