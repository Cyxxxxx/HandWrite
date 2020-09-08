package Algorithm.PureLRU;

/**
 * 不借助集合框架手撕LRU
 * @param <K>
 * @param <V>
 */
public class PureLRU<K,V> {

    /**
     * 缓存容量
     */
    private int capacity;

    /**
     * 缓存元素个数
     */
    private int size;

    /**
     * 链表的头、尾指针
     */
    private Entry head, tail;

    public PureLRU(int capacity){
        this.capacity=capacity;
        this.size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 头插方法
     * @param entry
     */
    private void addToHead(Entry entry){
        entry.next = head;
        head.pre = entry;
        head = entry;
        ++size;
    }

    /**
     * 尾删方法
     */
    private void removeLast(){
        tail = tail.pre;
        tail.next = null;
        --size;
    }

    private void moveToHead(Entry entry){
        // 当指定节点为头节点，无需移动
        if(entry == head){
            return;
        }
        // 指定节点为尾节点时，尾删头插即可
        if(entry == tail){
            removeLast();
            addToHead(entry);
            return;
        }
        // 指定节点为其他节点时
        Entry pre = entry.pre;
        Entry next = entry.next;
        pre.next = next;
        next.pre = pre;
        // 以上操作相当于从链表中删去该节点，需要将size自减
        --size;
        addToHead(entry);
    }

    /**
     * 根据key寻找节点，O(n)
     * @param key
     * @return
     */
    private Entry findEntryByKey(K key){
        if (key == null){
            for(Entry cur = head; cur != null; cur = cur.next) {
                if(cur.key==null){
                    return cur;
                }
            }
        }else {
            for(Entry cur = head; cur != null; cur = cur.next){
                if(cur.key.equals(key)){
                    return cur;
                }
            }

        }
        return null;
    }

    /**
     * 查询缓存中是否包含指定key
     * @param key
     * @return
     */
    public boolean contains(K key){
        return findEntryByKey(key) != null;
    }

    /**
     * 置入新数据
     * @param key
     * @param val
     */
    public void put(K key,V val){
        // 当缓存中存在当前要置入的数据的键时
        Entry entry = findEntryByKey(key);
        if(entry != null){
            moveToHead(entry);
            // 更新数据
            head.val=val;
            return;
        }

        // 缓存中不存在要存入的键时
        // 用Entry存储新键值对
        Entry<K,V> newEntry = new Entry<>(key,val);
        // 当容器为空时，头节点=尾节点，
        if (this.isEmpty()){
            head = newEntry;
            tail = head;
            //不要忽略size的自增
            ++size;
        }else {
            // 当容器不为空时
            // 当容器满时要尾删
            if (size == capacity){
                removeLast();
            }
            // 头插新节点
            addToHead(newEntry);
        }
    }

    public V get(K key){
        Entry target = findEntryByKey(key);
        // 不存在该键时，返回空即可
        if(target == null){
            return null;
        }
        // 将被访问数据节点移动到头节点
        moveToHead(target);
        return (V)target.val;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Entry cur = head; cur != null; cur = cur.next) {
            sb.append(cur.key).append(",");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private class Entry<K,V>{
        public K key;
        public V val;

        public Entry next,pre;

        public Entry(K key,V val){
            this.key = key;
            this.val = val;
        }
    }

}
