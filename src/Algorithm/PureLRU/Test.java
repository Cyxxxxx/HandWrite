package Algorithm.PureLRU;

public class Test  {
    public static void main(String[] args) {
        PureLRU<Integer,String> pureLRU = new PureLRU<>(3);
        System.out.println(pureLRU.isEmpty()); // true
        pureLRU.put(1,"A");
        pureLRU.put(2,"B");
        pureLRU.put(3,"C");
        System.out.println(pureLRU.toString()); // 3,2,1
        System.out.println(pureLRU.get(1)); // A
        System.out.println(pureLRU.toString()); // 1,3,2
        pureLRU.get(2);
        System.out.println(pureLRU.toString()); // 2,1,3

        pureLRU.put(4,"D");
        System.out.println(pureLRU.toString()); // 4,2,1

        pureLRU.put(1,"Z");
        System.out.println(pureLRU.toString()); // 1,4,2
        System.out.println(pureLRU.get(1)); // Z

        System.out.println(pureLRU.contains(4)); // true
        System.out.println(pureLRU.isEmpty()); // false

        pureLRU.put(null,"nullVal");
        System.out.println(pureLRU.toString()); // null,1,4
        System.out.println(pureLRU.get(null)); // nullVal


    }
}
