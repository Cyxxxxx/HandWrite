package data_structure.queue;

import java.util.Arrays;

/**
 * 数组实现有界队列
 *
 * @param <T>
 * @author YuC
 */
public class ArrayQueue<T> {

    /**
     * 存放队列元素的数组
     */
    Object[] elements;

    /**
     * 头、尾指针
     */
    private int head, tail;


    /**
     * 队列容量与队列当前大小
     */
    private int capacity, size;


    /**
     * 有界队列构造方法
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    /**
     * 出队操作，队列为空时抛出异常
     *
     * @return 队头
     * @throws Exception
     */
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("队列为空！");
        }
        // 元素出队时，size记得自减
        --size;
        T res = (T) elements[head];
        elements[head] = null;
        // head+1，并与容量取模
        // 例：capacity为10，head为9+1=10，即将数组越界
        // 将当前头指针索引10与容量10取模，得head=10%10=0（头指针循环）
        head = (head + 1) % capacity;
        return res;
    }

    /**
     * 入队操作，队列满时返回false，入队成功时返回true
     *
     * @param t
     * @return
     */
    public boolean offer(T t) {
        if (size == capacity) {
            return false;
        }
        // 元素入队时，size记得自增
        ++size;
        elements[tail] = t;
        // 尾指针的取模与头指针同理（尾指针循环）
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * 队列为空时返回true
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    /**
     * main方法，测试用
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 1; i <= 6; ++i) {
            System.out.println("offer:" + i + "," + queue.offer(i));
        }
        System.out.println(queue.toString());

        for (int i = 1; i <= 3; ++i) {
            System.out.println("pop:" + queue.pop());
        }
        System.out.println(queue.toString());
        for (int i = 1; i <= 2; ++i) {
            System.out.println("offer:" + i + "," + queue.offer(i));
        }
        System.out.println(queue.toString());
        for (int i = 1; i <= 3; ++i) {
            System.out.println("pop:" + queue.pop());
        }
        System.out.println(queue.toString());
        for (int i = 1; i <= 2; ++i) {
            System.out.println("offer:" + i + "," + queue.offer(i));
        }
        System.out.println(queue.toString());

        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
        queue.pop();
    }

}
