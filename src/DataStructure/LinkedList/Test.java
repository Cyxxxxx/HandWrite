package DataStructure.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.add(3);
        l.add(6);
        l.add(1);
        System.out.println(l.size());           //3
        System.out.println(l.remove(2)); //1
        System.out.println(l.remove(0)); //3
        System.out.println(l.remove(0)); //6
        System.out.println(l.remove(0)); //-1
        l.add(9);
        l.add(7);
        System.out.println(l.size());           //2
        System.out.println(l.set(0,3));         //9
        System.out.println(l.get(0));           //3
    }
}
