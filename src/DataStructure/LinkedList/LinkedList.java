package DataStructure.LinkedList;

//手写一个双向链表
public class LinkedList {
    //头尾节点
    ListNode head=null,tail=null;
    //链表长度
    int size=0;

    //添加元素方法
    public void add(int val){
        //往链表中添加元素时，链表长度自增
        ++size;
        //当链表为空时
        if(head==null){
            //new一个链表头
            head=new ListNode(val);
            //由于链表里只有一个元素，所以链头和链尾是一样的
            tail=head;
        }else{
            //链表不为空时，在链表尾插一个新节点
            tail.next=new ListNode(val);
            tail.next.pre=tail;
            tail=tail.next;
        }
    }

    //通过索引获取元素方法
    public int get(int index){
        ListNode res=getNode(index);
        //当getNode方法传出null时,返回-1
        if(res==null) return -1;
        else return res.val;
    }

    //通过索引修改元素方法
    public int set(int index,int val){
        //老样子,通过遍历拿到所需的节点
        ListNode node=getNode(index);
        int oldVal=node.val;
        //直接修改对应节点的val字段即可
        node.val=val;
        //返回该节点被修改前的值
        return oldVal;
    }

    //通过索引删除元素方法
    public int remove(int index){
        ListNode res=getNode(index);
        //当getNode方法传出null时,返回-1
        if(res==null) return -1;
        //删除节点后size自减
        //当size大于1时,正常自减
        if(size--<=1){//当size小于等于1,删除链表中最后一个元素,头尾指针置空
            head=null;
            tail=null;
            return res.val;
        }
        //若要删除的节点是尾节点
        if(res==tail){
            tail=tail.pre;
            tail.next=null;
            return res.val;
        }
        //若要删除的节点是头节点
        if(res==head){
            head=head.next;
            head.pre=null;
            return res.val;
        }
        //若都不是,获取被删除节点的前后节点
        ListNode pre=res.pre;
        ListNode next=res.next;
        //删除一个节点就是要让被删除节点的前后节点都跳过他
        pre.next=next;
        next.pre=pre;
        //返回被删除节点的值
        return res.val;
    }

    //返回链表长度
    public int size(){
        return size;
    }

    public ListNode getNode(int index) {
        //当传入索引大于链表长度所支持的最大索引，返回null
        if(index>size-1)
            return null;
        //在链表中要通过索引获取元素，要对整个链表进行遍历，时间复杂度为O(n)
        /*
        ListNode cur=head;
        while(index-->0)
            cur=cur.next;
         */
        //优化:当所求索引大于链表长度的一半，从尾节点开始遍历，否则从头节点开始遍历
        int midIndex=size/2;
        ListNode cur=null;
        if(index>=midIndex){
            cur=tail;
            //索引也要反过来
            index=size-index-1;
            //反过来遍历
            while(index-->0)
                cur=cur.pre;
        }else{
            cur=head;
            while(index-->0)
                cur=cur.next;
        }
        return cur;
    }

    //内部类，双向链表的核心
    private class ListNode{
        int val;
        ListNode pre,next;
        ListNode(int val){
            this.val=val;
        }
    }

}