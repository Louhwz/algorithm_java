package algorithm_practice.leetcode.code0400;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * H0460_LFU缓存
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 * <p>
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 * <p>
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 * <p>
 * 示例：
 * <p>
 * LFUCache cache = new LFUCache( 2 /* capacity (缓存容量)
 */

public class LFUCache {


    Map<Integer, Node> hashtable;
    PriorityQueue<Node> minHeap;
    int capacity;
    int time;

    public LFUCache(int capacity) {
        hashtable = new Hashtable<>(capacity);
        if (capacity > 0)
            minHeap = new PriorityQueue<>(capacity);
        time = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0)
            return 0;
        if (hashtable.containsKey(key)) {
            Node k = hashtable.get(key);
            minHeap.remove(k);
            k.idx = time++;
            k.freq += 1;

            minHeap.offer(k);

            return k.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (hashtable.containsKey(key)) {
            Node k = hashtable.get(key);
            minHeap.remove(k);
            k.idx = time++;
            k.freq += 1;
            k.value = value;
            minHeap.offer(k);
        } else {
            if (minHeap.size() == capacity) {
                Node nok = minHeap.poll();
                minHeap.remove(nok);
                hashtable.remove(nok.key);
            }

            Node node = new Node(key, value, time++);
            minHeap.add(node);
            hashtable.put(key, node);
        }
    }
    @Test
    public void test0460() {
        Hashtable<Integer, Node> hashtable = new Hashtable<>();
        Node k = new Node(1, 1, 0);
        Node k2 = new Node(2, 2, 1);
        hashtable.put(1, k);
        hashtable.put(2, k2);
        Node c = hashtable.get(1);
        c.idx++;
        Node m = hashtable.get(1);
        System.out.println(m.idx);

    }
}


class Node implements Comparable<Node> {
    int key;
    int value;
    int freq;
    int idx;    //访问时间

    public Node() {

    }

    public Node(int key, int value, int idx) {
        this.key = key;
        this.value = value;
        this.idx = idx;
        this.freq = 1;
    }

    @Override
    public int compareTo(Node node) {
/*        int k = o.freq - this.freq;
        return k != 0 ? k : (o.idx - this.idx);*/
        int diff = freq - node.freq;
        return diff != 0 ? diff : idx - node.idx;
    }
}