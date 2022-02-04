class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> range = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            if(range.isEmpty()){
                range.offerLast(i);
            }else{
                while(!range.isEmpty() && range.peekFirst()<=i-k){
                    range.pollFirst();
                }
                while(!range.isEmpty() && nums[range.peekLast()]<=nums[i]){
                    range.pollLast();
                }
                range.offerLast(i);
            }
            if(i>=k-1){
                res[i-k+1] = nums[range.peekFirst()];
            }
        }
        return res;
    }
}