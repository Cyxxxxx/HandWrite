package DataStructure.LinkedQueue;

//

/**
 * 基于单链表的队列
 * @author YuC
 */
public class LinkedQueue {

    /**
     * 头尾指针，指向链表的头和尾
     */
    private Node head,tail;

    /**
     * 记录队列长度
     */
    private int size=0;

    /**
     * 入队
     * @param val
     * @return
     */
    public int offer(int val){
        //按队列是否为空来决定操作
        if(size++==0){
            head=new Node(val);
            tail=head;
        }else{
            //单链表的尾插
            tail.next=new Node(val);
            tail=tail.next;
        }
        return tail.val;
    }


    /**
     * 出队
     * @return
     */
    public int poll(){
        //按队列是否为空来决定操作
        //队列为空返回-1
        if(size==0){
            return -1;
        }
        //队列不为空时, 队列长度自减
        --size;
        //获取当前链头
        Node res=head;
        //单链表头删
        head=head.next;
        return res.val;
    }

    /**
     * 获取队头元素
     * @return
     */
    public int peek(){
        return head.val;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 单链表节点类
     */
    private class Node{
        Node next;
        int val;
        Node(int val){
            this.val=val;
        }
    }
}

