class Solution {
    public List<String> cellsInRange(String s) {
        char startCol = s.charAt(0);
        char endCol = s.charAt(3);
        char startRow = s.charAt(1);
        char endRow = s.charAt(4);
        List<String> res = new ArrayList<>();
        for(char col=startCol; col<=endCol; col++){
            for(char row=startRow; row<=endRow; row++){
                res.add(col+""+row);
            }
        }
        return res;
    }
}