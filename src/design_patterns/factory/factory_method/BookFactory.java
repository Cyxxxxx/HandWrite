package design_patterns.factory.factory_method;

import design_patterns.factory.product.stationery.book.Book;

public class BookFactory implements StationeryFactory{
    @Override
    public Book create() {
        return new Book();
    }
}
