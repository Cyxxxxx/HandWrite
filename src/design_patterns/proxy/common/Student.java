package design_patterns.proxy.common;

/**
 * @author yuc
 * @description 学生类
 * @Date 2020/12/17 17:57
 */
public class Student implements IStudent {

    /**
     * 学生名字
     */
    private String stuName;

    /**
     * Constructor
     * @param stuName
     */
    public Student(IStudent student,String stuName) throws Exception {
        if (student == null) {
            throw new Exception("只有代理能创建学生实例！");
        }
        this.stuName = stuName;
    }

    @Override
    public void study() {
        System.out.println(stuName + ": 开始学习");
    }

    @Override
    public void exam() {
        System.out.println(stuName + ": 开始考试");
    }
}
