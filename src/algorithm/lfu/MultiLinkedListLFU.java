package algorithm.lfu;

import java.util.HashMap;

public class MultiLinkedListLFU<K, V> {

    /**
     * 记录<键key,频次freq>的哈希图，用于快速定位节点
     */
    private final HashMap<K, Integer> KEY_FREQ_MAP = new HashMap<>();

    /**
     * 头/尾链表
     */
    private MultiLinkedList headList, tailList;

    /**
     * 容器中链表的数量
     */
    private int listAmount;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 有参构造方法
     *
     * @param capacity
     */
    public MultiLinkedListLFU(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key, V val) {
        // 若缓存中存在与传入键值相同的值
        if (KEY_FREQ_MAP.containsKey(key)) {
            // 获取当前key的频次
            int freq = KEY_FREQ_MAP.get(key);
            // 获取当前频次所对应的链表list
            MultiLinkedList list = findListByFreq(freq);
            // 在list中删去指定节点
            list.removeEntryByKey(key);
            // 键值频次自增
            freqIncrease(list, key, val);
        } else {
            // 当刚初始化，容器中尚不存在链表时
            if (listAmount == 0) {
                headList = new MultiLinkedList();
                tailList = headList;
                ++listAmount;
            }
            // 当容器满，尾删
            if (getSumSize() == capacity) {
                tailList.removeLast();
                //当尾链表为空时，删除尾链表
                if (tailList.isEmpty()) {
                    removeTailList();
                    --listAmount;
                }
            }
            // 刚被添加的数据，频次为0，从尾链表添加
            tailList.put(key, val);
            // 记录到KEY_FREQ_MAP
            KEY_FREQ_MAP.put(key, 0);
        }
    }

    /**
     * 键值频次自增
     *
     * @param list
     * @param key
     * @param val
     */
    private void freqIncrease(MultiLinkedList list, K key, V val) {
        // 将节点放置到比原链表频次+1的新链表
        // 当list不存在前链表，说明list为头链表headList
        if (list.pre == null) {
            newHeadList();
            headList.put(key, val);
            // 记录到KEY_FREQ_MAP
            KEY_FREQ_MAP.put(key, headList.freq);
        } else {
            // 当list存在前链表，将节点在前链表上进行头插
            list.pre.put(key, val);
            // 记录到KEY_FREQ_MAP
            KEY_FREQ_MAP.put(key, list.pre.freq);
        }
    }

    /**
     * get方法
     *
     * @param key
     * @return
     */
    public V get(K key) {
        // 当<key,freq>表中不存在查询key时，返回空值
        if (!KEY_FREQ_MAP.containsKey(key)) {
            return null;
        }
        // 获取查询key的频次
        int freq = KEY_FREQ_MAP.get(key);
        // 根据频次找到数据所在链表
        MultiLinkedList list = findListByFreq(freq);
        V val = list.findEntryByKey(key).val;
        // 在原位置删除原节点
        list.removeEntryByKey(key);
        // 键值频次自增
        freqIncrease(list, key, val);
        // 返回链表中对应键的值
        return val;
    }

    /**
     * 对外显示缓存元素个数
     *
     * @return
     */
    public int size() {
        return getSumSize();
    }

    /**
     * 对内展示缓存元素个数
     *
     * @return
     */
    private int getSumSize() {
        int sum = 0;
        for (MultiLinkedList list = headList; list != null; list = list.next) {
            sum += list.size;
        }
        return sum;
    }

    /**
     * 基于频次找到对应链表
     *
     * @param freq
     * @return
     */
    private MultiLinkedList findListByFreq(int freq) {
        MultiLinkedList list = headList;
        while (list.freq != freq) {
            list = list.next;
        }
        return list;
    }

    /**
     * 新增一条频次比当前头链表多1的链表，并将其作为新头链表
     */
    private void newHeadList() {
        MultiLinkedList newList = new MultiLinkedList(headList.freq + 1);
        newList.next = headList;
        headList.pre = newList;
        headList = newList;
        ++listAmount;
    }

    /**
     * 删除尾链表
     */
    private void removeTailList() {
        tailList = tailList.pre;
        tailList.next = null;
        --listAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MultiLinkedList cur = headList; cur != null; cur = cur.next) {
            sb.append("频次")
                    .append(cur.freq)
                    .append(":")
                    .append(cur.toString())
                    .append("\n");
        }
        return sb.toString();
    }

    private class MultiLinkedList {
        /**
         * 记录被访问的频次
         */
        int freq;

        /**
         * 前/后链表
         */
        MultiLinkedList pre, next;

        /**
         * 当前链表的头/尾节点
         */
        Entry head, tail;

        /**
         * 当前链表的长度
         */
        private int size;

        /**
         * 无参构造方法
         */
        MultiLinkedList() {
        }

        /**
         * 有参构造方法
         *
         * @param freq
         */
        MultiLinkedList(int freq) {
            this.freq = freq;
        }

        /**
         * 添加数据方法
         *
         * @param key
         * @param val
         */
        void put(K key, V val) {
            // 链表为空/不为空，分情况讨论
            if (size == 0) {
                head = new Entry(key, val);
                tail = head;
                ++size;
            } else {
                addToHead(new Entry(key, val));
            }
        }

        boolean isEmpty() {
            return size == 0;
        }

        /**
         * 返回链表长度
         *
         * @return
         */
        int size() {
            return size;
        }

        /**
         * 头删
         */
        void removeFirst() {
            head.next.pre = null;
            head = head.next;
            --size;
        }

        /**
         * 尾删
         * <p>
         * 当链表中仅剩一个元素，并触发尾删时
         * 只改变size数量，让外部缓存容器放弃该链表
         */
        void removeLast() {
            if (size <= 1) {
                tail.pre.next = null;
                tail = tail.pre;
            }
            --size;
        }

        /**
         * 通过key删除指定节点
         *
         * @param key
         */
        boolean removeEntryByKey(K key) {
            Entry entry = findEntryByKey(key);
            if (entry == null) {
                //未找到指定节点，删除失败
                return false;
            } else {
                // 当前key得到的节点是尾节点时，直接尾删
                if (key.equals(tail.key)) {
                    removeLast();
                    // 当前key得到的节点是头节点时，直接头删
                } else if (key.equals(head.key)) {
                    removeFirst();
                } else {
                    removeEntry(entry);
                }
                return true;
            }
        }

        void removeEntry(Entry entry){
            Entry pre = entry.pre;
            Entry next = entry.next;
            pre.next = next;
            next.pre = pre;
            --size;
        }

        /**
         * 头插
         *
         * @param entry
         */
        void addToHead(Entry entry) {
            entry.pre = null;
            entry.next = head;
            head.pre = entry;
            head = entry;
            ++size;
        }

        /**
         * 通过key寻找节点
         *
         * @param key
         * @return
         */
        Entry findEntryByKey(K key) {
            Entry cur = head;
            if (key == null) {
                for (; cur != null; cur = cur.next) {
                    if (cur.key == null) {
                        return cur;
                    }
                }
            } else {
                for (; cur != null; cur = cur.next) {
                    if (key.equals(cur.key)) {
                        return cur;
                    }
                }
            }
            return null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Entry cur = head; cur != null; cur = cur.next) {
                sb.append(cur.key)
                        .append("->");
            }
            return sb.substring(0, sb.length() - 2).toString();
        }

        class Entry {
            K key;
            V val;

            Entry pre, next;

            Entry(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    /**
     * main方法，测试用
     * @param args
     */
    public static void main(String[] args) {
        MultiLinkedListLFU<Integer, String> lfu = new MultiLinkedListLFU<>(5);
        lfu.put(1, "a");
        lfu.put(2, "b");
        lfu.put(3, "c");
        lfu.put(4, "d");
        lfu.put(5, "e");
        lfu.put(2, "y");
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次1:2
         * 频次0:5->4->3->1
         */
        System.out.println(lfu.get(1)); // a
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次1:1->2
         * 频次0:5->4->3
         */
        lfu.put(6, "f");
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次1:1->2
         * 频次0:6->5->4
         */
        lfu.put(4, "x");
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次1:4->1->2
         * 频次0:6->5
         */
        System.out.println(lfu.get(6)); // f
        /**
         * output:
         * 频次1:6->4->1->2
         * 频次0:5
         */
        System.out.println(lfu.get(4)); // x
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次2:4
         * 频次1:6->1->2
         * 频次0:5
         */
        lfu.put(7, "g");
        System.out.println(lfu.toString());
        /**
         * output:
         * 频次2:4
         * 频次1:7->6->1->2
         */
    }
}
