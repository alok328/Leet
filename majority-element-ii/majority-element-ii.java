class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int a=Integer.MAX_VALUE, b=Integer.MAX_VALUE, ca = 0, cb = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==a){
                ca++;
            }else if(nums[i]==b){
                cb++;
            }else if(ca==0){
                a = nums[i];
                ca++;
            }else if(cb==0){
                b = nums[i];
                cb++;
            }else {
                ca--;
                cb--;
            }
        }
        ca = 0;
        cb = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==a){
                ca++;
            }else if(nums[i]==b){
                cb++;
            }
        }
        if(ca>nums.length/3){
            ans.add(a);
        }
        if(cb>nums.length/3){
            ans.add(b);
        }
        return ans;
    }
}