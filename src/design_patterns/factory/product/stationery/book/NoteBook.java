package design_patterns.factory.product.stationery.book;

public class NoteBook extends Book {
    @Override
    public void getName() {
        System.out.println("笔记本");
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
