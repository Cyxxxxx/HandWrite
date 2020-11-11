package design_patterns.factory.factory_method;

import design_patterns.factory.product.Product;

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
        Product pen = null;
        try {
            pen = penFactory.create("black");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("————钢笔制造完毕，属性如下————");
        pen.getName();
        pen.getPrice();

        // 制造本子
        Product book = null;
        try {
            book = bookFactory.create("comic");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("————本子制造完毕，属性如下————");
        book.getName();
        book.getPrice();
    }

}