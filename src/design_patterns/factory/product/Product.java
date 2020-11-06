package design_patterns.factory.product;

/**
 * 产品接口
 * 定义产品通用接口
 *
 * @Author
 */
public interface Product {

    /**
     * 获取产品名
     */
    void getName();

    /**
     * 获取产品价格
     */
    void getPrice();
}
