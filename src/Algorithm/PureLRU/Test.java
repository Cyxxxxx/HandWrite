package Algorithm.PureLRU;

public class Test  {
    public static void main(String[] args) {
        PureLRU<Integer,String> PureLRU = new PureLRU<>(3);
        System.out.println(PureLRU.isEmpty()); // true
        PureLRU.put(1,"A");
        PureLRU.put(2,"B");
        PureLRU.put(3,"C");
        System.out.println(PureLRU.toString()); // 3,2,1
        System.out.println(PureLRU.get(1)); // A
        System.out.println(PureLRU.toString()); // 1,3,2
        PureLRU.get(2);
        System.out.println(PureLRU.toString()); // 2,1,3

        PureLRU.put(4,"D");
        System.out.println(PureLRU.toString()); // 4,2,1

        PureLRU.put(1,"Z");
        System.out.println(PureLRU.toString()); // 1,4,2
        System.out.println(PureLRU.get(1)); // Z

        System.out.println(PureLRU.contains(4)); // true
        System.out.println(PureLRU.isEmpty()); // false
    }
}
