package design_patterns.factory.common_factory;

import design_patterns.factory.product.Pen;

/**
 * 钢笔工厂
 */
public class PenFactory implements StationeryFactory {
    @Override
    public Pen create(){
        return new Pen();
    }
}
