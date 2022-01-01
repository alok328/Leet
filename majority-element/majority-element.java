class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majEle = -1;
        for(int i=0; i<nums.length; i++){
            if(count==0){
                majEle = nums[i];
            }
            if(nums[i]==majEle){
                count++;
            }else{
                count--;
            }
        }
        return majEle;
    }
}