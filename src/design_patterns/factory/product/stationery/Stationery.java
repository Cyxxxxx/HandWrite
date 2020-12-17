package design_patterns.factory.product.stationery;

import design_patterns.factory.product.Product;

public abstract class Stationery implements Product {

    protected int price = 3;

    public Stationery() {
    }

    public Stationery(int price) {
        this.price = price;
    }

    static {
        System.out.println("————生产文具————");
    }
}
