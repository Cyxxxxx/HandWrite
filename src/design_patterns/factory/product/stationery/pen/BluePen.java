package design_patterns.factory.product.stationery.pen;

public class BluePen extends Pen {
    @Override
    public void getName() {
        System.out.println("蓝笔");
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @Override
    public void getPrice() {
        super.getPrice();
    }
}
