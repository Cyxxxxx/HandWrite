package design_patterns.factory.common_factory;

import design_patterns.factory.product.Book;
import design_patterns.factory.product.Pen;
import design_patterns.factory.product.Product;
import design_patterns.factory.simple_factory.StationeryFactory;

/**
 * 老板操作工厂，生产产品
 *
 * @Author yuc
 */
public class Boss {

    public static void main(String[] args) {
        // 创建钢笔工厂实例
        PenFactory penFactory = new PenFactory();
        // 创建本子工厂实例
        BookFactory bookFactory = new BookFactory();
        // 制造钢笔
        Product pen = penFactory.create();
        System.out.println("————钢笔制造完毕，属性如下————");
        pen.getName();
        pen.getPrice();

        // 制造本子
        Product book = bookFactory.create();
        System.out.println("————本子制造完毕，属性如下————");
        book.getName();
        book.getPrice();
    }

}