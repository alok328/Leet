class Solution {
    public int calPoints(String[] ops) {
        List<Integer> points = new LinkedList<>();
        for(String s : ops){
            if(s.equals("+")){
                points.add(points.get(points.size()-1) + points.get(points.size()-2));
            }else if(s.equals("D")){
                points.add((points.get(points.size()-1))*2);
            }else if(s.equals("C")){
                points.remove(points.size()-1);
            }else{
                points.add(Integer.parseInt(s));
            }
        }
        return points.stream().reduce(0, Integer::sum);
    }
}