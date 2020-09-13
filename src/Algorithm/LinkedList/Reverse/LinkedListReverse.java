package Algorithm.LinkedList.Reverse;

/**
 * 链表反转——迭代法与递归法
 *
 * @author YuC
 */
public class LinkedListReverse {

    /**
     * 传入一个单链表的头节点，将该链表反转
     * 迭代法
     *
     * @param head
     */
    public static ListNode iterative(ListNode head) {
        // 定义当前节点为入参节点
        ListNode cur = head;
        // 定义两个前后指针，待用
        // pre代表cur的上一节点，next代表cur的下一节点，在while中进行赋值
        ListNode pre = null, next = null;

        while (cur != null) {
            // 将前指针定义为入参节点的下一节点
            next = cur.next;
            // 将当前节点的下一节点指向pre
            cur.next = pre;
            // 将pre指向当前节点
            pre = cur;
            // 将当前节点指向下一节点
            cur = next;
        }
        // 在最后一轮的while循环中，pre指向了原本的链表尾
        return pre;
    }

    /**
     * 传入一个单链表的头节点，将该链表反转
     * 递归法
     *
     * @param head
     */
    public static ListNode recurse(ListNode head) {
        // 设置限制条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归获得链表尾节点
        ListNode node = recurse(head.next);

        // 获得链表尾节点之后，在链表尾的前一节点开始返回
        // 这一句的意思是，将当前head的下一节点的next指针指向当前head
        head.next.next = head;
        // 将当前head的next指针置空，在下次返回的时候再将其指向其前一节点（即上面那句的操作）
        head.next = null;

        // 返回尾节点node
        return node;
    }

    /**
     * 单链表节点类
     */
    public static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode cur = next;
            while (cur != null) {
                sb.append("->")
                        .append(cur.val);
                cur = cur.next;
            }
            return sb.toString();
        }
    }
}
