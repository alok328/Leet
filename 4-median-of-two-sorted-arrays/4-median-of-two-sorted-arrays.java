class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int la = a.length;
        int lb = b.length;
        if (la > lb) {
            return findMedianSortedArrays(b, a);
        }
        int size = la+lb;
        int medPos = (size+1) / 2;
        int lo = 0;
        int hi = a.length;
        while (lo <= hi) {
            int elementsInA = (lo+hi)>>1;
            int elementsInB = medPos - elementsInA;

            int l1 = elementsInA==0 ? Integer.MIN_VALUE : a[elementsInA-1];
            int l2 = elementsInB==0 ? Integer.MIN_VALUE : b[elementsInB-1];
            int r1 = elementsInA==la ? Integer.MAX_VALUE : a[elementsInA];
            int r2 = elementsInB==lb ? Integer.MAX_VALUE : b[elementsInB];

            if(l1<=r2 && l2<=r1){
                if(size%2==0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }else {
                    return Math.max(l1, l2);
                }
            }else if(l1>r2){
                hi = elementsInA-1;
            }else{
                lo = elementsInA+1;
            }
        }
        return 0;
    }
}