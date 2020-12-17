package design_patterns.proxy.static_proxy;

/**
 * @author yuc
 * @description 学生代理类
 * @Date 2020/12/17 18:00
 */
public class StudentProxy implements IStudent{

    /**
     * 学生实例
     */
    private IStudent stu = null;

    public StudentProxy(String stuName){
        try {
            this.stu = new Student(this,stuName);
            System.out.println("学生代理对象 For " + stuName + "已创建并初始化");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void study() {
        this.before();
        this.stu.study();
        this.after();
    }

    @Override
    public void exam() {
        this.before();
        this.stu.exam();
        this.after();
    }


    /**
     * 预处理
     */
    private void before(){
        System.out.println("代理预处理...");
    }

    /**
     * 善后处理
     */
    private void after(){
        System.out.println("代理善后...");
    }
}
