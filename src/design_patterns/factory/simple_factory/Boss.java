package design_patterns.factory.simple_factory;

import design_patterns.factory.product.Book;
import design_patterns.factory.product.Pen;
import design_patterns.factory.product.Product;

/**
 * 老板操作工厂，生产产品
 *
 * @Author yuc
 */
public class Boss {

    public static void main(String[] args) {
        // 制造钢笔
        Product pen = StationeryFactory.createProduct(Pen.class);
        System.out.println("————钢笔制造完毕，属性如下————");
        pen.getName();
        pen.getPrice();

        // 制造本子
        Product book = StationeryFactory.createProduct(Book.class);
        System.out.println("————本子制造完毕，属性如下————");
        book.getName();
        book.getPrice();
    }

}
