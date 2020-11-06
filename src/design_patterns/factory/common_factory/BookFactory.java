package design_patterns.factory.common_factory;

import design_patterns.factory.product.Book;

public class BookFactory implements StationeryFactory{
    @Override
    public Book create() {
        return new Book();
    }
}
