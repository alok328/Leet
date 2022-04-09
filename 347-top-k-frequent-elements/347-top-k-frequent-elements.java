class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        Queue<Integer> minHeap = new PriorityQueue<>(
                (n1, n2) -> Integer.compare(freq.get(n1), freq.get(n2))
            );
        
        for(int n : freq.keySet()){
            minHeap.offer(n);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        
        int[] ans = new int[k];
        while(k-1>=0){
            ans[k-1] = minHeap.poll();
            k-=1;
        }
        return ans;
    }
}