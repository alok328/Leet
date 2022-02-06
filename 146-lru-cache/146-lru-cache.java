class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(){
        
    }
    
    public Node(int k, int v){
        key = k;
        val = v;
    }
}

class LRUCache {

    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        insertAtHead(node);
        return node.val;
    }
    
    private void insertAtHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void put(int key, int val) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            node.val = val;
            insertAtHead(node);
        }else{
            Node node = new Node(key, val);
            if(capacity == cache.size()){
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            insertAtHead(node);
            cache.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */