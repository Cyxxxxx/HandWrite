package Algorithm.LFU.MultiLinkedListLFU;

public class Test {
    public static void main(String[] args) {
        MultiLinkedListLFU<Integer, String> lfu = new MultiLinkedListLFU<>(5);
        lfu.put(1, "a");
        lfu.put(2, "b");
        lfu.put(3, "c");
        lfu.put(4, "d");
        lfu.put(5, "e");
        lfu.put(2, "y");
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次1:2
         * 频次0:5->4->3->1
         */
        System.out.println(lfu.get(1)); // a
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次1:1->2
         * 频次0:5->4->3
         */
        lfu.put(6, "f");
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次1:1->2
         * 频次0:6->5->4
         */
        lfu.put(4, "x");
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次1:4->1->2
         * 频次0:6->5
         */
        System.out.println(lfu.get(6)); // f
        /**
         * output:
         * 频次1:6->4->1->2
         * 频次0:5
         */
        System.out.println(lfu.get(4)); // x
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次2:4
         * 频次1:6->1->2
         * 频次0:5
         */
        lfu.put(7, "g");
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次2:4
         * 频次1:7->6->1->2
         */
    }
}
