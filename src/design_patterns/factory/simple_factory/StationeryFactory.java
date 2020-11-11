package design_patterns.factory.simple_factory;

import design_patterns.factory.product.stationery.Stationery;

/**
 * 简单工厂模式
 *
 *
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
    public static <T extends Stationery> T createProduct(Class<? extends Stationery> clazz) {
        Stationery product = null;
        try {
            product = (Stationery) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("产品生产错误！");
        }
        return (T)product;
    }


}
