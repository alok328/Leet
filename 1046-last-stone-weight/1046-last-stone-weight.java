class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> s = new ArrayList<>();
        Arrays.stream(stones).forEach(i -> s.add(i));
        Collections.sort(s);
        while(s.size()>1){
            int a = s.get(s.size()-1);
            int b = s.get(s.size()-2);
            if(a==b){
                s.remove(s.size()-1);
                s.remove(s.size()-1);
            }else{
                int y = s.remove(s.size()-1);
                int x = s.remove(s.size()-1);
                s.add(y-x);
                Collections.sort(s);
            }
        }
        return s.size()==1 ? s.get(0) : 0;
    }
}