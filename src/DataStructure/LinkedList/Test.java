package DataStructure.LinkedList;

public class Test {
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
