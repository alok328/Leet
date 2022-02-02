class FreqCacheNode {
    int key;
    int val;
    int freq;
    FreqCacheNode prev;
    FreqCacheNode next;

    public FreqCacheNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DLLQueue {

    FreqCacheNode head;
    FreqCacheNode tail;
    int size;

    public DLLQueue(){
        head = new FreqCacheNode(-1, -10);
        tail = new FreqCacheNode(-1, 10);
        head.next = tail;
        tail.prev = head;
    }

    public void add(FreqCacheNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void remove(FreqCacheNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public FreqCacheNode removeLast(){
        if (size<=0)
            return null;
        FreqCacheNode last = tail.prev;
        remove(last);
        return last;
    }

}

class LFUCache {

    int capacity;
    int minFreq;
    Map<Integer, FreqCacheNode> cacheMap;
    Map<Integer, DLLQueue> freqQueue;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        cacheMap = new HashMap<>();
        freqQueue = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        updateFreq(cacheMap.get(key));
        return cacheMap.get(key).val;
    }
    
    public void put(int key, int val) {
        if(capacity==0)
            return;
        if(cacheMap.containsKey(key)){
            FreqCacheNode node = cacheMap.get(key);
            node.val = val;
            updateFreq(node);
        }else{
            FreqCacheNode node = new FreqCacheNode(key, val);
            cacheMap.put(key, node);
            if(cacheMap.size()>capacity){
                DLLQueue minFreqQueue = freqQueue.get(minFreq);
                FreqCacheNode last = minFreqQueue.removeLast();
                cacheMap.remove(last.key);
            }
            DLLQueue freqQ = freqQueue.getOrDefault(node.freq, new DLLQueue());
            freqQ.add(node);
            minFreq = 1;
            freqQueue.put(node.freq, freqQ);
        }
    }
    
    private void updateFreq(FreqCacheNode node) {
        DLLQueue oldFreqQue = freqQueue.get(node.freq);
        oldFreqQue.remove(node);
        if(node.freq==minFreq && oldFreqQue.size==0){
            minFreq++;
        }
        node.freq++;
        DLLQueue higherFreqQueue = freqQueue.getOrDefault(node.freq, new DLLQueue());
        higherFreqQueue.add(node);
        freqQueue.put(node.freq, higherFreqQueue);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */