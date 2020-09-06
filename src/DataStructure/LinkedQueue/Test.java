package DataStructure.LinkedQueue;

public class Test {
    public static void main(String[] args) {
        LinkedQueue lq=new LinkedQueue();
        lq.offer(3);
        lq.offer(6);
        lq.offer(9);
        System.out.println(lq.peek()); //3
        while(!lq.isEmpty())
            System.out.println(lq.poll()); //依次输出3,6,9
        System.out.println(lq.isEmpty()); //true
    }
}
