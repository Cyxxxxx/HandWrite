package design_patterns.factory.factory_method.factory.pen_factory;

import design_patterns.factory.product.stationery.Stationery;
import design_patterns.factory.product.stationery.pen.BlackPen;

public class BlackPenFactory extends AbstractPenFactory{
    @Override
    public Stationery create() throws Exception {
        return new BlackPen();
    }
}
