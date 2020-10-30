package algorithm.lfu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 多链表实现LFU
 *
 * @param <K>
 * @param <V>
 * @Author yuc
 */
public class LFUCache<K, V> extends HashMap<K, V> {

    /**
     * 链表池
     */
    private List<LinkedList<K>> listPool;

    /**
     * 容量与当前大小
     */
    private int capacity, size;

    /**
     * 构造方法
     *
     * @param capacity
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        listPool = new ArrayList<>();
        listPool.add(new LinkedList<>());
    }

    @Override
    public V put(K key, V val) {
        // 当缓存命中时
        if (super.containsKey(key)) {
            V oldVal = super.get(key);
            cacheIncr(key);
            super.put(key, val);
            return oldVal;
            // 缓存未命中时，新增键值对
        } else {
            if (size == capacity) {
                removeLeastUsedCache();
            }
            ++size;
            super.put(key, val);
            // 新增的数据从尾链表头插
            listPool.get(0).addFirst(key);
            return null;
        }
    }

    @Override
    public V get(Object key) {
        if (super.containsKey(key)) {
            cacheIncr((K) key);
        }
        return super.get(key);
    }

    /**
     * 移除最少被访问的数据
     *
     * @return
     */
    public V removeLeastUsedCache() {
        --size;
        K key = listPool.get(0).getLast();
        V val = super.get(key);
        listPool.get(0).removeLast();
        super.remove(key);
        return val;
    }

    /**
     * 将被命中的缓存抬上更高一级链表
     *
     * @param key
     */
    private void cacheIncr(K key) {
        int curIdx = findListAddr(key);
        listPool.get(curIdx).remove(key);
        if (curIdx == listPool.size() - 1) {
            listPool.add(new LinkedList<>());
        }
        listPool.get(curIdx).remove(key);
        listPool.get(curIdx + 1).add(key);
    }

    /**
     * 寻找这个key在listPool中的哪条list中
     *
     * @param key
     * @return 找到输出所在索引，找不到输出-1
     */
    private int findListAddr(K key) {
        int idx = 0;
        for (List list : listPool) {
            if (list.contains(key)) {
                return idx;
            }
            ++idx;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List list : listPool) {
            sb.append(list.toString() + "\n");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        LFUCache<Character, Integer> lfu = new LFUCache<>(5);
        for (int i = 0; i < 5; ++i) lfu.put((char) (i + 'a'), i);
//        System.out.println(lfu.toString());
        System.out.println(lfu.get('c'));
//        System.out.println(lfu.toString());
        lfu.get('c');
        lfu.get('c');
        for (int i = 0; i < 5; ++i) lfu.get((char) (i + 'a'));

        System.out.println(lfu.toString());
    }
}
