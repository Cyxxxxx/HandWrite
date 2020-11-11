package design_patterns.factory.factory_method.factory;

import design_patterns.factory.product.stationery.Stationery;
import design_patterns.factory.product.stationery.book.Book;

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
    Stationery create() throws Exception;
}
