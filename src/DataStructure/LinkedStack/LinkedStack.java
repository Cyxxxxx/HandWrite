package DataStructure.LinkedStack;

//基于双链表的栈
public class LinkedStack {

    private Node tail=null;
    private int size=0;

    public int push(int val){
        //若栈中没有元素
        if(size++==0){
            //此时栈中只有一个元素,直接为栈尾赋值
            tail=new Node(val);
        }else{ //若栈中存在元素，则对栈内链表进行尾插
            tail.next=new Node(val);
            tail.next.pre=tail;//将新栈尾的pre指针指向旧栈尾
            tail=tail.next;
        }
        return tail.val;//返回栈尾元素值（也就是刚插入的元素）
    }

    public int pop(){
        //若栈为空，返回-1
        if(size==0) return-1;
        //若栈非空：
        --size; //栈的长度自减
        Node res=tail;
        tail=tail.pre; //尾指针指向原链表尾的前一个元素
        return res.val; //返回原栈顶元素
    }

    //返回栈顶元素
    public int peek(){
        return tail.val;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //获取栈当前长度
    public int size(){
        return size;
    }

    //双链表节点类
    private class Node{
        //前后指针
        Node next,pre;
        int val;
        //构造方法
        Node(int val){
            this.val=val;
        }
    }
}
