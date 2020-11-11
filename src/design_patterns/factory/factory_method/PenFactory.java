package design_patterns.factory.factory_method;

import design_patterns.factory.product.stationery.pen.BlackPen;
import design_patterns.factory.product.stationery.pen.BluePen;
import design_patterns.factory.product.stationery.pen.Pen;

/**
 * 钢笔工厂
 */
public class PenFactory implements StationeryFactory {
    @Override
    public Pen create(String type) throws Exception{
        switch (type){
            case "black": return new BlackPen();
            case "blue": return new BluePen();
            default: throw new Exception("无此类型产品");
        }
    }
}
