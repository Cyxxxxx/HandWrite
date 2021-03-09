package design_patterns.builder.lombok;

/**
 * @author yuc
 * @description
 * @Date 2020/12/16 11:37
 */
public class Test {
    public static void main(String[] args) {
        Bean bean = Bean.builder()
                .field1("1")
                .field2("2")
                .field3("3")
                .field4("4")
                .build();
        System.out.println(bean.toString());
    }
}
