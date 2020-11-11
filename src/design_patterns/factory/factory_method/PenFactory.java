package design_patterns.factory.factory_method;

import design_patterns.factory.product.stationery.pen.Pen;

/**
 * 钢笔工厂
 */
public class PenFactory implements StationeryFactory {
    @Override
    public Pen create(){
        return new Pen();
    }
}
