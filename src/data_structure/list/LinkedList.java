package data_structure.list;

/**
 * 手写一个双向链表
 * @author YuC
 */
public class LinkedList {

    /**
     * 头尾节点
     */
    private ListNode head=null,tail=null;

    /**
     * 链表长度
     */
    private int size=0;

    /**
     * 添加元素方法
     * @param val
     */
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

    /**
     * 通过索引获取元素方法
     * @param index
     * @return
     */
    public int get(int index){
        ListNode res=getNode(index);
        //当getNode方法传出null时,返回-1
        if(res==null){
            return -1;
        }else{
            return res.val;
        }
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

    /**
     * 通过索引删除元素方法
     * @param index
     * @return
     */
    public int remove(int index){
        ListNode res=getNode(index);
        //当getNode方法传出null时,返回-1
        if(res==null){
            return -1;
        }
        //删除节点后size自减
        //当size大于1时,正常自减
        //当size小于等于1,删除链表中最后一个元素,头尾指针置空
        if(size--<=1){
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

    /**
     * 返回链表长度
     * @return
     */
    public int size(){
        return size;
    }

    public ListNode getNode(int index) {
        //当传入索引大于链表长度所支持的最大索引，返回null
        if(index>size-1) {
            return null;
        }
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
            while(index-->0) {
                cur = cur.pre;
            }
        }else{
            cur=head;
            while(index-->0){
                cur=cur.next;
            }
        }
        return cur;
    }



    // LRU 需要的方法

    /**
     * 将节点移到链头
     * @param val
     * @return
     */
    public boolean moveToHead(int val){
        // 用 node记录被移动节点
        ListNode node;

        // 当链表中不存在这个值，返回false
        if ((node = getNodeByVal(val)) == null){
            return false;
        }


        // 若 node本就是头节点，无需移动
        if(node == head){
            return true;
        }

        // 处理 node 的前后关系
        // 当 node不是尾节点
        if (node != tail){
            removeNode(node);
        }else{ // node是尾节点时，先尾删
            removeLast();
        }

        //将node头插
        addFirst(node);
        return true;
    }

    /**
     * 通过值寻找节点, 时间复杂度 O(n)
     * @param val
     * @return
     */
    private ListNode getNodeByVal(int val){
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 查询链表是否包含所传入值
     * @param val
     * @return
     */
    public boolean contains(int val){
        return getNodeByVal(val)!=null;
    }


    /**
     * 头插方法
     * @param node
     */
    private void addFirst(ListNode node){
        node.next = head;
        head.pre = node;
        node.pre = null;
        head = node;
        ++size;
    }


    /**
     * 删除节点方法
     * @param node
     */
    private void removeNode(ListNode node){
        ListNode nodePre = node.pre;
        ListNode nodeNext = node.next;
        nodePre.next = nodeNext;
        nodeNext.pre = nodePre;
        --size;
    }

    /**
     * 尾删方法
     * @return
     */
    public int removeLast(){
        // 存储链尾的值
        int res = tail.val;

        //尾删
        tail=tail.pre;
        tail.next.pre=null;
        tail.next=null;
        --size;

        return res;
    }

    @Override
    public String toString(){
        if(size==0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while(cur != null){
            sb.append(cur.val).append(",");
            cur = cur.next;
        }
        return sb.toString();
    }


    /**
     * 内部类，双向链表的核心
     */
    private class ListNode{
        int val;
        ListNode pre,next;
        ListNode(int val){
            this.val=val;
        }
    }

    /**
     * main方法，测试用
     * @param args
     */
    public static void main(String[] args) {
        LinkedList l=new LinkedList();

        // add 测试 正常
        l.add(3);
        l.add(6);
        l.add(1);

        // moveToHead 测试 正常
        System.out.println(l.toString()); // 3,6,1,
        System.out.println(l.moveToHead(1)); // true
        System.out.println(l.toString()); // 1,3,6, (移动成功)
        System.out.println(l.moveToHead(3)); // true
        System.out.println(l.toString());

        // contains 测试 正常
        System.out.println(l.contains(3)); // true (链表中有值3
        System.out.println(l.contains(5)); // false (链表中没有值5

        // removeLast 测试 正常
        l.removeLast();
        System.out.println(l.toString()+" | removeLast"); // 3,1, | removeLast

        // remove(int index) 测试 正常
        System.out.println(l.size());           // 2
        System.out.println(l.remove(2)); // -1
        System.out.println(l.toString());  // 3,1,
        System.out.println(l.remove(0)); //3
        System.out.println(l.toString()); // 1,
        System.out.println(l.remove(0)); //1
        System.out.println(l.toString()); // null

        // set(int index, int val) 测试 正常
        l.add(9);
        l.add(7);
        System.out.println(l.toString()); // 9,7,
        System.out.println(l.set(0,3));         //9
        System.out.println(l.toString()); // 3,7,
    }

}