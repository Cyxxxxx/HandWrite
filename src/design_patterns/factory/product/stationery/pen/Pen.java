package design_patterns.factory.product.stationery.pen;

import design_patterns.factory.product.stationery.Stationery;

/**
 * 产品 - 钢笔
 *
 * @Author yuc
 */
public class Pen extends Stationery {

    public Pen() {
        super();
    }

    public Pen(int price) {
        super(price);
    }

    @Override
    public void getName() {
        System.out.println("钢笔");
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void getPrice() {
        System.out.println(this.price + "元");
    }
}
