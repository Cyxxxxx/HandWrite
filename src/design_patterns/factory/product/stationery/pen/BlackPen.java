package design_patterns.factory.product.stationery.pen;

public class BlackPen extends Pen {
    @Override
    public void getName() {
        System.out.println("黑笔");
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
