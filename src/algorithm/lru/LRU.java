package algorithm.lru;

import java.util.*;
import java.util.LinkedList;

/**
 * 手写一个LRU容器
 * @author YuC
 */
public class LRU<K,V> {

    /**
     * 容器大小
     */
    private int size;

    /**
     * 链表存储key
     */
    private LinkedList<K> linkedList;

    /**
     * HashMap存储键值对
     */
    private HashMap<K,V> hashMap;

    public LRU(int size){
        this.size=size;
        this.linkedList=new LinkedList<>();
        this.hashMap=new HashMap<>();
    }

    public void put(K key,V val){
        //检测链表中是否已有该键

        // 链表中存在该键时
        if(linkedList.contains(key)){
            //将该键的位置置于链表头
            linkedList.remove(key);
            linkedList.addFirst(key);
            //更新哈希表
            hashMap.put(key,val);
            return;
        }else{ // 链表中不存在该键时

            //当容器满，进行淘汰策略
            if(linkedList.size()==size){
                K knockOutKey = linkedList.getLast();
                //在哈希表中删除最久未使用的数据
                hashMap.remove(knockOutKey);
                //链表尾删
                linkedList.removeLast();
            }

            //数据置入哈希表
            hashMap.put(key, val);
            //链表头插
            linkedList.addFirst(key);
        }
    }

    public V get(K key){
        //检测链表中是否存在该key
        // 当链表中存在该key时
        if (linkedList.contains(key)){
            // 将key置于链头
            linkedList.remove(key);
            linkedList.addFirst(key);
            return hashMap.get(key);
        }else { // 链表中不存在该key，返回null
            return null;
        }
    }

    public String keySetString(){
        if (linkedList.size()==0){
            return null;
        }else {
            StringBuilder sb = new StringBuilder();
            Iterator iterator = linkedList.iterator();
            while(iterator.hasNext()) {
                sb.append(iterator.next()).append(",");
            }
            return sb.toString();
        }
    }

    public int size(){
        return linkedList.size();
    }

    /**
     * main方法，测试用
     * @param args
     */
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