class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        String temp = "";
        while(temp.length()<b.length()){
            temp=temp+a; //comparing time (412ms previously)
            count++;
        }
        if(temp.contains(b)) return count;
        if((temp+a).contains(b)) return ++count;
        return -1;
    }
}