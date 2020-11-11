package design_patterns.factory.factory_method;

import design_patterns.factory.product.stationery.book.Book;
import design_patterns.factory.product.stationery.book.ComicBook;
import design_patterns.factory.product.stationery.book.NoteBook;
import design_patterns.factory.product.stationery.pen.BlackPen;
import design_patterns.factory.product.stationery.pen.BluePen;

public class BookFactory implements StationeryFactory{
    @Override
    public Book create(String type) throws Exception{
        switch (type){
            case "comic": return new ComicBook();
            case "note": return new NoteBook();
            default: throw new Exception("无此类型产品");
        }
    }
}
