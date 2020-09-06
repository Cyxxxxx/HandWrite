package Algorithm.LRU;

public class LRUTest {
    public static void main(String[] args) {
        LRU<Integer,String> lru = new LRU<>(3);
        lru.put(1,"a");
        lru.put(2,"b");
        lru.put(3,"c");
        System.out.println(lru.keySetString()); // 3,2,1,
        lru.put(4,"d");
        //(当要存入的数据多于缓存限定的个数时，淘汰最不常用的数据，即 < 1, "a">
        System.out.println(lru.keySetString()); // 4,3,2,
        lru.put(2,"z"); // 将 < 2,"b">更新为 < 2, "z">
        // key: 2被访问，置于链表头
        System.out.println(lru.keySetString()); // 2,4,3,
        System.out.println(lru.get(2)); // z
        System.out.println(lru.get(3)); // c
        lru.put(5,"e");
        System.out.println(lru.keySetString()); // 5,3,2,
    }
}
