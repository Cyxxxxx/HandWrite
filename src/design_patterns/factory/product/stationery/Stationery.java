package design_patterns.factory.product.stationery;

import design_patterns.factory.product.Product;

public abstract class Stationery implements Product {
    static {
        System.out.println("————生产文具————");
    }
}
