package design_patterns.factory.common_factory;

import design_patterns.factory.product.Product;

/**
 * 常规的工厂方法通过实现接口来扩展
 *
 * @Author yuc
 */
public interface StationeryFactory {

    /**
     * 工厂方法
     *
     * @return
     */
    Object create();
}
