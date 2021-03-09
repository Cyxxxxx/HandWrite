package design_patterns.factory.simple_factory;

import design_patterns.factory.product.stationery.Stationery;

import java.lang.reflect.Constructor;

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
    public static <T extends Stationery> T createProduct(Class<? extends Stationery> clazz,Object... args) {
        Stationery product = null;
        try {
            // 获取构造方法
            if (args.length > 0){
                Constructor constructor = clazz.getConstructor(int.class);
                product = (Stationery) constructor.newInstance((int)args[0]);
            } else {
                Constructor constructor = clazz.getConstructor();
                product = (Stationery) constructor.newInstance();
            }
//            product = (Stationery) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("产品生产错误！");
        }
        return (T)product;
    }


}
