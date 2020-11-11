package design_patterns.factory.factory_method;

import design_patterns.factory.factory_method.factory.book_factory.AbstractBookFactory;
import design_patterns.factory.factory_method.factory.book_factory.NoteBookFactory;
import design_patterns.factory.factory_method.factory.pen_factory.AbstractPenFactory;
import design_patterns.factory.factory_method.factory.pen_factory.BlackPenFactory;
import design_patterns.factory.product.Product;
import design_patterns.factory.product.stationery.Stationery;

/**
 * 老板操作工厂，生产产品
 *
 * @Author yuc
 */
public class Boss {

    public static void main(String[] args) {
        // 创建黑色钢笔工厂实例
        AbstractPenFactory blackPenFactory = new BlackPenFactory();
        // 创建笔记本工厂实例
        AbstractBookFactory noteBookFactory = new NoteBookFactory();
        // 制造钢笔
        Stationery pen = null;
        try {
            pen = blackPenFactory.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("————钢笔制造完毕，属性如下————");
        pen.getName();
        pen.getPrice();

        // 制造本子
        Stationery book = null;
        try {
            book = noteBookFactory.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("————本子制造完毕，属性如下————");
        book.getName();
        book.getPrice();
    }

}