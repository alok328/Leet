class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a1 = (ax2-ax1) * (ay2-ay1);
        int a2 = (bx2-bx1) * (by2-by1);
        int xo = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int yo = Math.min(ay2, by2) - Math.max(ay1, by1);
        int o = 0;
        if (xo > 0 && yo > 0) {
            o = xo * yo;
        }
        return a1 + a2 - o;
    }
}