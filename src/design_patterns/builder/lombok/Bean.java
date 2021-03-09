package design_patterns.builder.lombok;

/**
 * @author yuc
 * @description 仿照lombok内置Builder的Java Bean
 * @Date 2020/12/16 11:03
 */
public class Bean {

    /**
     * Field
     */
    private String field1;
    private String field2;
    private String field3;
    private String field4;

    /**
     * Constructor
     * @param field1
     * @param field2
     * @param field3
     * @param field4
     */
    public Bean(String field1, String field2, String field3, String field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    public static class BeanBuilder{
        /**
         * Field
         */
        private String field1;
        private String field2;
        private String field3;
        private String field4;

        /**
         * Setter
         */
        public Bean.BeanBuilder field1(String field1) {
            this.field1 = field1;
            return this;
        }
        public Bean.BeanBuilder field2(String field2) {
            this.field2 = field2;
            return this;
        }
        public Bean.BeanBuilder field3(String field3) {
            this.field3 = field3;
            return this;
        }
        public Bean.BeanBuilder field4(String field4) {
            this.field4 = field4;
            return this;
        }

        public Bean build(){
            return new Bean(this.field1,this.field2,this.field3,this.field4);
        }
    }

    /**
     * Builder Getter
     */
    public static Bean.BeanBuilder builder(){
        return new Bean.BeanBuilder();
    }

    /**
     * Getter
     */
    public String getField1() {
        return field1;
    }


    public String getField2() {
        return field2;
    }



    public String getField3() {
        return field3;
    }


    public String getField4() {
        return field4;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                '}';
    }


}
