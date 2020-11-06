package design_patterns.factory.product;

/**
 * 产品 - 钢笔
 *
 * @Author yuc
 */
public class Pen extends Stationery {

    private int price = 3;

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
