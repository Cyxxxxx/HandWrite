package Algorithm.LRU;

import java.util.*;
import java.util.LinkedList;

//手写一个LRU容器
public class LRU<K,V> {

    // 容器大小
    private int size;

    // 链表存储key
    private LinkedList<K> linkedList;

    // HashMap存储键值对
    private HashMap<K,V> hashMap;

    public LRU(int size){
        this.size=size;
        this.linkedList=new LinkedList<>();
        this.hashMap=new HashMap<>();
    }

    public void put(K key,V val){
        //检测链表中是否已有该键
        if(linkedList.contains(key)){ // 链表中存在该键时
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
        if (linkedList.contains(key)){ // 当链表中存在该key时
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
            while(iterator.hasNext())
                sb.append(iterator.next()).append(",");
            return sb.toString();
        }
    }

    public int size(){
        return linkedList.size();
    }

}