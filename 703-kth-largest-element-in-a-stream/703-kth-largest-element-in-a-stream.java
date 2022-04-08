class KthLargest {

    private int k;
    private PriorityQueue<Integer> heap;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>(); // min heap
        
        for(int n : nums){
            heap.offer(n);
        }
        
        while(heap.size()>k){
            heap.poll();
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if(heap.size()>k){
            heap.poll();
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */