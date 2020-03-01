class Node {
    int key;
    int val;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.val = value;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap(capacity);
        this.capacity = capacity;

        this.head = new Node(0,0);
        this.tail = new Node(0,0);

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
            addToHead(curr);
            return curr.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
            temp.val = value;
            addToHead(temp);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            Node temp = new Node(key, value);
            map.put(key, temp);
            addToHead(temp);
        }
    }

    public void remove(Node n) {
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    public void addToHead(Node n) {
        n.pre = head;
        n.next = head.next;
        head.next.pre = n;
        head.next = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */