package design_patterns.factory.product;

public abstract class Stationery implements Product {
    static {
        System.out.println("————生产文具————");
    }
}
