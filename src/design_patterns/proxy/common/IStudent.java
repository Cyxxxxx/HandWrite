package design_patterns.proxy.common;

/**
 * @author yuc
 * @description
 * 代理模式 - 普通代理
 * 学生实体类与学生代理继承此接口
 * @Date 2020/12/17 17:56
 */
public interface IStudent {

    /**
     * 学生要学习
     */
    void study();

    /**
     * 学生要考试
     */
    void exam();

}
