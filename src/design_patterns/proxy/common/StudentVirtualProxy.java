package design_patterns.proxy.common;

/**
 * @author yuc
 * @description 学生代理类[虚拟代理]
 * @Date 2020/12/17 18:37
 */
public class StudentVirtualProxy implements IStudent {

    /**
     * 被代理的主题
     */
    private IStudent subject;

    /**
     * 被代理的学生名字
     */
    private String stuName;

    public StudentVirtualProxy(String stuName) {
        this.stuName = stuName;
        System.out.println("学生虚拟代理对象 For " + stuName + "已创建");
    }

    /**
     * 虚拟代理：在需要时才初始化主题对象
     * 优点：可以避免被代理对象较多而引起的初始化缓慢的问题
     * 缺点：每个方法中都需要判定主题对象是否被创建
     */
    private void init() {
        if (this.subject == null) {
            try {
                this.subject = new Student(this, this.stuName);
                System.out.println("学生虚拟代理对象 For " + stuName + "已初始化");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void study() {
        this.init();
        this.before();
        this.subject.study();
        this.after();
    }

    @Override
    public void exam() {
        this.init();
        this.before();
        this.subject.exam();
        this.after();
    }

    /**
     * 预处理
     */
    private void before() {
        System.out.println("代理预处理...");
    }

    /**
     * 善后处理
     */
    private void after() {
        System.out.println("代理善后...");
    }
}
