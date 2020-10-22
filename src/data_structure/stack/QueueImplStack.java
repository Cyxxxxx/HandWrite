package data_structure.stack;
import java.util.Queue;
import java.util.LinkedList;
/**
 * leetcode 225
 * @author yuc
 *
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 32.42% 的用户
 *
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 */
public class QueueImplStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int size;

    /**
     * 容器状态，当status==false时，q1为元素放置队列，否则q2为元素放置队列
     */
    boolean status;

    /** Initialize your data structure here. */
    public QueueImplStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 向元素放置队列添加新元素
        if(status){
            q2.offer(x);
        }else{
            q1.offer(x);
        }
        ++size;
    }

    /**
     * 队列转换，将当前放置元素所用的队列poll到另一条空队列，直到当前队列仅剩一个元素
     * pop/top操作取栈顶元素时使用
     */
    private void queueTransfer(){
        for(int tmpSize=size-1;tmpSize>0;--tmpSize){
            if(status){
                q1.offer(q2.poll());
            }else{
                q2.offer(q1.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        queueTransfer();
        // 根据状态，取当前放置元素队列仅剩的一个元素并出队
        int res = status?q2.poll():q1.poll();
        // 更改状态，使当前放置元素队列更改为另一队列
        status=!status;
        --size;
        return res;
    }

    /** Get the top element. */
    public int top() {
        queueTransfer();
        // 根据状态，取当前放置元素队列仅剩的一个元素
        int res = status?q2.peek():q1.peek();
        // 将当前放置元素队列的最后一个元素移动到另一队列
        if(status){
            q1.offer(q2.poll());
        }else{
            q2.offer(q1.poll());
        }
        // 更改状态，使当前放置元素队列更改为另一队列
        status=!status;
        return res;
    }



    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size==0;
    }



}
