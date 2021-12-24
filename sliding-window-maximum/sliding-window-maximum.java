class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[n-k+1];
        int c = 0;
        for(int i=0; i<n; i++){
            if(queue.isEmpty()){
                queue.offerLast(i);
            }else{
                while(!queue.isEmpty() && queue.peekFirst()<=i-k){
                    queue.pollFirst();
                }
                while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                    queue.pollLast();
                }
                queue.offerLast(i);
            }
            if(i>=k-1){
                ans[c++] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}