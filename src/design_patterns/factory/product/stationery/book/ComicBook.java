package design_patterns.factory.product.stationery.book;

public class ComicBook extends Book{
    @Override
    public void getName() {
        System.out.println("漫画书");
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
