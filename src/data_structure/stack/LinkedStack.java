package data_structure.stack;

/**
 * 基于双链表的栈
 * @author YuC
 */
public class LinkedStack {

    /**
     * 指向链表尾节点
     */
    private Node tail=null;

    /**
     * 记录栈长度
     */
    private int size=0;

    /**
     * 入栈
     * @param val
     * @return
     */
    public int push(int val){
        //若栈中没有元素
        if(size++==0){
            //此时栈中只有一个元素,直接为栈尾赋值
            tail=new Node(val);
        }else{ //若栈中存在元素，则对栈内链表进行尾插
            tail.next=new Node(val);
            //将新栈尾的pre指针指向旧栈尾
            tail.next.pre=tail;
            tail=tail.next;
        }
        //返回栈尾元素值（也就是刚插入的元素）
        return tail.val;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        //若栈为空，返回-1
        if(size==0){
            return-1;
        }
        //若栈非空, 栈的长度自减
        --size;
        Node res=tail;
        //尾指针指向原链表尾的前一个元素
        tail=tail.pre;
        //返回原栈顶元素
        return res.val;
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public int peek(){
        return tail.val;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 获取栈当前长度
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 双链表节点类
     */
    private class Node{
        //前后指针
        Node next,pre;
        int val;
        //构造方法
        Node(int val){
            this.val=val;
        }
    }

    /**
     * main方法，测试用
     * @param args
     */
    public static void main(String[] args) {
        LinkedStack ls=new LinkedStack();
        ls.push(3);
        ls.push(6);
        ls.push(9);
        System.out.println(ls.isEmpty()); //false
        System.out.println(ls.size()); //3
        System.out.println(ls.peek()); //9
        while(!ls.isEmpty())
            System.out.println(ls.pop()); //顺序输出9,6,3
        System.out.println(ls.isEmpty()); //true
    }
}
