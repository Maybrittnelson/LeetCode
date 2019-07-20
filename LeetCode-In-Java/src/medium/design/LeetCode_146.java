package medium.design;

import java.util.Hashtable;

/**
 * 应用场景：
 *
 * @author <a href="mailto:ge.sf.chn@gmail.com">shaofeng</a>
 * @since 2019/7/20
 */
public class LeetCode_146 {

    static class LRUCache {

        private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
        private int count;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            head.pre = null;

            tail = new DLinkedNode();
            tail.post = null;

            head.post = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }

            moveToHead(node);
            return node.value;
        }


        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if (node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                this.cache.put(key, newNode);
                this.addNode(newNode);

                ++count;

                if (count > capacity) {
                    DLinkedNode tail = this.popTail();
                    this.cache.remove(tail.key);
                    count--;
                }
            } else {
                node.value = value;
                this.moveToHead(node);
            }
        }

        private DLinkedNode popTail() {
            DLinkedNode node = tail.pre;
            this.removeNode(node);
            return node;
        }

        public void moveToHead(DLinkedNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        public void addNode(DLinkedNode node) {
            //node need to do
            //node pre head
            //node post head's old_post
            node.post = head.post;
            node.pre = head;

            //on both sides of node to do
            //head(post node) node  old_post(pre node)
            head.post.pre = node;
            head.post = node;
        }

        public void removeNode(DLinkedNode node) {
            DLinkedNode pre = node.pre;
            DLinkedNode post = node.post;

            pre.post = post;
            post.pre = pre;
        }


        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode post;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
    }
}
