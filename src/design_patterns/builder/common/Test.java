package design_patterns.builder.common;

import design_patterns.builder.common.product.BMWCar;

/**
 * @author yuc
 * @description
 * @Date 2020/12/16 16:50
 */
public class Test {
    public static void main(String[] args) {
        BMWCar.builder()
                .add("stop")
                .add("alarm")
                .add("start")
                .build()
                .run();
    }
}
