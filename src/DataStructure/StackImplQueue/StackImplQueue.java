package DataStructure.StackImplQueue;

import java.util.Stack;

/**
 * 双栈实现队列
 *
 * @author yuc
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *
 * 执行用时： 59 ms , 在所有 Java 提交中击败了 48.82% 的用户
 * 内存消耗： 47.6 MB , 在所有 Java 提交中击败了 88.28% 的用户
 */
public class StackImplQueue {

    /**
     * 这里用了java.util.Stack的栈，在速度上会比较慢，用LinkedList会快些，但没必要^_^
     */
    Stack<Integer> s1;
    Stack<Integer> s2;

    public StackImplQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * 添加操作时，往栈1添加元素
     *
     * @param value
     */
    public void appendTail(int value) {
        s1.push(value);
    }

    /**
     * 删除操作时，当两个栈都为空，返回-1
     * 当栈2为空，把栈1的元素倒腾到栈2上，再用栈2出栈（栈反转就是队列）
     *
     * @return
     */
    public int deleteHead() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        }
        if (s2.isEmpty()) {
            stackTransfer();
        }
        return s2.pop();
    }

    /**
     * 将栈1倒腾到栈2上的方法
     */
    public void stackTransfer() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}
