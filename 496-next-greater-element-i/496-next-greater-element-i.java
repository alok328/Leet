class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> nge = new Stack<>();
        Map<Integer, Integer> ngeMap = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            while(!nge.isEmpty() && nge.peek()<nums2[i]){
                ngeMap.put(nge.peek(), nums2[i]);
                nge.pop();
            }
            nge.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            if(ngeMap.containsKey(nums1[i])){
                ans[i] = ngeMap.get(nums1[i]);
            }else{
                ans[i] = -1;
            }
        }
        return ans;
    }
}