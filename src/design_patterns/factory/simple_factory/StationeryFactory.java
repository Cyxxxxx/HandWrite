package design_patterns.factory.simple_factory;

import design_patterns.factory.product.Product;

/**
 * 简单工厂模式
 * 静态工厂
 *
 * @Author yuc
 */
public class StationeryFactory {

    /**
     * 静态工厂方法
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Product> T createProduct(Class<T> clazz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("产品生产错误！");
        }
        return (T)product;
    }


}
