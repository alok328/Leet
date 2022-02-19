class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowSum = 0;
        int count = 0;
        //k=3
        //t=4
        //arrlen - k = 8-3 = 5
        for(int i=0; i<arr.length; i++){
            if(i<k){
                windowSum+=arr[i];
            }else{
                if((windowSum/k)>=threshold){
                    count++;
                }
                windowSum-=arr[i-k];
                windowSum+=arr[i];
            }
        }
        if((windowSum/k)>=threshold)
            count++;
        return count;
    }
}