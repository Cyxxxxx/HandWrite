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
        // 将新节点的下一节点定义为当前链表的头节点
        entry.next = head;
        // 将当前链表头节点的上一个节点定义为新节点
        head.pre = entry;
        // 以上两步将新节点与链头连接完成

        // 将头节点定义为新节点，实现头插
        head = entry;
        // 链表添置新元素，size自增
        ++size;
    }

    /**
     * 尾删方法
     */
    private void removeLast(){
        // 将尾节点定义为当前尾节点的前一个节点
        tail = tail.pre;
        // 将尾节点的下一个节点（即原本的尾节点）设置为null
        tail.next = null;
        //以上操作将原本的尾节点与链表脱离，size自减
        --size;
    }

    /**
     * 将节点移动到链头
     * @param entry
     */
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
        // 从链表中删去该节点后，将该节点头插
        addToHead(entry);
    }

    /**
     * 根据key寻找节点，O(n)
     * @param key
     * @return
     */
    private Entry findEntryByKey(K key){
        // 当key为空时，寻找链表中key为空的节点
        if (key == null){
            for(Entry cur = head; cur != null; cur = cur.next) {
                if(cur.key==null){
                    return cur;
                }
            }
        }else {
            // key不为空时，寻找key和传入值相等的节点
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

    /**
     * 查询数据
     * @param key
     * @return
     */
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

    /**
     * 键值对节点
     * @param <K>
     * @param <V>
     */
    private class Entry<K,V>{

        /**
         * 存放节点的键
         */
        public K key;

        /**
         * 存放节点的值
         */
        public V val;

        /**
         * 节点的前后指针
         */
        public Entry next,pre;

        public Entry(K key,V val){
            this.key = key;
            this.val = val;
        }
    }

}
