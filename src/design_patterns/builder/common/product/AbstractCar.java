package design_patterns.builder.common.product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuc
 * @description
 * @Date 2020/12/16 11:49
 */
public abstract class AbstractCar {

    /**
     * Constructor
     * @param actionSeq
     */
    public AbstractCar(List<String> actionSeq) {
        this.actionSeq = actionSeq;
    }

    /**
     * 执行顺序
     */
    private List<String> actionSeq;
    public List<String> getActionSeq() {
        return actionSeq;
    }
    public void setActionSeq(List<String> actionSeq) {
        this.actionSeq = actionSeq;
    }

    /**
     * 动作
     */
    protected void start(){};
    protected void stop(){};
    protected void alarm(){};

    /**
     * 车辆运行
     */
    public void run(){
        for(String action : actionSeq){
            switch (action) {
                case "start": {
                    this.start();
                    break;
                }
                case "stop": {
                    this.stop();
                    break;
                }
                case "alarm": {
                    this.alarm();
                    break;
                }
                default: break;
            }
        }
    };
}
