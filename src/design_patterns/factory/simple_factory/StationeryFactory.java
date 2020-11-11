package design_patterns.factory.simple_factory;

import design_patterns.factory.product.Stationery;

/**
 * 简单工厂模式
 *
 * 假设我们只要开一个文具厂
 * 文具厂中只有笔和本子两种产品
 * 那么我们用简单工厂模式来实现是完全没有问题的
 *
 * 优点：简单
 * 缺点：扩展性差
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
