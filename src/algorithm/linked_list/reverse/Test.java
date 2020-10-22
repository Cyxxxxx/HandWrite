package algorithm.linked_list.reverse;

/**
 * 链表反转 测试类
 * @author YuC
 */
public class Test {

    static LinkedListReverse.ListNode head;

    public static void main(String[] args) {
        // 生成链表 1->2->3->4
        dataInit();
        // 输出链表反转（迭代法）
        System.out.println(LinkedListReverse.iterative(head).toString());
        /**
         * output: 4->3->2->1
         */

        // 生成链表 1->2->3->4
        dataInit();
        // 输出链表反转（递归法）
        System.out.println(LinkedListReverse.recurse(head).toString());
        /**
         * output: 4->3->2->1
         */
    }

    static void dataInit(){
        head=new LinkedListReverse.ListNode(1);
        LinkedListReverse.ListNode cur=head;
        for(int i=2;i<=4;++i){
            LinkedListReverse.ListNode node = new LinkedListReverse.ListNode(i);
            cur.next=node;
            cur=node;
        }
        System.out.println(head.toString());
        /**
         * output: 1->2->3->4
         */
    }

}
