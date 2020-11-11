package design_patterns.factory.factory_method.factory.book_factory;

import design_patterns.factory.product.stationery.Stationery;
import design_patterns.factory.product.stationery.book.NoteBook;

public class NoteBookFactory extends AbstractBookFactory {
    @Override
    public Stationery create() throws Exception {
        return new NoteBook();
    }
}
