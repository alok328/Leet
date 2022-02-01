class CacheNode {

    int key;
    int val;
    CacheNode prev;
    CacheNode next;

    public CacheNode(){

    }

    public CacheNode(int key, int val){
        this.key = key;
        this.val = val;
    }

}

class LRUCache {
    
    private final CacheNode head;
    private final CacheNode tail;
    private final int capacity;
    private final Map<Integer, CacheNode> cache;
    
    public LRUCache(int capacity){
        this.capacity = capacity;
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    public void put(int key, int val){
        if(cache.containsKey(key)){
            delete(cache.get(key));
        }
        if(cache.size()==capacity){
            delete(tail.prev);
        }
        insert(new CacheNode(key, val));
    }

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        CacheNode node = cache.get(key);
        delete(node);
        insert(new CacheNode(node.key, node.val));
        return cache.get(key).val;
    }

    private void delete(CacheNode cacheNode) {
        cache.remove(cacheNode.key);
        cacheNode.prev.next = cacheNode.next;
        cacheNode.next.prev = cacheNode.prev;
    }

    private void insert(CacheNode cacheNode) {
        cache.put(cacheNode.key, cacheNode);
        cacheNode.next = head.next;
        cacheNode.prev = head.next.prev;
        head.next.prev = cacheNode;
        head.next = cacheNode;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */