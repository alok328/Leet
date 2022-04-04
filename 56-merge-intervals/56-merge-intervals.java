class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0 ||  intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(new int[] {intervals[0][0], intervals[0][1]});
        for(int i=1; i<intervals.length; i++) {
            int idx = merged.size()-1;
            if(intervals[i][0]>=merged.get(idx)[0] && intervals[i][0]<=merged.get(idx)[1]){
                merged.get(idx)[1] = Math.max(merged.get(idx)[1], intervals[i][1]);
            }else{
                merged.add(new int[] {intervals[i][0], intervals[i][1]});
            }
        }
        int[][] res = new int[merged.size()][2];
        for(int i=0; i<merged.size(); i++) {
            res[i] = merged.get(i);
        }
        return res;
    }
}