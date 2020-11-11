package design_patterns.factory.factory_method.factory.book_factory;

import design_patterns.factory.product.stationery.Stationery;
import design_patterns.factory.product.stationery.book.ComicBook;

public class ComicBookFactory extends AbstractBookFactory {
    @Override
    public Stationery create() {
        return new ComicBook();
    }
}
