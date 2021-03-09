package design_patterns.factory.factory_method.factory.pen_factory;

import design_patterns.factory.product.stationery.Stationery;
import design_patterns.factory.product.stationery.pen.BluePen;

public class BluePenFactory extends AbstractPenFactory {
    @Override
    public Stationery create() {
        return new BluePen();
    }
}
