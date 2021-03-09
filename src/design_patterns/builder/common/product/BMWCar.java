package design_patterns.builder.common.product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuc
 * @description
 * @Date 2020/12/16 11:54
 */
public class BMWCar extends AbstractCar {

    /**
     * Constructor
     * @param actionSeq
     */
    public BMWCar(List<String> actionSeq) {
        super(actionSeq);
    }

    public static class Builder{
        /**
         * 执行顺序
         */
        private List<String> actionSeq;
        public BMWCar.Builder actionSeq(List<String> actionSeq) {
            this.actionSeq = actionSeq;
            return this;
        }
        public BMWCar.Builder add(String action){
            if(actionSeq == null){
                actionSeq = new ArrayList<>();
            }
            this.actionSeq.add(action);
            return this;
        }
        public BMWCar build(){
            return new BMWCar(this.actionSeq);
        }
    }

    public static BMWCar.Builder builder(){
        return new BMWCar.Builder();
    }

    @Override
    protected void start() {
        System.out.println("宝马启动");
    }

    @Override
    protected void stop() {
        System.out.println("宝马停车");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马鸣笛");
    }
}
