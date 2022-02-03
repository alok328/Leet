class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        Arrays.fill(nse, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                nse[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        int[] pse = new int[n];
        Arrays.fill(pse, -1);
        stack.clear();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                pse[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        int maxArea = 0;
        for(int i=0; i<n; i++){
            int rightExt = nse[i] == -1 ? (n-1)-i : nse[i]-i-1;
            int leftExt = pse[i] == -1 ? i : i-pse[i]-1;
            int width = 1;
            width += leftExt>0 ? leftExt : 0;
            width += rightExt>0 ? rightExt : 0;
            int area = width*heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}